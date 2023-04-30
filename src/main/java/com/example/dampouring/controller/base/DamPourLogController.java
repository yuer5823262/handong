package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.DamPourLogQue;
import com.example.dampouring.service.DamPourLogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "系统日志")
@RequestMapping("api/DamPourLog")
@Controller
public class DamPourLogController {
    @Autowired
    DamPourLogService DamPourLogService;

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listDamPourLog(@RequestBody DamPourLogQue damPourLogQue) {
        PageInfo pageInfo = DamPourLogService.orUserList(damPourLogQue);
        return ApiRestResponse.success(pageInfo);
    }
}
