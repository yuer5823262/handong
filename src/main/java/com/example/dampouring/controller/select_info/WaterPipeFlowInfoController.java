package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.model.vo.PouringTempMonitorVO;
import com.example.dampouring.model.vo.WaterMonitorVO;
import com.example.dampouring.model.vo.WaterPipeFlowInfoVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.query.WaterPipeFlowInfoQue;
import com.example.dampouring.service.WaterPipeFlowInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/WaterPipeFlowInfo")
@Controller
@Api(description = "通水信息")
public class WaterPipeFlowInfoController {
    @Autowired
    WaterPipeFlowInfoService waterPipeFlowInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listWaterPipeFlowInfo(@RequestParam Integer pageNum,
                                                  @RequestParam Integer pageSize) {
        PageInfo pageInfo = waterPipeFlowInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectWaterPipeFlowInfo(@RequestBody WaterPipeFlowInfoQue WaterPipeFlowInfoQue) {
        PageInfo pageInfo = waterPipeFlowInfoService.orUserSelect(WaterPipeFlowInfoQue);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterPipeFlowInfo(@RequestBody WaterPipeFlowInfo WaterPipeFlowInfo) {
        waterPipeFlowInfoService.add(WaterPipeFlowInfo);
        return ApiRestResponse.success();
    }

    @PostMapping("/assess")
    @ResponseBody
    public ApiRestResponse listSelectWaterPipeFlowAssess(@RequestBody WaterPipeFlowAssessQue waterPipeFlowAssessQue) {
        PageInfo pageInfo = waterPipeFlowInfoService.assess(waterPipeFlowAssessQue);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation(value = "当前计算调控仓")
    @PostMapping("/calculating")
    @ResponseBody
    public ApiRestResponse listSelectWaterPipeFlowCalculating(@RequestBody WaterPipeFlowAssessQue waterPipeFlowAssessQue) {
        PageInfo pageInfo = waterPipeFlowInfoService.calculating(waterPipeFlowAssessQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody WaterPipeFlowInfoQue WaterPipeFlowInfoQue) {
        List<WaterPipeFlowInfoVO> memberList = waterPipeFlowInfoService.exportListByQue(WaterPipeFlowInfoQue);
        ExportParams params = new ExportParams("通水信息", "通水信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPipeFlowInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "通水信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
//    @ApiOperation(value = "智能通水结果")
//    @PostMapping("/smartWaterFlow")
//    @ResponseBody
//    public ApiRestResponse listSelectsmartWaterFlow(@RequestBody WaterPipeFlowInfoQue waterPipeFlowInfoQue) {
////        PageInfo pageInfo = waterPipeFlowInfoService.smartWaterFlow(waterPipeFlowInfoQue);
////        return ApiRestResponse.success(pageInfo);
//        return null;
//    }
    @ApiOperation(value = "通水监控")
    @PostMapping("/waterMonitor")
    @ResponseBody
    public ApiRestResponse waterMonitor() {
        List<WaterMonitorVO> waterMonitorVOS = waterPipeFlowInfoService.waterMonitor();
        return ApiRestResponse.success(waterMonitorVOS);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterPipeFlowInfoVO> memberList = waterPipeFlowInfoService.exportList();
        ExportParams params = new ExportParams("通水信息", "通水信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPipeFlowInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "通水信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<WaterPipeFlowInfo> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("通水信息", "通水信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPipeFlowInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "通水信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation("从Excel导入")
    @PostMapping("/importMemberList")
    @ResponseBody
    public ApiRestResponse importMemberList(@RequestPart("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        try {
            List<WaterPipeFlowInfo> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    WaterPipeFlowInfo.class, params);
            list.forEach(t->t.setBl(1));
            waterPipeFlowInfoService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
