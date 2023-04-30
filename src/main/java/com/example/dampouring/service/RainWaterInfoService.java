package com.example.dampouring.service;

import com.example.dampouring.model.pojo.RainWaterInfo;
import com.example.dampouring.query.RainWaterInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RainWaterInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize,String type);
    PageInfo orUserSelect(RainWaterInfoQue RainWaterInfoQue);

    List<RainWaterInfo> exportList();

    List<RainWaterInfo> exportListByQue(RainWaterInfoQue rainWaterInfoQue);
}
