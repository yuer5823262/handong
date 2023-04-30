package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.Beton;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddBetonReq;
import com.example.dampouring.model.request.UpdateBetonReq;
import com.example.dampouring.service.BetonService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/beton")
@Controller
@Api(description = "水泥")
public class  BetonController {
    @Autowired
    BetonService betonService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addBeton(
            @RequestBody @Valid AddBetonReq addBetonReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        betonService.add(addBetonReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddBetonReq segmentReq = new AddBetonReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            BetonService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateBeton(
            @Valid @RequestBody UpdateBetonReq updateBetonReq) {

        betonService.update(updateBetonReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteBeton(@RequestParam("ids") Integer[] ids) {
        betonService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<Beton> pageInfo = betonService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }
}
