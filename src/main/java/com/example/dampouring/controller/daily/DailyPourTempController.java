package com.example.dampouring.controller.daily;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.DailyPourTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyPourTempService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RequestMapping("api/DailyPourTemp")
@Controller
@Api(description = "正在浇筑分段温控情况及评价")
public class DailyPourTempController {
    @Autowired
    DailyPourTempService dailyPourTempService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectDailyPourTemp(@RequestBody DailyPourTempQue DailyPourTempQue) {
        PageInfo pageInfo = dailyPourTempService.orUserSelect(DailyPourTempQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestBody DailyPourTempQue DailyPourTempQue) {
        List<DailyPourTempVO> memberList = dailyPourTempService.exportListByQue(DailyPourTempQue);
        ExportParams params = new ExportParams("正在浇筑分段温控情况及评价", "正在浇筑分段温控情况及评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, DailyPourTempVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "正在浇筑分段温控情况及评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
