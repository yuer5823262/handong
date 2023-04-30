package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SystemConstant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemConstantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConstant record);

    int insertSelective(SystemConstant record);

    SystemConstant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConstant record);

    int updateByPrimaryKey(SystemConstant record);

    List<SystemConstant> selectList();

    SystemConstant selectByType(String type);
}