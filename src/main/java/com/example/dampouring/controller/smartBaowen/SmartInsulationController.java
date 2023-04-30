package com.example.dampouring.controller.smartBaowen;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.SmartBwAdviceVO;
import com.example.dampouring.query.SmartInsulationQue;
import com.example.dampouring.service.BetonService;
import com.example.dampouring.service.SmartInsulationService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RequestMapping("api/SmartInsulation")
@Controller
@Api(description = "智能保温")
public class SmartInsulationController {
    @Autowired
    SmartInsulationService SmartInsulationService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSmartInsulation(@RequestBody SmartInsulationQue SmartInsulationQue) {
        PageInfo pageInfo = SmartInsulationService.orUserSelect(SmartInsulationQue);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("智能保温结果")
    @GetMapping("/result")
    @ResponseBody
    public void result(@RequestParam Integer dmNo, @RequestParam Integer gc,@RequestParam Integer type, HttpServletResponse response) throws IOException {
        String filePath = Constant.SMART_BW_DATA_PATH+"yuntu"+"\\"+gc+"-"+dmNo+"-"+type+".png";
        OutputStream os = null;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new FileInputStream(new File(filePath)));
            response.setContentType("image/png");
            os = response.getOutputStream();
            if (image != null) {
                ImageIO.write(image, "png", os);
            }
        }
        catch (Exception e)
        {
            throw new DamPourException(30000,"不存在该分段云图及应力图");
        }
        finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
    }


    @ApiOperation("智能保温建议")
    @GetMapping("/smartBwAdvice")
    @ResponseBody
    public ApiRestResponse bwAdvice()
    {
        List<SmartBwAdviceVO> smartBwAdviceVOList = SmartInsulationService.bwAdvice();
        return ApiRestResponse.success(smartBwAdviceVOList);
    }


    @ApiOperation("智能保温气温信息")
    @GetMapping("/airTemp")
    @ResponseBody
    public ApiRestResponse airTemp()
    {
        List<TempMeasurementsAssess> tempMeasurementsAssessList = SmartInsulationService.getAirTemp();
        return ApiRestResponse.success(tempMeasurementsAssessList);
    }
}
