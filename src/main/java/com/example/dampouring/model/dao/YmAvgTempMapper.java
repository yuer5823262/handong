package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.YmAvgTemp;
import com.example.dampouring.model.vo.MmaTempVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YmAvgTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YmAvgTemp record);

    int insertSelective(YmAvgTemp record);

    YmAvgTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YmAvgTemp record);

    int updateByPrimaryKey(YmAvgTemp record);

    List<YmAvgTemp> list();

    MmaTempVO mmaTemp();
}