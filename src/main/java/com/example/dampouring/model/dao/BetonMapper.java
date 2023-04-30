package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.Beton;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetonMapper {
    List<Beton> selectList();


    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(Beton record);

    int insertSelective(Beton record);

    Beton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Beton record);

    int updateByPrimaryKey(Beton record);
}