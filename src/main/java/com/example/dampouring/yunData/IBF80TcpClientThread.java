package com.example.dampouring.yunData;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.*;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.SmartMixingResultService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IBF80TcpClientThread extends Thread{
    @Autowired
    MixingEgSensorMapper mixingEgSensorMapper;
    @Autowired
    MaterialsTempInfoMapper materialsTempInfoMapper;
    @Autowired
    ExportMachineTempInfoMapper exportMachineTempInfoMapper;
    @Autowired
    MixingBuildingMapper mixingBuildingMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    SmartMixingResultService smartMixingResultService;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    private String serverIP = null;
    private int serverPort;
    private boolean isRun = true;
    private boolean isConnect = false;
    private Socket tcpClient = null;

    public IBF80TcpClientThread(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        super.run();
        Thread readDataThread = new Thread() {
            @Override
            public void run() {
                super.run();
                readData();
            }
        };
        readDataThread.start();
        while(isRun) {
            try {
                checkConnect();
                if(isConnect == false || tcpClient.isConnected() == false) {
                    Thread.sleep(60 * 10000);
                }
                OutputStream os = tcpClient.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                writer.write("#00");
                writer.flush();
                Thread.sleep(60 * 1000);
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
                isConnect = false;
            }
        }
    }

    private void checkConnect() throws Exception {
        if(isConnect == false || tcpClient.isConnected() == false) {
            try {
                tcpClient = new Socket(serverIP, serverPort);
                isConnect = true;
            } catch (IOException e) {
                Constant.logger.error("错误:",e);
            }
        }
    }

    private void readData()  {
        while(isRun) {
            try {
                if(isConnect == false || tcpClient.isConnected() == false) {
                    Thread.sleep(10000*60);
                    continue;
                }
                InputStream is = tcpClient.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String message = reader.readLine();
                System.out.println(message);
                insertData(message);
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        }
    }
    private void insertData(String str) throws Exception {
        str = str.substring(1);
        str = str.split(",")[0];
        System.out.println(str);
        List<String> stringList  = Arrays.asList(str.split("\\."));
        List<Double> doubleList = new ArrayList<>();
        for(String s:stringList)
        {
            Double d = (Double.parseDouble(s)/1000-4)*38.75-20;
            doubleList.add(d);
        }
        List<MixingEgSensor> mixingEgSensors =  mixingEgSensorMapper.selectByIpDk(serverIP,serverPort);
        for(MixingEgSensor mixingEgSensor:mixingEgSensors)
        {
            Integer c = mixingEgSensor.getCno()-1;
            if(doubleList.size()>c&&doubleList.get(c)!=-175)
            {
                MixingBuilding mixingBuilding = mixingBuildingMapper.selectByPrimaryKey(mixingEgSensor.getBhid());
                if(mixingEgSensor.getType().equals("出机口"))
                {
                    List<PouringBaseVO> pouringBaseList = pouringBaseMapper.selectBy30Min();
                    if(pouringBaseList.size()==0) continue;
                    for(PouringBaseVO pouringBase:pouringBaseList)
                    {
                        ExportMachineTempInfo exportMachineTempInfo = new ExportMachineTempInfo();
                        exportMachineTempInfo.setTime(TimeUtils.getNowTime());
                        exportMachineTempInfo.setPosition(mixingBuilding.getNo());
                        exportMachineTempInfo.setTemperature(doubleList.get(c));
                        SelectNormQue selectNormQue = new SelectNormQue();
                        selectNormQue.setPbId(exportMachineTempInfo.getPouringBaseId());
                        SbTempNormVO sbTempNormVO = sbTempNormMapper.selectNorm(selectNormQue);
                        if(sbTempNormVO!=null)
                            exportMachineTempInfo.setNorm(sbTempNormVO.getPortTemp());
                        exportMachineTempInfo.setOperator(serverIP+serverPort);
                        exportMachineTempInfo.setPouringBaseId(pouringBase.getId());
                        exportMachineTempInfoMapper.insertSelective(exportMachineTempInfo);
                        ConnectionUtil.Send(exportMachineTempInfo.toMqStr(pouringBase));
                    }

                }
                if(mixingEgSensor.getType().equals("骨料"))
                {
                    MaterialsTempInfo materialsTempInfo = new MaterialsTempInfo();
                    materialsTempInfo.setTime(TimeUtils.getNowTime());
                    materialsTempInfo.setPosition(mixingBuilding.getNo());
                    materialsTempInfo.setType(mixingEgSensor.getLqType());
                    materialsTempInfo.setMaterials(mixingEgSensor.getGlType());
                    materialsTempInfo.setTemperature(doubleList.get(c));
                    materialsTempInfo.setOperator(serverIP+serverPort);
                    materialsTempInfoMapper.insertSelective(materialsTempInfo);
                    ConnectionUtil.Send(materialsTempInfo.toMqStr());
                }
            }
        }
        smartMixingResultService.SmartMixingResultCalculate();

    }
}
