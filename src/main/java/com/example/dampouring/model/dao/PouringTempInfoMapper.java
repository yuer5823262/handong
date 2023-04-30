package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.PouringTempAssess;
import com.example.dampouring.model.pojo.PouringTempInfo;
import com.example.dampouring.model.vo.PouringTempAssessVO;
import com.example.dampouring.model.vo.PouringTempInfoVO;
import com.example.dampouring.model.vo.PouringTempMonitorVO;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.query.PouringTempInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PouringTempInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PouringTempInfo record);

    int insertSelective(PouringTempInfo record);

    PouringTempInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PouringTempInfo record);

    int updateByPrimaryKey(PouringTempInfo record);

    List<PouringTempInfoVO> List();

    List<PouringTempInfoVO> selectList(PouringTempInfoQue pouringTempInfoQue);

    List<PouringTempAssessVO> assess(PouringTempAssessQue pouringTempAssessQue);

    List<PouringTempMonitorVO> tempMonitor();

    List<PouringTempAssess> timingComputing();

    Double selectAvgTempByPbId(Integer id);
}