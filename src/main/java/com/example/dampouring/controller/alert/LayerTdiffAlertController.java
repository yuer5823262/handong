package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.LayerTdiffAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/LayerTdiffAlert")
@Controller
@Api(description = "上下层温差预警")
public class LayerTdiffAlertController {
    @Autowired
    LayerTdiffAlertService LayerTdiffAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectLayerTdiffAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = LayerTdiffAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingLayerTdiffAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        LayerTdiffAlertService.processing(ids,username,"2",0);
        return ApiRestResponse.success();
    }
}
