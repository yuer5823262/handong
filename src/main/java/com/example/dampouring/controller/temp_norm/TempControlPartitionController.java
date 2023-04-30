package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.request.AddTempControlPartitionReq;
import com.example.dampouring.model.request.UpdateTempControlPartitionReq;
import com.example.dampouring.model.vo.TempControlPartitionVO;
import com.example.dampouring.service.TempControlPartitionService;
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

@Api(description = "温控标准分区信息")
@RequestMapping("api/TempControlPartition")
@Controller
public class TempControlPartitionController {
    @Autowired
    TempControlPartitionService TempControlPartitionService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlPartition(
            @RequestBody @Valid AddTempControlPartitionReq addTempControlPartitionReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlPartitionService.add(addTempControlPartitionReq,username);

//        for (int i = 2; i < 100; i++) {
//            AddTempControlPartitionReq adds = new AddTempControlPartitionReq();
//            adds.setRemark("test"+i);
//            adds.setCbNo("FZX-"+i);
//            adds.setScsId(2);
//            TempControlPartitionService.add(adds,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlPartition(
            @Valid @RequestBody UpdateTempControlPartitionReq updateTempControlPartitionReq) {

        TempControlPartitionService.update(updateTempControlPartitionReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlPartition(@RequestParam("ids") Integer[] ids) {
        TempControlPartitionService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = TempControlPartitionService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlPartitionByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlPartitionVO> TempControlPartitionList = TempControlPartitionService.listByIds(ids);
        return ApiRestResponse.success(TempControlPartitionList);
    }
}
