package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.EquipmentAlertQue;
import com.example.dampouring.service.EquipmentAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/EquipmentAlert")
@Controller
@Api(description = "设备预警")
public class EquipmentAlertController {
    @Autowired
    EquipmentAlertService EquipmentAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectEquipmentAlert(@RequestBody EquipmentAlertQue AlertQue) {
        PageInfo pageInfo = EquipmentAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingEquipmentAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        EquipmentAlertService.processing(ids,username,"1",0);
        return ApiRestResponse.success();
    }
}
