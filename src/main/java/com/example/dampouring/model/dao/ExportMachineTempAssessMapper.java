package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ExportMachineTempAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportMachineTempAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExportMachineTempAssess record);

    int insertSelective(ExportMachineTempAssess record);

    ExportMachineTempAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExportMachineTempAssess record);

    int updateByPrimaryKey(ExportMachineTempAssess record);

    List<ExportMachineTempAssessVO> List();

    List<ExportMachineTempAssessVO> selectList(ExportMachineTempAssessQue exportMachineTempAssessQue);

    void deleteAll();
}