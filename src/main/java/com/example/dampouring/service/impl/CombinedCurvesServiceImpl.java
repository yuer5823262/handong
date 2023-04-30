package com.example.dampouring.service.impl;

import com.example.dampouring.model.vo.CombinedCurvesVO;
import com.example.dampouring.query.CombinedCurvesQue;
import com.example.dampouring.service.CombinedCurvesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinedCurvesServiceImpl implements CombinedCurvesService {
    @Autowired
    com.example.dampouring.model.dao.WaterPipeFlowInfoMapper WaterPipeFlowInfoMapper;
    @Override
    public PageInfo orUserSelect(CombinedCurvesQue combinedCurvesQue) {
        PageHelper.startPage(combinedCurvesQue.getPageNum(), combinedCurvesQue.getPageSize());
        List<CombinedCurvesVO> combinedCurvesVOS = WaterPipeFlowInfoMapper.CombinedCurves(combinedCurvesQue);
        if(combinedCurvesVOS.size()!=0){
            for(int i=combinedCurvesVOS.size()-1;i>0;i--){
                if(combinedCurvesVOS.get(i).getAvgInnerTemp()!=null && combinedCurvesVOS.get(i-1).getAvgInnerTemp()!=null)
                {
                    combinedCurvesVOS.get(i).setDiffInnerTemp(
                            combinedCurvesVOS.get(i).getAvgInnerTemp() - combinedCurvesVOS.get(i-1).getAvgInnerTemp());
                }
            }
        }

        PageInfo pageInfo = new PageInfo(combinedCurvesVOS);
        return pageInfo;
    }

    @Override
    public List<CombinedCurvesVO> exportList(CombinedCurvesQue combinedCurvesQue) {
        List<CombinedCurvesVO> combinedCurvesVOS = WaterPipeFlowInfoMapper.CombinedCurves(combinedCurvesQue);
        if(combinedCurvesVOS.size()!=0){
            for(int i=combinedCurvesVOS.size()-1;i>0;i--){
                combinedCurvesVOS.get(i).setDiffInnerTemp(
                        combinedCurvesVOS.get(i).getAvgInnerTemp() - combinedCurvesVOS.get(i-1).getAvgInnerTemp());
            }
        }
        return combinedCurvesVOS;
    }
}
