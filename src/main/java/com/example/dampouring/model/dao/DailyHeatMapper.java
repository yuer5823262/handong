package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyHeat;
import com.example.dampouring.model.vo.DailyHeatVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyHeatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyHeat record);

    int insertSelective(DailyHeat record);

    DailyHeat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyHeat record);

    int updateByPrimaryKey(DailyHeat record);

    List<DailyHeatVO> selectList(DailyPourTempQue dailyHeatQue);
}