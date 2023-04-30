package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingWaterInfoMapper;
import com.example.dampouring.model.pojo.MixingWaterInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.example.dampouring.service.MixingWaterInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingWaterInfoServiceImpl implements MixingWaterInfoService {
    @Autowired
    MixingWaterInfoMapper MixingWaterInfoMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterInfoQue MixingWaterInfoQue) {
        PageHelper.startPage(MixingWaterInfoQue.getPageNum(), MixingWaterInfoQue.getPageSize());
        List<MixingWaterInfo> MixingWaterInfos= MixingWaterInfoMapper.selectList(MixingWaterInfoQue);
        PageInfo pageInfo = new PageInfo(MixingWaterInfos);
        return pageInfo;
    }

    @Override
    public List<MixingWaterInfo> exportList() {
        List<MixingWaterInfo> MixingWaterInfos= MixingWaterInfoMapper.selectList(new MixingWaterInfoQue());
        return MixingWaterInfos;
    }

    @Override
    public List<MixingWaterInfo> exportListByQue(MixingWaterInfoQue mixingWaterInfoQue) {
        return MixingWaterInfoMapper.selectList(mixingWaterInfoQue);
    }
}
