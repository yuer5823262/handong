package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddTempControlNormInfoReq;
import com.example.dampouring.model.request.UpdateTempControlNormInfoReq;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.example.dampouring.service.TempControlNormInfoService;
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

@Api(description = "温控标准信息")
@RequestMapping("api/TempControlNormInfo")
@Controller
public class TempControlNormInfoController {
    @Autowired
    TempControlNormInfoService TempControlNormInfoService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlNormInfo(
            @RequestBody @Valid AddTempControlNormInfoReq addTempControlNormInfoReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlNormInfoService.add(addTempControlNormInfoReq,username);

//        for (int i = 2; i < 100; i++) {
//            AddTempControlNormInfoReq adds = new AddTempControlNormInfoReq();
//            adds.setRemark("test"+i);
//            adds.setCbNo("FZX-"+i);
//            adds.setScsId(2);
//            TempControlNormInfoService.add(adds,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlNormInfo(
            @Valid @RequestBody UpdateTempControlNormInfoReq updateTempControlNormInfoReq) {

        TempControlNormInfoService.update(updateTempControlNormInfoReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlNormInfo(@RequestParam("ids") Integer[] ids) {
        TempControlNormInfoService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = TempControlNormInfoService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlNormInfoByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlNormInfoVO> TempControlNormInfoList = TempControlNormInfoService.listByIds(ids);
        return ApiRestResponse.success(TempControlNormInfoList);
    }
}
