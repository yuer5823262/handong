package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DailyPourTemp;
import com.example.dampouring.model.vo.DailyPourTempVO;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.query.DailyPourTempQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPourTempMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(DailyPourTemp record);

    int insertSelective(DailyPourTemp record);

    DailyPourTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyPourTemp record);

    int updateByPrimaryKey(DailyPourTemp record);

    List<DailyPourTempVO> selectList(DailyPourTempQue dailyPourTempQue);

    List<DailyPourTemp> dailyPourTemp();
}