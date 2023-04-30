package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.WaterRainStation;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddWaterRainStationReq;
import com.example.dampouring.model.request.UpdateWaterRainStationReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.WaterRainStationService;
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

@RequestMapping("api/waterRainStation")
@Controller
@Api(description = "水雨情测站")
public class WaterRainStationController {
    @Autowired
    WaterRainStationService waterRainStationService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterRainStation(
            @RequestBody @Valid AddWaterRainStationReq addWaterRainStationReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        waterRainStationService.add(addWaterRainStationReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddWaterRainStationReq segmentReq = new AddWaterRainStationReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            WaterRainStationService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateWaterRainStation(
            @Valid @RequestBody UpdateWaterRainStationReq updateWaterRainStationReq) {

        waterRainStationService.update(updateWaterRainStationReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteWaterRainStation(@RequestParam("ids") Integer[] ids) {
        waterRainStationService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = waterRainStationService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterRainStationQue waterRainStationQue) {
        PageInfo pageInfo = waterRainStationService.selectByQue(waterRainStationQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectWaterRainStationByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<WaterRainStation> waterRainStationList = waterRainStationService.listByIds(ids);
        return ApiRestResponse.success(waterRainStationList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterRainStation> memberList = waterRainStationService.exportList();
        ExportParams params = new ExportParams("水雨情测站", "水雨情测站", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterRainStation.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水雨情测站");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
