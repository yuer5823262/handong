package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.SbTempNorm;
import com.example.dampouring.model.pojo.YmAvgTemp;
import com.example.dampouring.model.request.AddSbTempNormReq;
import com.example.dampouring.model.request.UpdateSbTempNormReq;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.SbTempNormQue;
import com.example.dampouring.service.SbTempNormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SbTempNormServiceImpl implements SbTempNormService {
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Override
    public void update(UpdateSbTempNormReq updateSbTempNormReq) {
        SbTempNorm sbTempNorm = new SbTempNorm();
        BeanUtils.copyProperties(updateSbTempNormReq,sbTempNorm);
        sbTempNormMapper.updateByPrimaryKeySelective(sbTempNorm);
    }

    @Override
    public PageInfo orUserList(SbTempNormQue sbTempNormQue) {
        PageHelper.startPage(sbTempNormQue.getPageNum(), sbTempNormQue.getPageSize());
        List<SbTempNormVO> sbTempNormList = sbTempNormMapper.List(sbTempNormQue);
        PageInfo pageInfo = new PageInfo(sbTempNormList);
        return pageInfo;
    }

    @Override
    public List<SbTempNormVO> listByIds(Integer[] ids) {
        List<SbTempNormVO> sbTempNormVOList = sbTempNormMapper.selectByIds(ids);
        return sbTempNormVOList;
    }

    @Override
    public void add(AddSbTempNormReq addSbTempNormReq) {
        SbTempNorm sbTempNorm = new SbTempNorm();
        BeanUtils.copyProperties(addSbTempNormReq,sbTempNorm);
        sbTempNormMapper.insertSelective(sbTempNorm);
    }

}
