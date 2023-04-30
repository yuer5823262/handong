package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempControlStandardNorm;
import com.example.dampouring.model.request.AddTempControlStandardNormReq;
import com.example.dampouring.model.request.UpdateTempControlStandardNormReq;
import com.example.dampouring.service.TempControlStandardNormService;
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

@Api(description = "自定义其他温控信息")
@RequestMapping("api/TempControlStandardNorm")
@Controller
public class TempControlStandardNormController {
    @Autowired
    TempControlStandardNormService TempControlStandardNormService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlStandardNorm(
            @RequestBody @Valid AddTempControlStandardNormReq addTempControlStandardNormReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlStandardNormService.add(addTempControlStandardNormReq,username);

        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlStandardNorm(
            @Valid @RequestBody UpdateTempControlStandardNormReq updateTempControlStandardNormReq) {

        TempControlStandardNormService.update(updateTempControlStandardNormReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlStandardNorm(@RequestParam("ids") Integer[] ids) {
        TempControlStandardNormService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = TempControlStandardNormService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlStandardNormByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlStandardNorm> TempControlStandardNormList = TempControlStandardNormService.listByIds(ids);
        return ApiRestResponse.success(TempControlStandardNormList);
    }
}
