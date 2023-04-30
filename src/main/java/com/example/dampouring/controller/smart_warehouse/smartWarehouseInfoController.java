package com.example.dampouring.controller.smart_warehouse;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.SmartWarehouseInfoQue;
import com.example.dampouring.service.smartWarehouseInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("api/smartWarehouseInfo")
@Controller
@Api(description = "智能仓面信息")
public class smartWarehouseInfoController {
    @Autowired
    smartWarehouseInfoService smartWarehouseInfoService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectsmartWarehouseInfo(@RequestBody SmartWarehouseInfoQue smartWarehouseInfoQue) {
        PageInfo pageInfo = smartWarehouseInfoService.orUserSelect(smartWarehouseInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
}
