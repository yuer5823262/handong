package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingBuildingMapper;
import com.example.dampouring.model.dao.SmartMixingParaMapper;
import com.example.dampouring.model.dao.SmartMixingResultMapper;
import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.model.pojo.SmartMixingPara;
import com.example.dampouring.model.pojo.SmartMixingResult;
import com.example.dampouring.query.SmartMixingResultQue;
import com.example.dampouring.query.SmartMixingResultQue;
import com.example.dampouring.service.MixingAlertService;
import com.example.dampouring.service.SmartMixingResultService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartMixingResultServiceImpl implements SmartMixingResultService {
    @Autowired
    SmartMixingResultMapper SmartMixingResultMapper;
    @Autowired
    MixingBuildingMapper mixingBuildingMapper;
    @Autowired
    SmartMixingParaMapper smartMixingParaMapper;
    @Autowired
    MixingAlertService mixingAlertService;

    @Override
    public PageInfo orUserSelect(SmartMixingResultQue SmartMixingResultQue) {
        PageHelper.startPage(SmartMixingResultQue.getPageNum(), SmartMixingResultQue.getPageSize());
        List<SmartMixingResult> SmartMixingResults = SmartMixingResultMapper.selectList(SmartMixingResultQue);
        PageInfo pageInfo = new PageInfo(SmartMixingResults);
        return pageInfo;
    }
    @Override
    @Async
    public void SmartMixingResultCalculate()
    {
        List<MixingBuilding> mixingBuildingList = mixingBuildingMapper.selectList();
        for(MixingBuilding mixingBuilding:mixingBuildingList)
        {
            SmartMixingPara smartMixingPara = smartMixingParaMapper.selectByMbId(mixingBuilding.getId());
            if(smartMixingPara==null) continue;
            SmartMixingResult smartMixingResult = SmartMixingResultMapper.getTemp(mixingBuilding.getNo());
            if(smartMixingResult==null) continue;
            if(smartMixingResult.checkData()==false) continue;
            smartMixingResult.setMbid(mixingBuilding.getId());
            smartMixingResult.setTime(TimeUtils.getNowTime());
            smartMixingResult.Calculate(smartMixingPara);
            SmartMixingResultMapper.insertSelective(smartMixingResult);
            mixingAlertService.mixingTempAlert(smartMixingResult);
        }

    }

    @Override
    public List<SmartMixingResult> exportList() {
        List<SmartMixingResult> SmartMixingResults = SmartMixingResultMapper.selectList(new SmartMixingResultQue());
        return SmartMixingResults;
    }

}
