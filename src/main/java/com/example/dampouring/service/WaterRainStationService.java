package com.example.dampouring.service;

import com.example.dampouring.model.pojo.WaterRainStation;
import com.example.dampouring.model.request.AddWaterRainStationReq;
import com.example.dampouring.model.request.UpdateWaterRainStationReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterRainStationService {
    void add(AddWaterRainStationReq addWaterRainStationReq, String userName);

    void update(UpdateWaterRainStationReq updateWaterRainStationReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<WaterRainStation> listByIds(Integer[] ids);

    List<WaterRainStation> exportList();

    PageInfo selectByQue(WaterRainStationQue waterRainStationQue);
}
