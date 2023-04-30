package com.example.dampouring.service;

import com.example.dampouring.query.AlertQue;
import com.github.pagehelper.PageInfo;

public interface SmartHeat7dayService {
    PageInfo orUserSelect(AlertQue alertQue);
}
