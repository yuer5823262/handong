package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.smartWarehouseInfo;
import com.example.dampouring.query.SmartWarehouseInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface smartWarehouseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(smartWarehouseInfo record);

    int insertSelective(smartWarehouseInfo record);

    smartWarehouseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(smartWarehouseInfo record);

    int updateByPrimaryKey(smartWarehouseInfo record);

    List<smartWarehouseInfo> selectList(SmartWarehouseInfoQue smartWarehouseInfoQue);
}