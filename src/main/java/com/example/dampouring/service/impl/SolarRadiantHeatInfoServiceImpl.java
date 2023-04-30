package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.SolarRadiantHeatInfoMapper;
import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.query.SolarRadiantHeatInfoQue;
import com.example.dampouring.query.SolarRadiantHeatInfoQue;
import com.example.dampouring.service.SolarRadiantHeatInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarRadiantHeatInfoServiceImpl implements SolarRadiantHeatInfoService {
    @Autowired
    SolarRadiantHeatInfoMapper solarRadiantHeatInfoMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SolarRadiantHeatInfo> SolarRadiantHeatInfo = solarRadiantHeatInfoMapper.List();
        PageInfo pageInfo = new PageInfo(SolarRadiantHeatInfo);
        return pageInfo;
    }

    @Override
    public PageInfo orUserSelect(SolarRadiantHeatInfoQue SolarRadiantHeatInfoQue) {
        PageHelper.startPage(SolarRadiantHeatInfoQue.getPageNum(), SolarRadiantHeatInfoQue.getPageSize());
        List<SolarRadiantHeatInfo> SolarRadiantHeatInfo = solarRadiantHeatInfoMapper.selectList(SolarRadiantHeatInfoQue);
        PageInfo pageInfo = new PageInfo(SolarRadiantHeatInfo);
        return pageInfo;
    }

    @Override
    public List<SolarRadiantHeatInfo> exportList() {
        List<SolarRadiantHeatInfo> SolarRadiantHeatInfo = solarRadiantHeatInfoMapper.List();

        return SolarRadiantHeatInfo;
    }

    @Override
    public void addAll(List<SolarRadiantHeatInfo> list) {
        for(SolarRadiantHeatInfo solarRadiantHeatInfo:list)
        {
            solarRadiantHeatInfoMapper.insertSelective(solarRadiantHeatInfo);
        }
    }

    @Override
    public List<SolarRadiantHeatInfo> exportListByQue(SolarRadiantHeatInfoQue solarRadiantHeatInfoQue) {
        return solarRadiantHeatInfoMapper.selectList(solarRadiantHeatInfoQue);
    }
}
