package com.example.dampouring.service;

import com.example.dampouring.model.pojo.PouringBase;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FaceDiapauseAlertService {
    PageInfo orUserSelect(AlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    void upFaceDiapauseAlert(PouringBase pouringBase);

    void upOpenTimeFaceDiapauseAlert(PouringBase pouringBase);

    void faceDiapauseAlert();

    List<AlertBaseVO> list(Integer type);
}
