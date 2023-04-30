package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.model.request.AddMixingBuildingReq;
import com.example.dampouring.model.request.UpdateMixingBuildingReq;
import com.example.dampouring.query.MixingBuildingQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingBuildingService {
    void add(AddMixingBuildingReq addMixingBuildingReq, String userName);

    void update(UpdateMixingBuildingReq updateMixingBuildingReq);

    void delete(Integer[] ids);


    List<MixingBuilding> orUserList();

    List<MixingBuilding> listByIds(Integer[] ids);

    PageInfo select(MixingBuildingQue mixingBuildingQue);
}
