package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempControlStandardNorm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempControlStandardNormMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlStandardNorm record);

    int insertSelective(TempControlStandardNorm record);

    TempControlStandardNorm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempControlStandardNorm record);

    int updateByPrimaryKey(TempControlStandardNorm record);

    List<TempControlStandardNorm> selectList();

    List<TempControlStandardNorm> selectListByIds(@Param("ids") Integer[] ids);

    TempControlStandardNorm selectByType(String type);
}