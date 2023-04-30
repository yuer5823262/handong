package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartBwBwres;
import com.example.dampouring.model.pojo.SwBata;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmartBwBwresMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartBwBwres record);

    int insertSelective(SmartBwBwres record);

    SmartBwBwres selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartBwBwres record);

    int updateByPrimaryKey(SmartBwBwres record);

    List<SmartBwBwres> selectList(String dsNo);

    void deleteAll();
}