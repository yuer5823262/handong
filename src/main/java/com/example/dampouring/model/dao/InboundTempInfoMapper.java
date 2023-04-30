package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InboundTempAssess;
import com.example.dampouring.model.pojo.InboundTempInfo;
import com.example.dampouring.model.vo.InboundTempAssessVO;
import com.example.dampouring.model.vo.InboundTempInfoVO;
import com.example.dampouring.model.vo.InboundTempMonitorVO;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.query.InboundTempInfoQue;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InboundTempInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InboundTempInfo record);

    int insertSelective(InboundTempInfo record);

    InboundTempInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InboundTempInfo record);

    int updateByPrimaryKey(InboundTempInfo record);

    List<InboundTempInfoVO> List();

    List<InboundTempInfoVO> selectList(InboundTempInfoQue inboundTempInfoQue);

    List<InboundTempAssessVO> assess(InboundTempAssessQue inboundTempAssessQue);

    List<InboundTempMonitorVO> tempMonitor();

    List<InboundTempAssess> timingComputing();
}