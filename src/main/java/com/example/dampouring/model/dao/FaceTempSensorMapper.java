package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.FaceTempSensor;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.vo.InnerTempSensorVO;
import com.example.dampouring.query.InnerTempSensorQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceTempSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(FaceTempSensor record);

    int insertSelective(FaceTempSensor record);

    FaceTempSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaceTempSensor record);

    int updateByPrimaryKey(FaceTempSensor record);

    List<InnerTempSensor> selectByCuIdCNo(Integer cuId, Integer channelNo);


    FaceTempSensor selectByTempNo(String tempNo);

    List<InnerTempSensorVO> selectList(InnerTempSensorQue innerTempSensorQue);

    List<InnerTempSensorVO> selectListByIds(Integer[] ids);

    List<FaceTempSensor> listByUseful();
}