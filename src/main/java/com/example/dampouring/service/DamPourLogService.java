package com.example.dampouring.service;

import com.example.dampouring.query.DamPourLogQue;
import com.github.pagehelper.PageInfo;

public interface DamPourLogService {
    PageInfo orUserList(DamPourLogQue damPourLogQue);
}
