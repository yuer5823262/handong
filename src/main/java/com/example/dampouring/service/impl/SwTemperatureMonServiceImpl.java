package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SwTemperatureMonMapper;
import com.example.dampouring.model.pojo.SwTemperatureMon;
import com.example.dampouring.model.request.AddSwTemperatureMonReq;
import com.example.dampouring.model.request.UpdateSwTemperatureMonReq;
import com.example.dampouring.service.SwTemperatureMonService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwTemperatureMonServiceImpl implements SwTemperatureMonService {
    @Autowired
    com.example.dampouring.model.dao.SwTemperatureMonMapper SwTemperatureMonMapper;

    @Override
    public void add(AddSwTemperatureMonReq addSwTemperatureMonReq, String userName) {
        SwTemperatureMon SwTemperatureMon = new SwTemperatureMon();
        BeanUtils.copyProperties(addSwTemperatureMonReq,SwTemperatureMon);
        SwTemperatureMon.setOperator(userName);
        SwTemperatureMon.setCreateTime(TimeUtils.getNowTime());
        int count = SwTemperatureMonMapper.insertSelective(SwTemperatureMon);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSwTemperatureMonReq updateSwTemperatureMonReq){
        SwTemperatureMon SwTemperatureMon =
                SwTemperatureMonMapper.selectByPrimaryKey(updateSwTemperatureMonReq.getId());
        if (SwTemperatureMon == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSwTemperatureMonReq,SwTemperatureMon);

        int count = SwTemperatureMonMapper.updateByPrimaryKeySelective(SwTemperatureMon);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SwTemperatureMonMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SwTemperatureMon> SwTemperatureMonList = SwTemperatureMonMapper.selectList();
        PageInfo pageInfo = new PageInfo(SwTemperatureMonList);
        return pageInfo;
    }

    @Override
    public List<SwTemperatureMon> listByIds(Integer[] ids) {
        List<SwTemperatureMon> categoryList = SwTemperatureMonMapper.selectListByIds(ids);

        return categoryList;

    }
}
