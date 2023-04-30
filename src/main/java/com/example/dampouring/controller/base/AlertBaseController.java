package com.example.dampouring.controller.base;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.Role;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.UpdateAirTempSensorReq;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.CloseGroutAlertVO;
import com.example.dampouring.service.*;
import com.example.dampouring.util.JwtUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Api(description = "待办事项")
//@RequestMapping("api/AlertBase")
//@Controller
public class AlertBaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    CloseGroutAlertService CloseGroutAlertService;
    @Autowired
    DataMissAlertService DataMissAlertService;
    @Autowired
    EquipmentAlertService EquipmentAlertService;
    @Autowired
    FaceDiapauseAlertService FaceDiapauseAlertService;
    @Autowired
    HandAlertService HandAlertService;
    @Autowired
    LayerTdiffAlertService LayerTdiffAlertService;
    @Autowired
    InWarehouseTempAlertService InWarehouseTempAlertService;
    @Autowired
    MaxTempAlertService MaxTempAlertService;
    @Autowired
    MixingAlertService MixingAlertService;
    @Autowired
    OutletTempAlertService OutletTempAlertService;
    @Autowired
    PouringTempAlertService PouringTempAlertService;
    @Autowired
    ReduceTempAlertService ReduceTempAlertService;
    @Autowired
    StorageColdAlertService StorageColdAlertService;
    @Autowired
    TempGradAlertService TempGradAlertService;
    @Autowired
    TempRiseAlertService TempRiseAlertService;
    @Autowired
    WaterColdAlertService WaterColdAlertService;
    @PostMapping("/processing")
    @ResponseBody
    public ApiRestResponse processing(
            @RequestBody HashMap<String, Integer[]> req, HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer uid = JwtUtils.GetId(token);
        UserTable user = userService.getUser(uid);
        String uName = user.getUsername();
        String type = user.getType().toString();
        Integer mark = req.get("mark")[0];
        if(req.containsKey("1"))
            CloseGroutAlertService.processing(req.get("1"),uName,type,mark);
        if(req.containsKey("2"))
            DataMissAlertService.processing(req.get("2"),uName,type,mark);
        if(req.containsKey("3"))
            EquipmentAlertService.processing(req.get("3"),uName,type,mark);
        if(req.containsKey("4"))
            FaceDiapauseAlertService.processing(req.get("4"),uName,type,mark);
        if(req.containsKey("5"))
            HandAlertService.processing(req.get("5"),uName,type,mark);
        if(req.containsKey("6"))
            InWarehouseTempAlertService.processing(req.get("6"),uName,type,mark);
        if(req.containsKey("7"))
            LayerTdiffAlertService.processing(req.get("7"),uName,type,mark);
        if(req.containsKey("8"))
            MaxTempAlertService.processing(req.get("8"),uName,type,mark);
        if(req.containsKey("9"))
            MixingAlertService.processing(req.get("9"),uName,type,mark);
        if(req.containsKey("10"))
            OutletTempAlertService.processing(req.get("10"),uName,type,mark);
        if(req.containsKey("11"))
            PouringTempAlertService.processing(req.get("11"),uName,type,mark);
        if(req.containsKey("12"))
            ReduceTempAlertService.processing(req.get("12"),uName,type,mark);
        if(req.containsKey("13"))
            StorageColdAlertService.processing(req.get("13"),uName,type,mark);
        if(req.containsKey("14"))
            TempGradAlertService.processing(req.get("14"),uName,type,mark);
        if(req.containsKey("15"))
            TempRiseAlertService.processing(req.get("15"),uName,type,mark);
        if(req.containsKey("16"))
            WaterColdAlertService.processing(req.get("16"),uName,type,mark);
        return ApiRestResponse.success();
    }

    @GetMapping("/selectList")
    @ResponseBody
    public ApiRestResponse selectList(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer uid = JwtUtils.GetId(token);
        UserTable user = userService.getUser(uid);
        Role role = roleService.selectById(user.getRole());
        String alertInfo = role.getAlertInfo();
        List<Object> resultList = new ArrayList<>();
        if(alertInfo.charAt(0)=='1')
        {
            List<AlertBaseVO> t = CloseGroutAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(1)=='1')
        {
            List<AlertBaseVO> t = DataMissAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(2)=='1')
        {
            List<AlertBaseVO> t = EquipmentAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(3)=='1')
        {
            List<AlertBaseVO> t = FaceDiapauseAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(4)=='1')
        {
            List<AlertBaseVO> t = HandAlertService.list(user.getType(),user.getRole());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(5)=='1')
        {
            List<AlertBaseVO> t = InWarehouseTempAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(6)=='1')
        {
            List<AlertBaseVO> t = LayerTdiffAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(7)=='1')
        {
            List<AlertBaseVO> t = MaxTempAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(8)=='1')
        {
            List<AlertBaseVO> t = MixingAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(9)=='1')
        {
            List<AlertBaseVO> t = OutletTempAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(10)=='1')
        {
            List<AlertBaseVO> t = PouringTempAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(11)=='1')
        {
            List<AlertBaseVO> t = ReduceTempAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(12)=='1')
        {
            List<AlertBaseVO> t = StorageColdAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(13)=='1')
        {
            List<AlertBaseVO> t = TempGradAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(14)=='1')
        {
            List<AlertBaseVO> t = TempRiseAlertService.list(user.getType());
            resultList.addAll(t);
        }
        if(alertInfo.charAt(15)=='1')
        {
            List<AlertBaseVO> t = WaterColdAlertService.list(user.getType());
            resultList.addAll(t);
        }
        return ApiRestResponse.success(resultList);
    }
}
