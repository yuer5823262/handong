package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempRiseAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.TempRiseAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempRiseAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempRiseAlert record);

    int insertSelective(TempRiseAlert record);

    TempRiseAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempRiseAlert record);

    int updateByPrimaryKey(TempRiseAlert record);

    List<TempRiseAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<TempRiseAlert> TempRiseAlert(String today, String yesterday);

    List<AlertBaseVO> list(Integer type);
}