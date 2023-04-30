package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.FaceTempSensorInfo;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceTempSensorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FaceTempSensorInfo record);

    int insertSelective(FaceTempSensorInfo record);

    FaceTempSensorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaceTempSensorInfo record);

    int updateByPrimaryKey(FaceTempSensorInfo record);

    List<InnerTempSensorInfoVO> List();

    List<InnerTempSensorInfoVO> selectList(InnerTempSensorInfoQue faceTempSensorInfoQue);

    List<CoolingRateVo> coolingRate(InnerTempSensorInfoQue faceTempSensorInfoQue);

    List<TopTempAssessVO> maxTemp(TopTempAssessQue topTempAssessQue);

    List<DamTempVO> damTemp(DamTempQue damTempQue);

    List<InnerTempMonitorVO> tempMonitor();

    List<InnerTempSensorInfoVO> timeAvgTemp(String time);

    FaceTempSensorInfo selectBySIdAndTime(Integer innerTempSensorId, String time);
}