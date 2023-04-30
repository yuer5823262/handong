package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.model.pojo.MixingSandAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.example.dampouring.service.MixingSandAssessService;
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

@RequestMapping("api/MixingSandAssess")
@Controller
@Api(description = "智能拌合砂温度评价")
public class MixingSandAssessController {
    @Autowired
    MixingSandAssessService MixingSandAssessService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMixingSandAssess(@RequestBody MixingWaterAssessQue MixingWaterAssessQue) {
        PageInfo pageInfo = MixingSandAssessService.orUserSelect(MixingWaterAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingSandAssess> memberList = MixingSandAssessService.exportList();
        ExportParams params = new ExportParams("智能拌合砂温度评价", "智能拌合砂温度评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingSandAssess.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能拌合砂温度评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
