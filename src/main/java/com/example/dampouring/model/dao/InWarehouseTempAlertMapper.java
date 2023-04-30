package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InWarehouseTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.InWarehouseTempAlertVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InWarehouseTempAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InWarehouseTempAlert record);

    int insertSelective(InWarehouseTempAlert record);

    InWarehouseTempAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InWarehouseTempAlert record);

    int updateByPrimaryKey(InWarehouseTempAlert record);

    int processinge(Integer[] ids);

    List<InWarehouseTempAlertVO> selectList(AlertQue alertQue);

    MaxTempNormVO normInfo(Integer pouringBaseId);

    List<AlertBaseVO> list(Integer type);
}