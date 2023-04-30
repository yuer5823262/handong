package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddWaterPressureSensorReq;
import com.example.dampouring.model.request.UpdateWaterPressureSensorReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.model.vo.WaterPressureSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.example.dampouring.query.WaterReversingDeviceQue;
import com.example.dampouring.service.WaterPressureSensorService;
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


@RequestMapping("api/waterPressureSensor")
@Controller
@Api(description = "水压传感器表")
public class WaterPressureSensorController {
    @Autowired
    WaterPressureSensorService waterPressureSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterPressureSensor(
            @RequestBody @Valid AddWaterPressureSensorReq addWaterPressureSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        waterPressureSensorService.add(addWaterPressureSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddWaterPressureSensorReq segmentReq = new AddWaterPressureSensorReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            WaterPressureSensorService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateWaterPressureSensor(
            @Valid @RequestBody UpdateWaterPressureSensorReq updateWaterPressureSensorReq) {

        waterPressureSensorService.update(updateWaterPressureSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteWaterPressureSensor(@RequestParam("ids") Integer[] ids) {
        waterPressureSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = waterPressureSensorService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("分页列表Que")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterPressureSensorQue waterReversingDeviceQue) {
        PageInfo pageInfo = waterPressureSensorService.select(waterReversingDeviceQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectWaterPressureSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<WaterPressureSensorVO> waterPressureSensorList = waterPressureSensorService.listByIds(ids);
        return ApiRestResponse.success(waterPressureSensorList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterPressureSensorVO> memberList = waterPressureSensorService.exportList();
        ExportParams params = new ExportParams("水压传感器表", "水压传感器表", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPressureSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水压传感器表");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
