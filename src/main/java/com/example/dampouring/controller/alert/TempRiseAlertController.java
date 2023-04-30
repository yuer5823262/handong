package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.TempRiseAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/TempRiseAlert")
@Controller
@Api(description = "温度回升预警")
public class TempRiseAlertController {
    @Autowired
    TempRiseAlertService TempRiseAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectTempRiseAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = TempRiseAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingTempRiseAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempRiseAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
