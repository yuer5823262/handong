package com.example.dampouring.service;

import com.example.dampouring.query.AlertBaseQue;
import com.github.pagehelper.PageInfo;

public interface AlertBaseService {
    PageInfo selectByAlertInfo(String alertInfo, AlertBaseQue alertBaseQue);

    void processing(String uName, Integer type, String remark, Integer[] ids, Integer mark);
}
