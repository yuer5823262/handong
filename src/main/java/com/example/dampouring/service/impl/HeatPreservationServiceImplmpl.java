package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.HeatPreservationMapper;
import com.example.dampouring.model.pojo.HeatPreservation;
import com.example.dampouring.model.request.AddHeatPreservationReq;
import com.example.dampouring.model.request.UpdateHeatPreservationReq;
import com.example.dampouring.model.vo.HeatPreservationVO;
import com.example.dampouring.query.HeatPreservationQue;
import com.example.dampouring.service.HeatPreservationService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeatPreservationServiceImplmpl implements HeatPreservationService {
    @Autowired
    HeatPreservationMapper heatPreservationMapper;

    @Override
    public void add(AddHeatPreservationReq addHeatPreservationReq, String userName) {
        HeatPreservation HeatPreservation = new HeatPreservation();
        BeanUtils.copyProperties(addHeatPreservationReq,HeatPreservation);
        HeatPreservation.setOperator(userName);
        HeatPreservation.setCreateTime(TimeUtils.getNowTime());
        int count = heatPreservationMapper.insertSelective(HeatPreservation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateHeatPreservationReq updateHeatPreservationReq){
        HeatPreservation HeatPreservation =
                heatPreservationMapper.selectByPrimaryKey(updateHeatPreservationReq.getId());
        if (HeatPreservation == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateHeatPreservationReq,HeatPreservation);

        int count = heatPreservationMapper.updateByPrimaryKeySelective(HeatPreservation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = heatPreservationMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HeatPreservationVO> HeatPreservationList = heatPreservationMapper.selectList();
        PageInfo pageInfo = new PageInfo(HeatPreservationList);
        return pageInfo;
    }

    @Override
    public PageInfo selectByQue(HeatPreservationQue heatPreservationQue) {
        PageHelper.startPage(heatPreservationQue.getPageNum(), heatPreservationQue.getPageSize());
        List<HeatPreservationVO> HeatPreservationList = heatPreservationMapper.selectListByQue(heatPreservationQue);
        for (HeatPreservationVO heatPreservationVO : HeatPreservationList) {
            heatPreservationVO.setWarmIntervalByWarmTime();
        }
        PageInfo pageInfo = new PageInfo(HeatPreservationList);
        return pageInfo;
    }

    @Override
    public List<HeatPreservationVO> listByIds(Integer[] ids) {
        List<HeatPreservationVO> categoryList = heatPreservationMapper.selectListByIds(ids);
        return categoryList;

    }

    @Override
    public List<HeatPreservationVO> exportList() {
        List<HeatPreservationVO> HeatPreservationList = heatPreservationMapper.selectList();

        return HeatPreservationList;
    }
}
