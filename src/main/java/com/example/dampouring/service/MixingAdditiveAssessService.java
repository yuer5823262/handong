package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingAdditiveAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingAdditiveAssessService {
    PageInfo orUserSelect(MixingWaterAssessQue mixingWaterAssessQue);

    void timingComputing();

    List<MixingAdditiveAssess> exportList();
}
