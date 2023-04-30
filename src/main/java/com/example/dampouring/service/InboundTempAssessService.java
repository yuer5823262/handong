package com.example.dampouring.service;

import com.example.dampouring.model.vo.InboundTempAssessVO;
import com.example.dampouring.query.InboundTempAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InboundTempAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(InboundTempAssessQue InboundTempAssessQue);

    void timingComputing();

    List<InboundTempAssessVO> exportList();
}
