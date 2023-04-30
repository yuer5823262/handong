package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ReduceTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.ReduceTempAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReduceTempAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReduceTempAlert record);

    int insertSelective(ReduceTempAlert record);

    ReduceTempAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReduceTempAlert record);

    int updateByPrimaryKey(ReduceTempAlert record);

    List<ReduceTempAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<ReduceTempAlert> reduceTempAlert(String today, String yesterday);

    MaxTempNormVO normInfo(Integer sbId, Integer qs);

    List<AlertBaseVO> list(Integer type);
}