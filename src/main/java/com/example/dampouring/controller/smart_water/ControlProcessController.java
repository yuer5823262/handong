package com.example.dampouring.controller.smart_water;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.model.vo.AirTempSensorVO;
import com.example.dampouring.query.ControlProcessQue;
import com.example.dampouring.service.ControlProcessService;
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

@Api(description = "调控过程监控")
@RequestMapping("api/ControlProcess")
@Controller
public class ControlProcessController {
    @Autowired
    ControlProcessService ControlProcessService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectControlProcess(@RequestBody ControlProcessQue ControlProcessQue) {
        PageInfo pageInfo = ControlProcessService.orUserSelect(ControlProcessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody ControlProcessQue ControlProcessQue) {
        List<ControlProcess> memberList = ControlProcessService.exportListByQue(ControlProcessQue);
        ExportParams params = new ExportParams("调控过程监控", "调控过程监控", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ControlProcess.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "调控过程监控");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ControlProcess> memberList = ControlProcessService.exportList();
        ExportParams params = new ExportParams("调控过程监控", "调控过程监控", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ControlProcess.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "调控过程监控");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
