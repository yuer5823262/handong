package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyOneWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyOneWaterService {
    PageInfo orUserSelect(DailyPourTempQue dailyOneWaterQue);

    List<DailyOneWaterVO> exportListByQue(DailyPourTempQue dailyOneWaterQue);

    void  dailyOneWater();
}
