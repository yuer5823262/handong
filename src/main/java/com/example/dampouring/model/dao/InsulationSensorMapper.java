package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InsulationSensor;
import com.example.dampouring.model.vo.InsulationSensorVO;
import com.example.dampouring.query.InsulationSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsulationSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(InsulationSensor record);

    int insertSelective(InsulationSensor record);

    InsulationSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsulationSensor record);

    int updateByPrimaryKey(InsulationSensor record);

    InsulationSensor selectByTempNo(String tempNo);

    List<InsulationSensorVO> selectList(InsulationSensorQue insulationSensorQue);

    List<InsulationSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    List<InsulationSensor> listByUseful();

    List<InsulationSensorVO> selectListByCuId(Integer id);
}