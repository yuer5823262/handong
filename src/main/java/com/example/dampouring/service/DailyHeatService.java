package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyHeatVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyHeatService {
    List<DailyHeatVO> exportListByQue(DailyPourTempQue dailyHeatQue);

    PageInfo orUserSelect(DailyPourTempQue dailyHeatQue);
}
