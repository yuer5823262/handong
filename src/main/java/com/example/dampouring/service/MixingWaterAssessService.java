package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingWaterAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingWaterAssessService {
    PageInfo orUserSelect(MixingWaterAssessQue mixingWaterAssessQue);

    void timingComputing();

    List<MixingWaterAssess> exportList();
}
