package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.OutletTempAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/OutletTempAlert")
@Controller
@Api(description = "出机口温度预警")
public class OutletTempAlertController {
    @Autowired
    OutletTempAlertService OutletTempAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectOutletTempAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = OutletTempAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingOutletTempAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        OutletTempAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
