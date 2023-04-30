package com.example.dampouring.controller.smart_warehouse;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.SmartWarehouseWarningQue;
import com.example.dampouring.service.SmartWarehouseWarningService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/SmartWarehouseWarning")
@Controller
@Api(description = "智能仓面预警")
public class SmartWarehouseWarningController {
    @Autowired
    SmartWarehouseWarningService SmartWarehouseWarningService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSmartWarehouseWarning(@RequestBody SmartWarehouseWarningQue SmartWarehouseWarningQue) {
        PageInfo pageInfo = SmartWarehouseWarningService.orUserSelect(SmartWarehouseWarningQue);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingSmartWarehouseWarning(Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SmartWarehouseWarningService.processing(ids,username);
        return ApiRestResponse.success();
    }
}
