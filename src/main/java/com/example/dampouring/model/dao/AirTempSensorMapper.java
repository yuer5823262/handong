package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.AirTempSensor;
import com.example.dampouring.model.vo.AirTempSensorVO;
import com.example.dampouring.query.AirTempSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirTempSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(AirTempSensor record);

    int insertSelective(AirTempSensor record);

    AirTempSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirTempSensor record);

    int updateByPrimaryKey(AirTempSensor record);

    List<AirTempSensorVO> selectList();

    List<AirTempSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    AirTempSensor selectByCuId(Integer cuId);

    List<AirTempSensor> selectByCuIdCNo(Integer cuId, Integer channelNo);

    List<AirTempSensor> list();

    List<AirTempSensorVO> selectListByQue(AirTempSensorQue airTempSensorQue);
}