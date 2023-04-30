package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.MixingAdditiveAssess;
import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.query.MixingBetonAssessQue;
import com.example.dampouring.service.MixingBetonAssessService;
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

@RequestMapping("api/MixingBetonAssess")
@Controller
@Api(description = "智能拌合水泥温度评价")
public class MixingBetonAssessController {
    @Autowired
    MixingBetonAssessService MixingBetonAssessService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMixingBetonAssess(@RequestBody MixingBetonAssessQue MixingBetonAssessQue) {
        PageInfo pageInfo = MixingBetonAssessService.orUserSelect(MixingBetonAssessQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingBetonAssess> memberList = MixingBetonAssessService.exportList();
        ExportParams params = new ExportParams("智能拌合水泥温度评价", "智能拌合水泥温度评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingBetonAssess.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能拌合水泥温度评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
