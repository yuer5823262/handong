package com.example.dampouring.service;

import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface LayerTdiffAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);
    @Async("doSomethingExecutor")
    void layerTdiffAlert(String time);

    List<AlertBaseVO> list(Integer type);
}
