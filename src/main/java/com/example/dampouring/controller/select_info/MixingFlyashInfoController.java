package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.MixingBetonInfo;
import com.example.dampouring.model.pojo.MixingFlyashInfo;
import com.example.dampouring.query.MixingFlyashInfoQue;
import com.example.dampouring.service.MixingFlyashInfoService;
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

@RequestMapping("api/MixingFlyashInfo")
@Controller
@Api(description = "拌合粉煤灰温度信息")
public class MixingFlyashInfoController{
    @Autowired
    MixingFlyashInfoService MixingFlyashInfoService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMixingFlyashInfo(@RequestBody MixingFlyashInfoQue MixingFlyashInfoQue) {
        PageInfo pageInfo = MixingFlyashInfoService.orUserSelect(MixingFlyashInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody MixingFlyashInfoQue MixingFlyashInfoQue) {
        List<MixingFlyashInfo> memberList = MixingFlyashInfoService.exportListByQue(MixingFlyashInfoQue);
        ExportParams params = new ExportParams("拌合粉煤灰温度信息", "拌合粉煤灰温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingFlyashInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "拌合粉煤灰温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingFlyashInfo> memberList = MixingFlyashInfoService.exportList();
        ExportParams params = new ExportParams("拌合粉煤灰温度信息", "拌合粉煤灰温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingFlyashInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "拌合粉煤灰温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
