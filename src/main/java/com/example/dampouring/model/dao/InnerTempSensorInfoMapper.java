package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.pojo.TopTempAssess;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InnerTempSensorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnerTempSensorInfo record);

    int insertSelective(InnerTempSensorInfo record);

    InnerTempSensorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerTempSensorInfo record);

    int updateByPrimaryKey(InnerTempSensorInfo record);

    List<TopTempAssess> timingComputing();

    List<InnerTempSensorInfoVO> List();

    List<InnerTempSensorInfoVO> selectList(InnerTempSensorInfoQue innerTempSensorInfoQue);

    List<CoolingRateVo> coolingRate(InnerTempSensorInfoQue innerTempSensorInfoQue);

    List<TopTempAssessVO> maxTemp(TopTempAssessQue topTempAssessQue);
    InnerTempSensorInfo selectBySIdAndTime(Integer sId,String time);
    List<DamTempVO> damTemp(DamTempQue damTempQue);

    List<InnerTempMonitorVO> tempMonitor();

    List<InnerTempSensorInfoVO> timeAvgTemp(String time);
}