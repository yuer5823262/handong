package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartBwLines;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmartBwLinesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartBwLines record);

    int insertSelective(SmartBwLines record);

    SmartBwLines selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartBwLines record);

    int updateByPrimaryKey(SmartBwLines record);

    List<SmartBwLines> selectList(String dsNo);

    void deleteAll();
}