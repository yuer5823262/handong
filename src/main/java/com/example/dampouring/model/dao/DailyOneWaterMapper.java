package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyOneWater;
import com.example.dampouring.model.vo.DailyOneWaterVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DailyOneWaterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyOneWater record);

    int insertSelective(DailyOneWater record);

    DailyOneWater selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyOneWater record);

    int updateByPrimaryKey(DailyOneWater record);

    List<DailyOneWaterVO> selectList(DailyPourTempQue dailyOneWaterQue);

    List<DailyOneWater> dailyOneWater();
}