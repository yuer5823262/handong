package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.DataMissAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/DataMissAlert")
@Controller
@Api(description = "监测数据缺失预警")
public class DataMissAlertController {
    @Autowired
    DataMissAlertService DataMissAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectDataMissAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = DataMissAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingDataMissAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        DataMissAlertService.processing(ids,username,"1",0);
        return ApiRestResponse.success();
    }
}
