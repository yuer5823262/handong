package com.example.dampouring.service;

import com.example.dampouring.model.request.AddTempGradometerReq;
import com.example.dampouring.model.request.UpdateTempGradometerReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.query.TempGradometerQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempGradometerService {
    void add(AddTempGradometerReq addTempGradometerReq, String userName);

    void update(UpdateTempGradometerReq updateTempGradometerReq);

    void delete(Integer[] ids);


    PageInfo orUserList(TempGradometerQue tempGradometerQue);

    List<TempGradometerVO> listByIds(Integer[] ids);

    List<TempGradometerVO> exportList();

    void updateChannelAll();
}
