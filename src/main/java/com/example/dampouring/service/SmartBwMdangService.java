package com.example.dampouring.service;

import com.github.pagehelper.PageInfo;

public interface SmartBwMdangService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);

    void getDateInsert();
}
