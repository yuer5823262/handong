package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.WaterRainStationMapper;
import com.example.dampouring.model.pojo.WaterRainStation;
import com.example.dampouring.model.request.AddWaterRainStationReq;
import com.example.dampouring.model.request.UpdateWaterRainStationReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.WaterRainStationService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaterRainStationServiceImpl implements WaterRainStationService {
    @Autowired
    WaterRainStationMapper waterRainStationMapper;

    @Override
    public void add(AddWaterRainStationReq addWaterRainStationReq, String userName) {
        WaterRainStation waterRainStationCheck = waterRainStationMapper.selectByName(addWaterRainStationReq.getWrsName());
        if (waterRainStationCheck != null) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        WaterRainStation waterRainStation = new WaterRainStation();
        BeanUtils.copyProperties(addWaterRainStationReq,waterRainStation);
        waterRainStation.setOperator(userName);
        waterRainStation.setCreateTime(TimeUtils.getNowTime());
        int count = waterRainStationMapper.insertSelective(waterRainStation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateWaterRainStationReq updateWaterRainStationReq){
        WaterRainStation waterRainStation =
                waterRainStationMapper.selectByPrimaryKey(updateWaterRainStationReq.getId());
        if (waterRainStation == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        WaterRainStation waterRainStationCheck =
                waterRainStationMapper.selectByName(updateWaterRainStationReq.getWrsName());
        if (waterRainStationCheck != null &&
                !waterRainStationCheck.getWrsName().equals(waterRainStation.getWrsName()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateWaterRainStationReq,waterRainStation);

        int count = waterRainStationMapper.updateByPrimaryKeySelective(waterRainStation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = waterRainStationMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterRainStation> waterRainStationList = waterRainStationMapper.selectList();
        PageInfo pageInfo = new PageInfo(waterRainStationList);
        return pageInfo;
    }

    @Override
    public List<WaterRainStation> listByIds(Integer[] ids) {
        List<WaterRainStation> categoryList = waterRainStationMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<WaterRainStation> exportList() {
        List<WaterRainStation> waterRainStationList = waterRainStationMapper.selectList();

        return waterRainStationList;
    }

    @Override
    public PageInfo selectByQue(WaterRainStationQue waterRainStationQue) {
        PageHelper.startPage(waterRainStationQue.getPageNum(), waterRainStationQue.getPageSize());
        List<WaterRainStation> waterRainStationList = waterRainStationMapper.selectByQue(waterRainStationQue);
        PageInfo pageInfo = new PageInfo(waterRainStationList);
        return pageInfo;
    }
}
