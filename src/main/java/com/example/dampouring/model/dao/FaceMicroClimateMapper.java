package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.FaceMicroClimate;
import com.example.dampouring.query.WaterRainStationQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceMicroClimateMapper {


    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(FaceMicroClimate record);

    int insertSelective(FaceMicroClimate record);

    FaceMicroClimate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaceMicroClimate record);

    int updateByPrimaryKey(FaceMicroClimate record);

    FaceMicroClimate selectByDeviceNo(String deviceNo);

    List<FaceMicroClimate> selectList();

    List<FaceMicroClimate> selectListByIds(@Param("ids") Integer[] ids);

    List<FaceMicroClimate> selectByQue(WaterRainStationQue waterRainStationQue);
}