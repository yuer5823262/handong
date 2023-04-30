package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyMidWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyMidWaterService {
    PageInfo orUserSelect(DailyPourTempQue dailyMidWaterQue);

    List<DailyMidWaterVO> exportListByQue(DailyPourTempQue dailyMidWaterQue);

    void dailyMidWater();
}
