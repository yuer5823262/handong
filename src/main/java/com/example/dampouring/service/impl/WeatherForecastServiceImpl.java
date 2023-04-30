package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.WeatherForecastMapper;
import com.example.dampouring.model.pojo.WeatherForecast;
import com.example.dampouring.model.vo.TianqiVO;
import com.example.dampouring.query.WeatherForecastQue;
import com.example.dampouring.service.WeatherForecastService;
import com.example.dampouring.util.TianqiUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {
    @Autowired
    WeatherForecastMapper weatherForecastMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WeatherForecast> WeatherForecast = weatherForecastMapper.List();
        PageInfo pageInfo = new PageInfo(WeatherForecast);
        return pageInfo;
    }

    @Override
    public PageInfo orUserSelect(WeatherForecastQue WeatherForecastQue) {
        PageHelper.startPage(WeatherForecastQue.getPageNum(), WeatherForecastQue.getPageSize());
        List<WeatherForecast> WeatherForecast = weatherForecastMapper.selectList(WeatherForecastQue);
        PageInfo pageInfo = new PageInfo(WeatherForecast);
        return pageInfo;
    }

    @Override
    public List<WeatherForecast> exportList() {
        List<WeatherForecast> WeatherForecast = weatherForecastMapper.List();
        return WeatherForecast;
    }

    @Override
    public void timingComputing() {
        try {
            List<TianqiVO> integerList = TianqiUtils.getTiqnqi();
            if(integerList==null) return;
            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setCity(Constant.city);
            weatherForecast.setFirstDay(TimeUtils.getNextDay(0));
            weatherForecast.setFirstDayHight(integerList.get(7).getMaxTemperature());
            weatherForecast.setFirstDayLow(integerList.get(7).getMinTemperature());
            weatherForecast.setSecondDay(TimeUtils.getNextDay(1));
            weatherForecast.setSecondDayHight(integerList.get(8).getMaxTemperature());
            weatherForecast.setSecondDayLow(integerList.get(8).getMinTemperature());
            weatherForecast.setThirdDay(TimeUtils.getNextDay(2));
            weatherForecast.setThirdDayHight(integerList.get(9).getMaxTemperature());
            weatherForecast.setThirdDayLow(integerList.get(9).getMinTemperature());
            Double diff=0.;
            Double temp1 = (integerList.get(7).getMaxTemperature()+integerList.get(7).getMinTemperature())/2;
            Double temp2 = (integerList.get(8).getMaxTemperature()+integerList.get(8).getMinTemperature())/2;
            Double temp3 = (integerList.get(9).getMaxTemperature()+integerList.get(9).getMinTemperature())/2;
            Double temp4 = (integerList.get(10).getMaxTemperature()+integerList.get(10).getMinTemperature())/2;
            diff = diff + (temp1-temp2)>0?temp1-temp2:0;
            diff = diff + (temp2-temp3)>0?temp2-temp3:0;
            diff = diff + (temp3-temp4)>0?temp3-temp4:0;
            weatherForecast.setTempDifference(diff);
            weatherForecast.setBl(2);
            weatherForecastMapper.insertSelective(weatherForecast);
        } catch (Exception e) {
            Constant.logger.error("天气预报信息获取失败",e);
        }

    }

    @Override
    public void addAll(List<WeatherForecast> list) {
        for(WeatherForecast weatherForecast:list)
        {
            weatherForecastMapper.insertSelective(weatherForecast);
        }
    }

    @Override
    public List<WeatherForecast> exportListByQue(WeatherForecastQue weatherForecastQue) {
        return weatherForecastMapper.selectList(weatherForecastQue);
    }
}
