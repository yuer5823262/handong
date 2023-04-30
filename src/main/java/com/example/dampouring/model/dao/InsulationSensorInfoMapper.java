package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InsulationSensorInfo;
import com.example.dampouring.model.vo.InsulationSensorInfoVO;
import com.example.dampouring.query.InsulationSensorInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsulationSensorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsulationSensorInfo record);

    int insertSelective(InsulationSensorInfo record);

    InsulationSensorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsulationSensorInfo record);

    int updateByPrimaryKey(InsulationSensorInfo record);

    List<InsulationSensorInfoVO> selectList(InsulationSensorInfoQue insulationSensorInfoQue);

    List<InsulationSensorInfoVO> List();
}