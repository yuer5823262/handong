package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.model.vo.PouringTempMonitorVO;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.query.PouringTempInfoQue;
import com.example.dampouring.service.PouringTempInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/PouringTempInfo")
@Controller
@Api(description = "浇筑温度信息")
public class PouringTempInfoController {
    @Autowired
    PouringTempInfoService pouringTempInfoService;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listPouringTempInfo(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize) {
        PageInfo pageInfo = pouringTempInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectPouringTempInfo(@RequestBody PouringTempInfoQue PouringTempInfoQue) {
        PageInfo pageInfo = pouringTempInfoService.orUserSelect(PouringTempInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                      @RequestBody PouringTempInfoQue PouringTempInfoQue) {
        List<PouringTempInfoVO> memberList = pouringTempInfoService.exportListByQue(PouringTempInfoQue);
        ExportParams params = new ExportParams("浇筑温度信息", "浇筑温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, PouringTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "浇筑温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "浇筑温度监控")
    @PostMapping("/tempMonitor")
    @ResponseBody
    public ApiRestResponse tempMonitor() {
        List<PouringTempMonitorVO> pouringTempMonitorVOS = pouringTempInfoService.tempMonitor();
        return ApiRestResponse.success(pouringTempMonitorVOS);
    }


    @PostMapping("/assess")
    @ResponseBody
    public ApiRestResponse listSelectPouringTempAssess(@RequestBody PouringTempAssessQue PouringTempAssessQue) {
        PageInfo pageInfo = pouringTempInfoService.assess(PouringTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

//    @ApiOperation("浇筑温度")
//    @GetMapping("/pouringMonitor")
//    @ResponseBody
//    public ApiRestResponse pouringMonitor()
//    {
//        List<PouringMonitorVO> pouringMonitorVOS = damSegmentService.pouringMonitor();
//        return ApiRestResponse.success(pouringMonitorVOS);
//    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<PouringTempInfoVO> memberList = pouringTempInfoService.exportList();
        ExportParams params = new ExportParams("浇筑温度信息", "浇筑温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, PouringTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "浇筑温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        List<PouringTempInfoVO> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("浇筑温度信息", "浇筑温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, PouringTempInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "浇筑温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation("从Excel导入")
    @PostMapping("/importMemberList")
    @ResponseBody
    public ApiRestResponse importMemberList(@RequestPart("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        try {
            List<PouringTempInfoVO> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    PouringTempInfoVO.class, params);
            list.forEach(t->t.setBl(1));
            pouringTempInfoService.addAll(list);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }
}
