package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddMixingEgSensorReq;
import com.example.dampouring.model.request.UpdateMixingEgSensorReq;
import com.example.dampouring.model.vo.MixingEgSensorVO;
import com.example.dampouring.query.MixingEgSensorQue;
import com.example.dampouring.service.MixingEgSensorService;
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

@RequestMapping("api/MixingEgSensor")
@Controller
@Api(description = "出机口和骨料设备")
public class MixingEgSensorController {
    @Autowired
    MixingEgSensorService MixingEgSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addMixingEgSensor(
            @RequestBody @Valid AddMixingEgSensorReq addMixingEgSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MixingEgSensorService.add(addMixingEgSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddMixingEgSensorReq segmentReq = new AddMixingEgSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            MixingEgSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateMixingEgSensor(
            @Valid @RequestBody UpdateMixingEgSensorReq updateMixingEgSensorReq) {

        MixingEgSensorService.update(updateMixingEgSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteMixingEgSensor(@RequestParam("ids") Integer[] ids) {
        MixingEgSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody MixingEgSensorQue MixingEgSensorInfoQue) {
        PageInfo pageInfo = MixingEgSensorService.orUserList(MixingEgSensorInfoQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectMixingEgSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<MixingEgSensorVO> MixingEgSensorList = MixingEgSensorService.listByIds(ids);
        return ApiRestResponse.success(MixingEgSensorList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingEgSensorVO> memberList = MixingEgSensorService.exportList();
        ExportParams params = new ExportParams("出机口和骨料设备", "出机口和骨料设备", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingEgSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "出机口和骨料设备");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
