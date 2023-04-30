package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.RoleDetail;
import com.example.dampouring.model.request.AddRoleDetailReq;
import com.example.dampouring.model.request.UpdateRoleDetailReq;
import com.example.dampouring.service.RoleDetailService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
@RequestMapping("api/RoleDetail")
@Controller
@Api(description = "角色权限管理")
public class RoleDetailController {
    @Autowired
    RoleDetailService RoleDetailService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addRoleDetail(
            @RequestBody @Valid AddRoleDetailReq addRoleDetailReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        RoleDetailService.add(addRoleDetailReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddRoleDetailReq segmentReq = new AddRoleDetailReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            RoleDetailService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateRoleDetail(
            @Valid @RequestBody UpdateRoleDetailReq updateRoleDetailReq) {

        RoleDetailService.update(updateRoleDetailReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteRoleDetail(@RequestParam("ids") Integer[] ids) {
        RoleDetailService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(Integer roleId) {
        List<RoleDetail> pageInfo = RoleDetailService.orUserList(roleId);
        return ApiRestResponse.success(pageInfo);
    }
}
