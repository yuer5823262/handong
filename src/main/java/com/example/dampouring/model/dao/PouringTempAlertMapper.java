package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.PouringTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.PouringTempAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PouringTempAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PouringTempAlert record);

    int insertSelective(PouringTempAlert record);

    PouringTempAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PouringTempAlert record);

    int updateByPrimaryKey(PouringTempAlert record);

    List<PouringTempAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    MaxTempNormVO normInfo(Integer pouringBaseId);

    List<AlertBaseVO> list(Integer type);
}