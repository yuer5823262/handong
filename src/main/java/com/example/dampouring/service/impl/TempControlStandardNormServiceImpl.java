package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.TempControlStandardNormMapper;
import com.example.dampouring.model.pojo.TempControlStandardNorm;
import com.example.dampouring.model.request.AddTempControlStandardNormReq;
import com.example.dampouring.model.request.UpdateTempControlStandardNormReq;
import com.example.dampouring.service.TempControlStandardNormService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempControlStandardNormServiceImpl implements TempControlStandardNormService {
    @Autowired
    TempControlStandardNormMapper TempControlStandardNormMapper;

    @Override
    public void add(AddTempControlStandardNormReq addTempControlStandardNormReq, String userName) {
        TempControlStandardNorm TempControlStandardNorm = new TempControlStandardNorm();
        BeanUtils.copyProperties(addTempControlStandardNormReq,TempControlStandardNorm);
        TempControlStandardNorm.setOperator(userName);
        TempControlStandardNorm.setCreateTime(TimeUtils.getNowTime());
        int count = TempControlStandardNormMapper.insertSelective(TempControlStandardNorm);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlStandardNormReq updateTempControlStandardNormReq){
        TempControlStandardNorm TempControlStandardNorm =
                TempControlStandardNormMapper.selectByPrimaryKey(updateTempControlStandardNormReq.getId());
        if (TempControlStandardNorm == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlStandardNormReq,TempControlStandardNorm);

        int count = TempControlStandardNormMapper.updateByPrimaryKeySelective(TempControlStandardNorm);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlStandardNormMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempControlStandardNorm> TempControlStandardNormList = TempControlStandardNormMapper.selectList();
        PageInfo pageInfo = new PageInfo(TempControlStandardNormList);
        return pageInfo;
    }

    @Override
    public List<TempControlStandardNorm> listByIds(Integer[] ids) {
        List<TempControlStandardNorm> categoryList = TempControlStandardNormMapper.selectListByIds(ids);

        return categoryList;

    }
}
