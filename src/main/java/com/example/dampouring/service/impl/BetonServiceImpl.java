package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.BetonMapper;
import com.example.dampouring.model.pojo.Beton;
import com.example.dampouring.model.request.AddBetonReq;
import com.example.dampouring.model.request.UpdateBetonReq;
import com.example.dampouring.service.BetonService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetonServiceImpl implements BetonService {
    @Autowired
    BetonMapper betonMapper;

    @Override
    public void add(AddBetonReq addBetonReq, String userName) {
        Beton Beton = new Beton();
        BeanUtils.copyProperties(addBetonReq,Beton);
        Beton.setOperator(userName);
        Beton.setCreateTime(TimeUtils.getNowTime());
        int count = betonMapper.insertSelective(Beton);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateBetonReq updateBetonReq){
        Beton Beton =
                betonMapper.selectByPrimaryKey(updateBetonReq.getId());
        if (Beton == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
//        Beton BetonCheck =
//                betonMapper.selectByName(updateBetonReq.getBsName());
//        if (BetonCheck != null &&
//                !BetonCheck.getBsNo().equals(Beton.getBsNo()) ) {
//
//            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
//        }
        BeanUtils.copyProperties(updateBetonReq,Beton);

        int count = betonMapper.updateByPrimaryKeySelective(Beton);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = betonMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<Beton> orUserList() {

        List<Beton> BetonList = betonMapper.selectList();
        return BetonList;
    }
}
