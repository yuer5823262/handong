package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartFlowResult;
import com.example.dampouring.query.SmartFlowResultQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartFlowResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartFlowResult record);

    int insertSelective(SmartFlowResult record);

    SmartFlowResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartFlowResult record);

    int updateByPrimaryKey(SmartFlowResult record);

    List<SmartFlowResult> selectList(SmartFlowResultQue smartFlowResultQue);
}