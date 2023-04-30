package com.example.dampouring.controller.smart_mixing;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SmartMixingResult;
import com.example.dampouring.model.vo.InnerTempSensorInfoVO;
import com.example.dampouring.query.SmartMixingResultQue;
import com.example.dampouring.service.SmartMixingResultService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(description = "智能拌合结果")
@RequestMapping("api/SmartMixingResult")
@Controller
public class SmartMixingResultController {
    @Autowired
    SmartMixingResultService SmartMixingResultService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSmartMixingResult(@RequestBody SmartMixingResultQue SmartMixingResultQue) {
        PageInfo smartMixingResults = SmartMixingResultService.orUserSelect(SmartMixingResultQue);
        return ApiRestResponse.success(smartMixingResults);
    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SmartMixingResult> memberList = SmartMixingResultService.exportList();
        ExportParams params = new ExportParams("智能拌合结果", "智能拌合结果", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SmartMixingResult.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能拌合结果");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
