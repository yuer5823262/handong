package com.example.dampouring.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLibraryQh extends Library {
    CLibraryQh INSTANCE = Native.loadLibrary(System.getProperty("user.dir")+"\\ZSDLL.dll", CLibraryQh.class);
    Short ZS_Radiation(byte Address, double[] Instantaneous, double[] DailyAccumulated, int TimOut);
    Short ZS_Weather(byte Address, double[] Temperature, double[] Humidity,
                     int[] WindDire, double[] WindSpeed0, double[] WindSpeed2, double[] WindSpeedA,
                     int TimOut);
    Short OpenSerialPort(short portNumber, short BRate);
    Short CloseSerialPort();


}
