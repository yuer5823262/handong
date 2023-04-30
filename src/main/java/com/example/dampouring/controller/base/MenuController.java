package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.Menu;
import com.example.dampouring.model.request.AddMenuReq;
import com.example.dampouring.model.request.UpdateMenuReq;
import com.example.dampouring.service.MenuService;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/menu")
@Controller
@Api(description = "菜单管理")
public class MenuController {
    @Autowired
    MenuService MenuService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addMenu(
            @RequestBody @Valid AddMenuReq addMenuReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        MenuService.add(addMenuReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddMenuReq segmentReq = new AddMenuReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            MenuService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateMenu(
            @Valid @RequestBody UpdateMenuReq updateMenuReq) {

        MenuService.update(updateMenuReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteMenu(@RequestParam("ids") Integer[] ids) {
        MenuService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement() {
        List<Menu> pageInfo = MenuService.orUserList();
        return ApiRestResponse.success(pageInfo);
    }
    
}
