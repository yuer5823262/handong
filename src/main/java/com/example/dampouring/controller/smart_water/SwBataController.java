package com.example.dampouring.controller.smart_water;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.SwBata;
import com.example.dampouring.model.request.AddSwBataReq;
import com.example.dampouring.model.request.UpdateSwBataReq;
import com.example.dampouring.service.SwBataService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api(description = "智能通水监测Bata")
@RequestMapping("api/SwBata")
@Controller
public class SwBataController {
    @Autowired
    SwBataService SwBataService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addSwBata(
            @RequestBody @Valid AddSwBataReq addSwBataReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        SwBataService.add(addSwBataReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateSwBata(
            @Valid @RequestBody UpdateSwBataReq updateSwBataReq) {

        SwBataService.update(updateSwBataReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteSwBata(@RequestParam("ids") Integer[] ids) {
        SwBataService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = SwBataService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectSwBataByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<SwBata> SwBataList = SwBataService.listByIds(ids);
        return ApiRestResponse.success(SwBataList);
    }

}
