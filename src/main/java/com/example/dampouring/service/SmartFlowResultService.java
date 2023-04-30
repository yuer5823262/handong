package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SwFollowCurve;
import com.example.dampouring.query.SwFollowCurveQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmartFlowResultService {
    PageInfo orUserSelect(SwFollowCurveQue smartFlowResultQue);

    List<SwFollowCurve> exportList();

    void waterReversing();

    int getFlowResult() throws  Exception;

    void controlProcess();

    List<SwFollowCurve> exportListByQue(SwFollowCurveQue swFollowCurveQue);
}
