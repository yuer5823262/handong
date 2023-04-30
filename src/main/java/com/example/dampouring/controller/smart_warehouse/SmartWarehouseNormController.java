package com.example.dampouring.controller.smart_warehouse;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddSmartWarehouseNormReq;
import com.example.dampouring.model.request.UpdateSmartWarehouseNormReq;
import com.example.dampouring.service.SmartWarehouseNormService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("api/SmartWarehouseNorm")
@Controller
@Api(description = "智能仓面标准")
public class SmartWarehouseNormController {
    @Autowired
    SmartWarehouseNormService SmartWarehouseNormService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSmartWarehouseNorm(
            @RequestBody @Valid AddSmartWarehouseNormReq addSmartWarehouseNormReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SmartWarehouseNormService.add(addSmartWarehouseNormReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddSmartWarehouseNormReq segmentReq = new AddSmartWarehouseNormReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            SmartWarehouseNormService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSmartWarehouseNorm(
            @Valid @RequestBody UpdateSmartWarehouseNormReq updateSmartWarehouseNormReq) {

        SmartWarehouseNormService.update(updateSmartWarehouseNormReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSmartWarehouseNorm(@RequestParam("ids") Integer[] ids) {
        SmartWarehouseNormService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SmartWarehouseNormService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    
}
