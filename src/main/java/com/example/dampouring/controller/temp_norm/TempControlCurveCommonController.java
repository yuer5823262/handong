package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempControlCurveCommon;
import com.example.dampouring.model.request.AddTempControlCurveCommonReq;
import com.example.dampouring.model.request.UpdateTempControlCurveCommonReq;
import com.example.dampouring.service.TempControlCurveCommonService;
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

@Api(description = "温控标准曲线信息")
@RequestMapping("api/TempControlCurveCommon")
@Controller
public class TempControlCurveCommonController {
    @Autowired
    TempControlCurveCommonService TempControlCurveCommonService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlCurveCommon(
            @RequestBody @Valid AddTempControlCurveCommonReq addTempControlCurveCommonReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlCurveCommonService.add(addTempControlCurveCommonReq,username);

//        for (int i = 2; i < 100; i++) {
//            AddTempControlCurveCommonReq adds = new AddTempControlCurveCommonReq();
//            adds.setRemark("test"+i);
//            adds.setCbNo("FZX-"+i);
//            adds.setScsId(2);
//            TempControlCurveCommonService.add(adds,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlCurveCommon(
            @Valid @RequestBody UpdateTempControlCurveCommonReq updateTempControlCurveCommonReq) {

        TempControlCurveCommonService.update(updateTempControlCurveCommonReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlCurveCommon(@RequestParam("ids") Integer[] ids) {
        TempControlCurveCommonService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = TempControlCurveCommonService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlCurveCommonByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlCurveCommon> TempControlCurveCommonList = TempControlCurveCommonService.listByIds(ids);
        return ApiRestResponse.success(TempControlCurveCommonList);
    }
}
