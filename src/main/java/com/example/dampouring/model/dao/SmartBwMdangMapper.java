package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartBwMdang;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmartBwMdangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartBwMdang record);

    int insertSelective(SmartBwMdang record);

    SmartBwMdang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartBwMdang record);

    int updateByPrimaryKey(SmartBwMdang record);

    List<SmartBwMdang> selectList();

    void deleteAll();
}