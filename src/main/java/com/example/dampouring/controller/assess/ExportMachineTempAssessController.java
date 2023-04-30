package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.service.ExportMachineTempAssessService;
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

@RequestMapping("api/ExportMachineTempAssess")
@Controller
@Api(description = "出机口温度评价")
public class ExportMachineTempAssessController {
    @Autowired
    ExportMachineTempAssessService exportMachineTempAssessService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listExportMachineTempAssess(@RequestParam Integer pageNum,
                                                   @RequestParam Integer pageSize) {
        PageInfo pageInfo = exportMachineTempAssessService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectExportMachineTempAssess(@RequestBody ExportMachineTempAssessQue ExportMachineTempAssessQue) {
        PageInfo pageInfo = exportMachineTempAssessService.orUserSelect(ExportMachineTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ExportMachineTempAssessVO> memberList = exportMachineTempAssessService.exportList();
        ExportParams params = new ExportParams("出机口温度评价", "出机口温度评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ExportMachineTempAssessVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口温度评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
