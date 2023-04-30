package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.MaintainMapper;
import com.example.dampouring.model.pojo.Maintain;
import com.example.dampouring.model.request.AddMaintainReq;
import com.example.dampouring.model.request.UpdateMaintainReq;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.query.MaintainQue;
import com.example.dampouring.service.MaintainService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    MaintainMapper maintainMapper;

    @Override
    public void add(AddMaintainReq addMaintainReq, String userName) {
        Maintain Maintain = new Maintain();
        BeanUtils.copyProperties(addMaintainReq,Maintain);
        Maintain.setOperator(userName);
        Maintain.setCreateTime(TimeUtils.getNowTime());
        int count = maintainMapper.insertSelective(Maintain);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateMaintainReq updateMaintainReq){
        Maintain Maintain =
                maintainMapper.selectByPrimaryKey(updateMaintainReq.getId());
        if (Maintain == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateMaintainReq,Maintain);

        int count = maintainMapper.updateByPrimaryKeySelective(Maintain);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = maintainMapper.deleteByPrimaryKey(ids);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MaintainVO> maintainList = maintainMapper.selectList();
        PageInfo pageInfo = new PageInfo(maintainList);
        return pageInfo;
    }

    @Override
    public List<MaintainVO> listByIds(Integer[] ids) {
        List<MaintainVO> categoryList = maintainMapper.selectListByIds(ids);
        return categoryList;

    }

    @Override
    public PageInfo selectByQue(MaintainQue maintainQue) {
        PageHelper.startPage(maintainQue.getPageNum(), maintainQue.getPageSize());
        List<MaintainVO> maintainVOS = maintainMapper.selectListByQue(maintainQue);
        for (MaintainVO maintainVO : maintainVOS) {
            maintainVO.setWarmIntervalByWarmTime();
        }
        PageInfo pageInfo = new PageInfo(maintainVOS);
        return pageInfo;
    }

    @Override
    public List<MaintainVO> exportList() {
        List<MaintainVO> maintainList = maintainMapper.selectList();

        return maintainList;
    }
}
