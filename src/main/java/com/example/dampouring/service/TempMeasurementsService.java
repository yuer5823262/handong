package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.query.TempMeasurementsQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempMeasurementsService {

    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(TempMeasurementsQue tempMeasurementsQue);

    PageInfo assess(TempMeasurementsAssessQue tempMeasurementsAssessQue);

    List<TempMeasurements> exportList();

    void addAll(List<TempMeasurements> list);

    List<TempMeasurements> exportListByQue(TempMeasurementsQue tempMeasurementsQue);
}
