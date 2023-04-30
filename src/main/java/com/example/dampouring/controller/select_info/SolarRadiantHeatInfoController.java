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
import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.model.pojo.WeatherForecast;
import com.example.dampouring.query.SolarRadiantHeatInfoQue;
import com.example.dampouring.service.SolarRadiantHeatInfoService;
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

@RequestMapping("api/SolarRadiantHeatInfo")
@Controller
@Api(description = "太阳辐射热信息")
public class SolarRadiantHeatInfoController {
    @Autowired
    SolarRadiantHeatInfoService solarRadiantHeatInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listSolarRadiantHeatInfo(@RequestParam Integer pageNum,
                                                @RequestParam Integer pageSize) {
        PageInfo pageInfo = solarRadiantHeatInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSolarRadiantHeatInfo(@RequestBody SolarRadiantHeatInfoQue SolarRadiantHeatInfoQue) {
        PageInfo pageInfo = solarRadiantHeatInfoService.orUserSelect(SolarRadiantHeatInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                      @RequestBody SolarRadiantHeatInfoQue SolarRadiantHeatInfoQue) {
        List<SolarRadiantHeatInfo> memberList = solarRadiantHeatInfoService.exportListByQue(SolarRadiantHeatInfoQue);
        ExportParams params = new ExportParams("太阳辐射热信息", "太阳辐射热信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SolarRadiantHeatInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "太阳辐射热信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SolarRadiantHeatInfo> memberList = solarRadiantHeatInfoService.exportList();
        ExportParams params = new ExportParams("太阳辐射热信息", "太阳辐射热信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SolarRadiantHeatInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "太阳辐射热信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<SolarRadiantHeatInfo> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("太阳辐射热信息", "太阳辐射热信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SolarRadiantHeatInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "太阳辐射热信息");
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
            List<SolarRadiantHeatInfo> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    SolarRadiantHeatInfo.class, params);
            list.forEach(t->t.setBl(1));
            solarRadiantHeatInfoService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
