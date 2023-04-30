package com.example.dampouring.yunData;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.MixingEgSensorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.dampouring.model.pojo.MixingEgSensor;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class YunData {
    @Autowired
    MixingEgSensorMapper mixingEgSensorMapper;
//    @PostConstruct
    public void getYunData(){
        List<MixingEgSensor> mixingEgSensorL = mixingEgSensorMapper.getIpDk();
        for(MixingEgSensor mixingEgSensor:mixingEgSensorL)
        {
            Constant.print("启动线程socket获取拌合楼数据:"+mixingEgSensor.getIp());
            try {
                IBF80TcpClientThread ibf80TcpClientThread = new IBF80TcpClientThread(mixingEgSensor.getIp(), mixingEgSensor.getDkno());
                ibf80TcpClientThread.start();
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }

        }

    }
}
