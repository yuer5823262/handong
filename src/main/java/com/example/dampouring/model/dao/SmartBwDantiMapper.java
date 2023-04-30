package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartBwDanti;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartBwDantiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartBwDanti record);

    int insertSelective(SmartBwDanti record);

    SmartBwDanti selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartBwDanti record);

    int updateByPrimaryKey(SmartBwDanti record);

    List<SmartBwDanti> selectList(String dsNo);

    void deleteAll();
}