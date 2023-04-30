package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyTwoWater;
import com.example.dampouring.model.vo.DailyTwoWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DailyTwoWaterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyTwoWater record);

    int insertSelective(DailyTwoWater record);

    DailyTwoWater selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyTwoWater record);

    int updateByPrimaryKey(DailyTwoWater record);

    List<DailyTwoWaterVO> selectList(DailyPourTempQue dailyTwoWaterQue);

    List<DailyTwoWater> dailyTwoWater();
}