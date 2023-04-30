package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OutletTempAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void OutletTempAlerAlert(ExportMachineTempInfo exportMachineTempInfo, SbTempNormVO sbTempNormVO);

    List<AlertBaseVO> list(Integer type);
}
