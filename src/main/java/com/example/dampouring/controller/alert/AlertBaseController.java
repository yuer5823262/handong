package com.example.dampouring.controller.alert;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.Role;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.query.AlertBaseQue;
import com.example.dampouring.service.AlertBaseService;
import com.example.dampouring.service.RoleService;
import com.example.dampouring.service.UserService;
import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Api(description = "待办事项")
@RequestMapping("api/AlertBase")
@Controller
public class AlertBaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AlertBaseService alertBaseService;
    @PostMapping("/selectList")
    @ResponseBody
    public ApiRestResponse selectList(HttpServletRequest request, @RequestBody AlertBaseQue alertBaseQue) {
        String token = request.getHeader("token");
        Integer uid = JwtUtils.GetId(token);
        UserTable user = userService.getUser(uid);
        Role role = roleService.selectById(user.getRole());
        String alertInfo = role.getAlertInfo();
        PageInfo resultList = alertBaseService.selectByAlertInfo(alertInfo,alertBaseQue);
        return ApiRestResponse.success(resultList);
    }

    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse processing(
            @RequestParam Integer[] ids,@RequestParam String remark,@RequestParam Integer mark ,HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer uid = JwtUtils.GetId(token);
        UserTable user = userService.getUser(uid);
        String uName = user.getUsername();
        Integer type = user.getType();
        alertBaseService.processing(uName,type,remark,ids,mark);
        return ApiRestResponse.success();
    }
}
