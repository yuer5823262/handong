package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.SolarRadioMeter;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddTempGradometerReq;
import com.example.dampouring.model.request.UpdateTempGradometerReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.query.TempGradometerQue;
import com.example.dampouring.service.TempGradometerService;
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
@RequestMapping("api/tempGradometer")
@Controller
@Api(description = "温度梯度仪")
public class TempGradometerController {
    @Autowired
    TempGradometerService tempGradometerService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempGradometer(
            @RequestBody @Valid AddTempGradometerReq addTempGradometerReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        tempGradometerService.add(addTempGradometerReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddTempGradometerReq segmentReq = new AddTempGradometerReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            TempGradometerService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempGradometer(
            @Valid @RequestBody UpdateTempGradometerReq updateTempGradometerReq) {

        tempGradometerService.update(updateTempGradometerReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempGradometer(@RequestParam("ids") Integer[] ids) {
        tempGradometerService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody TempGradometerQue tempGradometerQue) {
        PageInfo pageInfo = tempGradometerService.orUserList(tempGradometerQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempGradometerByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempGradometerVO> tempGradometerList = tempGradometerService.listByIds(ids);
        return ApiRestResponse.success(tempGradometerList);
    }
    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        tempGradometerService.updateChannelAll();
        return ApiRestResponse.success();
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<TempGradometerVO> memberList = tempGradometerService.exportList();
        ExportParams params = new ExportParams("温度梯度仪", "温度梯度仪", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, TempGradometerVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "温度梯度仪");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
