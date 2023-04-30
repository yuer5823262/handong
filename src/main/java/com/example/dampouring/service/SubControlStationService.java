package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.model.request.AddSubControlStationReq;
import com.example.dampouring.model.request.UpdateSubControlStationReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubControlStationService {
    void add(AddSubControlStationReq addSubControlStationReq, String userName);

    void update(UpdateSubControlStationReq updateSubControlStationReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SubControlStation> listByIds(Integer[] ids);

    List<SubControlStation> exportList();

    PageInfo selectByQue(WaterRainStationQue waterRainStationQue);
}
