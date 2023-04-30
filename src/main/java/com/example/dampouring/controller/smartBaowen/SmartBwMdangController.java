package com.example.dampouring.controller.smartBaowen;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.service.SmartBwMdangService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "智能保温计算Mdang")
@RequestMapping("api/SmartBwMdang")
@Controller
public class SmartBwMdangController {
    @Autowired
    com.example.dampouring.service.SmartBwMdangService SmartBwMdangService;

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SmartBwMdangService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
}
