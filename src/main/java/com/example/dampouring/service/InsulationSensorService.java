package com.example.dampouring.service;

import com.example.dampouring.model.request.AddInsulationSensorReq;
import com.example.dampouring.model.request.UpdateInsulationSensorReq;
import com.example.dampouring.model.vo.InsulationSensorVO;
import com.example.dampouring.query.InsulationSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InsulationSensorService {
    void add(AddInsulationSensorReq addInsulationSensorReq, String username);

    void update(UpdateInsulationSensorReq updateInsulationSensorReq);

    void delete(Integer[] ids);

    PageInfo orUserList(InsulationSensorQue insulationSensorQue);

    void updateChannelAll();

    List<InsulationSensorVO> listByIds(Integer[] ids);

    List<InsulationSensorVO> exportList();
}
