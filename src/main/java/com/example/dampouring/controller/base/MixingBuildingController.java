package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.model.request.AddMixingBuildingReq;
import com.example.dampouring.model.request.UpdateMixingBuildingReq;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.model.vo.MixingSensorVO;
import com.example.dampouring.query.MixingBuildingQue;
import com.example.dampouring.service.MixingBuildingService;
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

@RequestMapping("api/MixingBuilding")
@Controller
@Api(description = "拌合楼")
public class MixingBuildingController {
    @Autowired
    MixingBuildingService MixingBuildingService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addMixingBuilding(
            @RequestBody @Valid AddMixingBuildingReq addMixingBuildingReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MixingBuildingService.add(addMixingBuildingReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddMixingBuildingReq segmentReq = new AddMixingBuildingReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            MixingBuildingService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateMixingBuilding(
            @Valid @RequestBody UpdateMixingBuildingReq updateMixingBuildingReq) {

        MixingBuildingService.update(updateMixingBuildingReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteMixingBuilding(@RequestParam("ids") Integer[] ids) {
        MixingBuildingService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<MixingBuilding> pageInfo = MixingBuildingService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody MixingBuildingQue mixingBuildingQue) {
        PageInfo pageInfo = MixingBuildingService.select(mixingBuildingQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectMixingBuildingByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<MixingBuilding> mixingBuildings = MixingBuildingService.listByIds(ids);
        return ApiRestResponse.success(mixingBuildings);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingBuilding> memberList = MixingBuildingService.orUserList();
        ExportParams params = new ExportParams("拌合楼", "拌合楼", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingBuilding.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "拌合楼");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
