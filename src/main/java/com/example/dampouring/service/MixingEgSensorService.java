package com.example.dampouring.service;

import com.example.dampouring.model.request.AddMixingEgSensorReq;
import com.example.dampouring.model.request.UpdateMixingEgSensorReq;
import com.example.dampouring.model.vo.MixingEgSensorVO;
import com.example.dampouring.query.MixingEgSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingEgSensorService {
    void add(AddMixingEgSensorReq addMixingEgSensorReq, String userName);

    void update(UpdateMixingEgSensorReq updateMixingEgSensorReq);

    void delete(Integer[] ids);


    PageInfo orUserList(MixingEgSensorQue MixingEgSensorInfoQue);

    List<MixingEgSensorVO> listByIds(Integer[] ids);

    List<MixingEgSensorVO> exportList();
}
