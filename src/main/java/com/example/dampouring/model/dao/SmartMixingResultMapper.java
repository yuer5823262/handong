package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartMixingResult;
import com.example.dampouring.query.SmartMixingResultQue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SmartMixingResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartMixingResult record);

    int insertSelective(SmartMixingResult record);

    SmartMixingResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartMixingResult record);

    int updateByPrimaryKey(SmartMixingResult record);

//    List<SmartMixingResult> result(SmartMixingResultQue smartMixingResultQue);

    List<SmartMixingResult> selectList(SmartMixingResultQue smartMixingResultQue);

    SmartMixingResult getTemp(String no);
}