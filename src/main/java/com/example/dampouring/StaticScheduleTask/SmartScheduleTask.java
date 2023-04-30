package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.*;
import com.example.dampouring.service.*;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class SmartScheduleTask {
    @Autowired
    SmartBwBwresService smartBwBwresService;
    @Autowired
    SmartBwDantiService smartBwDantiService;
    @Autowired
    SmartBwLinesService smartBwLinesService;
    @Autowired
    SmartBwMdangService smartBwMdangService;
    @Autowired
    SmartBwZeroService smartBwZeroService;
    @Autowired
    SmartInsulationService smartInsulationService;
    @Autowired
    WaterPipeService waterPipeService;
    @Autowired
    SwFollowCurveService swFollowCurveService;
    @Autowired
    SwSiloDataService swSiloDataService;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    SwFollowCurveMapper swFollowCurveMapper;
    @Autowired
    SystemConstantMapper systemConstantMapper;
    @Autowired
    SmartFlowResultService smartFlowResultService;
    @Autowired
    ScheduledConfig scheduledUtils;


    @Autowired
    DailyInnerTempService dailyInnerTempService;
    @Autowired
    DailyPourTempService dailyPourTempService;
    @Autowired
    DailyOneWaterService dailyOneWaterService;
    @Autowired
    DailyMidWaterService dailyMidWaterService;
    @Autowired
    DailyTwoWaterService dailyTwoWaterService;
//    @Scheduled(fixedRate=60000*60)
//    @Scheduled(cron="0 1 * * * ?")
    public void writeBwData(){
//        try {
//            smartInsulationService.writeBaowenTianqi();
//        } catch (Exception e) {
//            Constant.logger.error("天气预报文件写入错误:",e);
//        }
//        try {
//            smartInsulationService.writeTESTINFOR();
//        } catch (Exception e) {
//            Constant.logger.error("TESTINFOR文件写入错误:",e);
//        }
//        try {
//            smartInsulationService.writeBEIYONG();
//        } catch (Exception e) {
//            Constant.logger.error("BEIYONG文件写入错误:",e);
//        }

        smartInsulationService.writeBwFile1();
        smartInsulationService.writeBwFile2();
        smartInsulationService.writeBwFile3();
        Constant.print("................写入保温计算所需数据文件....................");
    }
//    @Scheduled(cron="0 15 * * * ?")
//    @Scheduled(fixedRate=60000*60)
    public void getBwData() throws Exception {
        smartBwBwresService.getDateInsert();
        smartBwDantiService.getDateInsert();
        smartBwLinesService.getDateInsert();
        smartBwMdangService.getDateInsert();
        smartBwZeroService.getDateInsert();
        Constant.print("................获取保温计算生成数据文件....................");
//        smartInsulationService.getYuntu();
//        Constant.print("................画云图....................");
    }

//    @Scheduled(cron="0 55 0,4,7,14 * * ?")
//    @Scheduled(fixedRate=60000*60)
//    @Async
    public void bwSaveHistory() throws Exception {
        smartInsulationService.history();
        Constant.print("................保存历史保温数据文件....................");
    }



//    @Scheduled(cron="0 0 23 * * ?")
//    @Scheduled(fixedRate=60000*60)
    public void writeTsData() throws Exception {
        waterPipeService.writeFile();
        swSiloDataService.writeZyFile();
        swSiloDataService.writeFile();
        Constant.print("................写入通水数据文件....................");
        if(Constant.pSta!=0) return;
        int status = smartFlowResultService.getFlowResult();
        if(status == 0)
        {
            swFollowCurveService.readFile(1);
        }
    }


//    @Scheduled(cron="0 10 23 * * ?")
//    @Scheduled(fixedRate=60000*60)
//    @Async
    public void controlProcess(){
        if(Constant.pSta!=0) return;
        smartFlowResultService.controlProcess();
    }

    public void waterReversing(){
        if(Constant.pSta!=0) return;
        smartFlowResultService.waterReversing();
    }

    public void addSmartTask() {
        if(Constant.systemState == 64) return;
        scheduledUtils.cancelTriggerTaskAll();

        scheduledUtils.addTask("内部温度日报",new TriggerTask(() -> {
            try {
                dailyInnerTempService.dailyInnerTemp();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("内部温度日报").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("浇筑温控日报",new TriggerTask(() -> {
            try {
                dailyPourTempService.dailyPourTemp();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("浇筑温控日报").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));


        scheduledUtils.addTask("一期通水日报",new TriggerTask(() -> {
            try {
                dailyOneWaterService.dailyOneWater();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("一期通水日报").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));


        scheduledUtils.addTask("中期通水日报",new TriggerTask(() -> {
            try {
                dailyMidWaterService.dailyMidWater();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("中期通水日报").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("二期通水日报",new TriggerTask(() -> {
            try {
                dailyTwoWaterService.dailyTwoWater();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("二期通水日报").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));


        scheduledUtils.addTask("保温数据保存",new TriggerTask(() -> {
            try {
                bwSaveHistory();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("保温数据保存").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("保温文件写入",new TriggerTask(() -> {
                writeBwData();
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("保温文件写入").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("保温数据读取",new TriggerTask(() -> {
            try {
                getBwData();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("保温数据读取").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("通水调控",new TriggerTask(() -> {
            try {
                writeTsData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("通水调控").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));

        scheduledUtils.addTask("通水监测",new TriggerTask(() -> {
            controlProcess();
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("通水监测").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));
        scheduledUtils.addTask("通水换向",new TriggerTask(() -> {
            waterReversing();
        },scheduledConfig->{
            String cron = systemConstantMapper.selectByType("通水换向").getVal();
            Date date = new CronTrigger(cron).nextExecutionTime(scheduledConfig);
            return date;
        }));
    }
}
