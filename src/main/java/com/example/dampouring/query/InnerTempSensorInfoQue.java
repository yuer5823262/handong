package com.example.dampouring.query;

import lombok.Data;

@Data
public class InnerTempSensorInfoQue {
    Integer pageNum;
    Integer pageSize;
    Integer smallId;
    Integer dsName;
    String startTime;
    String endTime;
    Integer innerTempId;
    String sortOrder;
}
