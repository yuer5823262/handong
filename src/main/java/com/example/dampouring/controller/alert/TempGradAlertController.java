package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.TempGradAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/TempGradAlert")
@Controller
@Api(description = "温度梯度预警")
public class TempGradAlertController {
    @Autowired
    TempGradAlertService TempGradAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectTempGradAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = TempGradAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingTempGradAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempGradAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
