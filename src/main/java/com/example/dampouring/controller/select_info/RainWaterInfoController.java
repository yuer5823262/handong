package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.RainWaterInfo;
import com.example.dampouring.model.pojo.SolarRadiantHeatInfo;
import com.example.dampouring.query.RainWaterInfoQue;
import com.example.dampouring.service.RainWaterInfoService;
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

@RequestMapping("api/rainWaterInfo")
@Controller
@Api(description = "水雨情报信息")
public class RainWaterInfoController {
    @Autowired
    RainWaterInfoService rainWaterInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listRainWaterInfo(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize,
                                             @RequestParam String type) {
        PageInfo pageInfo = rainWaterInfoService.orUserList(pageNum, pageSize,type);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectRainWaterInfo(@RequestBody RainWaterInfoQue RainWaterInfoQue) {
        PageInfo pageInfo = rainWaterInfoService.orUserSelect(RainWaterInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody RainWaterInfoQue RainWaterInfoQue) {
        List<RainWaterInfo> memberList = rainWaterInfoService.exportListByQue(RainWaterInfoQue);
        ExportParams params = new ExportParams("水雨情报信息", "水雨情报信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, RainWaterInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水雨情报信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<RainWaterInfo> memberList = rainWaterInfoService.exportList();
        ExportParams params = new ExportParams("水雨情报信息", "水雨情报信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, RainWaterInfo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水雨情报信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
