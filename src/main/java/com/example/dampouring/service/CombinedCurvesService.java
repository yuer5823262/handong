package com.example.dampouring.service;

import com.example.dampouring.model.vo.CombinedCurvesVO;
import com.example.dampouring.query.CombinedCurvesQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CombinedCurvesService {
    PageInfo orUserSelect(CombinedCurvesQue combinedCurvesQue);

    List<CombinedCurvesVO> exportList(CombinedCurvesQue combinedCurvesQue);
}
