package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.ReduceTempAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/ReduceTempAlert")
@Controller
@Api(description = "降温速度预警")
public class ReduceTempAlertController {
    @Autowired
    ReduceTempAlertService ReduceTempAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectReduceTempAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = ReduceTempAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingReduceTempAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        ReduceTempAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
