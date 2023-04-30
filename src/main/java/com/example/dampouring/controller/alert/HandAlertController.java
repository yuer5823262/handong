package com.example.dampouring.controller.alert;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.dao.UserTableMapper;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddHandAlertReq;
import com.example.dampouring.model.request.UpdateHandAlertReq;
import com.example.dampouring.query.HandAlertQue;
import com.example.dampouring.service.HandAlertService;
import com.example.dampouring.service.UserService;
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

@RequestMapping("api/HandAlert")
@Controller
@Api(description = "手动报警")
public class HandAlertController {
    @Autowired
    HandAlertService HandAlertService;
    @Autowired
    UserService userService;
    @GetMapping("/processing")
    @ResponseBody
    public ApiRestResponse ProcessingDataMissAlert(@RequestParam("ids") Integer[] ids,HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        HandAlertService.processing(ids,username,"2",0);
        return ApiRestResponse.success();
    }

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addHandAlert(
            @RequestBody @Valid AddHandAlertReq addHandAlertReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        HandAlertService.add(addHandAlertReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddHandAlertReq segmentReq = new AddHandAlertReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            HandAlertService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateHandAlert(
            @Valid @RequestBody UpdateHandAlertReq updateHandAlertReq) {

        HandAlertService.update(updateHandAlertReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteHandAlert(@RequestParam("ids") Integer[] ids) {
        HandAlertService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody HandAlertQue handAlertQue,HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer uid = JwtUtils.GetId(token);
        UserTable userTable = userService.getUser(uid);
        handAlertQue.setRoleId(userTable.getRole());
        PageInfo pageInfo = HandAlertService.orUserList(handAlertQue);
        return ApiRestResponse.success(pageInfo);
    }

}
