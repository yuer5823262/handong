package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.pojo.WaterReversingDevice;
import com.example.dampouring.model.request.AddWaterReversingDeviceReq;
import com.example.dampouring.model.request.UpdateWaterReversingDeviceReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.WaterReversingDeviceQue;
import com.example.dampouring.service.WaterReversingDeviceService;
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

@RequestMapping("api/waterReversingDevice")
@Controller
@Api(description = "通水换向装置")
public class WaterReversingDeviceController {
    @Autowired
    WaterReversingDeviceService waterReversingDeviceService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterReversingDevice(
            @RequestBody @Valid AddWaterReversingDeviceReq addWaterReversingDeviceReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        waterReversingDeviceService.add(addWaterReversingDeviceReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateWaterReversingDevice(
            @Valid @RequestBody UpdateWaterReversingDeviceReq updateWaterReversingDeviceReq) {

        waterReversingDeviceService.update(updateWaterReversingDeviceReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteWaterReversingDevice(@RequestParam("ids") Integer[] ids) {
        waterReversingDeviceService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = waterReversingDeviceService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterReversingDeviceQue waterReversingDeviceQue) {
        PageInfo pageInfo = waterReversingDeviceService.select(waterReversingDeviceQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectWaterReversingDeviceByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<WaterReversingDeviceVO> WaterReversingDeviceList = waterReversingDeviceService.listByIds(ids);
        return ApiRestResponse.success(WaterReversingDeviceList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterReversingDeviceVO> memberList = waterReversingDeviceService.exportList();
        ExportParams params = new ExportParams("通水换向装置", "通水换向装置", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterReversingDeviceVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "通水换向装置");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
