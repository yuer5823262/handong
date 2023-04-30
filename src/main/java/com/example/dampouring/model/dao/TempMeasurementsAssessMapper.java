package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempMeasurementsAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMeasurementsAssess record);

    int insertSelective(TempMeasurementsAssess record);

    TempMeasurementsAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMeasurementsAssess record);

    int updateByPrimaryKey(TempMeasurementsAssess record);

    List<TempMeasurementsAssess> List();

    List<TempMeasurementsAssess> selectList(TempMeasurementsAssessQue tempMeasurementsAssessQue);

    List<TempMeasurementsAssess> selectByOld3Day(String yesterday,String yesterday1,String yesterday2);

    List<TempMeasurementsAssess> select30Day(Integer n);

    List<TempMeasurementsAssess> weatherInfo();

    TempMeasurementsAssess selectToDay();
}