package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyTwoWaterMapper;
import com.example.dampouring.model.pojo.DailyTwoWater;
import com.example.dampouring.model.vo.DailyTwoWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyTwoWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTwoWaterServiceImpl implements DailyTwoWaterService {
    @Autowired
    DailyTwoWaterMapper DailyTwoWaterMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue DailyTwoWaterQue) {
        PageHelper.startPage(DailyTwoWaterQue.getPageNum(), DailyTwoWaterQue.getPageSize());
        List<DailyTwoWaterVO> PouringTempInfo = DailyTwoWaterMapper.selectList(DailyTwoWaterQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyTwoWaterVO> exportListByQue(DailyPourTempQue DailyTwoWaterQue) {
        return DailyTwoWaterMapper.selectList(DailyTwoWaterQue);
    }

    @Override
    public void dailyTwoWater() {
        List<DailyTwoWater> dailyTwoWater = DailyTwoWaterMapper.dailyTwoWater();
        dailyTwoWater.forEach(t->DailyTwoWaterMapper.insertSelective(t));
    }
}
