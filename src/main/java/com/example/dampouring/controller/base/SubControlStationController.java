package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddSubControlStationReq;
import com.example.dampouring.model.request.UpdateSubControlStationReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.SubControlStationService;
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

@RequestMapping("api/subControlStation")
@Controller
@Api(description = "分控站")
public class SubControlStationController {
    @Autowired
    SubControlStationService subControlStationService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSubControlStation(
            @RequestBody @Valid AddSubControlStationReq addSubControlStationReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        subControlStationService.add(addSubControlStationReq,username);


//        for (int i = 2; i < 100; i++) {
//            AddSubControlStationReq adds = new AddSubControlStationReq();
//            adds.setRemark("adasd"+i);
//            adds.setScsNo("FKZ-"+i);
//            subControlStationService.add(adds,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSubControlStation(
            @Valid @RequestBody UpdateSubControlStationReq updateSubControlStationReq) {

        subControlStationService.update(updateSubControlStationReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSubControlStation(@RequestParam("ids") Integer[] ids) {
        subControlStationService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = subControlStationService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterRainStationQue waterRainStationQue) {
        PageInfo pageInfo = subControlStationService.selectByQue(waterRainStationQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSubControlStationByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SubControlStation> subControlStationList = subControlStationService.listByIds(ids);
        return ApiRestResponse.success(subControlStationList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<SubControlStation> memberList = subControlStationService.exportList();
        ExportParams params = new ExportParams("分控站", "分控站", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, SubControlStation.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "分控站");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
