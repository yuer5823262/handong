package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.request.AddMaintainReq;
import com.example.dampouring.model.request.UpdateMaintainReq;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.query.HeatPreservationQue;
import com.example.dampouring.query.MaintainQue;
import com.example.dampouring.service.MaintainService;
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

@RequestMapping("api/maintain")
@Controller
@Api(description = "养护信息")
public class MaintainController {
    @Autowired
    MaintainService maintainService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addMaintain(
            @RequestBody @Valid AddMaintainReq addMaintainReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        maintainService.add(addMaintainReq,username);

//        int n = 10000;
//        for (int i = 20; i < 100; i++) {
//            AddMaintainReq segmentReq = new AddMaintainReq();
//            segmentReq.setCbNo(i);
//            segmentReq.setCuAddr(""+i);
//            segmentReq.setSmallSbNo(i);
//            segmentReq.setCuType("测控装置"+i);
//            segmentReq.setRemark(String.valueOf(n+i));
//            MaintainService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateMaintain(
            @Valid @RequestBody UpdateMaintainReq updateMaintainReq) {

        maintainService.update(updateMaintainReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteMaintain(@RequestParam("ids") Integer[] ids) {
        maintainService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listMaintain(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        PageInfo pageInfo = maintainService.orUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }
    @PostMapping("/selectByQuery")
    @ResponseBody
    public ApiRestResponse selectMaintainByQuery(
            @Valid @RequestBody MaintainQue maintainQue) {

        PageInfo pageInfo= maintainService.selectByQue(maintainQue);
        return ApiRestResponse.success(pageInfo);

    }

    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectMaintainByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<MaintainVO> MaintainList = maintainService.listByIds(ids);
        return ApiRestResponse.success(MaintainList);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<MaintainVO> memberList = maintainService.exportList();
        ExportParams params = new ExportParams("养护信息", "养护信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, MaintainVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "养护信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
