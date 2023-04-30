package com.example.dampouring.controller.base;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.Role;
import com.example.dampouring.model.request.AddRoleReq;
import com.example.dampouring.model.request.UpdateRoleReq;
import com.example.dampouring.service.RoleService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/Role")
@Controller
@Api(description = "角色管理")
public class RoleController {
    @Autowired
    RoleService RoleService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addRole(
            @RequestBody @Valid AddRoleReq addRoleReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        RoleService.add(addRoleReq,username);
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateRole(
            @Valid @RequestBody UpdateRoleReq updateRoleReq) {
        RoleService.update(updateRoleReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteRole(@RequestParam("ids") Integer[] ids) {
        RoleService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<Role> pageInfo = RoleService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<Role> HeatPreservationList = RoleService.listByIds(ids);
        return ApiRestResponse.success(HeatPreservationList);
    }
}
