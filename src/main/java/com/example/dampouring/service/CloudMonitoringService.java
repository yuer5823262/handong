package com.example.dampouring.service;

import com.example.dampouring.model.vo.*;

import java.util.HashMap;
import java.util.List;

public interface CloudMonitoringService {
    PouringVolumeVO PouringVolume();

    List<PouringInfoVO> pouringInfo();

    List<ProcessComplianceVO> processCompliance();

    List<AlertCountVO> alertCount();

    HashMap<String, HashMap> weatherInfo();

    List<CurTempInfo> curTempInfo(Integer sbId);

    HeightDiffVO heightDifference();

    List<MaxTempMVO> maxTempM();

    List<CloudMonitoringVO> pouringMonitoring();
}
