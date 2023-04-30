package com.example.dampouring.service;

import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterColdAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void WaterColdAlert(WaterPipeFlowInfo waterPipeFlowInfo);

    List<AlertBaseVO> list(Integer type);
}
