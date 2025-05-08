package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.*;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.WaterPipeFlowInfoByTimeAndWpIdQue;
import com.example.dampouring.service.*;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.copyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TesstdoSome {
    @Autowired
    SolarRadiantHeatInfoMapper solarRadiantHeatInfoMapper;
    @Autowired
    TempMeasurementsMapper tempMeasurementsMapper;
    @Autowired
    AirTempSensorMapper airTempSensorMapper;
    @Autowired
    InnerTempSensorMapper innerTempSensorMapper;
    @Autowired
    InnerTempSensorInfoMapper innerTempSensorInfoMapper;
    @Autowired
    TempGradometerMapper tempGradometerMapper;
    @Autowired
    TempGradometerInfoMapper tempGradometerInfoMapper;
    @Autowired
    MaxTempAlertService maxTempAlertService;
    @Autowired
    TempGradAlertService tempGradAlertService;
    @Autowired
    WaterTempSensorMapper waterTempSensorMapper;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    WaterPipeFlowInfoMapper waterPipeFlowInfoMapper;
    @Autowired
    WaterPressureSensorMapper waterPressureSensorMapper;
    @Autowired
    StorageColdAlertService storageColdAlertService;
    @Autowired
    WaterColdAlertService waterColdAlertService;
    @Autowired
    MixingSensorMapper mixingSensorMapper;
    @Autowired
    MixingBuildingMapper mixingBuildingMapper;
    @Autowired
    MixingFlyashInfoMapper mixingFlyashInfoMapper;
    @Autowired
    MixingWaterInfoMapper mixingWaterInfoMapper;
    @Autowired
    MixingBetonInfoMapper mixingBetonInfoMapper;
    @Autowired
    MixingSandInfoMapper mixingSandInfoMapper;
    @Autowired
    MixingAdditiveInfoMapper mixingAdditiveInfoMapper;
    @Autowired
    MixingAlertService mixingAlertService;
    @Autowired
    MaxTempAlertMapper MaxTempAlertMapper;
    @Autowired
    EquipmentAlertService equipmentAlertService;
    @Autowired
    InsulationSensorInfoMapper insulationSensorInfoMapper;
    @Autowired
    InsulationSensorMapper insulationSensorMapper;

    public void getInnerVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        Integer c = 0;
        List<Double> valueList = controllerUnitValueVO.getValueList();

            List<InnerTempSensorVO> innerTempSensorList = innerTempSensorMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(InnerTempSensorVO innerTempSensor: innerTempSensorList)
            {
                try {
                    c = innerTempSensor.getChannel()-1;
                    if(c < 0) continue;
                    if(valueList.size()>c&&
                            valueList.get(c)!=100)
                    {
                        InnerTempSensorInfo innerTempSensorInfo = new InnerTempSensorInfo();
                        innerTempSensorInfo.setTemp(valueList.get(c));
                        innerTempSensorInfo.setTime(controllerUnitValueVO.getTime());
                        innerTempSensorInfo.setInnerTempSensorId(innerTempSensor.getId());
                        MaxTempNormVO maxTempNormVO = MaxTempAlertMapper.normInfo(innerTempSensorInfo.getInnerTempSensorId());
                        if(maxTempNormVO!=null)
                            innerTempSensorInfo.setNorm(maxTempNormVO.getMaxTemp());
                        if(innerTempSensorInfo.getTemp() <-2 || innerTempSensorInfo.getTemp()>60) {
                            innerTempSensorInfo.setTemp(null);
                        }
                        innerTempSensorInfoMapper.insertSelective(innerTempSensorInfo);
                        Constant.print(innerTempSensor.getSmallNo()+"下测控地址为"+controllerUnitValueVO.getCuAddr()+
                                ",通道号为"+innerTempSensor.getChannel()+",编号为"+innerTempSensor.getTempNo()+
                                "的内部温度计获取到温度数据:"+valueList.get(c));
                        if (maxTempNormVO==null) continue;
                        if(innerTempSensor.getCuAddr().charAt(0)=='1')
                        {
                            maxTempAlertService.maxTempAlert(innerTempSensorInfo,maxTempNormVO);
                            storageColdAlertService.storageColdAlert(innerTempSensorInfo,maxTempNormVO);
                        }

                     }
                } catch (Exception e) {
                    Constant.logger.error("错误",e);
                }
            }

    }


    public void getInsulationVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        Integer c = 0;
        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            List<InsulationSensorVO> insulationSensors = insulationSensorMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(InsulationSensorVO insulationSensor: insulationSensors)
            {
                c = insulationSensor.getChanel()-1;
                if(valueList.size()>c&&
                        valueList.get(c)!=100)
                {
                    InsulationSensorInfo insulationSensorInfo = new InsulationSensorInfo();
                    insulationSensorInfo.setTemp(valueList.get(c));
                    insulationSensorInfo.setTime(controllerUnitValueVO.getTime());
                    insulationSensorInfo.setSensorId(insulationSensor.getId());
                    insulationSensorInfoMapper.insertSelective(insulationSensorInfo);
                    Constant.print(insulationSensor.getDsNo()+"坝段下测控地址为"+controllerUnitValueVO.getCuAddr()+
                            ",通道号为"+insulationSensor.getChanel()+",编号为"+insulationSensor.getTempNo()+
                            "的表面保温温度计获取到温度数据:"+valueList.get(c));
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }


    public void getTempGradometerVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        Integer c;

        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            List<TempGradometerVO> tempGradometers = tempGradometerMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(TempGradometerVO tempGradometer: tempGradometers)
            {
                if(!tempGradometer.checkChanel()) continue;
                String[] cList = tempGradometer.getChannel().split(",");

                TempGradometerInfo tempGradometerInfo = new TempGradometerInfo();
                c=Integer.parseInt(cList[0])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp1(valueList.get(c));
                c=Integer.parseInt(cList[1])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp2(valueList.get(c));
                c=Integer.parseInt(cList[2])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp3(valueList.get(c));
                c=Integer.parseInt(cList[3])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp4(valueList.get(c));
                c=Integer.parseInt(cList[4])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp5(valueList.get(c));
                c=Integer.parseInt(cList[5])-1;
                if(c!=-2&&valueList.get(c)!=100)
                    tempGradometerInfo.setTemp6(valueList.get(c));
                tempGradometerInfo.setTime(controllerUnitValueVO.getTime());
                tempGradometerInfo.setTempGradometerId(tempGradometer.getId());
                tempGradometerInfoMapper.insertSelective(tempGradometerInfo);
                Constant.print(tempGradometer.getSmallNo()+"仓下测控地址为"+controllerUnitValueVO.getCuAddr()+
                        ",通道号为"+tempGradometer.getChannel()+",编号为"+tempGradometer.getTgmName()+
                        "的温度梯度仪获取到温度数据:"+tempGradometerInfo.getTempListStr());
                if(tempGradometer.getCuAddr().charAt(0)=='1')
                {
                    tempGradAlertService.TempGradTempAlert(tempGradometerInfo);
                }

            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }
    public void getAirTempVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            AirTempSensor airTempSensor = airTempSensorMapper.selectByCuId(controllerUnitValueVO.getId());
            if(airTempSensor==null) return;
            if(valueList.size()>airTempSensor.getChannel()&&
                    valueList.get(airTempSensor.getChannel()-1)!=100)
            {
                TempMeasurements tempMeasurements = new TempMeasurements();
                tempMeasurements.setTemperature(valueList.get(airTempSensor.getChannel()-1));
                tempMeasurements.setDate(controllerUnitValueVO.getTime());
                if(tempMeasurements.getTemperature() <-30 || tempMeasurements.getTemperature()>50)
                    return;
                tempMeasurementsMapper.insertSelective(tempMeasurements);
                Constant.print("测控地址为"+controllerUnitValueVO.getCuAddr()+
                        ",通道号为"+airTempSensor.getChannel()+
                        "的气温传感器获取到温度数据:"+tempMeasurements.getTemperature());

            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }

    public void getMixingTempVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            List<MixingSensor> mixingSensorList = mixingSensorMapper.selectByCuId(controllerUnitValueVO.getId());
            for(MixingSensor mixingSensor: mixingSensorList)
            {
                Integer c = mixingSensor.getChannel()-1;
                if(valueList.size()>c&&
                        valueList.get(c)!=100)
                {
                    String type = mixingSensor.getType();
                    MixingTempInfo mixingTempInfo = new MixingTempInfo();
                    mixingTempInfo.setTemp(valueList.get(c));
                    mixingTempInfo.setTime(controllerUnitValueVO.getTime());
                    MixingBuilding mixingBuilding = mixingBuildingMapper.selectByPrimaryKey(mixingSensor.getBelongId());
                    mixingTempInfo.setBuildingNo(mixingBuilding.getNo());
                    mixingTempInfo.setType(type);
                    if(type.equals("粉煤灰"))
                    {
                        MixingFlyashInfo mixingFlyashInfo = new MixingFlyashInfo();
                        copyUtils.copyPropertiesIgnoreNull(mixingTempInfo,mixingFlyashInfo);
                        mixingFlyashInfoMapper.insertSelective(mixingFlyashInfo);
                    }

                    if(type.equals("水温"))
                    {
                        MixingWaterInfo mixingTemp = new MixingWaterInfo();
                        copyUtils.copyPropertiesIgnoreNull(mixingTempInfo,mixingTemp);
                        mixingWaterInfoMapper.insertSelective(mixingTemp);
                    }
                    if(type.equals("水泥"))
                    {
                        MixingBetonInfo mixingTemp = new MixingBetonInfo();
                        copyUtils.copyPropertiesIgnoreNull(mixingTempInfo,mixingTemp);
                        mixingBetonInfoMapper.insertSelective(mixingTemp);
                    }
                    if(type.equals("砂"))
                    {
                        MixingSandInfo mixingTemp = new MixingSandInfo();
                        copyUtils.copyPropertiesIgnoreNull(mixingTempInfo,mixingTemp);
                        mixingSandInfoMapper.insertSelective(mixingTemp);
                    }
                    if(type.equals("外加剂"))
                    {
                        MixingAdditiveInfo mixingTemp = new MixingAdditiveInfo();
                        copyUtils.copyPropertiesIgnoreNull(mixingTempInfo,mixingTemp);
                        mixingAdditiveInfoMapper.insertSelective(mixingTemp);
                    }
                    Constant.print(mixingBuilding.getNo()+"拌合楼下测控地址为"+controllerUnitValueVO.getCuAddr()+
                            ",通道号为"+mixingSensor.getChannel()+",编号为"+mixingSensor.getNo()+
                            type+"温度计获取到温度数据:"+mixingTempInfo.getTemp());
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }
    public void getWaterTempVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        Integer c = 0;
        List<Double> valueList = controllerUnitValueVO.getValueList();

            List<WaterTempSensor> waterTempSensorList = waterTempSensorMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(WaterTempSensor waterTempSensor: waterTempSensorList)
            {
                try {
                    List<WaterPipeVO> waterPipeList = waterPipeMapper.selectBySmallId(waterTempSensor.getSbId());
                    for(WaterPipeVO waterPipe:waterPipeList)
                    {
                        WaterPipeFlowInfoByTimeAndWpIdQue waterPipeFlowInfoByTimeAndWpIdQue = new WaterPipeFlowInfoByTimeAndWpIdQue();
                        waterPipeFlowInfoByTimeAndWpIdQue.setTime(controllerUnitValueVO.getTime());
                        waterPipeFlowInfoByTimeAndWpIdQue.setWpId(waterPipe.getId());
                        WaterPipeFlowInfo waterPipeFlowInfo = waterPipeFlowInfoMapper.selectByTimeAndWpId(waterPipeFlowInfoByTimeAndWpIdQue);
                        if(waterPipeFlowInfo==null) continue;
                        c = waterTempSensor.getEnterChannel()-1;
                        if(valueList.size()>c&&
                                valueList.get(c)!=100 && valueList.get(c)>=-2 && valueList.get(c)<=30)
                        {
                            waterPipeFlowInfo.setEnterTemp(valueList.get(c));
                        }
                        c = waterTempSensor.getExitChannel()-1;
                        if(valueList.size()>c&&
                                valueList.get(c)!=100 && valueList.get(c)>=-2 && valueList.get(c)<=30)
                        {
                            waterPipeFlowInfo.setOutTemp(valueList.get(c));
                        }
                        waterPipeFlowInfo.setTemp();
                        waterPipeFlowInfoMapper.updateByPrimaryKeySelective(waterPipeFlowInfo);
                        Constant.print(waterPipe.getSmallNo()+"仓下测控地址为"+controllerUnitValueVO.getCuAddr()+
                                ",进口通道号为"+waterTempSensor.getEnterChannel()+",出口通道号为"+waterTempSensor.getExitChannel()+
                                "水温温度计获取到温度数据:"+waterPipeFlowInfo.getEnterTemp()+" "+waterPipeFlowInfo.getOutTemp());

                    }
                } catch (Exception e) {
                    Constant.logger.error("错误:",e);
                }

            }


    }


    public void getWaterPressureVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        Integer c = 0;
        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            List<WaterPressureSensor> waterPressureSensorList = waterPressureSensorMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(WaterPressureSensor waterPressureSensor: waterPressureSensorList)
            {
                List<WaterPipeVO> waterPipeList = waterPipeMapper.selectBySmallId(waterPressureSensor.getSbId());
                for(WaterPipeVO waterPipe:waterPipeList) {
                    WaterPipeFlowInfoByTimeAndWpIdQue waterPipeFlowInfoByTimeAndWpIdQue = new WaterPipeFlowInfoByTimeAndWpIdQue();
                    waterPipeFlowInfoByTimeAndWpIdQue.setTime(controllerUnitValueVO.getTime());
                    waterPipeFlowInfoByTimeAndWpIdQue.setWpId(waterPipe.getId());
                    WaterPipeFlowInfo waterPipeFlowInfo = waterPipeFlowInfoMapper.selectByTimeAndWpId(waterPipeFlowInfoByTimeAndWpIdQue);
                    if(waterPipeFlowInfo==null) continue;
                    c = waterPressureSensor.getEnterChannelNo()-1;
                    if(valueList.size()>c&&
                            valueList.get(c)!=100)
                    {
                        Double val = valueList.get(c);
                        if(val<=4||val>20) val = 0.;
                        else val = (val-4)/16;
                        if(val >=0 && val<=2)
                            waterPipeFlowInfo.setEnterMpa(val);
                    }
                    c = waterPressureSensor.getExitChannelNo()-1;
                    if(valueList.size()>c&&
                            valueList.get(c)!=100)
                    {
                        Double val = valueList.get(c);
                        if(val<=4||val>20) val = 0.;
                        else val = (val-4)/16;
                        if(val >=0 && val<=2)
                            waterPipeFlowInfo.setOutMpa(val);
                    }
                    waterPipeFlowInfo.setMpa();
                    Constant.print(waterPipe.getSmallNo()+"仓下测控地址为"+controllerUnitValueVO.getCuAddr()+
                            ",进口通道号为"+waterPressureSensor.getEnterChannelNo()+",出口通道号为"+waterPressureSensor.getExitChannelNo()+
                            "水压传感器获取到数据:"+waterPipeFlowInfo.getEnterMpa()+" "+waterPipeFlowInfo.getOutMpa());
                    waterPipeFlowInfoMapper.updateByPrimaryKeySelective(waterPipeFlowInfo);
                    equipmentAlertService.YCequipmentAlert(waterPipeFlowInfo,waterPipe.getSbId());
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }

    public void getFlowVal(ControllerUnitValueVO controllerUnitValueVO)
    {
        int c = 0;
        List<Double> valueList = controllerUnitValueVO.getValueList();
        try {
            List<WaterPipeVO> waterPipeList = waterPipeMapper.selectListByCuId(controllerUnitValueVO.getId());
            for(WaterPipeVO waterPipe: waterPipeList)
            {
                c = waterPipe.getChannelNo()-1;
                WaterPipeFlowInfoByTimeAndWpIdQue waterPipeFlowInfoByTimeAndWpIdQue = new WaterPipeFlowInfoByTimeAndWpIdQue();
                waterPipeFlowInfoByTimeAndWpIdQue.setTime(controllerUnitValueVO.getTime());
                waterPipeFlowInfoByTimeAndWpIdQue.setWpId(waterPipe.getId());
                WaterPipeFlowInfo waterPipeFlowInfo = waterPipeFlowInfoMapper.selectByTimeAndWpId(waterPipeFlowInfoByTimeAndWpIdQue);
                if(waterPipeFlowInfo==null) return;
                if(valueList.size()>c&&
                        valueList.get(c)!=100)
                {
                    Double val = valueList.get(c);
                    if(val<=4&&val>=3.9) val = 0.;
                    else if(val<=20&&val>4) val= (val-4)*10/16;
                    else val=null;
                    if(val != null && val >=0 && val<=8)
                    {
                        val = val/waterPipe.getBranchNum();
                        if(val<=0.05) val = 0.;
                        waterPipeFlowInfo.setFlow(val);
                    }

                    val = valueList.get(c+valueList.size()/2);
                    if(val<=4||val>20) val = 0.;
                    else val = (val-4)*100/16;
                    waterPipeFlowInfo.setOpening(val);
                    equipmentAlertService.pipeAlert(valueList.get(c),waterPipe.getSbId());
                }
                if(waterPipeFlowInfo.getFlow()!=null && waterPipeFlowInfo.getFlow()>8)
                {
                    waterPipeFlowInfo.setFlow(null);
                }
                waterPipeFlowInfoMapper.updateByPrimaryKeySelective(waterPipeFlowInfo);
                Constant.print(waterPipe.getSmallNo()+"仓下测控地址为"+controllerUnitValueVO.getCuAddr()+
                        ",通道号为"+waterPipe.getChannelNo()+
                        "水管测控装置获取到数据,流量:"+waterPipeFlowInfo.getFlow()+"阀门开度:"+waterPipeFlowInfo.getOpening());


            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }
    @Async("doSomethingExecutor")
    public void doSomething(ControllerUnitValueVO controllerUnitValueVO) {
        List<Double> valueList = controllerUnitValueVO.getValueList();
        Constant.print(controllerUnitValueVO.getCuType()+" "+controllerUnitValueVO.getCuAddr()+" "+"值列表:"+valueList);
        String cuType = controllerUnitValueVO.getCuType();
        if(cuType.equals("内部温度"))
        {
            getInnerVal(controllerUnitValueVO);
            getInsulationVal(controllerUnitValueVO);
            getTempGradometerVal(controllerUnitValueVO);
            getWaterTempVal(controllerUnitValueVO);
            getAirTempVal(controllerUnitValueVO);
        }
        if(cuType.equals("拌合温度"))
            getMixingTempVal(controllerUnitValueVO);
        if(cuType.equals("测控装置"))
        {
            getWaterPressureVal(controllerUnitValueVO);
            getFlowVal(controllerUnitValueVO);
        }
    }


    @Async("doSomethingExecutor")
    public void WeatherGetValue(ControllerUnitValueVO controllerUnitValueVO)
    {
        TempMeasurements tempMeasurements = new TempMeasurements();
        tempMeasurements.setTemperature(controllerUnitValueVO.getValueList().get(0));
        tempMeasurements.setDate(controllerUnitValueVO.getTime());
        if(tempMeasurements.getTemperature() <-30 || tempMeasurements.getTemperature()>50)
            return;
        tempMeasurementsMapper.insertSelective(tempMeasurements);
    }


    @Async("doSomethingExecutor")
    public void SunGetRadiationValue(String time,Double Instantaneous,Double DailyAccumulated,
                                     Double humidity, Double wind, Double wind2,Double wind10,int WindDire,Double temp)
    {
        SolarRadiantHeatInfo solarRadiantHeatInfo = new SolarRadiantHeatInfo();
        solarRadiantHeatInfo.setDate(time);
        solarRadiantHeatInfo.setAggregateVal(DailyAccumulated);
        solarRadiantHeatInfo.setMomentVal(Instantaneous);
        solarRadiantHeatInfo.setHumidity(humidity);
        solarRadiantHeatInfo.setWind(wind);
        solarRadiantHeatInfo.setWind2(wind2);
        solarRadiantHeatInfo.setWind10(wind10);
        solarRadiantHeatInfo.setDirection(WindDire);
        solarRadiantHeatInfo.setTemp(temp);
        solarRadiantHeatInfoMapper.insertSelective(solarRadiantHeatInfo);
    }

}
