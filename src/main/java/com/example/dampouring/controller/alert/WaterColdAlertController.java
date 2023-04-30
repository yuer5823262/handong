package com.example.dampouring.controller.alert;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.WaterColdAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/WaterColdAlert")
@Controller
@Api(description = "通水水温预警")
public class WaterColdAlertController {
    @Autowired
    WaterColdAlertService WaterColdAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectWaterColdAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = WaterColdAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingWaterColdAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        WaterColdAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
