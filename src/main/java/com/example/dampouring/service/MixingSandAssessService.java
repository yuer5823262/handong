package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingSandAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingSandAssessService {
    PageInfo orUserSelect(MixingWaterAssessQue mixingWaterAssessQue);

    void timingComputing();

    List<MixingSandAssess> exportList();
}
