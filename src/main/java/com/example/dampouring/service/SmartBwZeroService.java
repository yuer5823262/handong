package com.example.dampouring.service;

import com.github.pagehelper.PageInfo;

public interface SmartBwZeroService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);

    void getDateInsert();
}
