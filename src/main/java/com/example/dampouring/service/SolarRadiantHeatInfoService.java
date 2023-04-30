package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.query.SolarRadiantHeatInfoQue;
import com.example.dampouring.query.WeatherForecastQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SolarRadiantHeatInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(SolarRadiantHeatInfoQue solarRadiantHeatInfoQue);

    List<SolarRadiantHeatInfo> exportList();

    void addAll(List<SolarRadiantHeatInfo> list);

    List<SolarRadiantHeatInfo> exportListByQue(SolarRadiantHeatInfoQue solarRadiantHeatInfoQue);
}
