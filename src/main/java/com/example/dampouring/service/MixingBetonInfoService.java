package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MixingBetonInfo;
import com.example.dampouring.query.MixingBetonInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingBetonInfoService {
    PageInfo orUserSelect(MixingBetonInfoQue MixingBetonInfoQue);

    List<MixingBetonInfo> exportList();

    List<MixingBetonInfo> exportListByQue(MixingBetonInfoQue mixingBetonInfoQue);
}
