package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddPouringBaseReq;
import com.example.dampouring.model.request.UpdatePouringBaseReq;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.query.PouringBaseQue;
import com.example.dampouring.query.TempUpQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.service.PouringBaseService;
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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@RequestMapping("api/pouringBase")
@Controller
@Api(description = "浇筑信息")
public class PouringBaseController {
    @Autowired
    PouringBaseService pouringBaseService;
    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addPouringBase(
            @RequestBody @Valid AddPouringBaseReq addPouringBaseReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        pouringBaseService.add(addPouringBaseReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddPouringBaseReq segmentReq = new AddPouringBaseReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            PouringBaseService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updatePouringBase(
            @Valid @RequestBody UpdatePouringBaseReq updatePouringBaseReq) {
        pouringBaseService.update(updatePouringBaseReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deletePouringBase(@RequestParam("ids") Integer[] ids) {
        pouringBaseService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = pouringBaseService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectPouringBaseByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<PouringBaseVO> PouringBaseList = pouringBaseService.listByIds(ids);
        return ApiRestResponse.success(PouringBaseList);
    }

    @ApiOperation("当前暴露仓面")
    @PostMapping("/selectByFg")
    @ResponseBody
    public ApiRestResponse selectByFg(
            @Valid @RequestBody PouringBaseQue pouringBaseQue) {

        PageInfo pageInfo = pouringBaseService.selectByFg(pouringBaseQue);
        return ApiRestResponse.success(pageInfo);
    }

    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse selectPouringBase(
            @Valid @RequestBody PouringBaseQue pouringBaseQue) {
        PageInfo pageInfo = pouringBaseService.orUserSelect(pouringBaseQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation("运输导致温度升高")
    @PostMapping("/tempUp")
    @ResponseBody
    public ApiRestResponse selectPouringTempUp(@RequestBody TempUpQue tempUpQue) {
        PageInfo pageInfo = pouringBaseService.tempUp(tempUpQue);
        return ApiRestResponse.success(pageInfo);

    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<PouringBaseVO> memberList = pouringBaseService.exportList();
        ExportParams params = new ExportParams("浇筑信息", "浇筑信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, PouringBaseVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "浇筑信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
