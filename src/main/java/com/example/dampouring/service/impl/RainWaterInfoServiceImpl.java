package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.RainWaterInfoMapper;
import com.example.dampouring.model.pojo.RainWaterInfo;
import com.example.dampouring.query.RainWaterInfoQue;
import com.example.dampouring.service.RainWaterInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RainWaterInfoServiceImpl implements RainWaterInfoService {
    @Autowired
    RainWaterInfoMapper rainWaterInfoMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize,String type) {
        PageHelper.startPage(pageNum, pageSize);
        List<RainWaterInfo> RainWaterInfo = rainWaterInfoMapper.List(type);
        PageInfo pageInfo = new PageInfo(RainWaterInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(RainWaterInfoQue RainWaterInfoQue) {
        PageHelper.startPage(RainWaterInfoQue.getPageNum(), RainWaterInfoQue.getPageSize());
        List<RainWaterInfo> RainWaterInfo = rainWaterInfoMapper.selectList(RainWaterInfoQue);
        PageInfo pageInfo = new PageInfo(RainWaterInfo);
        return pageInfo;
    }

    @Override
    public List<RainWaterInfo> exportList() {
        List<RainWaterInfo> RainWaterInfo = rainWaterInfoMapper.selectList(new RainWaterInfoQue());
        return RainWaterInfo;
    }

    @Override
    public List<RainWaterInfo> exportListByQue(RainWaterInfoQue rainWaterInfoQue) {
        return rainWaterInfoMapper.selectList(rainWaterInfoQue);
    }
}
