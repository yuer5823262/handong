package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.HeatPreservation;
import com.example.dampouring.model.pojo.MaterialsTempInfo;
import com.example.dampouring.model.request.AddHeatPreservationReq;
import com.example.dampouring.model.request.UpdateHeatPreservationReq;
import com.example.dampouring.model.vo.HeatPreservationVO;
import com.example.dampouring.query.HeatPreservationQue;
import com.example.dampouring.service.HeatPreservationService;
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
@Api(description = "保温信息表")
@RequestMapping("api/heatPreservation")
@Controller
public class HeatPreservationController {
    @Autowired
    HeatPreservationService heatPreservationService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addHeatPreservation(
            @RequestBody @Valid AddHeatPreservationReq addHeatPreservationReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        heatPreservationService.add(addHeatPreservationReq,username);

//        int n = 10000;
//        for (int i = 20; i < 100; i++) {
//            AddHeatPreservationReq segmentReq = new AddHeatPreservationReq();
//            segmentReq.setCbNo(i);
//            segmentReq.setCuAddr(""+i);
//            segmentReq.setSmallSbNo(i);
//            segmentReq.setCuType("测控装置"+i);
//            segmentReq.setRemark(String.valueOf(n+i));
//            HeatPreservationService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateHeatPreservation(
            @Valid @RequestBody UpdateHeatPreservationReq updateHeatPreservationReq) {

        heatPreservationService.update(updateHeatPreservationReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteHeatPreservation(@RequestParam("ids") Integer[] ids) {
        heatPreservationService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = heatPreservationService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectHeatPreservationByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<HeatPreservationVO> HeatPreservationList = heatPreservationService.listByIds(ids);
        return ApiRestResponse.success(HeatPreservationList);
    }

    @PostMapping("/selectByQuery")
    @ResponseBody
    public ApiRestResponse selectHeatPreservationByQuery(
            @Valid @RequestBody HeatPreservationQue heatPreservationQue) {

        PageInfo heatPreservationVOS= heatPreservationService.selectByQue(heatPreservationQue);
        return ApiRestResponse.success(heatPreservationVOS);

    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<HeatPreservationVO> memberList = heatPreservationService.exportList();
        ExportParams params = new ExportParams("保温信息表", "保温信息表", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, HeatPreservationVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "保温信息表");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
//    @GetMapping("/selectBySmallSbId")
//    @ResponseBody
//    public ApiRestResponse selectSmallStorageBinBySmallSbId(Integer smallSbNo)
//    {
//        List<HeatPreservation> HeatPreservationList = heatPreservationService.listBySmallSbId(smallSbNo);
//        return ApiRestResponse.success(HeatPreservationList);
//    }
}
