package com.example.dampouring.service;

import com.example.dampouring.query.SmartWarehouseWarningQue;
import com.github.pagehelper.PageInfo;

public interface SmartWarehouseWarningService {
    PageInfo orUserSelect(SmartWarehouseWarningQue SmartWarehouseWarningQue);

    void processing(Integer[] ids, String username);
}
