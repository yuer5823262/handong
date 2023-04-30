package com.example.dampouring.controller.smart_water;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.HandheldTmeterQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.service.HandheldTmeterService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "智能手持温度计信息")
@RequestMapping("api/HandheldTmeter")
@Controller
public class HandheldTmeterController {
    @Autowired
    HandheldTmeterService handheldTmeterService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectHandheldTmeter(@RequestBody HandheldTmeterQue handheldTmeterQue) {
        PageInfo pageInfo = handheldTmeterService.orUserSelect(handheldTmeterQue);
        return ApiRestResponse.success(pageInfo);
    }
}
