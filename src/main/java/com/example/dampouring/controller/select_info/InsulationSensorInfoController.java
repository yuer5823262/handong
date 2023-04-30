package com.example.dampouring.controller.select_info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.dao.TempMapMapper;
import com.example.dampouring.model.pojo.TempMap;
import com.example.dampouring.model.vo.InsulationSensorInfoVO;
import com.example.dampouring.query.InsulationSensorInfoQue;
import com.example.dampouring.service.InsulationSensorInfoService;
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
import java.util.List;

@RequestMapping("api/InsulationSensorInfo")
@Controller
@Api(description = "保温温度信息")
public class InsulationSensorInfoController {
    @Autowired
    InsulationSensorInfoService InsulationSensorInfoService;

    @Autowired
    TempMapMapper tempMapMapper;

    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectInsulationSensorInfo(@RequestBody InsulationSensorInfoQue InsulationSensorInfoQue) {
        PageInfo pageInfo = InsulationSensorInfoService.orUserSelect(InsulationSensorInfoQue);
        return ApiRestResponse.success(pageInfo);
    }


    @ApiOperation(value = "导出Excel")
    @GetMapping("/exportList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<InsulationSensorInfoVO> memberList = InsulationSensorInfoService.exportList();
        ExportParams params = new ExportParams("保温温度信息", "保温温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InsulationSensorInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "保温温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @ApiOperation(value = "根据参数导出Excel")
    @PostMapping("/exportListByque")
    public void exportMemberListByQue(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestBody InsulationSensorInfoQue InsulationSensorInfoQue) {
        List<InsulationSensorInfoVO> memberList = InsulationSensorInfoService.exportListByQue(InsulationSensorInfoQue);
        ExportParams params = new ExportParams("保温温度信息", "保温温度信息", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, memberList);
        map.put(NormalExcelConstants.CLASS, InsulationSensorInfoVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "保温温度信息");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @ApiOperation("上传温度计分布图")
    @PostMapping( "/uploadTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse uploadTempMap(@RequestPart("file") MultipartFile upload,
                                         @RequestParam Integer dsNo,@RequestParam String name){
        String newFilePath = Constant.TEMP_MAP_PATH+dsNo+"-"+"3"+"-"+name+".png";
        TempMap tempMapCheck = tempMapMapper.selectBySbIdAndName(dsNo,name,"3");
        if(tempMapCheck!=null)
            throw new DamPourException(30000,"此仓已存在相同名称的图纸");
        try {
            upload.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            TempMap tempMap = new TempMap();
            tempMap.setType("3");
            tempMap.setSbId(dsNo);
            tempMap.setName(name);
            tempMap.setPath(dsNo+"-"+"3"+"-"+name+".png");
            tempMapMapper.insertSelective(tempMap);
            return ApiRestResponse.success();
        }catch(Exception e1){
            throw new DamPourException(30000,"上传失败");
        }
    }
    @ApiOperation("某仓下温度计分布图列表")
    @GetMapping( "/listTempMap")//测试的url接口
    @ResponseBody
    public ApiRestResponse listTempMap(@RequestParam Integer dsNo) {
        List<TempMap> tempMapList=tempMapMapper.listBySbId(dsNo,"3");
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
