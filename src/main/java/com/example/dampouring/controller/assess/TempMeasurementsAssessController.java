package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.service.TempMeasurementsAssessService;
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

@RequestMapping("api/tempMeasurementsAssess")
@Controller
@Api(description = "气温信息评价")
public class TempMeasurementsAssessController {
    @Autowired
    TempMeasurementsAssessService tempMeasurementsAssessService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listTempMeasurementsAssess(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize) {
        PageInfo pageInfo = tempMeasurementsAssessService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<TempMeasurementsAssess> memberList = tempMeasurementsAssessService.exportList();
        ExportParams params = new ExportParams("气温动态分析", "气温动态分析", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, TempMeasurementsAssess.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "气温动态分析");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectTempMeasurementsAssess(@RequestBody TempMeasurementsAssessQue TempMeasurementsAssessQue) {
        PageInfo pageInfo = tempMeasurementsAssessService.orUserSelect(TempMeasurementsAssessQue);
        return ApiRestResponse.success(pageInfo);
    }
}
