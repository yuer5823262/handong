package com.example.dampouring.controller.smart_mixing;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SmartMixingPara;
import com.example.dampouring.model.request.AddSmartMixingParaReq;
import com.example.dampouring.model.request.UpdateSmartMixingParaReq;
import com.example.dampouring.service.SmartMixingParaService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/SmartMixingPara")
@Controller
@Api(description = "智能拌合参数")
public class SmartMixingParaController {
    @Autowired
    SmartMixingParaService SmartMixingParaService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSmartMixingPara(
            @RequestBody @Valid AddSmartMixingParaReq addSmartMixingParaReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SmartMixingParaService.add(addSmartMixingParaReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSmartMixingPara(
            @Valid @RequestBody UpdateSmartMixingParaReq updateSmartMixingParaReq) {

        SmartMixingParaService.update(updateSmartMixingParaReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSmartMixingPara(@RequestParam("ids") Integer[] ids) {
        SmartMixingParaService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<SmartMixingPara> pageInfo = SmartMixingParaService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }
}
