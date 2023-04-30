package com.example.dampouring.service;

import com.example.dampouring.model.pojo.FaceMicroClimate;
import com.example.dampouring.model.request.AddFaceMicroClimateReq;
import com.example.dampouring.model.request.UpdateFaceMicroClimateReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FaceMicroClimateService {
    void add(AddFaceMicroClimateReq addFaceMicroClimateReq, String userName);

    void update(UpdateFaceMicroClimateReq updateFaceMicroClimateReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<FaceMicroClimate> listByIds(Integer[] ids);

    List<FaceMicroClimate> exportList();

    PageInfo selectByQue(WaterRainStationQue waterRainStationQue);
}
