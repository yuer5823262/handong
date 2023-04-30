package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;

import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.AddBigSegmentReq;
import com.example.dampouring.model.request.UpdateBigSegmentReq;
import com.example.dampouring.query.BigSegmentQue;
import com.example.dampouring.service.BigSegmentService;

import com.example.dampouring.util.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Api(description = "标段")
@RequestMapping("api/bigSegment")
@Controller
public class BigSegmentController {
    @Autowired
    BigSegmentService bigSegmentService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addBigSegment(
             @RequestBody @Valid AddBigSegmentReq addBigSegmentReq,
             HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        bigSegmentService.add(addBigSegmentReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddBigSegmentReq segmentReq = new AddBigSegmentReq();
//            segmentReq.setOperator(user.getUsername());
//            segmentReq.setBsName(String.valueOf(n+i));
//            segmentReq.setContractor(String.valueOf(n+i));
//            segmentReq.setRemark(String.valueOf(n+i));
//            bigSegmentService.add(segmentReq);
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateBigSegment(
            @Valid @RequestBody UpdateBigSegmentReq updateBigSegmentReq) {

        bigSegmentService.update(updateBigSegmentReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteBigSegment(@RequestParam("ids") Integer[] ids) {
        bigSegmentService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestParam Integer pageNum,
                                                @RequestParam Integer pageSize) {
        PageInfo pageInfo = bigSegmentService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectBigSegmentByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<BigSegment> bigSegmentList = bigSegmentService.listByIds(ids);
        return ApiRestResponse.success(bigSegmentList);
    }

    @GetMapping("/selectByContractor")
    @ResponseBody
    public ApiRestResponse selectBigSegmentByContractorList(@RequestParam String value)
    {
        List<BigSegment> bigSegmentList = bigSegmentService.listByContractor(value);
        return ApiRestResponse.success(bigSegmentList);
    }
    @ApiOperation("有查询参数的分页列表")
    @PostMapping("/selectByQue")
    @ResponseBody
    public ApiRestResponse listBigSegementQue(@RequestBody BigSegmentQue bigSegmentQue) {
        PageInfo pageInfo = bigSegmentService.orUserListQue(bigSegmentQue);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<BigSegment> memberList = bigSegmentService.exportList();
        ExportParams params = new ExportParams("标段", "标段", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, BigSegment.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "标段");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
