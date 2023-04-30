package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.model.vo.PouringTempMonitorVO;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.query.PouringTempInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PouringTempInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(PouringTempInfoQue PouringTempInfoQue);

    PageInfo assess(PouringTempAssessQue pouringTempAssessQue);

    List<PouringTempInfoVO> exportList();

    List<PouringTempMonitorVO> tempMonitor();

    void insert(MixingTempBc mixingTempBc);

    void addAll(List<PouringTempInfoVO> list);

    List<PouringTempInfoVO> exportListByQue(PouringTempInfoQue pouringTempInfoQue);
}
