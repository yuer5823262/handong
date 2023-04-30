package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.query.MixingBetonAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingBetonAssessService {
    PageInfo orUserSelect(MixingBetonAssessQue mixingBetonAssessQue);
    void timingComputing();

    List<MixingBetonAssess> exportList();
}
