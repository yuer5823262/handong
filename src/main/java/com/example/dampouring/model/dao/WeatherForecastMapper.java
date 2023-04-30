package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WeatherForecast;
import com.example.dampouring.query.WeatherForecastQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherForecastMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherForecast record);

    int insertSelective(WeatherForecast record);

    WeatherForecast selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherForecast record);

    int updateByPrimaryKey(WeatherForecast record);

    List<WeatherForecast> List();

    List<WeatherForecast> selectList(WeatherForecastQue weatherForecastQue);
}