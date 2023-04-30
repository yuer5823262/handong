package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.CloudMonitoringMapper;
import com.example.dampouring.model.dao.TempMeasurementsAssessMapper;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.service.CloudMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CloudMonitoringServiceImpl implements CloudMonitoringService {
    @Autowired
    CloudMonitoringMapper cloudMonitoringMapper;
    @Autowired
    TempMeasurementsAssessMapper tempMeasurementsAssessMapper;
    @Override
    public PouringVolumeVO PouringVolume() {
        PouringVolumeVO pouringVolumeVO = cloudMonitoringMapper.PouringVolume();

        return pouringVolumeVO;
    }

    @Override
    public List<PouringInfoVO> pouringInfo() {
        List<PouringInfoVO> pouringInfoVOList = cloudMonitoringMapper.pouringInfo();
        return pouringInfoVOList;
    }

    @Override
    public List<ProcessComplianceVO> processCompliance() {
        List<ProcessComplianceVO> processComplianceVOList = cloudMonitoringMapper.processCompliance();
        return processComplianceVOList;
    }

    @Override
    public List<AlertCountVO> alertCount() {
        List<AlertCountVO> alertCountVO = cloudMonitoringMapper.alertCount();
        return alertCountVO;
    }
    @Override
    public HashMap<String, HashMap> weatherInfo(){
        HashMap<String, HashMap> result = new HashMap<>();
        List<TempMeasurementsAssess> tempMeasurementsAssessList = tempMeasurementsAssessMapper.weatherInfo();
        HashMap<String,List<HashMap>> resultData = new HashMap<>();
        List<HashMap> AveragedailyTemperature = new ArrayList<>();
        List<HashMap> highestTemperature = new ArrayList<>();
        List<HashMap> lowestTemperature = new ArrayList<>();
        for(TempMeasurementsAssess tempMeasurementsAssess: tempMeasurementsAssessList)
        {
            HashMap<String,Object> at = new HashMap<>();
            at.put("date",tempMeasurementsAssess.getTime());
            at.put("value",tempMeasurementsAssess.getAvgTemp());
            AveragedailyTemperature.add(at);
            HashMap<String,Object> ht = new HashMap<>();
            ht.put("date",tempMeasurementsAssess.getTime());
            ht.put("value",tempMeasurementsAssess.getTopTemp());
            highestTemperature.add(ht);
            HashMap<String,Object> lt = new HashMap<>();
            lt.put("date",tempMeasurementsAssess.getTime());
            lt.put("value",tempMeasurementsAssess.getBottomTemp());
            lowestTemperature.add(lt);
        }
        resultData.put("AveragedailyTemperature",AveragedailyTemperature);
        resultData.put("highestTemperature",highestTemperature);
        resultData.put("lowestTemperature",lowestTemperature);
        result.put("result",resultData);
        return result;
    }

    @Override
    public List<CurTempInfo> curTempInfo(Integer sbId) {
        List<CurTempInfo> curTempInfoList = cloudMonitoringMapper.curTempInfo(sbId);
        return curTempInfoList;
    }

    @Override
    public HeightDiffVO heightDifference() {
        HeightDiffVO heightDiffVO = cloudMonitoringMapper.heightDifference();

        return heightDiffVO;
    }

    @Override
    public List<MaxTempMVO> maxTempM() {
        List<MaxTempMVO> maxTempMVOList = cloudMonitoringMapper.maxTempM();
        return maxTempMVOList;
    }

    @Override
    public List<CloudMonitoringVO> pouringMonitoring() {
        List<CloudMonitoringVO> cloudMonitoringVOList = cloudMonitoringMapper.pouringMonitoring();
        return cloudMonitoringVOList;
    }
}
