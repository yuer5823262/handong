package com.example.dampouring.controller.smart_water;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SwTemperatureMon;
import com.example.dampouring.model.request.AddSwTemperatureMonReq;
import com.example.dampouring.model.request.UpdateSwTemperatureMonReq;
import com.example.dampouring.service.SwTemperatureMonService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
@Api(description = "智能通水监测TemperatureMon")
@RequestMapping("api/SwTemperatureMon")
@Controller
public class SwTemperatureMonController {

    @Autowired
    com.example.dampouring.service.SwTemperatureMonService SwTemperatureMonService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSwTemperatureMon(
            @RequestBody @Valid AddSwTemperatureMonReq addSwTemperatureMonReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SwTemperatureMonService.add(addSwTemperatureMonReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSwTemperatureMon(
            @Valid @RequestBody UpdateSwTemperatureMonReq updateSwTemperatureMonReq) {

        SwTemperatureMonService.update(updateSwTemperatureMonReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSwTemperatureMon(@RequestParam("ids") Integer[] ids) {
        SwTemperatureMonService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SwTemperatureMonService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSwTemperatureMonByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SwTemperatureMon> SwTemperatureMonList = SwTemperatureMonService.listByIds(ids);
        return ApiRestResponse.success(SwTemperatureMonList);
    }
}
