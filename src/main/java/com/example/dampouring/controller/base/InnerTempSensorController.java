package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddInnerTempSensorReq;
import com.example.dampouring.model.request.RemoteDev;
import com.example.dampouring.model.request.UpdateInnerTempSensorReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.model.vo.InnerTempSensorVO;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.InnerTempSensorQue;
import com.example.dampouring.service.InnerTempSensorService;
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

@RequestMapping("api/innerTempSensor")
@Controller
@Api(description = "内部温度传感器")
public class InnerTempSensorController {
    @Autowired
    InnerTempSensorService innerTempSensorService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addInnerTempSensor(
            @RequestBody @Valid AddInnerTempSensorReq addInnerTempSensorReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        innerTempSensorService.add(addInnerTempSensorReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddInnerTempSensorReq segmentReq = new AddInnerTempSensorReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            innerTempSensorService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateInnerTempSensor(
            @Valid @RequestBody UpdateInnerTempSensorReq updateInnerTempSensorReq) {
        innerTempSensorService.update(updateInnerTempSensorReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteInnerTempSensor(@RequestParam("ids") Integer[] ids) {
        innerTempSensorService.delete(ids);
        return ApiRestResponse.success();
    }
    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody InnerTempSensorQue innerTempSensorQue) {
        PageInfo pageInfo = innerTempSensorService.orUserList(innerTempSensorQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("更新所有传感器通道")
    @GetMapping("/updateChannelAll")
    @ResponseBody
    public ApiRestResponse updateChannelAll() {
        innerTempSensorService.updateChannelAll();
        return ApiRestResponse.success();
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectInnerTempSensorByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<InnerTempSensorVO> InnerTempSensorList = innerTempSensorService.listByIds(ids);
        return ApiRestResponse.success(InnerTempSensorList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InnerTempSensorVO> memberList = innerTempSensorService.exportList();
        ExportParams params = new ExportParams("内部温度传感器", "内部温度传感器", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InnerTempSensorVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "内部温度传感器");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
