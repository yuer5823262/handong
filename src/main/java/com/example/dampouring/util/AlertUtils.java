package com.example.dampouring.util;

import com.example.dampouring.model.dao.MaxTempAlertMapper;
import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.pojo.MaxTempAlert;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.service.MaxTempAlertService;
import org.springframework.beans.factory.annotation.Autowired;


public class AlertUtils {

    @Autowired
    static
    MaxTempAlertService maxTempAlertService;
    public static void maxTempAlert(InnerTempSensorInfo innerTempSensorInfo)
    {
//        maxTempAlertService.maxTempAlert(innerTempSensorInfo);
    }
}
