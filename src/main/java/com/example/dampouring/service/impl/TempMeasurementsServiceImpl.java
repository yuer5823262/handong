package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.TempMeasurementsMapper;
import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.query.TempMeasurementsQue;
import com.example.dampouring.service.TempMeasurementsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempMeasurementsServiceImpl implements TempMeasurementsService {
    @Autowired
    TempMeasurementsMapper tempMeasurementsMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempMeasurements> tempMeasurements = tempMeasurementsMapper.List();
        PageInfo pageInfo = new PageInfo(tempMeasurements);
        return pageInfo;
    }

    @Override
    public PageInfo orUserSelect(TempMeasurementsQue tempMeasurementsQue) {
        PageHelper.startPage(tempMeasurementsQue.getPageNum(), tempMeasurementsQue.getPageSize());
        List<TempMeasurements> tempMeasurements = tempMeasurementsMapper.selectList(tempMeasurementsQue);
        PageInfo pageInfo = new PageInfo(tempMeasurements);
        return pageInfo;
    }

    @Override
    public PageInfo assess(TempMeasurementsAssessQue tempMeasurementsAssessQue) {
        PageHelper.startPage(tempMeasurementsAssessQue.getPageNum(), tempMeasurementsAssessQue.getPageSize());
        List<TempMeasurementsAssess> tempMeasurements = tempMeasurementsMapper.assess(tempMeasurementsAssessQue);
        for(int i = tempMeasurements.size()-1;i>0;i--){
            tempMeasurements.get(i).setLessTemp(tempMeasurements.get(i).getAvgTemp()-tempMeasurements.get(i-1).getAvgTemp());
        }
        PageInfo pageInfo = new PageInfo(tempMeasurements);
        return pageInfo;
    }

    @Override
    public List<TempMeasurements> exportList() {
        List<TempMeasurements> tempMeasurements = tempMeasurementsMapper.List();
        return tempMeasurements;
    }

    @Override
    public void addAll(List<TempMeasurements> list) {
        for(TempMeasurements tempMeasurements:list)
        {
            tempMeasurementsMapper.insertSelective(tempMeasurements);
        }
    }

    @Override
    public List<TempMeasurements> exportListByQue(TempMeasurementsQue tempMeasurementsQue) {
        return tempMeasurementsMapper.selectList(tempMeasurementsQue);
    }


}
