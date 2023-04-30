package com.example.dampouring.service;

import com.github.pagehelper.PageInfo;

public interface SmartBwBwresService {
    PageInfo orUserList(Integer pageNum, Integer pageSize, String dsNo);
    void getDateInsert();
}
