package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartInsulation;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.SmartInsulationQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartInsulationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartInsulation record);

    int insertSelective(SmartInsulation record);

    SmartInsulation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartInsulation record);

    int updateByPrimaryKey(SmartInsulation record);

    List<SmartInsulationVO> selectList(SmartInsulationQue smartInsulationQue);

    List<SmartBwAdviceVO> bwAdvice();

    List<BwTempVO> writeTemp();

    List<TESTINFORVO> writeTESTINFOR();
    List<BEIYONGVO> writeBEIYONG();

    List<BwFilePourTemp> writeBwFile1();

    List<BwFileFaceTempVO> writeBwFile2();

    List<BwFileFlowVO> writeBwFile3();
}