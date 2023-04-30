package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterPressureSensor;
import com.example.dampouring.model.vo.WaterPressureSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterPressureSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(WaterPressureSensor record);

    int insertSelective(WaterPressureSensor record);

    WaterPressureSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterPressureSensor record);

    int updateByPrimaryKey(WaterPressureSensor record);

    List<WaterPressureSensorVO> selectList();

    List<WaterPressureSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    List<WaterPressureSensor> selectListByCuId(Integer cuId);

    List<WaterPressureSensor> selectByCuIdCNo(Integer cuId);

    List<WaterPressureSensorVO> selectListByQue(WaterPressureSensorQue waterReversingDeviceQue);
}