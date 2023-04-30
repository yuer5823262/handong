package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyMidWaterMapper;
import com.example.dampouring.model.pojo.DailyMidWater;
import com.example.dampouring.model.vo.DailyMidWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyMidWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyMidWaterServiceImpl implements DailyMidWaterService {
    @Autowired
    com.example.dampouring.model.dao.DailyMidWaterMapper DailyMidWaterMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue DailyMidWaterQue) {
        PageHelper.startPage(DailyMidWaterQue.getPageNum(), DailyMidWaterQue.getPageSize());
        List<DailyMidWaterVO> PouringTempInfo = DailyMidWaterMapper.selectList(DailyMidWaterQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyMidWaterVO> exportListByQue(DailyPourTempQue DailyMidWaterQue) {
        return DailyMidWaterMapper.selectList(DailyMidWaterQue);
    }

    @Override
    public void dailyMidWater() {
        List<DailyMidWater> dailyMidWaters = DailyMidWaterMapper.dailyMidWater();
        dailyMidWaters.forEach(t->DailyMidWaterMapper.insertSelective(t));
    }
}
