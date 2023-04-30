package com.example.dampouring.service;

import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MaxTempAlertService {
    PageInfo orUserSelect(AlertQue AlertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);
    void maxTempAlert(InnerTempSensorInfo innerTempSensorInfo, MaxTempNormVO maxTempNormVO);

    List<AlertBaseVO> list(Integer type);
}
