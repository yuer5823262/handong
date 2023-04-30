package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.FaceMicroClimateMapper;
import com.example.dampouring.model.pojo.FaceMicroClimate;
import com.example.dampouring.model.request.AddFaceMicroClimateReq;
import com.example.dampouring.model.request.UpdateFaceMicroClimateReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.FaceMicroClimateService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FaceMicroClimateServiceImpl implements FaceMicroClimateService {
    @Autowired
    FaceMicroClimateMapper faceMicroClimateMapper;

    @Override
    public void add(AddFaceMicroClimateReq addFaceMicroClimateReq, String userName) {
        FaceMicroClimate faceMicroClimateCheck = faceMicroClimateMapper.selectByDeviceNo(addFaceMicroClimateReq.getDeviceNo());
        if (faceMicroClimateCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        FaceMicroClimate FaceMicroClimate = new FaceMicroClimate();
        BeanUtils.copyProperties(addFaceMicroClimateReq,FaceMicroClimate);
        FaceMicroClimate.setOperator(userName);
        FaceMicroClimate.setCreateTime(TimeUtils.getNowTime());
        int count = faceMicroClimateMapper.insertSelective(FaceMicroClimate);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateFaceMicroClimateReq updateFaceMicroClimateReq){
        FaceMicroClimate faceMicroClimate =
                faceMicroClimateMapper.selectByPrimaryKey(updateFaceMicroClimateReq.getId());
        if (faceMicroClimate == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        FaceMicroClimate faceMicroClimateCheck =
                faceMicroClimateMapper.selectByDeviceNo(updateFaceMicroClimateReq.getDeviceNo());
        if (faceMicroClimateCheck != null &&
                !faceMicroClimateCheck.getDeviceNo().equals(faceMicroClimate.getDeviceNo()) ) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateFaceMicroClimateReq,faceMicroClimate);

        int count = faceMicroClimateMapper.updateByPrimaryKeySelective(faceMicroClimate);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = faceMicroClimateMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FaceMicroClimate> FaceMicroClimateList = faceMicroClimateMapper.selectList();
        PageInfo pageInfo = new PageInfo(FaceMicroClimateList);
        return pageInfo;
    }

    @Override
    public List<FaceMicroClimate> listByIds(Integer[] ids) {
        List<FaceMicroClimate> categoryList = faceMicroClimateMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<FaceMicroClimate> exportList() {
        List<FaceMicroClimate> FaceMicroClimateList = faceMicroClimateMapper.selectList();

        return FaceMicroClimateList;
    }

    @Override
    public PageInfo selectByQue(WaterRainStationQue waterRainStationQue) {
        PageHelper.startPage(waterRainStationQue.getPageNum(), waterRainStationQue.getPageSize());
        List<FaceMicroClimate> FaceMicroClimateList = faceMicroClimateMapper.selectByQue(waterRainStationQue);
        PageInfo pageInfo = new PageInfo(FaceMicroClimateList);
        return pageInfo;
    }
}
