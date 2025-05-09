package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.pojo.waterPipeFlowAssess;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.CombinedCurvesQue;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.query.WaterPipeFlowInfoByTimeAndWpIdQue;
import com.example.dampouring.query.WaterPipeFlowInfoQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterPipeFlowInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WaterPipeFlowInfo record);

    int insertSelective(WaterPipeFlowInfo record);

    WaterPipeFlowInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterPipeFlowInfo record);

    int updateByPrimaryKey(WaterPipeFlowInfo record);

    List<WaterPipeFlowInfoVO> List(@Param("sbId")Integer sbId);

    List<WaterPipeFlowInfoVO> selectList(WaterPipeFlowInfoQue waterPipeFlowInfoQue);


    List<CombinedCurvesVO> CombinedCurves(CombinedCurvesQue combinedCurvesQue);

    List<WaterPipeFlowAssessVO> assess(WaterPipeFlowAssessQue waterPipeFlowAssessQue);

    List<CalculatingVO> calculating(WaterPipeFlowAssessQue waterPipeFlowAssessQue);

    List<WaterMonitorVO> waterMonitor();

    List<waterPipeFlowAssess> timingComputing(Integer id);
    WaterPipeFlowInfo selectByTimeAndWpId(WaterPipeFlowInfoByTimeAndWpIdQue waterPipeFlowInfoByTimeAndWpIdQue);

    void deleteEmpty();

    List<WaterPipeFlowInfoVO> selectByTime(String time);

    Double selectFlowCountById(Integer wpId, String qi);

    List<Integer> fetch_entity_ids_updated_today();
}
