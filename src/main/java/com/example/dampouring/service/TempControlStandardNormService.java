package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempControlStandardNorm;
import com.example.dampouring.model.request.AddTempControlStandardNormReq;
import com.example.dampouring.model.request.UpdateTempControlStandardNormReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempControlStandardNormService {
    void add(AddTempControlStandardNormReq addTempControlStandardNormReq, String userName);

    void update(UpdateTempControlStandardNormReq updateTempControlStandardNormReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<TempControlStandardNorm> listByIds(Integer[] ids);
}
