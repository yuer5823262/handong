package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SwTemperatureMon;
import com.example.dampouring.model.request.AddSwTemperatureMonReq;
import com.example.dampouring.model.request.UpdateSwTemperatureMonReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SwTemperatureMonService {
    void add(AddSwTemperatureMonReq addSwTemperatureMonReq, String userName);

    void update(UpdateSwTemperatureMonReq updateSwTemperatureMonReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SwTemperatureMon> listByIds(Integer[] ids);
}
