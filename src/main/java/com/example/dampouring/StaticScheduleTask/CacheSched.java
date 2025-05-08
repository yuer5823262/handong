package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.vo.AlertCountVO;
import com.example.dampouring.model.vo.CloudMonitoringVO;
import com.example.dampouring.model.vo.MaxTempMVO;
import com.example.dampouring.service.CloudMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class CacheSched {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CloudMonitoringService cloudMonitoringService;

    @Scheduled(fixedRate = 3000000) // 每隔10分钟执行一次
    public void updateMaxTempMCache() {
        if(Constant.systemState==32)
            return;
        // 将数据放入缓存中
        Cache maxCache = cacheManager.getCache("maxTempM");
        if(maxCache!=null)
        {
            HashMap<String, MaxTempMVO> result = new HashMap<>();
            List<MaxTempMVO> maxTempMVOList = cloudMonitoringService.maxTempM();
            result.put("totalPouringQuantity", maxTempMVOList.get(0));
            result.put("pouringWarehouseNumber", maxTempMVOList.get(1));
            maxCache.put("1", result);
        }
        Cache pourCache = cacheManager.getCache("pouringMonitoring");
        if(pourCache!=null)
        {
            List<CloudMonitoringVO> maxTempMVOList = cloudMonitoringService.pouringMonitoring();
            pourCache.put("1", ApiRestResponse.success(maxTempMVOList));
        }
        Cache alertCache = cacheManager.getCache("alertCount");
        if(alertCache!=null)
        {
            List<AlertCountVO> alertCount = cloudMonitoringService.alertCount();
            HashMap<String, List<AlertCountVO>> result = new HashMap<>();
            result.put("result",alertCount);
            alertCache.put("1", result);
        }

    }
}
