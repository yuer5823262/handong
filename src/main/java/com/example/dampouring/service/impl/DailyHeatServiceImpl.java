package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DailyHeatMapper;
import com.example.dampouring.model.vo.DailyHeatVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyHeatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DailyHeatServiceImpl implements DailyHeatService {
    @Autowired
    com.example.dampouring.model.dao.DailyHeatMapper DailyHeatMapper;
    @Override
    public PageInfo orUserSelect(DailyPourTempQue DailyHeatQue) {
        PageHelper.startPage(DailyHeatQue.getPageNum(), DailyHeatQue.getPageSize());
        List<DailyHeatVO> PouringTempInfo = DailyHeatMapper.selectList(DailyHeatQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public List<DailyHeatVO> exportListByQue(DailyPourTempQue DailyHeatQue) {
        return DailyHeatMapper.selectList(DailyHeatQue);
    }
}
