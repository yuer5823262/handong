package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempControlCurveCommon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempControlCurveCommonMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlCurveCommon record);

    int insertSelective(TempControlCurveCommon record);

    TempControlCurveCommon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempControlCurveCommon record);

    int updateByPrimaryKey(TempControlCurveCommon record);

    List<TempControlCurveCommon> selectList();

    List<TempControlCurveCommon> selectListByIds(@Param("ids") Integer[] ids);

    TempControlCurveCommon selectBySbId(Integer sbId);
}