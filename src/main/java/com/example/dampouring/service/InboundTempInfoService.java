package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.model.vo.InboundTempInfoVO;
import com.example.dampouring.model.vo.InboundTempMonitorVO;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.query.InboundTempInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InboundTempInfoService {


    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(InboundTempInfoQue InboundTempInfoQue);
    void insert(MixingTempBc mixingTempBc);
    PageInfo assess(InboundTempAssessQue inboundTempAssessQue);

    List<InboundTempInfoVO> exportList();

    List<InboundTempMonitorVO> tempMonitor();

    void addAll(List<InboundTempInfoVO> list);

    List<InboundTempInfoVO> exportListByque(InboundTempInfoQue inboundTempInfoQue);
}
