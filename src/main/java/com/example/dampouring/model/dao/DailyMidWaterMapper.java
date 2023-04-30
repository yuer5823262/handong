package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyMidWater;
import com.example.dampouring.model.vo.DailyMidWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyMidWaterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyMidWater record);

    int insertSelective(DailyMidWater record);

    DailyMidWater selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyMidWater record);

    int updateByPrimaryKey(DailyMidWater record);

    List<DailyMidWaterVO> selectList(DailyPourTempQue dailyMidWaterQue);

    List<DailyMidWater> dailyMidWater();
}