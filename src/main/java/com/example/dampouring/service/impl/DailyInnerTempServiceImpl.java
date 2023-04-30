package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyInnerTempMapper;
import com.example.dampouring.model.pojo.DailyInnerTemp;
import com.example.dampouring.model.vo.DailyInnerTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyInnerTempService;
import com.example.dampouring.service.DailyInnerTempService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyInnerTempServiceImpl implements DailyInnerTempService {
    @Autowired
    DailyInnerTempMapper DailyInnerTempMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue DailyInnerTempQue) {
        PageHelper.startPage(DailyInnerTempQue.getPageNum(), DailyInnerTempQue.getPageSize());
        List<DailyInnerTempVO> PouringTempInfo = DailyInnerTempMapper.selectList(DailyInnerTempQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyInnerTempVO> exportListByQue(DailyPourTempQue DailyInnerTempQue) {
        return DailyInnerTempMapper.selectList(DailyInnerTempQue);
    }

    @Override
    public void dailyInnerTemp() {
        List<DailyInnerTemp> dailyInnerTemps =  DailyInnerTempMapper.dailyInnerTemp();
        dailyInnerTemps.forEach(t->DailyInnerTempMapper.insertSelective(t));
    }
}
