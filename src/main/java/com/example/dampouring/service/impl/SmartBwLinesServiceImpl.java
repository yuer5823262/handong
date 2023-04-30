package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.SmartBwLinesMapper;
import com.example.dampouring.model.pojo.SmartBwLines;
import com.example.dampouring.service.SmartBwLinesService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SmartBwLinesServiceImpl implements SmartBwLinesService {
    @Autowired
    com.example.dampouring.model.dao.SmartBwLinesMapper SmartBwLinesMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize, String dsNo) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmartBwLines> SwBataList = SmartBwLinesMapper.selectList(dsNo);
        PageInfo pageInfo = new PageInfo(SwBataList);
        return pageInfo;
    }



    @Override
    public void getDateInsert() {
        SmartBwLinesMapper.deleteAll();
        String fileName = Constant.SMART_BW_DATA_PATH+"LINES.DAT";
        List<List<Double>> dataResult = new ArrayList<>();
        try {
            dataResult = DatUtils.getLinesDouble(fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
        String damNo=null;
        Integer qk = 0;
        for(List<Double> doubles:dataResult)
        {
            if(doubles.size()==2){
                damNo = doubles.get(0).intValue()+"";
                qk = doubles.get(1).intValue();
            }
            else {
                SmartBwLines smartBwLines = new SmartBwLines();
                smartBwLines.setDsName(damNo);
                smartBwLines.setQk(qk);
                String time = TimeUtils.intToTime(doubles.get(1).intValue(),doubles.get(2).intValue(),
                        doubles.get(3).intValue(),
                        doubles.get(4).intValue(),doubles.get(5).intValue());
                smartBwLines.setTime(time);
                smartBwLines.setAge(doubles.get(6));
                smartBwLines.setYl1(doubles.get(8));
                smartBwLines.setTemp1(doubles.get(7));
                smartBwLines.setFactor1(doubles.get(9));
                smartBwLines.setYl2(doubles.get(11));
                smartBwLines.setTemp2(doubles.get(10));
                smartBwLines.setFactor2(doubles.get(12));
                smartBwLines.setYl3(doubles.get(14));
                smartBwLines.setTemp3(doubles.get(13));
                smartBwLines.setFactor3(doubles.get(15));
                smartBwLines.setYl4(doubles.get(17));
                smartBwLines.setTemp4(doubles.get(16));
                smartBwLines.setFactor4(doubles.get(18));
                SmartBwLinesMapper.insertSelective(smartBwLines);
            }
        }
    }
}
