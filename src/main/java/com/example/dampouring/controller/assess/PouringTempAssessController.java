package com.example.dampouring.controller.assess;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.model.vo.PouringTempAssessVO;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.service.PouringTempAssessService;
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

@RequestMapping("api/PouringTempAssess")
@Controller
@Api(description = "浇筑温度评价")
public class PouringTempAssessController {
    @Autowired
    PouringTempAssessService PouringTempAssessService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listPouringTempAssess(@RequestParam Integer pageNum,
                                                 @RequestParam Integer pageSize) {
        PageInfo pageInfo = PouringTempAssessService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectPouringTempAssess(@RequestBody PouringTempAssessQue PouringTempAssessQue) {
        PageInfo pageInfo = PouringTempAssessService.orUserSelect(PouringTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<PouringTempAssessVO> memberList = PouringTempAssessService.exportList();
        ExportParams params = new ExportParams("浇筑温度评价", "浇筑温度评价", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, PouringTempAssessVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "浇筑温度评价");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
