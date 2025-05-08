package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;

import com.example.dampouring.model.request.AddInnerTempSensorReq;

import com.example.dampouring.model.request.UpdateInnerTempSensorReq;

import com.example.dampouring.model.vo.InnerTempSensorVO;

import com.example.dampouring.query.InnerTempSensorQue;
import com.example.dampouring.service.FaceTempSensorService;
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

@RequestMapping("api/FaceTempSensor")
@Controller
@Api(description = "表面温度传感器")
public class FaceTempSensorController {
    @Autowired
    FaceTempSensorService FaceTempSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addFaceTempSensor(
            @RequestBody @Valid AddInnerTempSensorReq addFaceTempSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        FaceTempSensorService.add(addFaceTempSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddFaceTempSensorReq segmentReq = new AddFaceTempSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            FaceTempSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateFaceTempSensor(
            @Valid @RequestBody UpdateInnerTempSensorReq updateFaceTempSensorReq) {
        FaceTempSensorService.update(updateFaceTempSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteFaceTempSensor(@RequestParam("ids") Integer[] ids) {
        FaceTempSensorService.delete(ids);
        return ApiRestResponse.success();
    }
    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody InnerTempSensorQue FaceTempSensorQue) {
        PageInfo pageInfo = FaceTempSensorService.orUserList(FaceTempSensorQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        FaceTempSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectFaceTempSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<InnerTempSensorVO> FaceTempSensorList = FaceTempSensorService.listByIds(ids);
        return ApiRestResponse.success(FaceTempSensorList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InnerTempSensorVO> memberList = FaceTempSensorService.exportList();
        ExportParams params = new ExportParams("表面温度传感器", "表面温度传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InnerTempSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "表面温度传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
