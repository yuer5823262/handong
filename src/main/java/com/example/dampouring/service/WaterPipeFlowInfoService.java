package com.example.dampouring.service;

import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.WaterMonitorVO;
import com.example.dampouring.model.vo.WaterPipeFlowInfoVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.query.WaterPipeFlowInfoQue;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface WaterPipeFlowInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(WaterPipeFlowInfoQue WaterPipeFlowInfoQue);

    PageInfo assess(WaterPipeFlowAssessQue waterPipeFlowAssessQue);

    PageInfo calculating(WaterPipeFlowAssessQue waterPipeFlowAssessQue);

    List<WaterPipeFlowInfoVO> exportList();

    List<WaterMonitorVO> waterMonitor();

    void insertByComputing(String time);

    void add(WaterPipeFlowInfo waterPipeFlowInfo);

    void addAll(List<WaterPipeFlowInfo> list);
    @Async
    void deleteEmpty(String time);
    void sendByTime(String time);

    List<WaterPipeFlowInfoVO> exportListByQue(WaterPipeFlowInfoQue waterPipeFlowInfoQue);
}
