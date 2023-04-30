package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.model.pojo.MixingAdditiveInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingAdditiveInfoService {
    PageInfo orUserSelect(MixingWaterInfoQue mixingInfoQue);

    List<MixingAdditiveInfo> exportList();

    List<MixingAdditiveInfo> exportListByQue(MixingWaterInfoQue mixingInfoQue);
}
