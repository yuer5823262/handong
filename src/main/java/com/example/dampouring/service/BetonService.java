package com.example.dampouring.service;

import com.example.dampouring.model.pojo.Beton;
import com.example.dampouring.model.request.AddBetonReq;
import com.example.dampouring.model.request.UpdateBetonReq;

import java.util.List;

public interface BetonService {
    void add(AddBetonReq addBetonReq, String userName);

    void update(UpdateBetonReq updateBetonReq);

    void delete(Integer[] ids);


    List<Beton> orUserList();
}
