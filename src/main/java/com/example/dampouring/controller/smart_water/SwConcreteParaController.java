package com.example.dampouring.controller.smart_water;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SwConcretePara;
import com.example.dampouring.model.request.AddSwConcreteParaReq;
import com.example.dampouring.model.request.UpdateSwConcreteParaReq;
import com.example.dampouring.service.SwConcreteParaService;
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

@Api(description = "智能通水监测ConcretePara")
@RequestMapping("api/SwConcretePara")
@Controller
public class SwConcreteParaController {
    @Autowired
    com.example.dampouring.service.SwConcreteParaService SwConcreteParaService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSwConcretePara(
            @RequestBody @Valid AddSwConcreteParaReq addSwConcreteParaReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SwConcreteParaService.add(addSwConcreteParaReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSwConcretePara(
            @Valid @RequestBody UpdateSwConcreteParaReq updateSwConcreteParaReq) {

        SwConcreteParaService.update(updateSwConcreteParaReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSwConcretePara(@RequestParam("ids") Integer[] ids) {
        SwConcreteParaService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SwConcreteParaService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSwConcreteParaByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SwConcretePara> SwConcreteParaList = SwConcreteParaService.listByIds(ids);
        return ApiRestResponse.success(SwConcreteParaList);
    }
}
