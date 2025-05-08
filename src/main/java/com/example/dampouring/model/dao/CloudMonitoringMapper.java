package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloudMonitoringMapper {
    PouringVolumeVO PouringVolume();

    List<PouringInfoVO> pouringInfo();

    List<ProcessComplianceVO> processCompliance();

    List<AlertCountVO> alertCount();


    List<CurTempInfo> curTempInfo(Integer sbId);

    HeightDiffVO heightDifference();

    List<MaxTempMVO> maxTempM();

    List<CloudMonitoringVO> pouringMonitoring();

    List<PouringProgressVO> pouringProgress();
}
