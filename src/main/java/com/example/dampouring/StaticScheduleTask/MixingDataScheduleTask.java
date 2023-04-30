package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.MixingTempBcMapper;
import com.example.dampouring.model.dao.db2.MixingTempYcMapper;
import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class MixingDataScheduleTask {
    @Autowired
    MixingTempYcMapper mixingTempYcMapper;
    @Autowired
    MixingTempBcMapper mixingTempBcMapper;
    @Autowired
    InboundTempInfoService inboundTempInfoService;
    @Autowired
    ExportMachineTempInfoService exportMachineTempInfoService;
    @Autowired
    PouringTempInfoService pouringTempInfoService;
    @Autowired
    MaterialsTempInfoService materialsTempInfoService;
    @Autowired
    SmartMixingResultService smartMixingResultService;


    @Scheduled(cron="59 * * * * ?")
    @Async
    public void mixingDataScheduleTask()
    {
        if(Constant.systemState==64) return;
        List<MixingTempBc> mixingTempBcs = mixingTempYcMapper.list();
        Constant.logger.info("-----------------mixingTempData------------"+mixingTempBcs.size());
        for(MixingTempBc mixingTempBc:mixingTempBcs)
        {
            try {
                String type =mixingTempBc.getWdtype();
//                Constant.logger.info("-----------------mixingTempData------------开始同步");
                int count = mixingTempBcMapper.selectBySourceId(mixingTempBc.getSourceid());
//                Constant.logger.info("-----------------mixingTempData------------查看是否重复:"+count);
                if(count>0)
                {
                    continue;
                }

                mixingTempBc.setId(null);
                mixingTempBcMapper.insertSelective(mixingTempBc);
                Constant.logger.info("-----------------mixingTempData------------:"+"成功同步"+type+","+mixingTempBc.getClwd()+","+mixingTempBc.getCwsj());
                if(type.equals("入仓温度"))
                    inboundTempInfoService.insert(mixingTempBc);
                if(type.equals("出机口温度"))
                    exportMachineTempInfoService.insert(mixingTempBc);
                if(type.equals("浇筑温度"))
                    pouringTempInfoService.insert(mixingTempBc);
                if(!mixingTempBc.getGllx().isEmpty()||!mixingTempBc.getGllx().equals(""))
                    materialsTempInfoService.insert(mixingTempBc);

            } catch (Exception e) {
                Constant.logger.error("拌合数据同步错误:",e);
            }

        }
        smartMixingResultService.SmartMixingResultCalculate();

    }
}
