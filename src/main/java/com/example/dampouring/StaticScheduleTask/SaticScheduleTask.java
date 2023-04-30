package com.example.dampouring.StaticScheduleTask;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.SolarRadioMeterMapper;
import com.example.dampouring.model.dao.SystemConstantMapper;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.ControllerUnitValueVO;
import com.example.dampouring.service.*;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask implements SchedulingConfigurer {
    //    static List<ControlUnit> controlUnitList = new ArrayList<ControlUnit>();
    Integer timeOut=Constant.timeout;
    Integer cTimes = 3;
    Date nextTime;
    @Autowired
    private TesstdoSome tesstdoSome;
    @Autowired
    ControlUnitMapper controlUnitMapper;
    @Autowired
    SolarRadioMeterMapper solarRadioMeterMapper;
    @Autowired
    WaterPipeFlowInfoService waterPipeFlowInfoService;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    LayerTdiffAlertService layerTdiffAlertService;
    @Autowired
    StorageColdAlertService storageColdAlertService;
    @Autowired
    EquipmentAlertService equipmentAlertService;
    @Autowired
    InnerTempSensorService innerTempSensorService;
    @Autowired
    TempGradometerService tempGradometerService;
    @Autowired
    WaterTempSensorService waterTempSensorService;
    @Autowired
    SmartMixingResultService smartMixingResultService;
    @Autowired
    InnerTempSensorInfoService innerTempSensorInfoService;
    @Autowired
    SystemConstantMapper systemConstantMapper;
    @Autowired
    ScheduledConfig scheduledConfig;

    SaticScheduleTask()
    {
        nextTime = new Date();
        nextTime.setTime(nextTime.getTime()+10000);
    }
//    @Scheduled(cron = "0 */10 * * * ?")
    public void  SunGetRadiationValue() {
        List<SolarRadioMeter> solarRadioMeterList = solarRadioMeterMapper.selectList();
//        short p  = solarRadioMeterList.get(0).getSerialNo().shortValue();
//        Constant.DllUTILS.C_CommOpen(p);
        double Instantaneous[]={-1};
        double DailyAccumulated[]={-1};
        short sunP = Constant.DllUTILS.Sun_GetRadiationValue(solarRadioMeterList.get(0).getEquipmentNo().byteValue(),Instantaneous,DailyAccumulated,timeOut);
        Constant.print("太阳辐射热读取状态p:"+sunP);
        if(sunP!=0) return;
        Constant.print("太阳辐射热读取值："+Instantaneous[0]+" "+DailyAccumulated[0]);
        tesstdoSome.SunGetRadiationValue(TimeUtils.getNowTime(),Instantaneous[0],DailyAccumulated[0]);
//        Constant.DllUTILS.C_CommClose();
    }

//    @Scheduled(cron = "0 */3 * * * ?")
//    @Scheduled(fixedDelay=60000*10)
    @Async
    public void getControlUnitValue(){
        if(Constant.pSta!=0) return;
        String time = TimeUtils.getNowTime();
//        short temp;
//        temp = Constant.DllUTILS.C_CommOpen(p);
//        Constant.print("打开端口:"+p+" temp:"+temp);
//        if(temp!=0) return;
        SunGetRadiationValue();
        short temp=0;
        long startTime = System.currentTimeMillis();
        waterPipeFlowInfoService.insertByComputing(time);
        List<ControllerUnitValueVO> controlUnitList = controlUnitMapper.selectByComputing();
        List<ControllerUnitValueVO> txgzList = new ArrayList<>();
        List<ControllerUnitValueVO> cgqgzList = new ArrayList<>();
        int tdMark=0;
        for(ControllerUnitValueVO controllerUnitValueVO:controlUnitList)
        {
            controllerUnitValueVO.setTime(time);
            String cuType = controllerUnitValueVO.getCuType();
            if(cuType.equals("内部温度")||cuType.equals("拌合温度")||(cuType.equals("测控装置")))
            {
                temp = readControllerUnitValue(controllerUnitValueVO);
                if(temp==0&&controllerUnitValueVO.getValueList().size()!=0)
                {
                    tesstdoSome.doSomething(controllerUnitValueVO);
                    tdMark = 1;
                }
                if(temp==2)
                    txgzList.add(controllerUnitValueVO);
                if(temp==3)
                    cgqgzList.add(controllerUnitValueVO);
            }
        }
        long endTime = System.currentTimeMillis();
//        temp = Constant.DllUTILS.C_CommClose();
        Constant.print("本轮数据采集结束,用时:"+((endTime-startTime)/1000)+"秒");
        waterPipeFlowInfoService.deleteEmpty(time);
        try {
            innerTempSensorInfoService.timeAvgTemp(time);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
//        layerTdiffAlertService.layerTdiffAlert(time);
        smartMixingResultService.SmartMixingResultCalculate();
        if(tdMark==0)
            equipmentAlertService.TDequipmentAlert();
        else
        {
            equipmentAlertService.TXequipmentAlert(txgzList);
            equipmentAlertService.GZequipmentAlert(cgqgzList);
        }
    }

    short readControllerUnitValue(ControllerUnitValueVO controllerUnitValueVO)
    {
        short temp = 1;
        String cuType = controllerUnitValueVO.getCuType();
        String cuAddr = controllerUnitValueVO.getCuAddr();
        Integer valCount = 0;
        double[] valueList = {0,0,0,0,0,0,0,0,0,0};
        double[] valueList1 = {0,0,0,0,0,0,0,0,0,0};
        if(cuType.equals("内部温度")||cuType.equals("拌合温度"))
        {
            temp= Constant.DllUTILS.LNT_ReadTemperatureValue(Byte.parseByte(cuAddr),
                    1,10,valueList,timeOut,cTimes);
            if(temp==0)
            {
                Constant.DllUTILS.LNT_ReadTemperatureValue(Byte.parseByte(cuAddr),
                        11,10,valueList1,timeOut,cTimes);
            }
            valCount=10;
        }
        else if(cuType.equals("测控装置"))
        {
            temp = Constant.DllUTILS.LNT_ReadInIValue(Byte.parseByte(cuAddr),
                    1,4,valueList,timeOut,cTimes);
            if(temp==0)
            {
                Constant.DllUTILS.LNT_ReadOutIValue(Byte.parseByte(cuAddr),
                        1,4,valueList1,timeOut,cTimes);
            }
            valCount=4;
        }
        Constant.print(cuType+"地址:"+cuAddr+" 状态值:"+temp);
        if(temp!=0) return temp;
        for(int i = 0;i<valCount;i++)
        {
            Double value = valueList[i];
            if(value!=-88.88&&value!=-99.99) controllerUnitValueVO.addValueList(value);
            else controllerUnitValueVO.addValueList(100.);
        }
        for(int i = 0;i<valCount;i++)
        {
            Double value = valueList1[i];
            if(value!=-88.88&&value!=-99.99) controllerUnitValueVO.addValueList(value);
            else controllerUnitValueVO.addValueList(100.);
        }
        return temp;
    }
//    @Scheduled(fixedRate=60000)
    public void testSen(){
        String time = TimeUtils.getNowTime();
        ControllerUnitValueVO controllerUnitValueVO = new ControllerUnitValueVO();
        controllerUnitValueVO.setCuAddr("2");
        controllerUnitValueVO.setId(8);
        controllerUnitValueVO.setCuType("内部温度");
        controllerUnitValueVO.setTime(time);

        double[] valueList1 = {26,24,23,22,21,25,21,24,25,26,26,24,23,22,21,25,21,24,25,26};
        for(double value:valueList1)
        {
            if(value!=0) controllerUnitValueVO.addValueList(value);
            else break;;
        }
        tesstdoSome.doSomething(controllerUnitValueVO);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Constant.logger.error("错误:",e);
        }
        try {
            innerTempSensorInfoService.timeAvgTemp(time);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }
//    @Autowired
//    SmartScheduleTask smartScheduleTask;
//    @Scheduled(fixedRate=600000)
//    public void test()
//    {
//        try {
//            smartScheduleTask.writeBwData();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
//
////        smartMixingResultService.SmartMixingResultCalculate();
//    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //lambda表达式实现简单的任务逻辑
        scheduledTaskRegistrar.addTriggerTask(() -> {
            getControlUnitValue();
            SystemConstant jgc = systemConstantMapper.selectByType("采集时间间隔");
            Integer jg = Integer.parseInt(jgc.getVal());
            Date date1 = new Date();
            long time = date1.getTime();
            long newTime = time + jg*60000;
            nextTime = new Date(newTime);
        },scheduledConfig-> nextTime);
    }

}

