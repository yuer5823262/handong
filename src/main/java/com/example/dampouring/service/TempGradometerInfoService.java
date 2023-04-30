package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempGradometerInfo;
import com.example.dampouring.model.vo.TempGradometerInfoVO;
import com.example.dampouring.query.TempGradometerInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempGradometerInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(TempGradometerInfoQue TempGradometerInfoQue);

    List<TempGradometerInfoVO> exportList();

    void add(TempGradometerInfo tempGradometerInfo);

    void addAll(List<TempGradometerInfo> list);

    List<TempGradometerInfoVO> exportListByQue(TempGradometerInfoQue tempGradometerInfoQue);
}
