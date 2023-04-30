package com.example.dampouring.service;

import com.example.dampouring.model.pojo.waterPipeFlowAssess;
import com.example.dampouring.model.vo.WaterPipeFlowAssessVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterPipeFlowAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(WaterPipeFlowAssessQue WaterPipeFlowAssessQue);

    void timingComputing();

    List<WaterPipeFlowAssessVO> exportList();
}
