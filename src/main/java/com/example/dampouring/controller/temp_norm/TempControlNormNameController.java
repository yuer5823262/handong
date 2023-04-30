package com.example.dampouring.controller.temp_norm;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempControlNormName;
import com.example.dampouring.model.request.AddTempControlNormNameReq;
import com.example.dampouring.model.request.UpdateTempControlNormNameReq;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.example.dampouring.query.TempControlNormNameQue;
import com.example.dampouring.service.TempControlNormNameService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/TempControlNormName")
@Controller
@Api(description = "温控标准名称")
public class TempControlNormNameController {
    @Autowired
    TempControlNormNameService TempControlNormNameService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addTempControlNormName(
            @RequestBody @Valid AddTempControlNormNameReq addTempControlNormNameReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        TempControlNormNameService.add(addTempControlNormNameReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddTempControlNormNameReq segmentReq = new AddTempControlNormNameReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            TempControlNormNameService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateTempControlNormName(
            @Valid @RequestBody UpdateTempControlNormNameReq updateTempControlNormNameReq) {

        TempControlNormNameService.update(updateTempControlNormNameReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteTempControlNormName(@RequestParam("ids") Integer[] ids) {
        TempControlNormNameService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody TempControlNormNameQue tempControlNormNameQue) {
        List<TempControlNormName> pageInfo = TempControlNormNameService.orUserList(tempControlNormNameQue);
        return ApiRestResponse.success(pageInfo);
    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectTempControlNormNameByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<TempControlNormName> tempControlNormNameList = TempControlNormNameService.listByIds(ids);
        return ApiRestResponse.success(tempControlNormNameList);
    }
}
