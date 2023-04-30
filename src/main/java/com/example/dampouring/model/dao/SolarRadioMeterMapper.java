package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SolarRadioMeter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolarRadioMeterMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SolarRadioMeter record);

    int insertSelective(SolarRadioMeter record);

    SolarRadioMeter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SolarRadioMeter record);

    int updateByPrimaryKey(SolarRadioMeter record);

    SolarRadioMeter selectByNo(String no);

    List<SolarRadioMeter> selectList();

    List<SolarRadioMeter> selectListByIds(@Param("ids") Integer[] ids);
}