package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddInsulationSensorReq;
import com.example.dampouring.model.request.UpdateInsulationSensorReq;
import com.example.dampouring.model.vo.InsulationSensorVO;
import com.example.dampouring.query.InsulationSensorQue;
import com.example.dampouring.service.InsulationSensorService;
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
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/InsulationSensor")
@Controller
@Api(description = "保温温度传感器")
public class InsulationSensorController {
    @Autowired
    InsulationSensorService InsulationSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addInsulationSensor(
            @RequestBody @Valid AddInsulationSensorReq addInsulationSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        InsulationSensorService.add(addInsulationSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddInsulationSensorReq segmentReq = new AddInsulationSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            InsulationSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateInsulationSensor(
            @Valid @RequestBody UpdateInsulationSensorReq updateInsulationSensorReq) {
        InsulationSensorService.update(updateInsulationSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteInsulationSensor(@RequestParam("ids") Integer[] ids) {
        InsulationSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody InsulationSensorQue InsulationSensorQue) {
        PageInfo pageInfo = InsulationSensorService.orUserList(InsulationSensorQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        InsulationSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectInsulationSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<InsulationSensorVO> InsulationSensorList = InsulationSensorService.listByIds(ids);
        return ApiRestResponse.success(InsulationSensorList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InsulationSensorVO> memberList = InsulationSensorService.exportList();
        ExportParams params = new ExportParams("保温传感器", "保温传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InsulationSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "保温传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
