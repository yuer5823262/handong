package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingSensor;
import com.example.dampouring.model.vo.MixingSensorVO;
import com.example.dampouring.query.MixingSensorInfoQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingSensorMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(MixingSensor record);

    int insertSelective(MixingSensor record);

    MixingSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingSensor record);

    int updateByPrimaryKey(MixingSensor record);

    MixingSensor selectByTempNo(String no);

    List<MixingSensorVO> selectListByIds(@Param("ids") Integer[] ids);

    List<MixingSensorVO> selectList(MixingSensorInfoQue mixingSensorInfoQue);

    List<MixingSensor> selectByCuId(Integer cuId);

    List<MixingSensor> selectByCuIdCNo(Integer cuId, Integer channelNo);

    List<MixingSensor> list();
}