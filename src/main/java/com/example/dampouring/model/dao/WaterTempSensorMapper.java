package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterTempSensor;
import com.example.dampouring.model.vo.WaterTempSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface WaterTempSensorMapper {


    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(WaterTempSensor record);

    int insertSelective(WaterTempSensor record);

    WaterTempSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterTempSensor record);

    int updateByPrimaryKey(WaterTempSensor record);

    List<WaterTempSensorVO> selectList();

    List<WaterTempSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    List<WaterTempSensor> selectListByCuId(Integer cuId);

    List<WaterTempSensor> listByUseful();

    List<WaterTempSensor> selectListByQue(WaterPressureSensorQue waterReversingDeviceQue);
}