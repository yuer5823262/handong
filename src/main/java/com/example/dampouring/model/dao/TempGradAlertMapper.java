package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempGradAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.TempGradAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempGradAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempGradAlert record);

    int insertSelective(TempGradAlert record);

    TempGradAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempGradAlert record);

    int updateByPrimaryKey(TempGradAlert record);

    List<TempGradAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    MaxTempNormVO normInfo(Integer tempGradometerId);

    List<AlertBaseVO> list(Integer type);
}