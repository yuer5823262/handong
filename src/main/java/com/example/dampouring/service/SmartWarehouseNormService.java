package com.example.dampouring.service;

import com.example.dampouring.model.request.AddSmartWarehouseNormReq;
import com.example.dampouring.model.request.UpdateSmartWarehouseNormReq;
import com.github.pagehelper.PageInfo;

public interface SmartWarehouseNormService {
    void add(AddSmartWarehouseNormReq addSmartWarehouseNormReq, String userName);

    void update(UpdateSmartWarehouseNormReq updateSmartWarehouseNormReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);
    
}
