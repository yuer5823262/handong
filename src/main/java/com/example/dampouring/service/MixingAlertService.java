package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingTempInfo;
import com.example.dampouring.model.pojo.SmartMixingResult;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.MixingAlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingAlertService {
    PageInfo orUserSelect(MixingAlertQue AlertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void mixingTempAlert(SmartMixingResult smartMixingResult);

    List<AlertBaseVO> list(Integer type);
}
