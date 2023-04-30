package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingSandInfoMapper;
import com.example.dampouring.model.pojo.MixingSandInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.example.dampouring.service.MixingSandInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingSandInfoServiceImpl implements MixingSandInfoService {
    @Autowired
    MixingSandInfoMapper MixingSandInfoMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterInfoQue MixingSandInfoQue) {
        PageHelper.startPage(MixingSandInfoQue.getPageNum(), MixingSandInfoQue.getPageSize());
        List<MixingSandInfo> MixingSandInfos= MixingSandInfoMapper.selectList(MixingSandInfoQue);
        PageInfo pageInfo = new PageInfo(MixingSandInfos);
        return pageInfo;
    }

    @Override
    public List<MixingSandInfo> exportList() {
        List<MixingSandInfo> MixingSandInfos= MixingSandInfoMapper.selectList(new MixingWaterInfoQue());

        return MixingSandInfos;
    }

    @Override
    public List<MixingSandInfo> exportListByQue(MixingWaterInfoQue mixingInfoQue) {
        return  MixingSandInfoMapper.selectList(mixingInfoQue);
    }
}
