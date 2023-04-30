package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyTwoWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyTwoWaterService {
    PageInfo orUserSelect(DailyPourTempQue dailyTwoWaterQue);

    List<DailyTwoWaterVO> exportListByQue(DailyPourTempQue dailyTwoWaterQue);
    void dailyTwoWater();
}
