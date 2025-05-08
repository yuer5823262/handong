package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddSmallStorageBinReq;
import com.example.dampouring.model.request.UpdateSmallStorageBinReq;
import com.example.dampouring.model.vo.StorageBinVO;
import com.example.dampouring.query.StorageBinQue;
import com.example.dampouring.service.SmallStorageBinService;
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

@RequestMapping("api/smallStorageBin")
@Controller
@Api(description = "仓位信息")
public class SmallStorageBinController {
    @Autowired
    SmallStorageBinService smallStorageBinService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSmallStorageBin(
            @RequestBody @Valid AddSmallStorageBinReq addSmallStorageBinReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        smallStorageBinService.add(addSmallStorageBinReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSmallStorageBin(
            @Valid @RequestBody UpdateSmallStorageBinReq updateSmallStorageBinReq) {
        smallStorageBinService.update(updateSmallStorageBinReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSmallStorageBin(@RequestParam("ids") Integer[] ids,HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer role =  JwtUtils.GetRole(token);
        if(role == null || role != 12) throw new DamPourException(60000,"非超级管理员不能删除");
        smallStorageBinService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = smallStorageBinService.userVoList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSmallStorageBinByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SmallStorageBin> smallStorageBinList = smallStorageBinService.listByIds(ids);
        return ApiRestResponse.success(smallStorageBinList);
    }

    @GetMapping("/selectBySbNo")
    @ResponseBody
    public ApiRestResponse selectSmallStorageBinByBigSbNo(String sbNo)
    {
        SmallStorageBin smallStorageBinList = smallStorageBinService.listBybNo(sbNo);
        return ApiRestResponse.success(smallStorageBinList);
    }

    @ApiOperation("有查询参数的分页列表")
    @PostMapping("/selectByQue")
    @ResponseBody
    public ApiRestResponse listStorageBinQue(@RequestBody StorageBinQue storageBinQue) {
        PageInfo pageInfo = smallStorageBinService.userVoListQue(storageBinQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SmallStorageBin> memberList = smallStorageBinService.exportList();
        ExportParams params = new ExportParams("仓位信息", "仓位信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SmallStorageBin.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "仓位数据表");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
