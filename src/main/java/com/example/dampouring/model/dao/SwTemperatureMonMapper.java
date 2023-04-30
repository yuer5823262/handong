package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SwTemperatureMon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwTemperatureMonMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SwTemperatureMon record);

    int insertSelective(SwTemperatureMon record);

    SwTemperatureMon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwTemperatureMon record);

    int updateByPrimaryKey(SwTemperatureMon record);

    List<SwTemperatureMon> selectList();

    List<SwTemperatureMon> selectListByIds(@Param("ids") Integer[] ids);
}