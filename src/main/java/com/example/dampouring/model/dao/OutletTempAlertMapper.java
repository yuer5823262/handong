package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.OutletTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.OutletTempAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletTempAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OutletTempAlert record);

    int insertSelective(OutletTempAlert record);

    OutletTempAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OutletTempAlert record);

    int updateByPrimaryKey(OutletTempAlert record);

    List<OutletTempAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    MaxTempNormVO normInfo(Integer pouringBaseId);

    List<AlertBaseVO> list(Integer type);
}