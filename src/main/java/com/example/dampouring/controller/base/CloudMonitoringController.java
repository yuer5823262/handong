package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.service.AirTempSensorService;
import com.example.dampouring.service.CloudMonitoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Api(description = "仿真云监控")
@RequestMapping("api/CloudMonitoring")
@Controller
public class CloudMonitoringController {
    @Autowired
    CloudMonitoringService cloudMonitoringService;

    @ApiOperation("总浇筑方量")
    @GetMapping("/pouringVolume")
    @ResponseBody
    public HashMap<String,HashMap> pouringVolume() {
        PouringVolumeVO pouringVolumeVO = cloudMonitoringService.PouringVolume();
        HashMap<String,Integer> data1 = new HashMap<>();
        HashMap<String,Integer> data2 = new HashMap<>();
        HashMap<String,Integer> data3 = new HashMap<>();
        data1.put("curMonth",pouringVolumeVO.getCurMonth());
        data1.put("curYear",pouringVolumeVO.getCurYear());
        data1.put("total",pouringVolumeVO.getTotal());
        data2.put("curMonth",pouringVolumeVO.getTotalSbM());
        data2.put("curYear",pouringVolumeVO.getTotalSbY());
        data2.put("total",pouringVolumeVO.getTotalSb());
        data3.put("thermometerTotal",pouringVolumeVO.getThermometerTotal());
        data3.put("wpTotal",pouringVolumeVO.getWpTotal());
        data3.put("ckTotal",pouringVolumeVO.getCkTotal());
        HashMap<String,HashMap> datalist = new HashMap<>();
        datalist.put("totalPouringQuantity",data1);
        datalist.put("pouringWarehouseNumber",data2);
        datalist.put("equipBuriedStatistics",data3);
        HashMap<String,HashMap> result = new HashMap<>();
        result.put("result",datalist);
        return result;
    }


    @ApiOperation("高差")
    @GetMapping("/heightDiff")
    @ResponseBody
    public HashMap<String,HeightDiffVO> heightDifference() {
        HeightDiffVO heightDiffVO = cloudMonitoringService.heightDifference();
        HashMap<String,HeightDiffVO> result = new HashMap<>();
        result.put("result",heightDiffVO);
        return result;
    }

    @ApiOperation("浇筑信息")
    @GetMapping("/pouringInfo")
    @ResponseBody
    public HashMap<String,List<PouringInfoVO>> pouringInfo() {
        List<PouringInfoVO> pouringInfoVOList = cloudMonitoringService.pouringInfo();
        HashMap<String,List<PouringInfoVO>> result = new HashMap<>();
        result.put("result",pouringInfoVOList);
        return result;
    }

    @ApiOperation("过程符合率")
    @GetMapping("/processCompliance")
    @ResponseBody
    public HashMap<String,List<ProcessComplianceVO>> processCompliance() {
        List<ProcessComplianceVO> pouringInfoVOList = cloudMonitoringService.processCompliance();
        HashMap<String,List<ProcessComplianceVO>> result = new HashMap<>();
        result.put("result",pouringInfoVOList);
        return result;
    }

    @ApiOperation("报警统计")
    @GetMapping("/alertCount")
    @ResponseBody
    public HashMap<String,List<AlertCountVO>> alertCount() {
        List<AlertCountVO> alertCount = cloudMonitoringService.alertCount();
        HashMap<String, List<AlertCountVO>> result = new HashMap<>();
        result.put("result",alertCount);
        return result;
    }
    @ApiOperation("当前温控概要")
    @GetMapping("/curTempInfo")
    @ResponseBody
    public HashMap<String,List<CurTempInfo>> curTempInfo(@RequestParam Integer sbId) {
        List<CurTempInfo> alertCount = cloudMonitoringService.curTempInfo(sbId);
        HashMap<String, List<CurTempInfo>> result = new HashMap<>();
        result.put("result",alertCount);
        return result;
    }

    @ApiOperation("气象信息")
    @GetMapping("/weatherInfo")
    @ResponseBody
    public HashMap<String,HashMap> weatherInfo() {
        HashMap<String,HashMap> result = cloudMonitoringService.weatherInfo();
        return result;
    }


    @ApiOperation("最高温度")
    @GetMapping("/maxTempM")
    @ResponseBody
    public HashMap<String,MaxTempMVO> maxTempM() {
        HashMap<String,MaxTempMVO> result = new HashMap<>();
        List<MaxTempMVO> maxTempMVOList = cloudMonitoringService.maxTempM();
        result.put("totalPouringQuantity",maxTempMVOList.get(0));
        result.put("pouringWarehouseNumber",maxTempMVOList.get(1));
        return result;
    }

    @ApiOperation("浇筑监控")
    @GetMapping("/pouringMonitoring")
    @ResponseBody
    public ApiRestResponse pouringMonitoring() {
        List<CloudMonitoringVO> maxTempMVOList = cloudMonitoringService.pouringMonitoring();
        return ApiRestResponse.success(maxTempMVOList);
    }



}
