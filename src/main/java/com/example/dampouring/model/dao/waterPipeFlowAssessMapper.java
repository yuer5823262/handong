package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.waterPipeFlowAssess;
import com.example.dampouring.model.vo.WaterPipeFlowAssessVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface waterPipeFlowAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(waterPipeFlowAssess record);

    int insertSelective(waterPipeFlowAssess record);

    waterPipeFlowAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(waterPipeFlowAssess record);

    int updateByPrimaryKey(waterPipeFlowAssess record);

    List<WaterPipeFlowAssessVO> List();

    List<WaterPipeFlowAssessVO> selectList(WaterPipeFlowAssessQue waterPipeFlowAssessQue);

    void deleteAll();
}