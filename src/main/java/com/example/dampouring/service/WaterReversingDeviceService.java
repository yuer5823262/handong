package com.example.dampouring.service;

import com.example.dampouring.model.request.AddWaterReversingDeviceReq;
import com.example.dampouring.model.request.UpdateWaterReversingDeviceReq;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.WaterReversingDeviceQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterReversingDeviceService {
    void add(AddWaterReversingDeviceReq addWaterReversingDeviceReq, String userName);

    void update(UpdateWaterReversingDeviceReq updateWaterReversingDeviceReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<WaterReversingDeviceVO> listByIds(Integer[] ids);

    List<WaterReversingDeviceVO> exportList();

    PageInfo select(WaterReversingDeviceQue waterReversingDeviceQue);
}
