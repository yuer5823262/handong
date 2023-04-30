package com.example.dampouring.service;

import com.example.dampouring.model.vo.DailyInnerTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DailyInnerTempService {
    PageInfo orUserSelect(DailyPourTempQue dailyInnerTempQue);

    List<DailyInnerTempVO> exportListByQue(DailyPourTempQue dailyInnerTempQue);

    void dailyInnerTemp();
}
