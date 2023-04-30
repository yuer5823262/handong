package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.InnerTempSensorInfoMapper;
import com.example.dampouring.model.dao.MixingBetonInfoMapper;
import com.example.dampouring.model.pojo.MixingBetonInfo;
import com.example.dampouring.model.vo.InnerTempSensorInfoVO;
import com.example.dampouring.query.MixingBetonInfoQue;
import com.example.dampouring.service.MixingBetonInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingBetonInfoServiceImpl implements MixingBetonInfoService {
    @Autowired
    MixingBetonInfoMapper mixingBetonInfoMapper;
    @Override
    public PageInfo orUserSelect(MixingBetonInfoQue MixingBetonInfoQue) {
        PageHelper.startPage(MixingBetonInfoQue.getPageNum(), MixingBetonInfoQue.getPageSize());
        List<MixingBetonInfo> mixingBetonInfos= mixingBetonInfoMapper.selectList(MixingBetonInfoQue);
        PageInfo pageInfo = new PageInfo(mixingBetonInfos);
        return pageInfo;
    }

    @Override
    public List<MixingBetonInfo> exportList() {
        List<MixingBetonInfo> mixingBetonInfos= mixingBetonInfoMapper.selectList(new MixingBetonInfoQue());

        return mixingBetonInfos;
    }

    @Override
    public List<MixingBetonInfo> exportListByQue(MixingBetonInfoQue mixingBetonInfoQue) {
        return mixingBetonInfoMapper.selectList(mixingBetonInfoQue);
    }
}
