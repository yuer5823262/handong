package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartWarehouseNorm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartWarehouseNormMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SmartWarehouseNorm record);

    int insertSelective(SmartWarehouseNorm record);

    SmartWarehouseNorm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartWarehouseNorm record);

    int updateByPrimaryKey(SmartWarehouseNorm record);

    List<SmartWarehouseNorm> selectList();
}