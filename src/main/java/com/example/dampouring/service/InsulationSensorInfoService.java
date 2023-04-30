package com.example.dampouring.service;

import com.example.dampouring.model.vo.InsulationSensorInfoVO;
import com.example.dampouring.query.InsulationSensorInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InsulationSensorInfoService {
    PageInfo orUserSelect(InsulationSensorInfoQue insulationSensorInfoQue);

    List<InsulationSensorInfoVO> exportList();

    List<InsulationSensorInfoVO> exportListByQue(InsulationSensorInfoQue insulationSensorInfoQue);
}
