package com.example.dampouring.service;

import com.example.dampouring.model.request.AddInnerTempSensorReq;
import com.example.dampouring.model.request.UpdateInnerTempSensorReq;
import com.example.dampouring.model.vo.InnerTempSensorVO;
import com.example.dampouring.query.InnerTempSensorQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FaceTempSensorService {
    void add(AddInnerTempSensorReq addInnerTempSensorReq, String userName);

    void update(UpdateInnerTempSensorReq updateInnerTempSensorReq);

    void delete(Integer[] ids);


    PageInfo orUserList(InnerTempSensorQue innerTempSensorQue);

    List<InnerTempSensorVO> listByIds(Integer[] ids);

    List<InnerTempSensorVO> exportList();

    void updateChannelAll();
}
