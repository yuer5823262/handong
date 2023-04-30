package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempMeasurementsAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(TempMeasurementsAssessQue TempMeasurementsAssessQue);

    void  timingComputing();

    List<TempMeasurementsAssess> exportList();
}
