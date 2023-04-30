package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SolarRadioMeterMapper;
import com.example.dampouring.model.pojo.SolarRadioMeter;
import com.example.dampouring.model.request.AddSolarRadioMeterReq;
import com.example.dampouring.model.request.UpdateSolarRadioMeterReq;
import com.example.dampouring.service.SolarRadioMeterService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarRadioMeterServiceImpl implements SolarRadioMeterService {
    @Autowired
    SolarRadioMeterMapper solarRadioMeterMapper;

    @Override
    public void add(AddSolarRadioMeterReq addSolarRadioMeterReq, String userName) {
        SolarRadioMeter SolarRadioMeterCheck = solarRadioMeterMapper.selectByNo(addSolarRadioMeterReq.getNo());
        if (SolarRadioMeterCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        SolarRadioMeter solarRadioMeter = new SolarRadioMeter();
        BeanUtils.copyProperties(addSolarRadioMeterReq,solarRadioMeter);
        solarRadioMeter.setOperator(userName);
        solarRadioMeter.setCreateTime(TimeUtils.getNowTime());
        int count = solarRadioMeterMapper.insertSelective(solarRadioMeter);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSolarRadioMeterReq updateSolarRadioMeterReq){
        SolarRadioMeter solarRadioMeter =
                solarRadioMeterMapper.selectByPrimaryKey(updateSolarRadioMeterReq.getId());
        if (solarRadioMeter == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        SolarRadioMeter solarRadioMeterCheck =
                solarRadioMeterMapper.selectByNo(updateSolarRadioMeterReq.getNo());
        if (solarRadioMeterCheck != null &&
                !solarRadioMeterCheck.getNo().equals(solarRadioMeter.getNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateSolarRadioMeterReq,solarRadioMeter);

        int count = solarRadioMeterMapper.updateByPrimaryKeySelective(solarRadioMeter);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = solarRadioMeterMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SolarRadioMeter> solarRadioMeterList = solarRadioMeterMapper.selectList();
        PageInfo pageInfo = new PageInfo(solarRadioMeterList);
        return pageInfo;
    }

    @Override
    public List<SolarRadioMeter> listByIds(Integer[] ids) {
        List<SolarRadioMeter> categoryList = solarRadioMeterMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<SolarRadioMeter> exportList() {
        List<SolarRadioMeter> solarRadioMeterList = solarRadioMeterMapper.selectList();

        return solarRadioMeterList;
    }
}
