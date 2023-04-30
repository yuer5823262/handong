package com.example.dampouring.service;

import com.example.dampouring.query.SmartWarehouseInfoQue;
import com.github.pagehelper.PageInfo;

public interface smartWarehouseInfoService {
    PageInfo orUserSelect(SmartWarehouseInfoQue smartWarehouseInfoQue);
}
