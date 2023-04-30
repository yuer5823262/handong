package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.StorageBinExclude;
import com.example.dampouring.model.request.AddStorageBinExcludeReq;
import com.example.dampouring.model.request.UpdateStorageBinExcludeReq;
import com.example.dampouring.model.vo.StorageBinExcludeVO;
import com.example.dampouring.query.StorageBinExcludeQue;
import com.example.dampouring.service.StorageBinExcludeService;
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
@Api(description = "无需计算仓位排除")
@RequestMapping("api/StorageBinExclude")
@Controller
public class StorageBinExcludeController {
    @Autowired
    StorageBinExcludeService StorageBinExcludeService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addStorageBinExclude(
            @RequestBody @Valid AddStorageBinExcludeReq addStorageBinExcludeReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        StorageBinExcludeService.add(addStorageBinExcludeReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateStorageBinExclude(
            @Valid @RequestBody UpdateStorageBinExcludeReq updateStorageBinExcludeReq) {

        StorageBinExcludeService.update(updateStorageBinExcludeReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteStorageBinExclude(@RequestParam("ids") Integer[] ids) {
        StorageBinExcludeService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody StorageBinExcludeQue storageBinExcludeQue) {
        PageInfo pageInfo = StorageBinExcludeService.orUserList(storageBinExcludeQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectStorageBinExcludeByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<StorageBinExcludeVO> StorageBinExcludeList = StorageBinExcludeService.listByIds(ids);
        return ApiRestResponse.success(StorageBinExcludeList);
    }
}
