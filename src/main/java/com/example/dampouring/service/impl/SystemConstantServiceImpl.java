package com.example.dampouring.service.impl;

import com.example.dampouring.StaticScheduleTask.SmartScheduleTask;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.SystemConstantMapper;
import com.example.dampouring.model.pojo.SystemConstant;
import com.example.dampouring.service.SystemConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemConstantServiceImpl implements SystemConstantService {
    @Autowired
    SystemConstantMapper systemConstantMapper;
    @Autowired
    SmartScheduleTask smartScheduleTask;

    @Override
    public void update(Integer id, String val) {
        SystemConstant systemConstant = new SystemConstant();
        systemConstant.setId(id);
        systemConstant.setVal(val);
        systemConstantMapper.updateByPrimaryKeySelective(systemConstant);
        setConsTantVal();
    }
    @Override
    public void setConsTantVal()
    {
        smartScheduleTask.addSmartTask();
        SystemConstant cityNo = systemConstantMapper.selectByType("天气预报城市号");
        SystemConstant ckNo = systemConstantMapper.selectByType("采集串口号");
        SystemConstant getDataSlot = systemConstantMapper.selectByType("采集时间间隔");
        SystemConstant mqIp = systemConstantMapper.selectByType("mqIp");
        Constant.p = Short.parseShort(ckNo.getVal());
        Constant.cityNo = cityNo.getVal();
        Constant.getDataSlot = Integer.parseInt(getDataSlot.getVal());
        Constant.mqIp=mqIp.getVal();
        Constant.openPort();

    }
    @Override
    public List<SystemConstant> orUserList() {
        List<SystemConstant> systemConstants = systemConstantMapper.selectList();
        return systemConstants;
    }

    @Override
    public SystemConstant selectByType(String type) {
        SystemConstant systemConstant = systemConstantMapper.selectByType(type);
        return systemConstant;
    }

    @Override
    public String getSystemName() {
        SystemConstant systemConstant = systemConstantMapper.selectByType("系统名称");
        return systemConstant.getVal();
    }
}
