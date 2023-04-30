package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.InboundTempAssess;
import com.example.dampouring.model.vo.InboundTempAssessVO;
import com.example.dampouring.query.InboundTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboundTempAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InboundTempAssess record);

    int insertSelective(InboundTempAssess record);

    InboundTempAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InboundTempAssess record);

    int updateByPrimaryKey(InboundTempAssess record);

    List<InboundTempAssessVO> List();

    List<InboundTempAssessVO> selectList(InboundTempAssessQue inboundTempAssessQue);

    void deleteAll();
}