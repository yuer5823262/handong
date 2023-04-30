package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.model.pojo.SolarRadioMeter;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddSolarRadioMeterReq;
import com.example.dampouring.model.request.UpdateSolarRadioMeterReq;
import com.example.dampouring.service.SolarRadioMeterService;
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

@RequestMapping("api/solarRadioMeter")
@Controller
@Api(description = "太阳辐射仪")
public class SolarRadioMeterController {
    @Autowired
    SolarRadioMeterService solarRadioMeterService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSolarRadioMeter(
            @RequestBody @Valid AddSolarRadioMeterReq addSolarRadioMeterReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        solarRadioMeterService.add(addSolarRadioMeterReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddSolarRadioMeterReq segmentReq = new AddSolarRadioMeterReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            SolarRadioMeterService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSolarRadioMeter(
            @Valid @RequestBody UpdateSolarRadioMeterReq updateSolarRadioMeterReq) {

        solarRadioMeterService.update(updateSolarRadioMeterReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSolarRadioMeter(@RequestParam("ids") Integer[] ids) {
        solarRadioMeterService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = solarRadioMeterService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSolarRadioMeterByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SolarRadioMeter> solarRadioMeterList = solarRadioMeterService.listByIds(ids);
        return ApiRestResponse.success(solarRadioMeterList);
    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SolarRadioMeter> memberList = solarRadioMeterService.exportList();
        ExportParams params = new ExportParams("太阳辐射仪", "太阳辐射仪", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SolarRadioMeter.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "太阳辐射仪");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
