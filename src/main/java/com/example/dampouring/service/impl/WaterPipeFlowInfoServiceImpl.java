package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.WaterPipeFlowInfoMapper;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.query.WaterPipeFlowInfoQue;
import com.example.dampouring.service.WaterColdAlertService;
import com.example.dampouring.service.WaterPipeFlowInfoService;
import com.example.dampouring.util.ConnectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WaterPipeFlowInfoServiceImpl implements WaterPipeFlowInfoService {
    @Autowired
    WaterPipeFlowInfoMapper WaterPipeFlowInfoMapper;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    WaterColdAlertService waterColdAlertService;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize, Integer sbId) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterPipeFlowInfoVO> WaterPipeFlowInfo = WaterPipeFlowInfoMapper.List(sbId);
        PageInfo pageInfo = new PageInfo(WaterPipeFlowInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(WaterPipeFlowInfoQue WaterPipeFlowInfoQue) {
        PageHelper.startPage(WaterPipeFlowInfoQue.getPageNum(), WaterPipeFlowInfoQue.getPageSize());
        List<WaterPipeFlowInfoVO> WaterPipeFlowInfo = WaterPipeFlowInfoMapper.selectList(WaterPipeFlowInfoQue);
        PageInfo pageInfo = new PageInfo(WaterPipeFlowInfo);
        return pageInfo;
    }

    @Override
    public PageInfo assess(WaterPipeFlowAssessQue waterPipeFlowAssessQue) {
        PageHelper.startPage(waterPipeFlowAssessQue.getPageNum(), waterPipeFlowAssessQue.getPageSize());
        List<WaterPipeFlowAssessVO> waterPipeFlowAssessVOS = WaterPipeFlowInfoMapper.assess(waterPipeFlowAssessQue);
        PageInfo pageInfo = new PageInfo(waterPipeFlowAssessVOS);
        return pageInfo;
    }

    @Override
    public PageInfo calculating(WaterPipeFlowAssessQue waterPipeFlowAssessQue) {
        PageHelper.startPage(waterPipeFlowAssessQue.getPageNum(), waterPipeFlowAssessQue.getPageSize());
        List<CalculatingVO> calculatingVOS = WaterPipeFlowInfoMapper.calculating(waterPipeFlowAssessQue);
        PageInfo pageInfo = new PageInfo(calculatingVOS);
        return pageInfo;
    }

    @Override
    public List<WaterPipeFlowInfoVO> exportList() {
        List<WaterPipeFlowInfoVO> WaterPipeFlowInfo = WaterPipeFlowInfoMapper.List(null);

        return WaterPipeFlowInfo;
    }

    @Override
    public List<WaterMonitorVO> waterMonitor() {
        List<WaterMonitorVO> WaterPipeFlowInfo = WaterPipeFlowInfoMapper.waterMonitor();

        return WaterPipeFlowInfo;
    }

    @Override
    public void insertByComputing(String time) {
        List<WaterPipeVO> waterPipeList =waterPipeMapper.selectByComputing();
        for(WaterPipeVO waterPipe:waterPipeList)
        {
            WaterPipeFlowInfo waterPipeFlowInfo = new WaterPipeFlowInfo();
            String qi = waterPipeMapper.getQsByWPid(waterPipe.getId());
            waterPipeFlowInfo.setTime(time);
            waterPipeFlowInfo.setQi(qi);
            waterPipeFlowInfo.setWaterPipeId(waterPipe.getId());
            WaterPipeFlowInfoMapper.insertSelective(waterPipeFlowInfo);
        }

    }

    @Override
    public void add(WaterPipeFlowInfo waterPipeFlowInfo) {
        WaterPipeFlowInfoMapper.insertSelective(waterPipeFlowInfo);
        waterColdAlertService.WaterColdAlert(waterPipeFlowInfo);
    }

    @Override
    public void addAll(List<WaterPipeFlowInfo> list) {
        for(WaterPipeFlowInfo waterPipeFlowInfo:list)
        {
            WaterPipeFlowInfoMapper.insertSelective(waterPipeFlowInfo);
        }
    }

    @Override
    public void deleteEmpty(String time) {
        try {
            TimeUnit.SECONDS.sleep(3);//秒
        } catch (InterruptedException e) {
            Constant.logger.error("错误:",e);
        }
        WaterPipeFlowInfoMapper.deleteEmpty();
        sendByTime(time);
    }

    @Override
    public void sendByTime(String time) {
        List<WaterPipeFlowInfoVO> waterPipeList =WaterPipeFlowInfoMapper.selectByTime(time);
        for(WaterPipeFlowInfoVO waterPipeFlowInfoVO:waterPipeList)
        {
            try {
                ConnectionUtil.Send(waterPipeFlowInfoVO.toMqStr());
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        }
    }

    @Override
    public List<WaterPipeFlowInfoVO> exportListByQue(WaterPipeFlowInfoQue waterPipeFlowInfoQue) {
        return WaterPipeFlowInfoMapper.selectList(waterPipeFlowInfoQue);
    }
}
