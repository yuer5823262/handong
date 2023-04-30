package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.query.TempMeasurementsQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempMeasurementsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMeasurements record);

    int insertSelective(TempMeasurements record);

    TempMeasurements selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMeasurements record);

    int updateByPrimaryKey(TempMeasurements record);

    List<TempMeasurements> List();

    List<TempMeasurements> selectList(TempMeasurementsQue tempMeasurementsQue);

    List<TempMeasurementsAssess> assess(TempMeasurementsAssessQue tempMeasurementsAssessQue);

    TempMeasurementsAssess AssessComputing(String yesterday);
}