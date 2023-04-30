package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.PouringBase;
import com.example.dampouring.model.request.AddPouringBaseReq;
import com.example.dampouring.model.request.UpdatePouringBaseReq;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.model.vo.TempUpVo;
import com.example.dampouring.query.PouringBaseQue;
import com.example.dampouring.query.TempUpQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.service.PouringBaseService;
import com.example.dampouring.util.TimeUtils;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PouringBaseServiceImpl implements PouringBaseService {
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    FaceDiapauseAlertService faceDiapauseAlertService;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Override
    public void add(AddPouringBaseReq addPouringBaseReq, String userName) {
        checkSbId(addPouringBaseReq.getSmallSbId());
        PouringBase pouringBase = new PouringBase();
        BeanUtils.copyProperties(addPouringBaseReq,pouringBase);
        checkOpenTime(pouringBase);
        pouringBase.setOperator(userName);
        pouringBase.setCreateTime(TimeUtils.getNowTime());
        pouringBase.setBataNo(0);
        if(pouringBase.getFaceKeepWarm().equals("是"))
            pouringBase.setBataNo(1);
        if(pouringBase.getCloseTime()!=null)
        {
            pouringBase.setPouringTimeByOCTime();
            pouringBase.setPouringStrengthBy();
        }
        int count = pouringBaseMapper.insertSelective(pouringBase);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
        faceDiapauseAlertService.upOpenTimeFaceDiapauseAlert(pouringBase);
    }
    @Override
    public void update(UpdatePouringBaseReq updatePouringBaseReq){
        PouringBase pouringBase =
                pouringBaseMapper.selectByPrimaryKey(updatePouringBaseReq.getId());
        if (pouringBase == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        if(updatePouringBaseReq.getCoverTime()!=null&&pouringBase.getCoverTime()==null)
        {
            copyUtils.copyPropertiesIgnoreNull(updatePouringBaseReq,pouringBase);
            faceDiapauseAlertService.upFaceDiapauseAlert(pouringBase);
        }
        copyUtils.copyPropertiesIgnoreNull(updatePouringBaseReq,pouringBase);
        checkOpenTime(pouringBase);
        pouringBase.setPouringTimeByOCTime();
        pouringBase.setPouringStrengthBy();

        int count = pouringBaseMapper.updateByPrimaryKeySelective(pouringBase);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }

    public  void checkSbId(Integer sbId)
    {
        PouringBase pouringBase = pouringBaseMapper.selectBySbId(sbId);
        if(pouringBase!=null)
            throw new DamPourException(30000,"每个仓位不能有重复的浇筑信息");
    }
    public void checkOpenTime(PouringBase pouringBase)
    {
        PouringBase downPouringBase = pouringBaseMapper.selectByUpSbBycheckOpenTime(pouringBase.getSmallSbId());
        if(downPouringBase==null) return;
        if(TimeUtils.getHourDifferentTime(downPouringBase.getOpenTime(),pouringBase.getOpenTime())<24)
        {
            throw new DamPourException(30000,"开仓时间应大于上一层开仓时间最少一天");
        }
    }
    @Override
    public void delete(Integer[] ids) {
        int count = pouringBaseMapper.deleteByPrimaryKey(ids);
        sbTempNormMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PouringBaseVO> pouringBaseList = pouringBaseMapper.selectList();
        PageInfo pageInfo = new PageInfo(pouringBaseList);
        return pageInfo;
    }

    @Override
    public List<PouringBaseVO> listByIds(Integer[] ids) {
        List<PouringBaseVO> categoryList = pouringBaseMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public PageInfo orUserSelect(PouringBaseQue pouringBaseQue) {
        PageHelper.startPage(pouringBaseQue.getPageNum(), pouringBaseQue.getPageSize());
        List<PouringBaseVO> RainWaterInfo = pouringBaseMapper.selectListQue(pouringBaseQue);
        PageInfo pageInfo = new PageInfo(RainWaterInfo);
        return pageInfo;
    }

    @Override
    public List<PouringBaseVO> exportList() {
        List<PouringBaseVO> pouringBaseList = pouringBaseMapper.selectList();
        return pouringBaseList;
    }

    @Override
    public PageInfo tempUp(TempUpQue tempUpQue) {
        PageHelper.startPage(tempUpQue.getPageNum(), tempUpQue.getPageSize());
        List<TempUpVo> tempUpVos = pouringBaseMapper.tempUp(tempUpQue);
        PageInfo pageInfo = new PageInfo(tempUpVos);
        return pageInfo;
    }

    @Override
    public PageInfo selectByFg(PouringBaseQue pouringBaseQue) {
        PageHelper.startPage(pouringBaseQue.getPageNum(), pouringBaseQue.getPageSize());
        List<PouringBaseVO> RainWaterInfo = pouringBaseMapper.selectByFg(pouringBaseQue);
        PageInfo pageInfo = new PageInfo(RainWaterInfo);
        return pageInfo;
    }

    @Override
    public Integer getQS(Integer sbId) {
        PouringBase pouringBase = pouringBaseMapper.selectBySbId(sbId);
        if(pouringBase == null) return 0;
        if(pouringBase.getInterCoolingStartTime().isEmpty()) return 1;
        if(pouringBase.getSecondCoolingStartTime().isEmpty()) return 2;
        return 3;
    }
}
