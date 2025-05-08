package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.InnerTempSensorMapper;
import com.example.dampouring.model.dao.MaxTempAlertMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.dao.TempMapMapper;
import com.example.dampouring.model.excel.InnerTempSensorInfoEx;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.request.InnerTempSensorInfoAdd;
import com.example.dampouring.model.request.RemoteDev;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import com.example.dampouring.service.InnerTempSensorInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/InnerTempSensorInfo")
@Controller
@Api(description = "内部温度信息")
public class InnerTempSensorInfoController {
    @Autowired
    InnerTempSensorInfoService innerTempSensorInfoService;
    @Autowired
    InnerTempSensorMapper innerTempSensorMapper;
    @Autowired
    TempMapMapper tempMapMapper;
    @Autowired
    MaxTempAlertMapper MaxTempAlertMapper;
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse listInnerTempSensorInfo(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize,@RequestParam Integer sbId) {
        PageInfo pageInfo = innerTempSensorInfoService.orUserList(pageNum, pageSize,sbId);
        return ApiRestResponse.success(pageInfo);
    }
    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse addInnerTempSensorInfo(@RequestBody InnerTempSensorInfoAdd innerTempSensorInfoAdd) {
        innerTempSensorInfoService.add(innerTempSensorInfoAdd);
        return ApiRestResponse.success();
    }
    @ApiOperation("添加远程温度信息")
    @PostMapping("/addByRemoteDev")
    @ResponseBody
    public ApiRestResponse addByRemoteDev(@RequestBody RemoteDev remoteDev) {
        innerTempSensorInfoService.addByRemoteDev(remoteDev);
        return ApiRestResponse.success();
    }

    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectInnerTempSensorInfo(@RequestBody InnerTempSensorInfoQue InnerTempSensorInfoQue) {
        PageInfo pageInfo = innerTempSensorInfoService.orUserSelect(InnerTempSensorInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "大坝沿高程分布")
    @PostMapping("/damTemp")
    @ResponseBody
    public ApiRestResponse listSelectDamTemp(@RequestBody DamTempQue damTempQue) {
        List<DamTempVO> damTempVOList = innerTempSensorInfoService.damTemp(damTempQue);
        return ApiRestResponse.success(damTempVOList);
    }

    @ApiOperation(value = "内部温度监控")
    @GetMapping("/tempMonitor")
    @ResponseBody
    public ApiRestResponse tempMonitor() {
        List<InnerTempMonitorVO> innerTempMonitorVOList = innerTempSensorInfoService.tempMonitor();
        return ApiRestResponse.success(innerTempMonitorVOList);
    }

    @ApiOperation(value = "降温速率")
    @PostMapping("/coolingRate")
    @ResponseBody
    public ApiRestResponse listCoolingRate(@RequestBody InnerTempSensorInfoQue InnerTempSensorInfoQue) {
        PageInfo pageInfo = innerTempSensorInfoService.CoolingRate(InnerTempSensorInfoQue);
        return ApiRestResponse.success(pageInfo);
    }
    @ApiOperation(value = "最高温度")
    @PostMapping("/maxTemp")
    @ResponseBody
    public ApiRestResponse listMaxTemp(@RequestBody TopTempAssessQue topTempAssessQue) {
        PageInfo pageInfo = innerTempSensorInfoService.maxTemp(topTempAssessQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation(value = "降温速率根据参数导出Excel")
    @PostMapping("/coolingRateExportListByQue")
    public void coolingRateExportMemberListByQue(ModelMap map,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestBody InnerTempSensorInfoQue InnerTempSensorInfoQue) {

        List<CoolingRateVo> memberList = innerTempSensorInfoService.CoolingRateExportList(InnerTempSensorInfoQue);
        ExportParams params = new ExportParams("降温速率", "降温速率", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, CoolingRateVo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "降温速率");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InnerTempSensorInfoVO> memberList = innerTempSensorInfoService.exportList();
        ExportParams params = new ExportParams("内部温度信息", "内部温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InnerTempSensorInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "内部温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByQue")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                      @RequestBody InnerTempSensorInfoQue InnerTempSensorInfoQue) {
        List<InnerTempSensorInfoVO> memberList = innerTempSensorInfoService.exportListByque(InnerTempSensorInfoQue);
        ExportParams params = new ExportParams("内部温度信息", "内部温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InnerTempSensorInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "内部温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "导入模板")
    @GetMapping("/muban")
    public void muban(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InnerTempSensorInfoEx> memberList = new ArrayList<>();
        ExportParams params = new ExportParams("内部温度信息", "内部温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InnerTempSensorInfoEx.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "内部温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation("从Excel导入")
    @PostMapping("/importMemberList")
    @ResponseBody
    public ApiRestResponse importMemberList(@RequestPart("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        try {
            List<InnerTempSensorInfoEx> list = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    InnerTempSensorInfoEx.class, params);
            List<InnerTempSensorInfo> innerTempSensorInfoList = new ArrayList<>();
            for (InnerTempSensorInfoEx innerTempSensorInfoEx:list)
            {
                InnerTempSensorInfo innerTempSensorInfo = new InnerTempSensorInfo();
                InnerTempSensor innerTempSensor = innerTempSensorMapper.selectByTempNo(innerTempSensorInfoEx.getTempSensorNo());
                innerTempSensorInfo.setInnerTempSensorId(innerTempSensor.getId());
                innerTempSensorInfo.setTemp(innerTempSensorInfoEx.getTemp());
                innerTempSensorInfo.setTime(innerTempSensorInfoEx.getTime());
                innerTempSensorInfo.setAvgTemp(innerTempSensorInfoEx.getTemp());
                innerTempSensorInfo.setBl(1);
                MaxTempNormVO maxTempNormVO = MaxTempAlertMapper.normInfo(innerTempSensorInfo.getInnerTempSensorId());
                innerTempSensorInfo.setNorm(maxTempNormVO.getMaxTemp());
                innerTempSensorInfoList.add(innerTempSensorInfo);
            }
            innerTempSensorInfoService.addAll(innerTempSensorInfoList);
            return ApiRestResponse.success(list);
        } catch (Exception e) {
            throw new DamPourException(DampouringExceptionEnum.DAORU_WRONG);
        }
    }

    @ApiOperation("上传温度计分布图")
    @PostMapping( "/uploadTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse uploadTempMap(@RequestPart("file") MultipartFile upload,
                                @RequestParam Integer sbId,@RequestParam String name){
        String newFilePath = Constant.TEMP_MAP_PATH+sbId+"-"+"1"+"-"+name+".png";
        TempMap tempMapCheck = tempMapMapper.selectBySbIdAndName(sbId,name,"1");
        if(tempMapCheck!=null)
            throw new DamPourException(30000,"此仓已存在相同名称的图纸");
        try {
            upload.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            TempMap tempMap = new TempMap();
            tempMap.setType("1");
            tempMap.setSbId(sbId);
            tempMap.setName(name);
            tempMap.setPath(sbId+"-"+"1"+"-"+name+".png");
            tempMapMapper.insertSelective(tempMap);
            return ApiRestResponse.success();
        }catch(Exception e1){
            throw new DamPourException(30000,"上传失败");
        }
    }
    @ApiOperation("某仓下温度计分布图列表")
    @GetMapping( "/listTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse listTempMap(@RequestParam Integer sbId) {
        List<TempMap> tempMapList=tempMapMapper.listBySbId(sbId,"1");
        return ApiRestResponse.success(tempMapList);
    }
    @ApiOperation("删除温度计分布图")
    @GetMapping( "/deleteTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse deleteTempMap(@RequestParam Integer id) {
        TempMap tempMap= tempMapMapper.selectByPrimaryKey(id);
        if(tempMap==null)
            return ApiRestResponse.error(30000,"不存在,删除失败");
        String filePath = Constant.TEMP_MAP_PATH+tempMap.getPath();
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
            tempMapMapper.deleteByPrimaryKey(id);
            return ApiRestResponse.success();
        }
        else
            return ApiRestResponse.error(30000,"不存在,删除失败");
    }
    @ApiOperation("查看温度计分布图")
    @GetMapping( "/selectTempMap")//测试的url接口
    @ResponseBody
    public void selectTempMap(@RequestParam Integer id, HttpServletResponse response) throws IOException {
        TempMap tempMap= tempMapMapper.selectByPrimaryKey(id);
        if(tempMap==null)
            throw new DamPourException(30000,"此图不存在");
        String filePath = Constant.TEMP_MAP_PATH+tempMap.getPath();
//        String filePath = "/jar/bwData/"+"yuntu"+"/"+gc+"-"+dmNo+"-"+type+".png";
        OutputStream os = null;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new FileInputStream(filePath));
            response.setContentType("image/png");
            os = response.getOutputStream();
            if (image != null) {
                ImageIO.write(image, "png", os);
            }
        }
        catch (Exception e)
        {
            throw new DamPourException(30000,"此图不存在");
        }
        finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }

    }

}
