package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.pojo.SmartMixingResult;
import com.example.dampouring.query.SmartMixingResultQue;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface SmartMixingResultService {
    PageInfo orUserSelect(SmartMixingResultQue smartMixingResultQue);
    @Async void SmartMixingResultCalculate();

    List<SmartMixingResult> exportList();
}
