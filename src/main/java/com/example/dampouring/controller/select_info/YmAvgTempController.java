package com.example.dampouring.controller.select_info;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.Beton;
import com.example.dampouring.model.pojo.YmAvgTemp;
import com.example.dampouring.model.request.UpdateBetonReq;
import com.example.dampouring.model.request.UpdateYmReq;
import com.example.dampouring.model.vo.MmaTempVO;
import com.example.dampouring.service.YmAvgTempService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/YmAvgTemp")
@Controller
@Api(description = "多年月平均气温")
public class YmAvgTempController {
    @Autowired
    YmAvgTempService ymAvgTempService;
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateBeton(
            @RequestBody UpdateYmReq updateBetonReq) {

        ymAvgTempService.update(updateBetonReq);
        return ApiRestResponse.success();

    }
    @ApiOperation("列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse orUserList() {
        List<YmAvgTemp> pageInfo = ymAvgTempService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation("年最大最低平均温度")
    @GetMapping("/mmaTemp")
    @ResponseBody
    public ApiRestResponse mmaTemp() {
        MmaTempVO pageInfo = ymAvgTempService.mmaTemp();
        return ApiRestResponse.success(pageInfo);
    }
}
