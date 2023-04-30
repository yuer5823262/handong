package com.example.dampouring.service;

import com.example.dampouring.model.vo.TopTempAssessVO;
import com.example.dampouring.query.TopTempAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TopTempAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(TopTempAssessQue TopTempAssessQue);

    void timingComputing();

    List<TopTempAssessVO> exportList();
}
