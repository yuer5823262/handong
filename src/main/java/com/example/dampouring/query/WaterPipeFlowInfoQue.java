package com.example.dampouring.query;

import lombok.Data;

@Data
public class WaterPipeFlowInfoQue {
    Integer pageNum;
    Integer pageSize;
    Integer smallId;
    String startTime;
    String endTime;
    Integer waterPipeId;
    Integer dsName;

}
