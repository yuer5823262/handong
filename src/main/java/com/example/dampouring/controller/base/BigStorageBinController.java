package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.BigStorageBin;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddBigStorageBinReq;
import com.example.dampouring.model.request.UpdateBigStorageBinReq;
import com.example.dampouring.service.BigStorageBinService;
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
@Api(description = "大仓")
@RequestMapping("api/bigStorageBin")
@Controller
public class BigStorageBinController {
    @Autowired
    BigStorageBinService bigStorageBinService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addBigStorageBin(
            @RequestBody @Valid AddBigStorageBinReq addBigStorageBinReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        bigStorageBinService.add(addBigStorageBinReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddBigStorageBinReq segmentReq = new AddBigStorageBinReq();
//            segmentReq.setDsName(String.valueOf(n+i));
//            segmentReq.setBsNo(100);
//            segmentReq.setElevationEnd(80.6+i);
//            segmentReq.setElevationStart(50.2+i);
//            BigStorageBinService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateBigStorageBin(
            @Valid @RequestBody UpdateBigStorageBinReq updateBigStorageBinReq) {

        bigStorageBinService.update(updateBigStorageBinReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteBigStorageBin(@RequestParam Integer id) {
        bigStorageBinService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = bigStorageBinService.userVoList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectBigStorageBinByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<BigStorageBin> BigStorageBinList = bigStorageBinService.listByIds(ids);
        return ApiRestResponse.success(BigStorageBinList);
    }


}
