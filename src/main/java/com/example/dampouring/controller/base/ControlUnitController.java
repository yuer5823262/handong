package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddControlUnitReq;
import com.example.dampouring.model.request.UpdateControlUnitReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.model.vo.ControlUnitVO;
import com.example.dampouring.query.ControlUnitQue;
import com.example.dampouring.service.ControlUnitService;
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

@Api(description = "控制单元")
@RequestMapping("api/controlUnit")
@Controller
public class ControlUnitController {
    @Autowired
    ControlUnitService controlUnitService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addControlUnit(
            @RequestBody @Valid AddControlUnitReq addControlUnitReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        controlUnitService.add(addControlUnitReq,username);

//        int n = 10000;
//        for (int i = 20; i < 100; i++) {
//            AddControlUnitReq segmentReq = new AddControlUnitReq();
//            segmentReq.setCbNo(i);
//            segmentReq.setCuAddr(""+i);
//            segmentReq.setSmallSbNo(i);
//            segmentReq.setCuType("测控装置"+i);
//            segmentReq.setRemark(String.valueOf(n+i));
//            controlUnitService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateControlUnit(
            @Valid @RequestBody UpdateControlUnitReq updateControlUnitReq) {

        controlUnitService.update(updateControlUnitReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteControlUnit(@RequestParam("ids") Integer[] ids) {
        controlUnitService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("监控测控单元")
    @GetMapping("/ControlUnitState")
    @ResponseBody
    public ApiRestResponse controlUnitState(Integer kzxId)
    {
        List<ControlUnitVO> controlUnitList = controlUnitService.controlUnitState(kzxId);
        return ApiRestResponse.success(controlUnitList);
    }


    @ApiOperation("监控通水状态")
    @GetMapping("flowState")
    @ResponseBody
    public ApiRestResponse flowState(Integer sbId)
    {
        List<ControlUnitVO> controlUnitList = controlUnitService.flowState(sbId);
        return ApiRestResponse.success(controlUnitList);
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = controlUnitService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("有查询参数的分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse selectControlUnit(@RequestBody ControlUnitQue controlUnitQue) {
        PageInfo pageInfo = controlUnitService.select(controlUnitQue);
        return ApiRestResponse.success(pageInfo);
    }
    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectControlUnitByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<ControlUnitVO> controlUnitList = controlUnitService.listByIds(ids);
        return ApiRestResponse.success(controlUnitList);
    }
//    @GetMapping("/selectBySmallSbId")
//    @ResponseBody
//    public ApiRestResponse selectSmallStorageBinBySmallSbId(Integer[] sbIds)
//    {
//        List<ControlUnit> controlUnitList = controlUnitService.listBySmallSbId(sbIds);
//        return ApiRestResponse.success(controlUnitList);
//    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ControlUnitVO> memberList = controlUnitService.exportList();
        ExportParams params = new ExportParams("控制单元", "控制单元", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ControlUnitVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "控制单元");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
