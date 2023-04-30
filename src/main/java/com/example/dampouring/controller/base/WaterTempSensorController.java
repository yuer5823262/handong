package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddWaterTempSensorReq;
import com.example.dampouring.model.request.UpdateWaterTempSensorReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.model.vo.WaterTempSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.example.dampouring.service.WaterTempSensorService;
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

@RequestMapping("api/waterTempSensor")
@Controller
@Api(description = "水温传感器")
public class WaterTempSensorController {
    @Autowired
    WaterTempSensorService waterTempSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterTempSensor(
            @RequestBody @Valid AddWaterTempSensorReq addWaterTempSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        waterTempSensorService.add(addWaterTempSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddWaterTempSensorReq segmentReq = new AddWaterTempSensorReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            WaterTempSensorService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }

    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        waterTempSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateWaterTempSensor(
            @Valid @RequestBody UpdateWaterTempSensorReq updateWaterTempSensorReq) {

        waterTempSensorService.update(updateWaterTempSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteWaterTempSensor(@RequestParam("ids") Integer[] ids) {
        waterTempSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = waterTempSensorService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("分页列表Que")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterPressureSensorQue waterReversingDeviceQue) {
        PageInfo pageInfo = waterTempSensorService.select(waterReversingDeviceQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectWaterTempSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<WaterTempSensorVO> WaterTempSensorList = waterTempSensorService.listByIds(ids);
        return ApiRestResponse.success(WaterTempSensorList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterTempSensorVO> memberList = waterTempSensorService.exportList();
        ExportParams params = new ExportParams("水温传感器", "水温传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterTempSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水温传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
