package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.PouringTempAssessMapper;
import com.example.dampouring.model.dao.PouringTempInfoMapper;
import com.example.dampouring.model.pojo.PouringTempAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.model.vo.PouringTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.service.PouringTempAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PouringTempAssessServiceImpl implements PouringTempAssessService {
    @Autowired
    PouringTempAssessMapper PouringTempAssessMapper;
    @Autowired
    PouringTempInfoMapper pouringTempInfoMapper;

    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PouringTempAssessVO> PouringTempAssess = PouringTempAssessMapper.List();
        PageInfo pageInfo = new PageInfo(PouringTempAssess);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(PouringTempAssessQue PouringTempAssessQue) {
        PageHelper.startPage(PouringTempAssessQue.getPageNum(), PouringTempAssessQue.getPageSize());
        List<PouringTempAssessVO> PouringTempAssess = PouringTempAssessMapper.selectList(PouringTempAssessQue);
        PageInfo pageInfo = new PageInfo(PouringTempAssess);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        try {
            List<PouringTempAssess> pouringTempAssesses = pouringTempInfoMapper.timingComputing();
            PouringTempAssessQue pouringTempAssessQue = new PouringTempAssessQue();
            for(PouringTempAssess PouringTempAssessVO: pouringTempAssesses)
            {
                PouringTempAssessVO.setExcessivePersent(
                        PouringTempAssessVO.getExcessiveCount()*100/PouringTempAssessVO.getRecordCount());
                Double TopExcessive = PouringTempAssessVO.getTopTemp()-PouringTempAssessVO.getNormTemp();
                PouringTempAssessVO.setTopExcessive(0.0);
                PouringTempAssessVO.setTopExcessivePersent(0);
                if(TopExcessive>0) {
                    PouringTempAssessVO.setTopExcessive(TopExcessive);
                    PouringTempAssessVO.setTopExcessivePersent((int) (TopExcessive*100/PouringTempAssessVO.getNormTemp()));
                }
                pouringTempAssessQue.setPbId(PouringTempAssessVO.getPouringBaseId());
                List<PouringTempAssessVO> pouringTempAssess = PouringTempAssessMapper.selectList(pouringTempAssessQue);
                if(pouringTempAssess.size()!=0)
                {
                    PouringTempAssessVO.setId(pouringTempAssess.get(0).getId());
                    PouringTempAssessMapper.updateByPrimaryKey(PouringTempAssessVO);
                }
                else
                {
                    PouringTempAssessMapper.insertSelective(PouringTempAssessVO);
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }

    @Override
    public List<PouringTempAssessVO> exportList() {
        List<PouringTempAssessVO> PouringTempAssess = PouringTempAssessMapper.List();
        return PouringTempAssess;
    }
}
