package com.example.dampouring.service;

import com.example.dampouring.model.vo.PouringTempAssessVO;
import com.example.dampouring.query.PouringTempAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PouringTempAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(PouringTempAssessQue PouringTempAssessQue);

    void timingComputing();

    List<PouringTempAssessVO> exportList();
}
