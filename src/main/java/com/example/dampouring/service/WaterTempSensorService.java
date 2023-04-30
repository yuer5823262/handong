package com.example.dampouring.service;

import com.example.dampouring.model.request.AddWaterTempSensorReq;
import com.example.dampouring.model.request.UpdateWaterTempSensorReq;
import com.example.dampouring.model.vo.WaterTempSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterTempSensorService {
    void add(AddWaterTempSensorReq addWaterTempSensorReq, String userName);

    void update(UpdateWaterTempSensorReq updateWaterTempSensorReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<WaterTempSensorVO> listByIds(Integer[] ids);

    List<WaterTempSensorVO> exportList();

    void updateChannelAll();

    PageInfo select(WaterPressureSensorQue waterReversingDeviceQue);
}
