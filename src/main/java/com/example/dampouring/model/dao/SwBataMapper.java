package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SwBata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwBataMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] id);

    int insert(SwBata record);

    int insertSelective(SwBata record);

    SwBata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwBata record);

    int updateByPrimaryKey(SwBata record);

    List<SwBata> selectList();

    List<SwBata> selectListByIds(@Param("ids") Integer[] ids);
}