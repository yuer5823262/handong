package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.SmartHeat3dayService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/SmartHeat3day")
@Controller
@Api(description = "智能保温预警3天")
public class SmartHeat3dayController {
    @Autowired
    SmartHeat3dayService SmartHeat3dayService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSmartHeat3day(@RequestBody AlertQue AlertQue, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        PageInfo pageInfo = SmartHeat3dayService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }
}
