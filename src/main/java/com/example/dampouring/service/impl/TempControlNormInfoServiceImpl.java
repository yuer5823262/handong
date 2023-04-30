package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.TempControlNormInfo;
import com.example.dampouring.model.request.AddTempControlNormInfoReq;
import com.example.dampouring.model.request.UpdateTempControlNormInfoReq;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.example.dampouring.service.TempControlNormInfoService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempControlNormInfoServiceImpl implements TempControlNormInfoService {
    @Autowired
    com.example.dampouring.model.dao.TempControlNormInfoMapper TempControlNormInfoMapper;

    @Override
    public void add(AddTempControlNormInfoReq addTempControlNormInfoReq, String userName) {
        TempControlNormInfo TempControlNormInfo = new TempControlNormInfo();
        BeanUtils.copyProperties(addTempControlNormInfoReq,TempControlNormInfo);
        TempControlNormInfo.setOperator(userName);
        TempControlNormInfo.setCreateTime(TimeUtils.getNowTime());
        int count = TempControlNormInfoMapper.insertSelective(TempControlNormInfo);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlNormInfoReq updateTempControlNormInfoReq){
        TempControlNormInfo TempControlNormInfo =
                TempControlNormInfoMapper.selectByPrimaryKey(updateTempControlNormInfoReq.getId());
        if (TempControlNormInfo == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlNormInfoReq,TempControlNormInfo);

        int count = TempControlNormInfoMapper.updateByPrimaryKeySelective(TempControlNormInfo);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlNormInfoMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempControlNormInfoVO> TempControlNormInfoList = TempControlNormInfoMapper.selectList();
        PageInfo pageInfo = new PageInfo(TempControlNormInfoList);
        return pageInfo;
    }

    @Override
    public List<TempControlNormInfoVO> listByIds(Integer[] ids) {
        List<TempControlNormInfoVO> categoryList = TempControlNormInfoMapper.selectListByIds(ids);

        return categoryList;

    }
}
