package com.example.dampouring.service;

import com.example.dampouring.model.request.AddAirTempSensorReq;
import com.example.dampouring.model.request.UpdateAirTempSensorReq;
import com.example.dampouring.model.vo.AirTempSensorVO;
import com.example.dampouring.query.AirTempSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AirTempSensorService {
    void add(AddAirTempSensorReq addAirTempSensorReq, String userName);
    void updateChannelAll();
    void update(UpdateAirTempSensorReq updateAirTempSensorReq);
    void delete(Integer[] ids);
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    List<AirTempSensorVO> listByIds(Integer[] ids);
    List<AirTempSensorVO> exportList();
    PageInfo select(AirTempSensorQue airTempSensorQue);
}
