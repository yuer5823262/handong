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
import com.example.dampouring.model.pojo.ExportMachineTempAssess;
import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.pojo.TempMeasurements;
import com.example.dampouring.model.pojo.WeatherForecast;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.ExportMachineTempInfoQue;
import com.example.dampouring.service.ExportMachineTempInfoService;
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

@RequestMapping("api/exportMachineTempInfo")
@Controller
@Api(description = "出机口温度信息")
public class ExportMachineTempInfoController {
    @Autowired
    ExportMachineTempInfoService exportMachineTempInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listExportMachineTempInfo(@RequestParam Integer pageNum,
                                             @RequestParam Integer pageSize) {
        PageInfo pageInfo = exportMachineTempInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectExportMachineTempInfo(@RequestBody ExportMachineTempInfoQue ExportMachineTempInfoQue) {
        PageInfo pageInfo = exportMachineTempInfoService.orUserSelect(ExportMachineTempInfoQue);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/assess")
    @ResponseBody
    public ApiRestResponse listSelectExportMachineTempAssess(@RequestBody ExportMachineTempAssessQue exportMachineTempAssessQue) {
        PageInfo pageInfo = exportMachineTempInfoService.assess(exportMachineTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportList")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,@RequestBody ExportMachineTempInfoQue ExportMachineTempInfoQue) {
        List<ExportMachineTempInfoVO> memberList = exportMachineTempInfoService.exportListByQue(ExportMachineTempInfoQue);
        ExportParams params = new ExportParams("出机口温度信息", "出机口温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ExportMachineTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportListByQue")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ExportMachineTempInfoVO> memberList = exportMachineTempInfoService.exportList();
        ExportParams params = new ExportParams("出机口温度信息", "出机口温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ExportMachineTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }


    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<ExportMachineTempInfoVO> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("出机口温度信息", "出机口温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ExportMachineTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口温度信息");
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
            List<ExportMachineTempInfoVO> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    ExportMachineTempInfoVO.class, params);
            list.forEach(t->t.setBl(1));
            exportMachineTempInfoService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
