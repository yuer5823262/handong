package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SmartWarehouseNormMapper;
import com.example.dampouring.model.pojo.SmartWarehouseNorm;
import com.example.dampouring.model.request.AddSmartWarehouseNormReq;
import com.example.dampouring.model.request.UpdateSmartWarehouseNormReq;
import com.example.dampouring.service.SmartWarehouseNormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartWarehouseNormServiceImpl implements SmartWarehouseNormService {
    @Autowired
    SmartWarehouseNormMapper SmartWarehouseNormMapper;

    @Override
    public void add(AddSmartWarehouseNormReq addSmartWarehouseNormReq, String userName) {
        SmartWarehouseNorm SmartWarehouseNorm = new SmartWarehouseNorm();
        BeanUtils.copyProperties(addSmartWarehouseNormReq,SmartWarehouseNorm);
        int count = SmartWarehouseNormMapper.insertSelective(SmartWarehouseNorm);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateSmartWarehouseNormReq updateSmartWarehouseNormReq){
        SmartWarehouseNorm SmartWarehouseNorm =
                SmartWarehouseNormMapper.selectByPrimaryKey(updateSmartWarehouseNormReq.getId());
        if (SmartWarehouseNorm == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSmartWarehouseNormReq,SmartWarehouseNorm);

        int count = SmartWarehouseNormMapper.updateByPrimaryKeySelective(SmartWarehouseNorm);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SmartWarehouseNormMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmartWarehouseNorm> SmartWarehouseNormList = SmartWarehouseNormMapper.selectList();
        PageInfo pageInfo = new PageInfo(SmartWarehouseNormList);
        return pageInfo;
    }

}
