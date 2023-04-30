package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddMixingSensorReq;
import com.example.dampouring.model.request.UpdateMixingSensorReq;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.model.vo.MixingSensorVO;
import com.example.dampouring.query.MixingSensorInfoQue;
import com.example.dampouring.service.MixingSensorService;
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

@RequestMapping("api/MixingSensor")
@Controller
@Api(description = "智能拌合传感器")
public class MixingSensorController {
    @Autowired
    MixingSensorService MixingSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addMixingSensor(
            @RequestBody @Valid AddMixingSensorReq addMixingSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MixingSensorService.add(addMixingSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddMixingSensorReq segmentReq = new AddMixingSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            MixingSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }

    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        MixingSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateMixingSensor(
            @Valid @RequestBody UpdateMixingSensorReq updateMixingSensorReq) {

        MixingSensorService.update(updateMixingSensorReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteMixingSensor(@RequestParam("ids") Integer[] ids) {
        MixingSensorService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody MixingSensorInfoQue MixingSensorInfoQue) {
        PageInfo pageInfo = MixingSensorService.orUserList(MixingSensorInfoQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectMixingSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<MixingSensorVO> MixingSensorList = MixingSensorService.listByIds(ids);
        return ApiRestResponse.success(MixingSensorList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MixingSensorVO> memberList = MixingSensorService.exportList();
        ExportParams params = new ExportParams("智能拌合传感器", "智能拌合传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MixingSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "智能拌合传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
