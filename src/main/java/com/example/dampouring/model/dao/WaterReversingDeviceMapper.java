package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterReversingDevice;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.WaterReversingDeviceQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterReversingDeviceMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(WaterReversingDevice record);

    int insertSelective(WaterReversingDevice record);

    WaterReversingDevice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterReversingDevice record);

    int updateByPrimaryKey(WaterReversingDevice record);

    List<WaterReversingDeviceVO> selectList();

    List<WaterReversingDeviceVO> selectListByIds(@Param("ids") Integer[] ids);

    List<WaterReversingDevice> selectByCuIdCNo(Integer cuId, Integer channelNo);

    WaterReversingDeviceVO selectBySbId(Integer sbId);

    List<WaterReversingDeviceVO> selectListByQue(WaterReversingDeviceQue waterReversingDeviceQue);

    List<WaterReversingDeviceVO> selectByComputing();
}