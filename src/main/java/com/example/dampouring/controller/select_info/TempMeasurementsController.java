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
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.query.TempMeasurementsQue;
import com.example.dampouring.service.BetonService;
import com.example.dampouring.service.TempMeasurementsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/tempMeasurements")
@Controller
@Api(description = "气温实测信息")
public class TempMeasurementsController {
    @Autowired
    TempMeasurementsService tempMeasurementsService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listtempMeasurements(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = tempMeasurementsService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectTempMeasurements(@RequestBody TempMeasurementsQue tempMeasurementsQue) {
        PageInfo pageInfo = tempMeasurementsService.orUserSelect(tempMeasurementsQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("气温信息评价")
    @PostMapping("/assess")
    @ResponseBody
    public ApiRestResponse AssessTempMeasurements(@RequestBody TempMeasurementsAssessQue tempMeasurementsAssessQue) {
        PageInfo pageInfo = tempMeasurementsService.assess(tempMeasurementsAssessQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody TempMeasurementsQue tempMeasurementsQue) {
        List<TempMeasurements> memberList = tempMeasurementsService.exportListByQue(tempMeasurementsQue);
        ExportParams params = new ExportParams("气温实测信息", "气温实测信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, TempMeasurements.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "气温实测信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<TempMeasurements> memberList = tempMeasurementsService.exportList();
        ExportParams params = new ExportParams("气温实测信息", "气温实测信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, TempMeasurements.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "气温实测信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<TempMeasurements> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("气温实测信息", "气温实测信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, TempMeasurements.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "气温实测信息");
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
            List<TempMeasurements> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    TempMeasurements.class, params);
            list.forEach(t->t.setBl(1));
            tempMeasurementsService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
