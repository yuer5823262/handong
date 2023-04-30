package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyOneWaterMapper;
import com.example.dampouring.model.pojo.DailyOneWater;
import com.example.dampouring.model.vo.DailyOneWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyOneWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyOneWaterServiceImpl implements DailyOneWaterService {
    @Autowired
    com.example.dampouring.model.dao.DailyOneWaterMapper DailyOneWaterMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue DailyOneWaterQue) {
        PageHelper.startPage(DailyOneWaterQue.getPageNum(), DailyOneWaterQue.getPageSize());
        List<DailyOneWaterVO> PouringTempInfo = DailyOneWaterMapper.selectList(DailyOneWaterQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyOneWaterVO> exportListByQue(DailyPourTempQue DailyOneWaterQue) {
        return DailyOneWaterMapper.selectList(DailyOneWaterQue);
    }

    @Override
    public void dailyOneWater() {
        List<DailyOneWater> dailyOneWaters= DailyOneWaterMapper.dailyOneWater();
        dailyOneWaters.forEach(t->DailyOneWaterMapper.insertSelective(t));
    }
}
