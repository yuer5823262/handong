package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.waterPipeFlowAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.model.vo.WaterPipeFlowAssessVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.service.WaterPipeFlowAssessService;
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

@RequestMapping("api/WaterPipeFlowAssess")
@Controller
@Api(description = "通水信息评价")
public class waterPipeFlowAssessController {
    @Autowired
    WaterPipeFlowAssessService WaterPipeFlowAssessService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listWaterPipeFlowAssess(@RequestParam Integer pageNum,
                                             @RequestParam Integer pageSize) {
        PageInfo pageInfo = WaterPipeFlowAssessService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectWaterPipeFlowAssess(@RequestBody WaterPipeFlowAssessQue WaterPipeFlowAssessQue) {
        PageInfo pageInfo = WaterPipeFlowAssessService.orUserSelect(WaterPipeFlowAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterPipeFlowAssessVO> memberList = WaterPipeFlowAssessService.exportList();
        ExportParams params = new ExportParams("出机口温度评价", "出机口温度评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPipeFlowAssessVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口温度评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
