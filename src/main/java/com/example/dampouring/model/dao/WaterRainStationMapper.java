package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterRainStation;
import com.example.dampouring.query.WaterRainStationQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterRainStationMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(WaterRainStation record);

    int insertSelective(WaterRainStation record);

    WaterRainStation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterRainStation record);

    int updateByPrimaryKey(WaterRainStation record);

    WaterRainStation selectByName(String wrsName);

    List<WaterRainStation> selectList();

    List<WaterRainStation> selectListByIds(@Param("ids") Integer[] ids);

    List<WaterRainStation> selectByQue(WaterRainStationQue waterRainStationQue);
}