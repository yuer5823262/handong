package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.SmartBwDanti;
import com.example.dampouring.service.SmartBwDantiService;
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
public class SmartBwDantiServiceImpl implements SmartBwDantiService {
    @Autowired
    com.example.dampouring.model.dao.SmartBwDantiMapper SmartBwDantiMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize, String dsNo) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmartBwDanti> SwBataList = SmartBwDantiMapper.selectList(dsNo);
        PageInfo pageInfo = new PageInfo(SwBataList);
        return pageInfo;
    }


    @Override
    public void getDateInsert() {
        SmartBwDantiMapper.deleteAll();
        String fileName = Constant.SMART_BW_DATA_PATH+"DANTI.DAT";
        List<List<Integer>> dataResult = new ArrayList<>();
        try {
            dataResult = DatUtils.getLinesInt(fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
        String damNo=null;
        Integer gk=1;
        for(List<Integer> integers:dataResult)
        {
            if(integers.size()==1)
            {
                damNo = integers.get(0)+"";
                gk = 1;
            }
            else {
                SmartBwDanti smartBwDanti = new SmartBwDanti();
                smartBwDanti.setDsName(damNo);
                String time = TimeUtils.intToTime(integers.get(1),integers.get(2),integers.get(3),
                        integers.get(4),integers.get(5));
                smartBwDanti.setTime(time);
                smartBwDanti.setGk(gk);
                SmartBwDantiMapper.insertSelective(smartBwDanti);
                gk++;
            }
        }
    }
}
