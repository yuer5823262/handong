package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempControlNormName;
import com.example.dampouring.model.request.AddTempControlNormNameReq;
import com.example.dampouring.model.request.UpdateTempControlNormNameReq;
import com.example.dampouring.query.TempControlNormNameQue;

import java.util.List;

public interface TempControlNormNameService {
    void add(AddTempControlNormNameReq addTempControlNormNameReq, String userName);

    void update(UpdateTempControlNormNameReq updateTempControlNormNameReq);

    void delete(Integer[] ids);


    List<TempControlNormName> orUserList(TempControlNormNameQue name);

    List<TempControlNormName> listByIds(Integer[] ids);
}
