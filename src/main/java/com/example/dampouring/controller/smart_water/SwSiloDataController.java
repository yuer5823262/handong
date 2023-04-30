package com.example.dampouring.controller.smart_water;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SwSiloData;
import com.example.dampouring.model.request.AddSwSiloDataReq;
import com.example.dampouring.model.request.UpdateSwSiloDataReq;
import com.example.dampouring.service.SwSiloDataService;
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

@Api(description = "智能通水监测SiloData")
@RequestMapping("api/SwSiloData")
@Controller
public class SwSiloDataController {
    @Autowired
    com.example.dampouring.service.SwSiloDataService SwSiloDataService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSwSiloData(
            @RequestBody @Valid AddSwSiloDataReq addSwSiloDataReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SwSiloDataService.add(addSwSiloDataReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSwSiloData(
            @Valid @RequestBody UpdateSwSiloDataReq updateSwSiloDataReq) {

        SwSiloDataService.update(updateSwSiloDataReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSwSiloData(@RequestParam("ids") Integer[] ids) {
        SwSiloDataService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SwSiloDataService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSwSiloDataByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SwSiloData> SwSiloDataList = SwSiloDataService.listByIds(ids);
        return ApiRestResponse.success(SwSiloDataList);
    }
}
