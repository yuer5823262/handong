package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingFlyashInfo;
import com.example.dampouring.query.MixingFlyashInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingFlyashInfoService {
    PageInfo orUserSelect(MixingFlyashInfoQue MixingFlyashInfoQue);

    List<MixingFlyashInfo> exportList();

    List<MixingFlyashInfo> exportListByQue(MixingFlyashInfoQue mixingFlyashInfoQue);
}
