package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingSandInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingSandInfoService {
    PageInfo orUserSelect(MixingWaterInfoQue mixingInfoQue);

    List<MixingSandInfo> exportList();

    List<MixingSandInfo> exportListByQue(MixingWaterInfoQue mixingInfoQue);
}
