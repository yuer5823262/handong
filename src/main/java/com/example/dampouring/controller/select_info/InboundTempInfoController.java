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
import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.model.vo.InboundTempInfoVO;
import com.example.dampouring.model.vo.InboundTempMonitorVO;
import com.example.dampouring.model.vo.InnerTempMonitorVO;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.query.InboundTempInfoQue;
import com.example.dampouring.service.InboundTempInfoService;
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
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/inboundTempInfo")
@Controller
@Api(description = "入仓温度信息")
public class InboundTempInfoController {
    @Autowired
    InboundTempInfoService inboundTempInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listInboundTempInfo(@RequestParam Integer pageNum,
                                                     @RequestParam Integer pageSize) {
        PageInfo pageInfo = inboundTempInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectInboundTempInfo(@RequestBody InboundTempInfoQue InboundTempInfoQue) {
        PageInfo pageInfo = inboundTempInfoService.orUserSelect(InboundTempInfoQue);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/assess")
    @ResponseBody
    public ApiRestResponse listSelectInboundTempAssess(@RequestBody InboundTempAssessQue InboundTempAssessQue) {
        PageInfo pageInfo = inboundTempInfoService.assess(InboundTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "入仓温度监控")
    @PostMapping("/tempMonitor")
    @ResponseBody
    public ApiRestResponse tempMonitor() {
        List<InboundTempMonitorVO> inboundTempMonitorVOS = inboundTempInfoService.tempMonitor();
        return ApiRestResponse.success(inboundTempMonitorVOS);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQueByQue")
    public void exportMemberListByque(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody InboundTempInfoQue InboundTempInfoQue) {
        List<InboundTempInfoVO> memberList = inboundTempInfoService.exportListByque(InboundTempInfoQue);
        ExportParams params = new ExportParams("入仓温度信息", "入仓温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InboundTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "入仓温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InboundTempInfoVO> memberList = inboundTempInfoService.exportList();
        ExportParams params = new ExportParams("入仓温度信息", "入仓温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InboundTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "入仓温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<InboundTempInfoVO> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("入仓温度信息", "入仓温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InboundTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "入仓温度信息");
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
            List<InboundTempInfoVO> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    InboundTempInfoVO.class, params);
            list.forEach(t->t.setBl(1));
            inboundTempInfoService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
