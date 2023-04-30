package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.dao.SmallStorageBinMapper;
import com.example.dampouring.model.dao.TempControlNormInfoMapper;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.request.AddSbTempNormReq;
import com.example.dampouring.model.request.UpdateSbTempNormReq;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.example.dampouring.query.SbTempNormQue;
import com.example.dampouring.service.SbTempNormService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(description = "具体仓位温控标准")
@RequestMapping("api/SbTempNorm")
@Controller
public class SbTempNormController {
    @Autowired
    SbTempNormService SbTempNormService;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Autowired
    TempControlNormInfoMapper tempControlNormInfoMapper;
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSbTempNorm(
            @Valid @RequestBody UpdateSbTempNormReq updateSbTempNormReq) {

        SbTempNormService.update(updateSbTempNormReq);
        return ApiRestResponse.success();

    }

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse updateSbTempNorm(
            @Valid @RequestBody AddSbTempNormReq addSbTempNormReq) {
        SbTempNormService.add(addSbTempNormReq);
        return ApiRestResponse.success();
    }

    @GetMapping("/getSbNorm")
    @ResponseBody
    public ApiRestResponse updateSbTempNorm(
            @RequestParam Integer sbId) {
        SmallStorageBin smallStorageBin = smallStorageBinMapper.selectByPrimaryKey(sbId);
        if(smallStorageBin==null)
            throw new DamPourException(30000,"没有找到对应的仓");
        TempControlNormInfoVO tempControlNormInfo = tempControlNormInfoMapper.selectBySb(smallStorageBin);
        if(tempControlNormInfo==null)
            throw new DamPourException(30000,"没有找到对应的温控标准");
        return ApiRestResponse.success(tempControlNormInfo);
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody SbTempNormQue sbTempNormQue) {
        PageInfo pageInfo = SbTempNormService.orUserList(sbTempNormQue);
        return ApiRestResponse.success(pageInfo);
    }
    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSbTempNormByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SbTempNormVO> SbTempNormList = SbTempNormService.listByIds(ids);
        return ApiRestResponse.success(SbTempNormList);
    }
}
