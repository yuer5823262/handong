package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.MixingEgSensor;
import com.example.dampouring.model.vo.MixingEgSensorVO;
import com.example.dampouring.query.CheckMixingEgSensorQue;
import com.example.dampouring.query.MixingEgSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingEgSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(MixingEgSensor record);

    int insertSelective(MixingEgSensor record);

    MixingEgSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingEgSensor record);

    int updateByPrimaryKey(MixingEgSensor record);

    List<MixingEgSensorVO> selectList(MixingEgSensorQue mixingEgSensorInfoQue);

    List<MixingEgSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    List<MixingEgSensor> getIpDk();

    List<MixingEgSensor> selectByIpDk(String serverIP, int serverPort);

    List<InnerTempSensor> selectByIpCNo(CheckMixingEgSensorQue checkMixingEgSensorQue);
}