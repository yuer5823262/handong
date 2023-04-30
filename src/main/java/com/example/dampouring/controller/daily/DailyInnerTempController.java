package com.example.dampouring.controller.daily;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.DailyInnerTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import com.example.dampouring.service.DailyInnerTempService;
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

@RequestMapping("api/DailyInnerTemp")
@Controller
@Api(description = "坝体内部温度情况")
public class DailyInnerTempController {
    @Autowired
    DailyInnerTempService DailyInnerTempService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectDailyInnerTemp(@RequestBody DailyPourTempQue DailyInnerTempQue) {
//        DailyInnerTempService.dailyInnerTemp();
        PageInfo pageInfo = DailyInnerTempService.orUserSelect(DailyInnerTempQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestBody DailyPourTempQue DailyInnerTempQue) {
        List<DailyInnerTempVO> memberList = DailyInnerTempService.exportListByQue(DailyInnerTempQue);
        ExportParams params = new ExportParams("坝体内部温度情况", "坝体内部温度情况", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, DailyInnerTempVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "坝体内部温度情况");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
