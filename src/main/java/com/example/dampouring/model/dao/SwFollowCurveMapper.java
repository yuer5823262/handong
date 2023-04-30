package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SwFollowCurve;
import com.example.dampouring.query.SwFollowCurveQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwFollowCurveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwFollowCurve record);

    int insertSelective(SwFollowCurve record);

    SwFollowCurve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwFollowCurve record);

    int updateByPrimaryKey(SwFollowCurve record);

    List<SwFollowCurve> selectList(SwFollowCurveQue swFollowCurveQue);

    SwFollowCurve selectByTimeSbNo(String nextDay, String smallNo);
}