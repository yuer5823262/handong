package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingFlyashInfoMapper;
import com.example.dampouring.model.pojo.MixingFlyashInfo;
import com.example.dampouring.query.MixingFlyashInfoQue;
import com.example.dampouring.service.MixingFlyashInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingFlyashInfoServiceImpl implements MixingFlyashInfoService {
    @Autowired
    MixingFlyashInfoMapper MixingFlyashInfoMapper;
    @Override
    public PageInfo orUserSelect(MixingFlyashInfoQue MixingFlyashInfoQue) {
        PageHelper.startPage(MixingFlyashInfoQue.getPageNum(), MixingFlyashInfoQue.getPageSize());
        List<MixingFlyashInfo> MixingFlyashInfos= MixingFlyashInfoMapper.selectList(MixingFlyashInfoQue);
        PageInfo pageInfo = new PageInfo(MixingFlyashInfos);
        return pageInfo;
    }

    @Override
    public List<MixingFlyashInfo> exportList() {
        List<MixingFlyashInfo> MixingFlyashInfos= MixingFlyashInfoMapper.selectList(new MixingFlyashInfoQue());

        return MixingFlyashInfos;
    }

    @Override
    public List<MixingFlyashInfo> exportListByQue(MixingFlyashInfoQue mixingFlyashInfoQue) {
        return MixingFlyashInfoMapper.selectList(mixingFlyashInfoQue);
    }
}
