package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.InWarehouseTempAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/InWarehouseTempAlert")
@Controller
@Api(description = "入仓温度预警")
public class InWarehouseTempAlertController {
    @Autowired
    InWarehouseTempAlertService InWarehouseTempAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectInWarehouseTempAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = InWarehouseTempAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingInWarehouseTempAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        InWarehouseTempAlertService.processing(ids,username,"2",0);
        return ApiRestResponse.success();
    }
}
