package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.ControlBox;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddControlBoxReq;
import com.example.dampouring.model.request.UpdateControlBoxReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.ControlBoxService;
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
@Api(description = "控制箱")
@RequestMapping("api/controlBox")
@Controller
public class ControlBoxController {
    @Autowired
    ControlBoxService controlBoxService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addControlBox(
            @RequestBody @Valid AddControlBoxReq addControlBoxReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        controlBoxService.add(addControlBoxReq,username);

//        for (int i = 2; i < 100; i++) {
//            AddControlBoxReq adds = new AddControlBoxReq();
//            adds.setRemark("test"+i);
//            adds.setCbNo("FZX-"+i);
//            adds.setScsId(2);
//            controlBoxService.add(adds,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateControlBox(
            @Valid @RequestBody UpdateControlBoxReq updateControlBoxReq) {

        controlBoxService.update(updateControlBoxReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteControlBox(@RequestParam("ids") Integer[] ids) {
        controlBoxService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = controlBoxService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("分页列表")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestBody WaterRainStationQue waterRainStationQue) {
        PageInfo pageInfo = controlBoxService.selectByQue(waterRainStationQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectControlBoxByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<ControlBoxVO> ControlBoxList = controlBoxService.listByIds(ids);
        return ApiRestResponse.success(ControlBoxList);
    }
    @GetMapping("/selectByScsId")
    @ResponseBody
    public ApiRestResponse selectSmallStorageBinBySbNo(Integer scsId)
    {
        List<ControlBox> smallStorageBinList = controlBoxService.listByScsId(scsId);
        return ApiRestResponse.success(smallStorageBinList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ControlBoxVO> memberList = controlBoxService.exportList();
        ExportParams params = new ExportParams("控制箱", "控制箱", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, ControlBoxVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "控制箱");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
