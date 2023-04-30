package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.FaceMicroClimate;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddFaceMicroClimateReq;
import com.example.dampouring.model.request.UpdateFaceMicroClimateReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.FaceMicroClimateService;
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
@Api(description = "仓面小气候")
@RequestMapping("api/faceMicroClimate")
@Controller
public class FaceMicroClimateController {
    @Autowired
    FaceMicroClimateService faceMicroClimateService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addFaceMicroClimate(
            @RequestBody @Valid AddFaceMicroClimateReq addFaceMicroClimateReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        faceMicroClimateService.add(addFaceMicroClimateReq,username);

//        int n = 10000;
//        for (int i = 1; i < 100; i++) {
//            AddFaceMicroClimateReq segmentReq = new AddFaceMicroClimateReq();
//            segmentReq.setDeviceAddr(""+1000+i);
//            segmentReq.setDeviceNo("XQH"+i);
//            segmentReq.setDeviceIp("192.168.18."+i);
//            faceMicroClimateService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateFaceMicroClimate(
            @Valid @RequestBody UpdateFaceMicroClimateReq updateFaceMicroClimateReq) {

        faceMicroClimateService.update(updateFaceMicroClimateReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteFaceMicroClimate(@RequestParam("ids") Integer[] ids) {
        faceMicroClimateService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = faceMicroClimateService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterRainStationQue waterRainStationQue) {
        PageInfo pageInfo = faceMicroClimateService.selectByQue(waterRainStationQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectFaceMicroClimateByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<FaceMicroClimate> faceMicroClimateList = faceMicroClimateService.listByIds(ids);
        return ApiRestResponse.success(faceMicroClimateList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<FaceMicroClimate> memberList = faceMicroClimateService.exportList();
        ExportParams params = new ExportParams("仓面小气候", "仓面小气候", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, FaceMicroClimate.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "仓面小气候");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
