package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.StorageColdAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/StorageColdAlert")
@Controller
@Api(description = "浇筑仓超冷预警")
public class StorageColdAlertController {
    @Autowired
    StorageColdAlertService StorageColdAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectStorageColdAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = StorageColdAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingStorageColdAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        StorageColdAlertService.processing(ids,username,"2",1);
        return ApiRestResponse.success();
    }
}
