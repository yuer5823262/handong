package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DataMissAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.DataCountVO;
import com.example.dampouring.model.vo.DataMissAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.DataMissAlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMissAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataMissAlert record);

    int insertSelective(DataMissAlert record);

    DataMissAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataMissAlert record);

    int updateByPrimaryKey(DataMissAlert record);

    List<DataMissAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    DataMissAlert selectAlert(DataMissAlertQue dataMissAlertQue);

    List<AlertBaseVO> list(Integer type);


    List<DataCountVO> todayDataCount();
}