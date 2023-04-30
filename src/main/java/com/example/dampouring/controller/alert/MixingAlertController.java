package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.MixingAlertQue;
import com.example.dampouring.service.MixingAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/MixingAlert")
@Controller
@Api(description = "拌合预警")
public class MixingAlertController {
    @Autowired
    MixingAlertService MixingAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectMixingAlert(@RequestBody MixingAlertQue AlertQue) {
        PageInfo pageInfo = MixingAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingMixingAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MixingAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
