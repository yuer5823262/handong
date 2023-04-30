package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.MixingBetonInfo;
import com.example.dampouring.model.pojo.MixingSandInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import com.example.dampouring.service.MixingSandInfoService;
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

@RequestMapping("api/MixingSandInfo")
@Controller
@Api(description = "拌合砂温度信息")
public class MixingSandInfoController {
    @Autowired
    MixingSandInfoService MixingSandInfoService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMixingSandInfo(@RequestBody MixingWaterInfoQue mixingInfoQue) {
        PageInfo pageInfo = MixingSandInfoService.orUserSelect(mixingInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody MixingWaterInfoQue mixingInfoQue) {
        List<MixingSandInfo> memberList = MixingSandInfoService.exportListByQue(mixingInfoQue);
        ExportParams params = new ExportParams("拌合砂温度信息", "拌合砂温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingSandInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "拌合砂温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingSandInfo> memberList = MixingSandInfoService.exportList();
        ExportParams params = new ExportParams("拌合砂温度信息", "拌合砂温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingSandInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "拌合砂温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
