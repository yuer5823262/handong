package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartBwZero;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmartBwZeroMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartBwZero record);

    int insertSelective(SmartBwZero record);

    SmartBwZero selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartBwZero record);

    int updateByPrimaryKey(SmartBwZero record);

    List<SmartBwZero> selectList();

    void deleteAll();
}