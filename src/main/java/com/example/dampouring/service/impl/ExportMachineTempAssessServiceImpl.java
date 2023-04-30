package com.example.dampouring.service.impl;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ExportMachineTempAssessMapper;
import com.example.dampouring.model.dao.ExportMachineTempInfoMapper;
import com.example.dampouring.model.pojo.ExportMachineTempAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.ExportMachineTempInfoQue;
import com.example.dampouring.service.ExportMachineTempAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExportMachineTempAssessServiceImpl implements ExportMachineTempAssessService {
    @Autowired
    ExportMachineTempAssessMapper exportMachineTempAssessMapper;
    @Autowired
    ExportMachineTempInfoMapper exportMachineTempInfoMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExportMachineTempAssessVO> ExportMachineTempAssess = exportMachineTempAssessMapper.List();
        PageInfo pageInfo = new PageInfo(ExportMachineTempAssess);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(ExportMachineTempAssessQue ExportMachineTempAssessQue) {
        PageHelper.startPage(ExportMachineTempAssessQue.getPageNum(), ExportMachineTempAssessQue.getPageSize());
        List<ExportMachineTempAssessVO> ExportMachineTempAssess = exportMachineTempAssessMapper.selectList(ExportMachineTempAssessQue);
        PageInfo pageInfo = new PageInfo(ExportMachineTempAssess);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        try{
            List<ExportMachineTempAssess> exportMachineTempAssessVOS=exportMachineTempInfoMapper.timingComputing();
            ExportMachineTempAssessQue exportMachineTempAssessQue = new ExportMachineTempAssessQue();
            for(ExportMachineTempAssess exportMachineTempAssessVO: exportMachineTempAssessVOS)
            {
                exportMachineTempAssessVO.setExcessivePersent(
                        exportMachineTempAssessVO.getExcessiveCount()*100/exportMachineTempAssessVO.getRecordCount());
                Double TopExcessive = exportMachineTempAssessVO.getTopTemp()-exportMachineTempAssessVO.getNormTemp();
                exportMachineTempAssessVO.setTopExcessive(0.0);
                exportMachineTempAssessVO.setTopExcessivePersent(0);
                if(TopExcessive>0) {
                    exportMachineTempAssessVO.setTopExcessive(TopExcessive);
                    exportMachineTempAssessVO.setTopExcessivePersent((int) (TopExcessive*100/exportMachineTempAssessVO.getNormTemp()));
                }
                exportMachineTempAssessQue.setPbId(exportMachineTempAssessVO.getPouringBaseId());
                List<ExportMachineTempAssessVO> machineTempAssess = exportMachineTempAssessMapper.selectList(exportMachineTempAssessQue);
                if(machineTempAssess.size()!=0)
                {
                    exportMachineTempAssessVO.setId(machineTempAssess.get(0).getId());
                    exportMachineTempAssessMapper.updateByPrimaryKey(exportMachineTempAssessVO);
                }
                else
                {
                    exportMachineTempAssessMapper.insertSelective(exportMachineTempAssessVO);
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public List<ExportMachineTempAssessVO> exportList() {
        List<ExportMachineTempAssessVO> ExportMachineTempAssess = exportMachineTempAssessMapper.List();
        return ExportMachineTempAssess;
    }
}
