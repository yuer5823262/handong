package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SwConcreteParaMapper;
import com.example.dampouring.model.pojo.SwConcretePara;
import com.example.dampouring.model.request.AddSwConcreteParaReq;
import com.example.dampouring.model.request.UpdateSwConcreteParaReq;
import com.example.dampouring.service.SwConcreteParaService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwConcreteParaServiceImpl implements SwConcreteParaService {
    @Autowired
    com.example.dampouring.model.dao.SwConcreteParaMapper SwConcreteParaMapper;

    @Override
    public void add(AddSwConcreteParaReq addSwConcreteParaReq, String userName) {
        SwConcretePara SwConcretePara = new SwConcretePara();
        BeanUtils.copyProperties(addSwConcreteParaReq,SwConcretePara);
        SwConcretePara.setOperator(userName);
        SwConcretePara.setCreateTime(TimeUtils.getNowTime());
        int count = SwConcreteParaMapper.insertSelective(SwConcretePara);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSwConcreteParaReq updateSwConcreteParaReq){
        SwConcretePara SwConcretePara =
                SwConcreteParaMapper.selectByPrimaryKey(updateSwConcreteParaReq.getId());
        if (SwConcretePara == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSwConcreteParaReq,SwConcretePara);

        int count = SwConcreteParaMapper.updateByPrimaryKeySelective(SwConcretePara);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SwConcreteParaMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SwConcretePara> SwConcreteParaList = SwConcreteParaMapper.selectList();
        PageInfo pageInfo = new PageInfo(SwConcreteParaList);
        return pageInfo;
    }

    @Override
    public List<SwConcretePara> listByIds(Integer[] ids) {
        List<SwConcretePara> categoryList = SwConcreteParaMapper.selectListByIds(ids);

        return categoryList;

    }
}
