package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SwSiloData;
import com.example.dampouring.model.request.AddSwSiloDataReq;
import com.example.dampouring.model.request.UpdateSwSiloDataReq;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

public interface SwSiloDataService {
    void add(AddSwSiloDataReq addSwSiloDataReq, String userName);

    void update(UpdateSwSiloDataReq updateSwSiloDataReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SwSiloData> listByIds(Integer[] ids);

    void writeFile() throws Exception;
    void writeZyFile() throws Exception;
}
