package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyPourTempMapper;
import com.example.dampouring.model.pojo.DailyPourTemp;
import com.example.dampouring.model.vo.DailyPourTempVO;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyPourTempService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyPourTempServiceImpl implements DailyPourTempService {
    @Autowired
    DailyPourTempMapper dailyPourTempMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue dailyPourTempQue) {
        PageHelper.startPage(dailyPourTempQue.getPageNum(), dailyPourTempQue.getPageSize());
        List<DailyPourTempVO> PouringTempInfo = dailyPourTempMapper.selectList(dailyPourTempQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyPourTempVO> exportListByQue(DailyPourTempQue dailyPourTempQue) {
        return dailyPourTempMapper.selectList(dailyPourTempQue);
    }

    @Override
    public void dailyPourTemp() {
        List<DailyPourTemp> dailyPourTempList = dailyPourTempMapper.dailyPourTemp();
        dailyPourTempList.forEach(t-> dailyPourTempMapper.insertSelective(t));
    }
}
