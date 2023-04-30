package com.example.dampouring.service;

import com.github.pagehelper.PageInfo;

public interface SmartBwDantiService {
    PageInfo orUserList(Integer pageNum, Integer pageSize, String dsNo);

    void getDateInsert();
}
