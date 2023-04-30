package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.TempMeasurementsAssessMapper;
import com.example.dampouring.model.dao.TempMeasurementsMapper;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.query.TempMeasurementsAssessQue;
import com.example.dampouring.service.TempMeasurementsAssessService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TempMeasurementsAssessServiceImpl implements TempMeasurementsAssessService {
    @Autowired
    TempMeasurementsAssessMapper TempMeasurementsAssessMapper;
    @Autowired
    TempMeasurementsMapper tempMeasurementsMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempMeasurementsAssess> TempMeasurementsAssess = TempMeasurementsAssessMapper.List();
        PageInfo pageInfo = new PageInfo(TempMeasurementsAssess);
        return pageInfo;
    }

    @Override
    public PageInfo orUserSelect(TempMeasurementsAssessQue TempMeasurementsAssessQue) {
        PageHelper.startPage(TempMeasurementsAssessQue.getPageNum(), TempMeasurementsAssessQue.getPageSize());
        List<TempMeasurementsAssess> TempMeasurementsAssess = TempMeasurementsAssessMapper.selectList(TempMeasurementsAssessQue);
        if(TempMeasurementsAssessQue.getPageNum()==1)
        {
            TempMeasurementsAssess todayAssess = TempMeasurementsAssessMapper.selectToDay();
            if(todayAssess!=null) TempMeasurementsAssess.add(0,todayAssess);
        }
        PageInfo pageInfo = new PageInfo(TempMeasurementsAssess);
        return pageInfo;
    }



    @Override
    public void  timingComputing() {
        try {
            String today = TimeUtils.getNextDay(-1);
            String yesterday = TimeUtils.getNextDay(-2);
            String yesterday1 = TimeUtils.getNextDay(-3);
            String yesterday2 = TimeUtils.getNextDay(-4);
            TempMeasurementsAssess tempMeasurementsAssess = tempMeasurementsMapper.AssessComputing(today);
            if (tempMeasurementsAssess == null) return;
            List<TempMeasurementsAssess> tempMeasurementsAssessOld = TempMeasurementsAssessMapper.selectByOld3Day(yesterday,yesterday1,yesterday2);
            Double temp = tempMeasurementsAssess.getAvgTemp();
            List<Double> valList = new ArrayList<>();
            tempMeasurementsAssessOld.forEach(t->valList.add(t.getAvgTemp()));
            valList.add(temp);
            Double lessTemp=0.;
            for(int i = 0;i<valList.size()-1;i++)
            {
                lessTemp=lessTemp+valList.get(i)-valList.get(i+1);
                lessTemp = lessTemp>0?lessTemp:0.;
            }
            tempMeasurementsAssess.setLessTemp(lessTemp);
            TempMeasurementsAssessMapper.insertSelective(tempMeasurementsAssess);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }


    }

    @Override
    public List<TempMeasurementsAssess> exportList() {
        List<TempMeasurementsAssess> TempMeasurementsAssess = TempMeasurementsAssessMapper.List();
        return TempMeasurementsAssess;
    }
}
