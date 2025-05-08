package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.ExportMachineTempAssess;
import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class AssessScheduleTask {
    @Autowired
    TempMeasurementsAssessService tempMeasurementsAssessService;
    @Autowired
    ExportMachineTempAssessService exportMachineTempAssessService;
    @Autowired
    WeatherForecastService weatherForecastService;
    @Autowired
    InboundTempAssessService inboundTempAssessService;
    @Autowired
    PouringTempAssessService pouringTempAssessService;
    @Autowired
    TopTempAssessService topTempAssessService;
    @Autowired
    WaterPipeFlowAssessService WaterPipeFlowAssessService;
    @Autowired
    MixingBetonAssessService mixingBetonAssessService;
    @Autowired
    MixingWaterAssessService mixingWaterAssessService;
    @Autowired
    MixingFlyashAssessService mixingFlyashAssessService;
    @Autowired
    MixingSandAssessService mixingSandAssessService;
    @Autowired
    MixingAdditiveAssessService mixingAdditiveAssessService;
    @Scheduled(cron="0 30 * * * ?")
//    @Scheduled(fixedRate=60000)
    @Async
    public void assessScheduleTask()
    {
        if(Constant.systemState==32) return;
        exportMachineTempAssessService.timingComputing();
        inboundTempAssessService.timingComputing();
        pouringTempAssessService.timingComputing();
        topTempAssessService.timingComputing();
        WaterPipeFlowAssessService.timingComputing();
        mixingBetonAssessService.timingComputing();
        mixingWaterAssessService.timingComputing();
        mixingFlyashAssessService.timingComputing();
        mixingSandAssessService.timingComputing();
        mixingAdditiveAssessService.timingComputing();
        Constant.print("..............................assess..............................");
    }
    @Scheduled(cron="0 0 1 * * ?")
//    @Scheduled(fixedRate=60000)
    @Async
    public void tmScheduleTask()
    {
        if(Constant.systemState==32) return;
        weatherForecastService.timingComputing();
        tempMeasurementsAssessService.timingComputing();
        Constant.print("..............................tm..............................");
    }

//    @Scheduled(fixedRate=60000)
    public void aaa()
    {
        WaterPipeFlowAssessService.timingComputing();
    }


}
