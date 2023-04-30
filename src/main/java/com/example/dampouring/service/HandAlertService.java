package com.example.dampouring.service;

import com.example.dampouring.model.request.AddHandAlertReq;
import com.example.dampouring.model.request.UpdateHandAlertReq;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.HandAlertQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HandAlertService {
    void add(AddHandAlertReq addHandAlertReq, String userName);

    void update(UpdateHandAlertReq updateHandAlertReq);

    void delete(Integer[] ids);

    PageInfo orUserList(HandAlertQue handAlertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    List<AlertBaseVO> list(Integer type, Integer role);
}
