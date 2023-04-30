package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyPourTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyPourTempService {
    PageInfo orUserSelect(DailyPourTempQue dailyPourTempQue);

    List<DailyPourTempVO> exportListByQue(DailyPourTempQue dailyPourTempQue);

    void dailyPourTemp();
}
