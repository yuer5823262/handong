package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.PouringTempAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/PouringTempAlert")
@Controller
@Api(description = "浇筑温度预警表")
public class PouringTempAlertController {
    @Autowired
    PouringTempAlertService PouringTempAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectPouringTempAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = PouringTempAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingPouringTempAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        PouringTempAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }

}
