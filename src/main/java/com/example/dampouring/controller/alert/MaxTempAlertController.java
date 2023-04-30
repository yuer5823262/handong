package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.MaxTempAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/MaxTempAlert")
@Controller
@Api(description = "最高温度预警表")
public class MaxTempAlertController {
    @Autowired
    MaxTempAlertService MaxTempAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMaxTempAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = MaxTempAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingMaxTempAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MaxTempAlertService.processing(ids,username,"2",0);
        return ApiRestResponse.success();
    }


}
