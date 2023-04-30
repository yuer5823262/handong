package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.query.WaterRainStationQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubControlStationMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SubControlStation record);

    int insertSelective(SubControlStation record);

    SubControlStation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubControlStation record);

    int updateByPrimaryKey(SubControlStation record);

    SubControlStation selectByScsNo(String scsNo);

    List<SubControlStation> selectList();

    List<SubControlStation> selectListByIds(@Param("ids") Integer[] ids);

    List<SubControlStation> selectByQue(WaterRainStationQue waterRainStationQue);
}