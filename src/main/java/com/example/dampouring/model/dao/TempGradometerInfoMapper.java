package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempGradometerInfo;
import com.example.dampouring.model.vo.TempGradometerInfoVO;
import com.example.dampouring.query.TempGradometerInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempGradometerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempGradometerInfo record);

    int insertSelective(TempGradometerInfo record);

    TempGradometerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempGradometerInfo record);

    int updateByPrimaryKey(TempGradometerInfo record);

    List<TempGradometerInfoVO> List();

    List<TempGradometerInfoVO> selectList(TempGradometerInfoQue tempGradometerInfoQue);
}