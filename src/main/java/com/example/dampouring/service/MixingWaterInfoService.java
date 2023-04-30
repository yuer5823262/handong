package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingWaterInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingWaterInfoService {
    PageInfo orUserSelect(MixingWaterInfoQue MixingWaterInfoQue);

    List<MixingWaterInfo> exportList();

    List<MixingWaterInfo> exportListByQue(MixingWaterInfoQue mixingWaterInfoQue);
}
