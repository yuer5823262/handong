package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.ReduceTempAlert;
import com.example.dampouring.model.vo.DataCountVO;
import com.example.dampouring.service.CloseGroutAlertService;
import com.example.dampouring.service.DataMissAlertService;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.service.ReduceTempAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class AlertScheduleTask {
    @Autowired
    ReduceTempAlertService reduceTempAlertService;
    @Autowired
    CloseGroutAlertService CloseGroutAlertService;
    @Autowired
    DataMissAlertService dataMissAlertService;
    @Autowired
    FaceDiapauseAlertService faceDiapauseAlertService;
    @Scheduled(cron="0 0 23 * * ?")
//    @Scheduled(fixedRate=600000)
    @Async
    public void assessScheduleTask()
    {
        if(Constant.systemState==32) return;
        dataMissAlertService.dataMissAlert();
        reduceTempAlertService.reduceTempAlert();
//        CloseGroutAlertService.closeGroutAlert();
//        faceDiapauseAlertService.faceDiapauseAlert();
        System.out.println(".........................................alert..................................");
    }
}
