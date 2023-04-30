package com.example.dampouring.controller.daily;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.DailyMidWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyMidWaterService;
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

@RequestMapping("api/DailyMidWater")
@Controller
@Api(description = "一期通水温控情况")
public class DailyMidWaterController {
    @Autowired
    com.example.dampouring.service.DailyMidWaterService DailyMidWaterService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectDailyMidWater(@RequestBody DailyPourTempQue DailyMidWaterQue) {
        PageInfo pageInfo = DailyMidWaterService.orUserSelect(DailyMidWaterQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestBody DailyPourTempQue DailyMidWaterQue) {
        List<DailyMidWaterVO> memberList = DailyMidWaterService.exportListByQue(DailyMidWaterQue);
        ExportParams params = new ExportParams("中期通水温控情况", "中期通水温控情况", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, DailyMidWaterVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "中期通水温控情况");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
