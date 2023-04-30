package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyInnerTemp;
import com.example.dampouring.model.vo.DailyInnerTempVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyInnerTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyInnerTemp record);

    int insertSelective(DailyInnerTemp record);

    DailyInnerTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyInnerTemp record);

    int updateByPrimaryKey(DailyInnerTemp record);

    List<DailyInnerTempVO> selectList(DailyPourTempQue dailyInnerTempQue);

    List<DailyInnerTemp> dailyInnerTemp();
}