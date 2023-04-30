package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.CloseGroutAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/CloseGroutAlert")
@Controller
@Api(description = "封拱灌浆预警")
public class CloseGroutAlertController {
    @Autowired
    CloseGroutAlertService CloseGroutAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectCloseGroutAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = CloseGroutAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingCloseGroutAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        CloseGroutAlertService.processing(ids,username,"2",0);
        return ApiRestResponse.success();
    }
}
