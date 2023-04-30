package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddAirTempSensorReq;
import com.example.dampouring.model.request.UpdateAirTempSensorReq;
import com.example.dampouring.model.vo.AirTempSensorVO;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.AirTempSensorQue;
import com.example.dampouring.query.WaterReversingDeviceQue;
import com.example.dampouring.service.AirTempSensorService;
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
@Api(description = "气温传感器")
@RequestMapping("api/airTempSensor")
@Controller
public class AirTempSensorController {
    @Autowired
    AirTempSensorService AirTempSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addAirTempSensor(
            @RequestBody @Valid AddAirTempSensorReq addAirTempSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        AirTempSensorService.add(addAirTempSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddAirTempSensorReq segmentReq = new AddAirTempSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            AirTempSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateAirTempSensor(
            @Valid @RequestBody UpdateAirTempSensorReq updateAirTempSensorReq) {

        AirTempSensorService.update(updateAirTempSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteAirTempSensor(@RequestParam("ids") Integer[] ids) {
        AirTempSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        AirTempSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }


    @ApiOperation("列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse list(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = AirTempSensorService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

//    @ApiOperation("分页列表")
//    @PostMapping("/select")
//    @ResponseBody
//    public ApiRestResponse select(@RequestBody AirTempSensorQue airTempSensorQue) {
//        PageInfo pageInfo = AirTempSensorService.select(airTempSensorQue);
//        return ApiRestResponse.success(pageInfo);
//    }
    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectAirTempSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<AirTempSensorVO> AirTempSensorList = AirTempSensorService.listByIds(ids);
        return ApiRestResponse.success(AirTempSensorList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<AirTempSensorVO> memberList = AirTempSensorService.exportList();
        ExportParams params = new ExportParams("气温传感器", "气温传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, AirTempSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "气温传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
