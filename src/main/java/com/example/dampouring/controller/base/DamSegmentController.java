package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddDamSegmentReq;
import com.example.dampouring.model.request.UpdateDamSegmentReq;
import com.example.dampouring.model.vo.DamSegmentVO;
import com.example.dampouring.model.vo.PouringMonitorVO;
import com.example.dampouring.query.DamSegmentQue;
import com.example.dampouring.service.DamSegmentService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
@Api(description = "分段")
@RequestMapping("api/damSegment")
@Controller
public class DamSegmentController {
    @Autowired
    DamSegmentService damSegmentService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addDamSegment(
            @RequestBody @Valid AddDamSegmentReq addDamSegmentReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        damSegmentService.add(addDamSegmentReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateDamSegment(
            @Valid @RequestBody UpdateDamSegmentReq updateDamSegmentReq) {

        damSegmentService.update(updateDamSegmentReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteDamSegment(@RequestParam("ids") Integer[] ids) {
        damSegmentService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = damSegmentService.userVoList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectDamSegmentByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<DamSegment> DamSegmentList = damSegmentService.listByIds(ids);
        return ApiRestResponse.success(DamSegmentList);
    }

    @GetMapping("/selectByBsNo")
    @ResponseBody
    public ApiRestResponse selectDamSegmentByBsNoList(@RequestParam Integer value)
    {
        List<DamSegment> bigSegmentList = damSegmentService.listByBsNo(value);
        return ApiRestResponse.success(bigSegmentList);
    }
    @ApiOperation("浇筑进度监控")
    @GetMapping("/pouringMonitor")
    @ResponseBody
    public ApiRestResponse pouringMonitor()
    {
        List<PouringMonitorVO> pouringMonitorVOS = damSegmentService.pouringMonitor();
        return ApiRestResponse.success(pouringMonitorVOS);
    }

    @ApiOperation("有查询参数的分页列表")
    @PostMapping("/selectByQue")
    @ResponseBody
    public ApiRestResponse listDamSegementQue(@RequestBody DamSegmentQue damSegmentQue) {
        PageInfo pageInfo = damSegmentService.userVoListQue(damSegmentQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<DamSegmentVO> memberList = damSegmentService.exportList();
        ExportParams params = new ExportParams("分段", "分段", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, DamSegmentVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "分段");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
