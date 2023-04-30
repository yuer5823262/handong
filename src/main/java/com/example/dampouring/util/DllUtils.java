package com.example.dampouring.util;


import com.example.dampouring.common.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class DllUtils {
    public int cTimes=3;
    private static DllUtils dllUtils = new DllUtils();
    public static DllUtils getDllUtils()
    {
        return dllUtils;
    }
    private static Lock lock = new ReentrantLock();
    private DllUtils(){}
    public short C_CommOpen(short p) {
        short b = 9600;
        return CLibrary.INSTANCE.C_CommOpen(p,b);
    }
    public short LNT_ReadInIValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut,int cTimes){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_ReadInIValue(Address,StrChanl,ChnalNumber,TemperValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
    public short LNT_ReadOutIValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut,int cTimes){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_ReadOutIValue(Address,StrChanl,ChnalNumber,TemperValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
    public short  LNT_SetElecNearAimI(byte Address,int Chanl,double
            AimValue,int TimOut){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_SetElecNearAimI(Address,Chanl,AimValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
    public short  LNT_SetElecNearOnOff(byte Address,byte Chanl,byte
            OnOff,int TimOut){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_SetElecNearOnOff(Address,Chanl,OnOff,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
    public short  LNT_SetIOValue(byte Address,byte Chanl,byte
            IOValue,int TimOut){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_SetIOValue(Address,Chanl,IOValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }

    public short  LNT_ReadIOValue(byte Address,int StrChanl,int
            ChnalNumber,byte[] SwitchValue,int TimOut){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_ReadIOValue(Address,StrChanl,ChnalNumber,SwitchValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }


    public short LNT_ReadTemperatureValue(byte Address,int StrChanl,int
            ChnalNumber,double[] TemperValue,int TimOut,int cTimes){
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_ReadTemperatureValue(Address,StrChanl,ChnalNumber,TemperValue,TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
//    public short LNT_SetOutIValue(byte Address,byte Chanl,double SetValue,int TimOut)
//    {
//        return CLibrary.INSTANCE.LNT_SetOutIValue(Address,Chanl,SetValue,TimOut);
//    }

    public short  Sun_GetRadiationValue(byte Address,double[]
            Instantaneous,double[] DailyAccumulated,int TimOut)
    {
        return CLibrary.INSTANCE.Sun_GetRadiationValue(Address,
        Instantaneous, DailyAccumulated, TimOut);
    }

    public short LNT_ReadSensorSerial(byte Address,byte GroupNum,byte
            ChanlNum,byte[] SensorSn,int TimOut)
    {
        lock.lock();
        short temp = 1;
        for(int i=0;i<cTimes;i++)
        {
            temp = CLibrary.INSTANCE.LNT_ReadSensorSerial(Address,GroupNum, ChanlNum, SensorSn, TimOut);
            if(temp==0) break;
        }
        lock.unlock();
        return temp;
    }
    public List<Integer> getTempSensorChannel(Integer Address, Integer GroupNum, List<String> addrList)
    {
        if(Address==null||GroupNum==null) return null;
//        short p = DllUtils.C_CommOpen(Constant.p);
//        if(p!=0) return null;
        Constant.print("getTempSensorChannel");
        short temp = 1;
        byte[] aa = new byte[200];
        for(int i = 0; i< 3; i++)
        {
            temp = LNT_ReadSensorSerial(Address.byteValue(),GroupNum.byteValue(),
                    (byte) 10,aa,Constant.timeout);
            if(temp==0) break;
        }
//        DllUtils.C_CommClose();
        StringBuffer result=new StringBuffer();
        for(int i=0;i<aa.length;i++){
            int t=  aa[i];
            char bb = (char) t;
            result.append(bb);
        }
        List<Integer> indexList = new ArrayList<>();
        for(String addr:addrList)
        {
            Integer mark = result.indexOf(addr);
            if(mark==-1) indexList.add(-1);
            else indexList.add((GroupNum-1)*10+(mark/16+1));
        }
        return indexList;

    }

    public short  Weather_GetValue(byte Address,double[] Temperature,
//            double[] Humidity,int[] WindDire,double[] WindSpeed0,double[]
//                                    WindSpeed2,double[] WindSpeedA
                                    int TimOut)
    {
        return CLibrary.INSTANCE.Weather_GetValue(Address,
        Temperature, new double[0], new int[0], new double[0],
                new double[0], new double[0],TimOut);
    }

    public short C_CommClose() {
        return CLibrary.INSTANCE.C_CommClose();
    }
}