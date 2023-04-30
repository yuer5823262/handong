package com.example.dampouring.controller.base;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.WaterPipe;
import com.example.dampouring.model.request.AddWaterPipeReq;
import com.example.dampouring.model.request.UpdateWaterPipeReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.WaterPipeQue;
import com.example.dampouring.service.WaterPipeService;
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

@RequestMapping("api/waterPipe")
@Controller
@Api(description = "水管")
public class WaterPipeController {
    @Autowired
    WaterPipeService waterPipeService;

    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addWaterPipe(
            @RequestBody @Valid AddWaterPipeReq addWaterPipeReq,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        String username =  JwtUtils.GetUserName(token);
        waterPipeService.add(addWaterPipeReq,username);

//        int n = 10000;
//        for (int i = 0; i < 1000; i++) {
//            AddWaterPipeReq segmentReq = new AddWaterPipeReq();
//            segmentReq.setTempNo("TEMP"+i);
//            segmentReq.setTempAddr("111as11"+i);
//            segmentReq.setChannelNo(1);
//            segmentReq.setCuId(i);
//            WaterPipeService.add(segmentReq,user.getUsername());
//        }
        return ApiRestResponse.success();
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse updateWaterPipe(
            @Valid @RequestBody UpdateWaterPipeReq updateWaterPipeReq) {

        waterPipeService.update(updateWaterPipeReq);
        return ApiRestResponse.success();

    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    @ResponseBody
    public ApiRestResponse deleteWaterPipe(@RequestParam("ids") Integer[] ids) {
        waterPipeService.delete(ids);
        return ApiRestResponse.success();
    }

    @ApiOperation("分页列表")
    @PostMapping("/list")
    @ResponseBody
    public ApiRestResponse listBigSegement(@RequestBody WaterPipeQue waterPipeQue) {
        PageInfo pageInfo = waterPipeService.orUserList(waterPipeQue);
        return ApiRestResponse.success(pageInfo);
    }


    @GetMapping("/selectByIds")
    @ResponseBody
    public ApiRestResponse selectWaterPipeByIdList(@RequestParam("ids") Integer[] ids)
    {
        List<WaterPipeVO> waterPipeList = waterPipeService.listByIds(ids);
        return ApiRestResponse.success(waterPipeList);
    }
    @GetMapping("/selectBySmallId")
    @ResponseBody
    @ApiOperation("获取小仓下的水管")
    public ApiRestResponse selectWaterPipeBySmallId(Integer smallId)
    {
        List<WaterPipeVO> waterPipeList = waterPipeService.selectBySmallId(smallId);
        return ApiRestResponse.success(waterPipeList);
    }
    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<WaterPipeVO> memberList = waterPipeService.exportList();
        ExportParams params = new ExportParams("水管信息", "水管信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, WaterPipeVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "水管信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
