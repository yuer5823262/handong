package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.query.SolarRadiantHeatInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolarRadiantHeatInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SolarRadiantHeatInfo record);

    int insertSelective(SolarRadiantHeatInfo record);

    SolarRadiantHeatInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SolarRadiantHeatInfo record);

    int updateByPrimaryKey(SolarRadiantHeatInfo record);

    List<SolarRadiantHeatInfo> List();

    List<SolarRadiantHeatInfo> selectList(SolarRadiantHeatInfoQue solarRadiantHeatInfoQue);
}