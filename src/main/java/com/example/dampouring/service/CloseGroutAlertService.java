package com.example.dampouring.service;

import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CloseGroutAlertService {
    PageInfo orUserSelect(AlertQue alertQue);
    List<AlertBaseVO> list(Integer type);
    void processing(Integer[] ids, String username,String type,Integer mark);
    void closeGroutAlert();
}
