package com.example.dampouring.controller.smartBaowen;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.service.SmartBwDantiService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "智能保温计算Danti")
@RequestMapping("api/SmartBwDanti")
@Controller
public class SmartBwDantiController {
    @Autowired
    SmartBwDantiService SmartBwDantiService;

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize,@RequestParam String dsNo) {
        PageInfo pageInfo = SmartBwDantiService.orUserList(pageNum, pageSize,dsNo);
        return ApiRestResponse.success(pageInfo);
    }
}
