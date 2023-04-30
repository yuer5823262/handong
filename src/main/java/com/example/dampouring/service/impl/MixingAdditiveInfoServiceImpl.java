package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingAdditiveInfoMapper;
import com.example.dampouring.model.pojo.MixingAdditiveInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.example.dampouring.service.MixingAdditiveInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingAdditiveInfoServiceImpl implements MixingAdditiveInfoService {
    @Autowired
    MixingAdditiveInfoMapper MixingAdditiveInfoMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterInfoQue MixingAdditiveInfoQue) {
        PageHelper.startPage(MixingAdditiveInfoQue.getPageNum(), MixingAdditiveInfoQue.getPageSize());
        List<MixingAdditiveInfo> MixingAdditiveInfos= MixingAdditiveInfoMapper.selectList(MixingAdditiveInfoQue);
        PageInfo pageInfo = new PageInfo(MixingAdditiveInfos);
        return pageInfo;
    }

    @Override
    public List<MixingAdditiveInfo> exportList() {
        List<MixingAdditiveInfo> MixingAdditiveInfos= MixingAdditiveInfoMapper.selectList(new MixingWaterInfoQue());
        return MixingAdditiveInfos;
    }

    @Override
    public List<MixingAdditiveInfo> exportListByQue(MixingWaterInfoQue mixingInfoQue) {
        return MixingAdditiveInfoMapper.selectList(mixingInfoQue);
    }
}
