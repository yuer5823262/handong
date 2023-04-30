package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.vo.InnerTempSensorVO;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.InnerTempSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InnerTempSensorMapper {

    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(InnerTempSensor record);

    int insertSelective(InnerTempSensor record);

    InnerTempSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerTempSensor record);

    int updateByPrimaryKey(InnerTempSensor record);
    List<InnerTempSensorVO> selectListByCuId(Integer cuId);
    List<InnerTempSensorVO> selectList(InnerTempSensorQue innerTempSensorQue);

    List<InnerTempSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    InnerTempSensor selectByTempNo(String tempNo);

    List<InnerTempSensor> selectByCuIdCNo(Integer cuId, Integer channelNo);

    List<InnerTempSensor> listByUseful();

    List<InnerTempSensorVO> selectByRemoteDev(String device_id, Integer ch);

//    List<TempSensorVO> selectByComputing();
}