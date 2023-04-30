package com.example.dampouring.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLibrary extends Library {
    CLibrary INSTANCE = Native.loadLibrary(System.getProperty("user.dir")+"\\LnDll.dll", CLibrary.class);
//    CLibrary INSTANCE = Native.loadLibrary("D:\\Users\\91036\\IdeaProjects\\DamPouringDemo\\src\\main\\resources\\LnDll.dll", CLibrary.class);
    short C_CommOpen(short Port,short Brate); //打开串口
    short C_CommClose();   //关闭串口
    short LNT_ReadTemperatureValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut);
    short LNT_ReadInIValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut);
    short LNT_ReadOutIValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut);
    short  Sun_GetRadiationValue(byte Address,double[]
            Instantaneous,double[] DailyAccumulated,int TimOut); //读取太阳辐射值
    short  Weather_GetValue(byte Address,double[]
            Temperature,double[] Humidity,int[] WindDire,double[] WindSpeed0,double[]
                                    WindSpeed2,double[] WindSpeedA,int TimOut); //读取气象数据
    short  LNT_SetOutIValue(byte Address,byte Chanl,double SetValue,int TimOut);
    short  LNT_ReadSensorSerial(byte Address, byte GroupNum, byte
            ChanlNum, byte[] SensorSn, int TimOut);
    short  LNT_SetElecNearAimI(byte Address,int Chanl,double
            AimValue,int TimOut);
    short  LNT_SetElecNearOnOff(byte Address,byte Chanl,byte
            OnOff,int TimOut);
    short  LNT_SetIOValue(byte Address,byte Chanl,byte IOValue,int
            TimOut);
    short  LNT_ReadIOValue(byte Address,int StrChanl,int
            ChnalNumber,byte[] SwitchValue,int TimOut);
}
