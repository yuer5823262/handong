package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.vo.DamSegmentVO;
import com.example.dampouring.model.vo.PouringMonitorVO;
import com.example.dampouring.query.DamSegmentQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamSegmentMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(DamSegment record);

    int insertSelective(DamSegment record);

    DamSegment selectByPrimaryKey(Integer dsNo);

    int updateByPrimaryKeySelective(DamSegment record);

    int updateByPrimaryKey(DamSegment record);

    DamSegment selectByName(String ds_name);

    List<DamSegmentVO> selectVoList();

    List<DamSegment> selectListByIds(@Param("ids") Integer[] ids);

    List<DamSegment> selectListByBSNo(Integer value);

    List<DamSegmentVO> selectVoListQue(DamSegmentQue damSegmentQue);

    List<PouringMonitorVO> pouringMonitor();
}