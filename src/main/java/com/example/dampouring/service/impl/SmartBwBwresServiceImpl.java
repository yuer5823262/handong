package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.SmartBwBwres;
import com.example.dampouring.service.SmartBwBwresService;
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
public class SmartBwBwresServiceImpl implements SmartBwBwresService {
    @Autowired
    com.example.dampouring.model.dao.SmartBwBwresMapper SmartBwBwresMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize, String dsNo) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmartBwBwres> SwBataList = SmartBwBwresMapper.selectList(dsNo);
        PageInfo pageInfo = new PageInfo(SwBataList);
        return pageInfo;
    }

    @Override
    public void getDateInsert() {
        SmartBwBwresMapper.deleteAll();
        String fileName = Constant.SMART_BW_DATA_PATH+ "BWRES.DAT";
        List<List<Integer>> dataResult = new ArrayList<>();
        try {
            dataResult = DatUtils.getLinesInt(fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
        String damNo=null;
        for(List<Integer> integers:dataResult)
        {
            if(integers.size()==1) damNo = integers.get(0)+"";
            else {
                SmartBwBwres smartBwBwres = new SmartBwBwres();
                smartBwBwres.setDsName(damNo);
                String time = TimeUtils.intToTime(integers.get(1),integers.get(2),integers.get(3),
                        integers.get(4),integers.get(5));
                smartBwBwres.setTime(time);
                smartBwBwres.setPlies(integers.get(6));
                SmartBwBwresMapper.insertSelective(smartBwBwres);
            }
        }
    }
}
