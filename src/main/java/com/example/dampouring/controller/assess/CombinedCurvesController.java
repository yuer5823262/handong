package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.CombinedCurvesVO;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.CombinedCurvesQue;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.service.CombinedCurvesService;
import com.example.dampouring.service.InboundTempAssessService;
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

@RequestMapping("api/CombinedCurves")
@Controller
@Api(description = "综合曲线图")
public class CombinedCurvesController {
    @Autowired
    CombinedCurvesService combinedCurvesService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectCombinedCurves(@RequestBody CombinedCurvesQue combinedCurvesQue) {
        PageInfo pageInfo = combinedCurvesService.orUserSelect(combinedCurvesQue);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam Integer sbId) {
        CombinedCurvesQue combinedCurvesQue = new CombinedCurvesQue();
        combinedCurvesQue.setSbId(sbId);
        List<CombinedCurvesVO> memberList = combinedCurvesService.exportList(combinedCurvesQue);
        ExportParams params = new ExportParams("综合曲线图", "综合曲线图", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, CombinedCurvesVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "综合曲线图");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
