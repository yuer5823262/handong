package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SwConcretePara;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwConcreteParaMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] id);

    int insert(SwConcretePara record);

    int insertSelective(SwConcretePara record);

    SwConcretePara selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwConcretePara record);

    int updateByPrimaryKey(SwConcretePara record);

    List<SwConcretePara> selectList();

    List<SwConcretePara> selectListByIds(@Param("ids") Integer[] ids);
}