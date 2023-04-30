package com.example.dampouring.service;

import com.example.dampouring.model.pojo.PouringTempInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PouringTempAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void pouringTempAlert(PouringTempInfo pouringTempInfo, SbTempNormVO sbTempNormVO);

    List<AlertBaseVO> list(Integer type);
}
