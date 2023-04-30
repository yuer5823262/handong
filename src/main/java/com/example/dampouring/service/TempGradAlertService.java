package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempGradometerInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempGradAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void TempGradTempAlert(TempGradometerInfo tempGradometerInfo);

    List<AlertBaseVO> list(Integer type);
}
