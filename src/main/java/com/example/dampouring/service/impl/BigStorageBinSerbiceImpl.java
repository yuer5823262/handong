package com.example.dampouring.service.impl;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.BigStorageBinMapper;
import com.example.dampouring.model.dao.DamSegmentMapper;
import com.example.dampouring.model.dao.SmallStorageBinMapper;
import com.example.dampouring.model.pojo.BigStorageBin;
import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.request.AddBigStorageBinReq;
import com.example.dampouring.model.request.UpdateBigStorageBinReq;
import com.example.dampouring.service.BigStorageBinService;
import com.example.dampouring.util.TimeUtils;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BigStorageBinSerbiceImpl implements BigStorageBinService {
    @Autowired
    BigStorageBinMapper bigStorageBinMapper;
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @Autowired
    DamSegmentMapper damSegmentMapper;


    @Transactional
    @Override
    public void add(AddBigStorageBinReq addBigStorageBinReq, String userName) {
        if(!checkReqDate(addBigStorageBinReq.getDsStart(),
                addBigStorageBinReq.getDsEnd(),
                addBigStorageBinReq.getElevationStart(),
                addBigStorageBinReq.getElevationEnd()
                )) throw new DamPourException(DampouringExceptionEnum.BIG_SB_ADD_ERROR);
        BigStorageBin bigStorageBin = new BigStorageBin();
        SmallStorageBin smallStorageBin = new SmallStorageBin();
        BeanUtils.copyProperties(addBigStorageBinReq,bigStorageBin);
        BeanUtils.copyProperties(addBigStorageBinReq,smallStorageBin);
        bigStorageBin.setOperator(userName);
        bigStorageBin.setCreateTime(TimeUtils.getNowTime());
        bigStorageBin.setBigSbNoByDs();
        smallStorageBin.setCreateTime(TimeUtils.getNowTime());
        smallStorageBin.setOperator(userName);
//        smallStorageBin.setBigSbNo(bigStorageBin.getBigSbNo());
//        smallStorageBin.setSmallSbNoByCount(1);

        int count = bigStorageBinMapper.insertSelective(bigStorageBin);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
        count = smallStorageBinMapper.insertSelective(smallStorageBin);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }

    @Override
    public void update(UpdateBigStorageBinReq updateBigStorageBinReq) {
        BigStorageBin bigStorageBin = bigStorageBinMapper.selectByPrimaryKey(updateBigStorageBinReq.getId());
        if(bigStorageBin==null){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        copyUtils.copyPropertiesIgnoreNull(updateBigStorageBinReq, bigStorageBin);
        if(!checkReqDate(bigStorageBin.getDsStart(),
                bigStorageBin.getDsEnd(),
                bigStorageBin.getElevationStart(),
                bigStorageBin.getElevationEnd()
        )) throw new DamPourException(DampouringExceptionEnum.BIG_SB_ADD_ERROR);
        bigStorageBin.setBigSbNoByDs();
        int count = bigStorageBinMapper.updateByPrimaryKeySelective(bigStorageBin);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public void delete(Integer id) {
        BigStorageBin bigStorageBin =
                bigStorageBinMapper.selectByPrimaryKey(id);
        if (bigStorageBin == null) {
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
        int count = bigStorageBinMapper.deleteByPrimaryKey(id);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public PageInfo userVoList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BigStorageBin> bigStorageBins = bigStorageBinMapper.selectVoList();
        PageInfo pageInfo = new PageInfo(bigStorageBins);
        return pageInfo;
    }

    @Override
    public List<BigStorageBin> listByIds(Integer[] ids) {
        List<BigStorageBin> bigStorageBins = bigStorageBinMapper.selectByids(ids);
        return bigStorageBins;
    }


    Boolean checkReqDate(String dsStart,String dsEnd,double elevationStart,double elevationEnd){
        if(elevationStart>=elevationEnd)
        {
            return false;
        }
        DamSegment damSegmentStart = damSegmentMapper.selectByName(dsStart);
        DamSegment damSegmentEnd = damSegmentMapper.selectByName(dsEnd);
        if(damSegmentStart==null||damSegmentEnd==null){
            return false;
        }
        if(elevationStart<damSegmentStart.getElevationStart()||
                elevationEnd>damSegmentEnd.getElevationEnd())
            return  false;
        return true;
    }

}
