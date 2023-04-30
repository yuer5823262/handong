package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SolarRadioMeter;
import com.example.dampouring.model.request.AddSolarRadioMeterReq;
import com.example.dampouring.model.request.UpdateSolarRadioMeterReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SolarRadioMeterService {
    void add(AddSolarRadioMeterReq addSolarRadioMeterReq, String userName);

    void update(UpdateSolarRadioMeterReq updateSolarRadioMeterReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SolarRadioMeter> listByIds(Integer[] ids);

    List<SolarRadioMeter> exportList();
}
