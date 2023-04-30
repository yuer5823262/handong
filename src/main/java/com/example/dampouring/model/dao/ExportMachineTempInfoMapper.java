package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ExportMachineTempAssess;
import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.model.vo.ExportMachineTempInfoVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.ExportMachineTempInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportMachineTempInfoMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(ExportMachineTempInfo record);

    int insertSelective(ExportMachineTempInfo record);

    ExportMachineTempInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExportMachineTempInfo record);

    int updateByPrimaryKey(ExportMachineTempInfo record);

    List<ExportMachineTempInfoVO> List();

    List<ExportMachineTempInfoVO> selectList(ExportMachineTempInfoQue exportMachineTempInfoQue);

    List<ExportMachineTempAssessVO> assess(ExportMachineTempAssessQue exportMachineTempAssessQue);

    List<ExportMachineTempAssess> timingComputing();
}