package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.DataMissAlert;
import com.example.dampouring.model.vo.DataCountVO;
import com.example.dampouring.query.AlertBaseQue;
import com.example.dampouring.query.DataMissAlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlertBase record);

    int insertSelective(AlertBase record);

    AlertBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlertBase record);

    int updateByPrimaryKey(AlertBase record);

    List<AlertBase> selectByAlertTypeList(AlertBaseQue alertBaseQue);

    List<DataCountVO> todayDataCount();

    List<AlertBase> selectDataMissAlert(DataMissAlertQue dataMissAlertQue);
}
