package com.example.dampouring.service;

import com.example.dampouring.model.request.AddWaterPressureSensorReq;
import com.example.dampouring.model.request.UpdateWaterPressureSensorReq;
import com.example.dampouring.model.vo.WaterPressureSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterPressureSensorService {
    void add(AddWaterPressureSensorReq addWaterPressureSensorReq, String userName);

    void update(UpdateWaterPressureSensorReq updateWaterPressureSensorReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<WaterPressureSensorVO> listByIds(Integer[] ids);

    List<WaterPressureSensorVO> exportList();

    PageInfo select(WaterPressureSensorQue waterReversingDeviceQue);
}
