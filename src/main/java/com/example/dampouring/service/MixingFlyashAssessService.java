package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingFlyashAssess;
import com.example.dampouring.query.MixingFlyashAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingFlyashAssessService {
    PageInfo orUserSelect(MixingFlyashAssessQue mixingFlyashAssessQue);


    void timingComputing();

    List<MixingFlyashAssess> exportList();
}
