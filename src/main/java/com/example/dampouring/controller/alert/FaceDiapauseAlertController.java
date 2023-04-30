package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/FaceDiapauseAlert")
@Controller
@Api(description = "仓面间歇期预警")
public class FaceDiapauseAlertController {
    @Autowired
    FaceDiapauseAlertService FaceDiapauseAlertService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectFaceDiapauseAlert(@RequestBody AlertQue AlertQue) {
        PageInfo pageInfo = FaceDiapauseAlertService.orUserSelect(AlertQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingFaceDiapauseAlert(@RequestParam("ids") Integer[] ids, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        FaceDiapauseAlertService.processing(ids,username,"1",0);
        return ApiRestResponse.success();
    }
}
