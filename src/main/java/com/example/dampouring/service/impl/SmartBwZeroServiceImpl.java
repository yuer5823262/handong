package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.SmartBwBwres;
import com.example.dampouring.model.pojo.SmartBwZero;
import com.example.dampouring.service.SmartBwZeroService;
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
public class SmartBwZeroServiceImpl implements SmartBwZeroService {
    @Autowired
    com.example.dampouring.model.dao.SmartBwZeroMapper SmartBwZeroMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmartBwZero> SwBataList = SmartBwZeroMapper.selectList();
        PageInfo pageInfo = new PageInfo(SwBataList);
        return pageInfo;
    }

    @Override
    public void getDateInsert() {
        SmartBwZeroMapper.deleteAll();
        String time = TimeUtils.getNowTime();
        String fileName = Constant.SMART_BW_DATA_PATH+"ZEROS.DAT";
        List<List<Integer>> dataResult = new ArrayList<>();
        try {
            dataResult = DatUtils.getLinesInt(fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
        String damNo=null;
        int mark = 1;

        for(List<Integer> integers:dataResult)
        {
            if(mark==1) {
                damNo = integers.get(0)+"";
                mark = 0;
            }
            else {
                SmartBwZero smartBwZero = new SmartBwZero();
                smartBwZero.setDsName(damNo);
                smartBwZero.setPiles(integers.get(0));
                smartBwZero.setTime(time);
                SmartBwZeroMapper.insertSelective(smartBwZero);
                mark =1;
            }
        }
    }
}
