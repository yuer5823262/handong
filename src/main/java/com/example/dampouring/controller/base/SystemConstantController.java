package com.example.dampouring.controller.base;

import com.example.dampouring.StaticScheduleTask.SaticScheduleTask;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.pojo.SystemConstant;
import com.example.dampouring.model.pojo.TempMap;
import com.example.dampouring.model.request.UpdateAirTempSensorReq;
import com.example.dampouring.service.SystemConstantService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.Date;
import java.util.List;

@RequestMapping("api/SystemConstant")
@Controller
@Api(description = "系统常量设置")
public class SystemConstantController {
    @Autowired
    SystemConstantService SystemConstantService;
    @Autowired
    SaticScheduleTask saticScheduleTask;
    @GetMapping("/update")
    @ResponseBody
    public ApiRestResponse update(
            @RequestParam Integer id, @RequestParam String val) {
        SystemConstantService.update(id,val);
        return ApiRestResponse.success();
    }
    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse list() {
        List<SystemConstant> pageInfo = SystemConstantService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/openPort")
    @ResponseBody
    public ApiRestResponse openPort() {
        Constant.openPort();
        saticScheduleTask.getControlUnitValue();
        return ApiRestResponse.success();
    }
    @GetMapping("/closePort")
    @ResponseBody
    public ApiRestResponse closePort() {
        Constant.closePort();
        return ApiRestResponse.success();
    }
    @GetMapping("/getPortSta")
    @ResponseBody
    public ApiRestResponse getPortSta() {
        return ApiRestResponse.success(Constant.pSta);
    }
    @ApiOperation("获取系统名称")
    @GetMapping("/getSystemName")
    @ResponseBody
    public ApiRestResponse getSystemName() {
        String systemName = SystemConstantService.getSystemName();
        return ApiRestResponse.success(systemName);
    }

    @ApiOperation("获取背景图链接")
    @GetMapping("/getSystemBgUrl")
    @ResponseBody
    public ApiRestResponse getSystemBgUrl() {
        SystemConstant systemConstant = SystemConstantService.selectByType("背景图链接");
        String BgUrl = systemConstant.getVal();;
        return ApiRestResponse.success(BgUrl);
    }

    @ApiOperation("上传系统背景图")
    @PostMapping( "/uploadTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse uploadTempMap(@RequestPart("file") MultipartFile upload){
        String newFilePath = Constant.IMAGE_STATIC_BG+ new Date().getTime() +".png";
        SystemConstant systemConstant = SystemConstantService.selectByType("背景图链接");

        try {
            upload.transferTo(new File(System.getProperty("user.dir")+newFilePath));//将传来的文件写入新建的文件
            SystemConstantService.update(systemConstant.getId(),newFilePath);
            return ApiRestResponse.success();
        }catch(Exception e1){
            e1.printStackTrace();
            throw new DamPourException(30000,"上传失败");
        }
    }
}
