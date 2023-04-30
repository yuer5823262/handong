package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.ExportMachineTempInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExportMachineTempInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(ExportMachineTempInfoQue ExportMachineTempInfoQue);

    PageInfo assess(ExportMachineTempAssessQue exportMachineTempAssessQue);

    List<ExportMachineTempInfoVO> exportList();

    void insert(MixingTempBc mixingTempBc);

    void addAll(List<ExportMachineTempInfoVO> list);

    List<ExportMachineTempInfoVO> exportListByQue(ExportMachineTempInfoQue exportMachineTempInfoQue);
}
