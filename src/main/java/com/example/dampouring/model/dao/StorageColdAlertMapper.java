package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.StorageColdAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.StorageColdAlertVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageColdAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageColdAlert record);

    int insertSelective(StorageColdAlert record);

    StorageColdAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageColdAlert record);

    int updateByPrimaryKey(StorageColdAlert record);

    List<StorageColdAlertVO> selectList(AlertQue alertQue);

    int processinge(Integer[] ids);

    MaxTempNormVO normInfo(Integer innerTempSensorId);

    List<AlertBaseVO> list(Integer type);
}