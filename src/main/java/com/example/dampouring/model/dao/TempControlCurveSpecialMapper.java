package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempControlCurveSpecial;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempControlCurveSpecialMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlCurveSpecial record);

    int insertSelective(TempControlCurveSpecial record);

    TempControlCurveSpecial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempControlCurveSpecial record);

    int updateByPrimaryKey(TempControlCurveSpecial record);

    List<TempControlCurveSpecial> selectList();

    List<TempControlCurveSpecial> selectListByIds(@Param("ids") Integer[] ids);
}