package com.example.dampouring.service.impl;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ControlProcessMapper;
import com.example.dampouring.model.dao.SwFollowCurveMapper;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.dao.WaterReversingDeviceMapper;
import com.example.dampouring.model.pojo.SwFollowCurve;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.SwFollowCurveQue;
import com.example.dampouring.service.SwFollowCurveService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SwFollowCurveServiceImpl implements SwFollowCurveService {
    @Autowired
    SwFollowCurveMapper SwFollowCurveMapper;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    WaterReversingDeviceMapper waterReversingDeviceMapper;
    @Autowired
    ControlProcessMapper controlProcessMapper;
    @Override
    public PageInfo orUserSelect(SwFollowCurveQue SwFollowCurveQue) {
        PageHelper.startPage(SwFollowCurveQue.getPageNum(), SwFollowCurveQue.getPageSize());
        List<SwFollowCurve> SwFollowCurveVOS = SwFollowCurveMapper.selectList(SwFollowCurveQue);
        PageInfo pageInfo = new PageInfo(SwFollowCurveVOS);
        return pageInfo;
    }


    @Override
    public void readFile(Integer state) {
        try {
            String fileName = Constant.SMART_TS_DATA_PATH + "follow_curve.out";
            List<List<String>> listList = DatUtils.getStringLinesSpilt(fileName);
            for (List<String> stringList : listList) {
                try{
                    if (stringList.size() < 15) continue;
                    Double val;
                    SwFollowCurve swFollowCurve = new SwFollowCurve();
                    swFollowCurve.setSbNo(stringList.get(1));
                    val = DatUtils.strToDouVal(stringList.get(3));
                    swFollowCurve.setAirTemp(val);
                    val = DatUtils.strToDouVal(stringList.get(4));
                    swFollowCurve.setScTemp(val);
                    val = DatUtils.strToDouVal(stringList.get(5));
                    swFollowCurve.setMbTemp(val);
                    val = DatUtils.strToDouVal(stringList.get(6));
                    swFollowCurve.setWaterTemp(val);
                    val = DatUtils.strToDouVal(stringList.get(7));
                    swFollowCurve.setScFlow(val==null?null:val/24);
                    val = DatUtils.strToDouVal(stringList.get(8));
                    swFollowCurve.setYcFlow(val==null?null:val/24);
                    val = DatUtils.strToDouVal(stringList.get(9));
                    swFollowCurve.setMbFlow(val==null?null:val/24);
                    val = DatUtils.strToDouVal(stringList.get(10));
                    swFollowCurve.setYcTemp(val);
                    swFollowCurve.setTime(TimeUtils.standTime(stringList.get(14)));
                    SwFollowCurve check = SwFollowCurveMapper.selectByTimeSbNo(swFollowCurve.getTime(),swFollowCurve.getSbNo());
                    if(check==null)
                        SwFollowCurveMapper.insertSelective(swFollowCurve);
                    else{
                        swFollowCurve.setId(check.getId());
                        SwFollowCurveMapper.updateByPrimaryKeySelective(swFollowCurve);
                    }
                    if(state==1)
                    {
                        setFmkd(swFollowCurve);
                    }
                } catch (Exception e) {
                    Constant.logger.error("错误:",e);
                }

            }
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
    }
    public void setFmkd(SwFollowCurve swFollowCurve)
    {
        List<WaterPipeVO> waterPipeList = waterPipeMapper.selectBySbNo(swFollowCurve.getSbNo());
        for(WaterPipeVO waterPipe:waterPipeList)
        {
            double dl = swFollowCurve.getMbFlow()*1.6*waterPipe.getBranchNum()+4;
            Constant.print(swFollowCurve.getSbNo()+" "+waterPipe.getWpNo()+"目标流量:"+swFollowCurve.getMbFlow()+",设置电流逼近参数.......电流:"+dl);
            short p = Constant.DllUTILS.LNT_SetElecNearAimI((byte)Integer.parseInt(waterPipe.getCuAddr()),
                    waterPipe.getChannelNo().byteValue(),dl,Constant.timeout);
            if(p==0)
            {
                short pp = Constant.DllUTILS.LNT_SetElecNearOnOff(Byte.parseByte(waterPipe.getCuAddr()),
                        waterPipe.getChannelNo().byteValue(), (byte) 1,Constant.timeout);
                Constant.print(swFollowCurve.getSbNo()+" "+waterPipe.getWpNo()+"启用电流输出逼近程序.......p:"+pp);
            }
        }

    }
}
