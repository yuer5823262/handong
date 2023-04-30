package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SmallStorageBinMapper;
import com.example.dampouring.model.dao.StorageBinExcludeMapper;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.StorageBinExclude;
import com.example.dampouring.model.request.AddStorageBinExcludeReq;
import com.example.dampouring.model.request.UpdateStorageBinExcludeReq;
import com.example.dampouring.model.vo.StorageBinExcludeVO;
import com.example.dampouring.query.StorageBinExcludeQue;
import com.example.dampouring.service.StorageBinExcludeService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageBinExcludeServiceImpl implements StorageBinExcludeService {
    @Autowired
    StorageBinExcludeMapper StorageBinExcludeMapper;
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @Override
    public void add(AddStorageBinExcludeReq addStorageBinExcludeReq, String userName) {
        StorageBinExclude StorageBinExclude = new StorageBinExclude();
        BeanUtils.copyProperties(addStorageBinExcludeReq,StorageBinExclude);
        StorageBinExclude.setOperator(userName);
        StorageBinExclude.setTime(TimeUtils.getNowTime());
        SmallStorageBin smallStorageBin = new SmallStorageBin();
        smallStorageBin.setId(StorageBinExclude.getSmallSbId());
        if(StorageBinExclude.getType().equals("noData"))
            smallStorageBin.setIsCalculate("0");
        if(StorageBinExclude.getType().equals("noWarn"))
            smallStorageBin.setIsAlert("0");
        if(StorageBinExclude.getType().equals("noColl"))
            smallStorageBin.setIsGetWater("0");
        if(StorageBinExclude.getType().equals("noCalc"))
            smallStorageBin.setIsComputer("0");
        smallStorageBinMapper.updateByPrimaryKeySelective(smallStorageBin);

        int count = StorageBinExcludeMapper.insertSelective(StorageBinExclude);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateStorageBinExcludeReq updateStorageBinExcludeReq){
        StorageBinExclude StorageBinExclude =
                StorageBinExcludeMapper.selectByPrimaryKey(updateStorageBinExcludeReq.getId());
        if (StorageBinExclude == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateStorageBinExcludeReq,StorageBinExclude);

        int count = StorageBinExcludeMapper.updateByPrimaryKeySelective(StorageBinExclude);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        for(Integer id:ids)
        {
            StorageBinExclude StorageBinExclude = StorageBinExcludeMapper.selectByPrimaryKey(id);
            SmallStorageBin smallStorageBin = new SmallStorageBin();
            smallStorageBin.setId(StorageBinExclude.getSmallSbId());
            if(StorageBinExclude.getType().equals("noData"))
                smallStorageBin.setIsCalculate("1");
            if(StorageBinExclude.getType().equals("noWarn"))
                smallStorageBin.setIsAlert("1");
            if(StorageBinExclude.getType().equals("noColl"))
                smallStorageBin.setIsGetWater("1");
            if(StorageBinExclude.getType().equals("noCalc"))
                smallStorageBin.setIsComputer("1");
            smallStorageBinMapper.updateByPrimaryKeySelective(smallStorageBin);
        }
        int count = StorageBinExcludeMapper.deleteByPrimaryKey(ids);

        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(StorageBinExcludeQue storageBinExcludeQue) {
        PageHelper.startPage(storageBinExcludeQue.getPageNum(), storageBinExcludeQue.getPageSize());
        List<StorageBinExcludeVO> StorageBinExcludeList = StorageBinExcludeMapper.selectList(storageBinExcludeQue);
        PageInfo pageInfo = new PageInfo(StorageBinExcludeList);
        return pageInfo;
    }

    @Override
    public List<StorageBinExcludeVO> listByIds(Integer[] ids) {
        List<StorageBinExcludeVO> categoryList = StorageBinExcludeMapper.selectListByIds(ids);

        return categoryList;

    }
}
