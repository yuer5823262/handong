package com.example.dampouring.controller.smart_water;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.StaticScheduleTask.SmartScheduleTask;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ControlProcessMapper;
import com.example.dampouring.model.dao.SwFollowCurveMapper;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.dao.WaterReversingDeviceMapper;
import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.model.pojo.SwFollowCurve;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.SmartFlowResultQue;
import com.example.dampouring.query.SwFollowCurveQue;
import com.example.dampouring.service.SmartFlowResultService;
import com.example.dampouring.service.SwFollowCurveService;
import com.example.dampouring.service.SwSiloDataService;
import com.example.dampouring.service.WaterPipeService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Api(description = "智能通水结果")
@RequestMapping("api/SmartFlowResult")
@Controller
public class SmartFlowResultController {
    @Autowired
    SmartFlowResultService SmartFlowResultService;
    @Autowired
    WaterPipeService waterPipeService;
    @Autowired
    SwFollowCurveService swFollowCurveService;
    @Autowired
    SwSiloDataService swSiloDataService;
    @Autowired
    WaterReversingDeviceMapper waterReversingDeviceMapper;
    @Autowired
    ControlProcessMapper controlProcessMapper;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    SwFollowCurveMapper swFollowCurveMapper;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSmartFlowResult(@RequestBody SwFollowCurveQue swFollowCurveQue) {
        PageInfo pageInfo = SmartFlowResultService.orUserSelect(swFollowCurveQue);
        return ApiRestResponse.success(pageInfo);
    }
    @GetMapping("/writeFlowFile")
    @ResponseBody
    public ApiRestResponse writeFlowFile() throws Exception {
        waterPipeService.writeFile();
        swSiloDataService.writeZyFile();
        swSiloDataService.writeFile();
        Constant.print("................writeTsData....................");
        return ApiRestResponse.success();
    }
    @GetMapping("/getFlowFile")
    @ResponseBody
    public ApiRestResponse getFlowResult() throws Exception {
        SmartFlowResultService.getFlowResult();
        return ApiRestResponse.success();
    }
    @GetMapping("/flowResult")
    @ResponseBody
    public ApiRestResponse readFlowFile(Integer state)
    {
        if(Constant.pSta!=0) return ApiRestResponse.error(30000,"串口未打开");
        Constant.print("................insertTsData....................");
        swFollowCurveService.readFile(state);
        return ApiRestResponse.success();
    }

    @GetMapping("/controlProcess")
    @ResponseBody
    public ApiRestResponse flowResult()
    {
        if(Constant.pSta!=0) return ApiRestResponse.error(30000,"串口未打开");
        SmartFlowResultService.controlProcess();
        return ApiRestResponse.success();
    }

    @GetMapping("/waterReversing")
    @ResponseBody
    public ApiRestResponse waterReversing() {
        if (Constant.pSta != 0) return ApiRestResponse.error(30000, "串口未打开");
        SmartFlowResultService.waterReversing();
        return ApiRestResponse.success();
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                      @RequestBody SwFollowCurveQue swFollowCurveQue) {
        List<SwFollowCurve> memberList = SmartFlowResultService.exportListByQue(swFollowCurveQue);
        ExportParams params = new ExportParams("智能通水结果", "智能通水结果", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SwFollowCurve.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能通水结果");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SwFollowCurve> memberList = SmartFlowResultService.exportList();
        ExportParams params = new ExportParams("智能通水结果", "智能通水结果", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SwFollowCurve.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能通水结果");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }


    @ApiOperation("获取通水文件列表")
    @GetMapping("/getFileList")
    @ResponseBody
    public ApiRestResponse getFileList() {
        List<String> fileNameList = DatUtils.getFileNameList(Constant.SMART_TS_DATA_PATH);
        return ApiRestResponse.success(fileNameList);
    }

    @ApiOperation("获取通水文件内容")
    @GetMapping("/getFileStringList")
    @ResponseBody
    public ApiRestResponse getFileStringList(@RequestParam String fileName) {
        List<String> fileNameList = null;
        try {
            fileNameList = DatUtils.getStringLines(Constant.SMART_TS_DATA_PATH+fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
        return ApiRestResponse.success(fileNameList);
    }

}
