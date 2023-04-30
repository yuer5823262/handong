package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.TempControlPartition;
import com.example.dampouring.model.request.AddTempControlPartitionReq;
import com.example.dampouring.model.request.UpdateTempControlPartitionReq;
import com.example.dampouring.model.vo.TempControlPartitionVO;
import com.example.dampouring.service.TempControlPartitionService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempControlPartitionServiceImpl implements TempControlPartitionService {
    @Autowired
    com.example.dampouring.model.dao.TempControlPartitionMapper TempControlPartitionMapper;

    @Override
    public void add(AddTempControlPartitionReq addTempControlPartitionReq, String userName) {
        TempControlPartition TempControlPartition = new TempControlPartition();
        BeanUtils.copyProperties(addTempControlPartitionReq,TempControlPartition);
        TempControlPartition.setOperator(userName);
        TempControlPartition.setCreateTime(TimeUtils.getNowTime());
        int count = TempControlPartitionMapper.insertSelective(TempControlPartition);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlPartitionReq updateTempControlPartitionReq){
        TempControlPartition TempControlPartition =
                TempControlPartitionMapper.selectByPrimaryKey(updateTempControlPartitionReq.getId());
        if (TempControlPartition == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlPartitionReq,TempControlPartition);

        int count = TempControlPartitionMapper.updateByPrimaryKeySelective(TempControlPartition);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlPartitionMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempControlPartitionVO> TempControlPartitionList = TempControlPartitionMapper.selectList();
        PageInfo pageInfo = new PageInfo(TempControlPartitionList);
        return pageInfo;
    }

    @Override
    public List<TempControlPartitionVO> listByIds(Integer[] ids) {
        List<TempControlPartitionVO> categoryList = TempControlPartitionMapper.selectListByIds(ids);

        return categoryList;

    }
}
