package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempControlCurveCommon;
import com.example.dampouring.model.pojo.TempControlCurveSpecial;
import com.example.dampouring.model.request.AddTempControlCurveSpecialReq;
import com.example.dampouring.model.request.UpdateTempControlCurveSpecialReq;
import com.example.dampouring.service.TempControlCurveSpecialService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/TempControlCurveSpecial")
@Controller
@Api(description = "温控曲线特殊")
public class TempControlCurveSpecialController {
    @Autowired
    TempControlCurveSpecialService TempControlCurveSpecialService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlCurveSpecial(
            @RequestBody @Valid AddTempControlCurveSpecialReq addTempControlCurveSpecialReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlCurveSpecialService.add(addTempControlCurveSpecialReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddTempControlCurveSpecialReq segmentReq = new AddTempControlCurveSpecialReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            TempControlCurveSpecialService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlCurveSpecial(
            @Valid @RequestBody UpdateTempControlCurveSpecialReq updateTempControlCurveSpecialReq) {

        TempControlCurveSpecialService.update(updateTempControlCurveSpecialReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlCurveSpecial(@RequestParam("ids") Integer[] ids) {
        TempControlCurveSpecialService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<TempControlCurveSpecial> pageInfo = TempControlCurveSpecialService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }
    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlCurveSpecialByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlCurveSpecial> TempControlCurveCommonList = TempControlCurveSpecialService.listByIds(ids);
        return ApiRestResponse.success(TempControlCurveCommonList);
    }
}
