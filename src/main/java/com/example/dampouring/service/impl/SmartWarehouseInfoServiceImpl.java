package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.smartWarehouseInfoMapper;
import com.example.dampouring.model.pojo.smartWarehouseInfo;
import com.example.dampouring.query.SmartWarehouseInfoQue;
import com.example.dampouring.service.smartWarehouseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartWarehouseInfoServiceImpl implements smartWarehouseInfoService {
    @Autowired
    smartWarehouseInfoMapper smartWarehouseInfoMapper;
    @Override
    public PageInfo orUserSelect(SmartWarehouseInfoQue SmartWarehouseInfoQue) {
        PageHelper.startPage(SmartWarehouseInfoQue.getPageNum(), SmartWarehouseInfoQue.getPageSize());
        List<smartWarehouseInfo> InboundTempInfo = smartWarehouseInfoMapper.selectList(SmartWarehouseInfoQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
}
