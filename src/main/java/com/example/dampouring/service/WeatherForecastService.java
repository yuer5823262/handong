package com.example.dampouring.service;

import com.example.dampouring.model.pojo.WeatherForecast;
import com.example.dampouring.query.WeatherForecastQue;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface WeatherForecastService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(WeatherForecastQue WeatherForecastQue);

    List<WeatherForecast> exportList();
    @Async
    void timingComputing();

    void addAll(List<WeatherForecast> list);

    List<WeatherForecast> exportListByQue(WeatherForecastQue weatherForecastQue);
}
