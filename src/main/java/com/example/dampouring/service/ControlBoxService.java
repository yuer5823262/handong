package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ControlBox;
import com.example.dampouring.model.request.AddControlBoxReq;
import com.example.dampouring.model.request.UpdateControlBoxReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.query.WaterRainStationQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ControlBoxService {
    void add(AddControlBoxReq addControlBoxReq, String userName);

    void update(UpdateControlBoxReq updateControlBoxReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<ControlBoxVO> listByIds( Integer[] ids);

    List<ControlBox> listByScsId(Integer scsId);


    List<ControlBoxVO> exportList();

    PageInfo selectByQue(WaterRainStationQue waterRainStationQue);
}
