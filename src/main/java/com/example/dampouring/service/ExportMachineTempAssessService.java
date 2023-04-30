package com.example.dampouring.service;

import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExportMachineTempAssessService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(ExportMachineTempAssessQue ExportMachineTempAssessQue);

    void timingComputing();

    List<ExportMachineTempAssessVO> exportList();
}
