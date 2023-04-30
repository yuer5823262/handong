package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.query.AlertBaseQue;
import com.example.dampouring.service.AlertBaseService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertBaseServiceImpl implements AlertBaseService {
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo selectByAlertInfo(String alertInfo, AlertBaseQue alertBaseQue) {
        char[] chars = alertInfo.toCharArray();
        List<Integer> list =  new ArrayList<>();
        for(int i =0;i<chars.length;i++)
        {
            if(chars[i]=='1')
                list.add(i+1);
        }
        alertBaseQue.setAlertTypeList(list);
        PageHelper.startPage(alertBaseQue.getPageNum(), alertBaseQue.getPageSize());
        List<AlertBase> alertBaseList = alertBaseMapper.selectByAlertTypeList(alertBaseQue);
        PageInfo pageInfo = new PageInfo(alertBaseList);
        return pageInfo;
    }

    @Override
    public void processing(String uName, Integer type, String remark, Integer[] ids, Integer mark) {
        String time = TimeUtils.getNowTime();
        for(Integer id:ids)
        {
            AlertBase alertBase = alertBaseMapper.selectByPrimaryKey(id);
            if(alertBase==null) continue;
            if(mark == 0)
            {
                alertBase.setState(0);
                alertBase.setStandby1(uName);
                alertBase.setStandby2(remark);
            }
            else
            {
                if(type==1)
                {
                    alertBase.setOperator1(uName);
                    alertBase.setOpTime1(time);
                    alertBase.setRemark1(remark);
                }
                if(type==2)
                {
                    alertBase.setOperator2(uName);
                    alertBase.setRemark2(remark);
                    alertBase.setOpTime2(time);
                }
                if(type==3)
                {
                    alertBase.setOperator3(uName);
                    alertBase.setRemark3(remark);
                    alertBase.setOpTime3(time);
                }
                alertBase.setState(type);
            }
            alertBaseMapper.updateByPrimaryKeySelective(alertBase);
        }
    }
}
