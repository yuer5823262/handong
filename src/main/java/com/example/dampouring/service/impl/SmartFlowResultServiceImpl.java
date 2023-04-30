package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ControlProcessMapper;
import com.example.dampouring.model.dao.SwFollowCurveMapper;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.dao.WaterReversingDeviceMapper;
import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.model.pojo.SwFollowCurve;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.SwFollowCurveQue;
import com.example.dampouring.service.SmartFlowResultService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class SmartFlowResultServiceImpl implements SmartFlowResultService {
    @Autowired
    SwFollowCurveMapper swFollowCurveMapper;
    @Autowired
    WaterPipeMapper waterPipeMapper;
    @Autowired
    WaterReversingDeviceMapper waterReversingDeviceMapper;
    @Autowired
    ControlProcessMapper controlProcessMapper;
    @Override
    public PageInfo orUserSelect(SwFollowCurveQue swFollowCurveQue) {
        PageHelper.startPage(swFollowCurveQue.getPageNum(), swFollowCurveQue.getPageSize());
        List<SwFollowCurve> smartFlowResults = swFollowCurveMapper.selectList(swFollowCurveQue);
        PageInfo pageInfo = new PageInfo(smartFlowResults);
        return pageInfo;
    }

    @Override
    public List<SwFollowCurve> exportList() {
        List<SwFollowCurve> smartFlowResults = swFollowCurveMapper.selectList(new SwFollowCurveQue());
        return smartFlowResults;
    }

    @Override
    public void waterReversing() {
        Constant.print("开始通水换向");
        List<WaterReversingDeviceVO> waterReversingDeviceList = waterReversingDeviceMapper.selectByComputing();
        short p;
        for (WaterReversingDeviceVO waterReversingDeviceVO : waterReversingDeviceList) {
            byte[] SwitchValue = {10};
            p = Constant.DllUTILS.LNT_ReadIOValue(waterReversingDeviceVO.getCuAddr().byteValue(),
                    waterReversingDeviceVO.getChannelNo(), 1, SwitchValue, Constant.timeout);
            if (p == 0 && (SwitchValue[0] == 0 || SwitchValue[0] == 1)) {
                Constant.print(waterReversingDeviceVO.getCuAddr()+" "+waterReversingDeviceVO.getChannelNo()+"通水换向状态:" + SwitchValue[0]);
                byte IoVal = 0;
                if (SwitchValue[0] == 0)
                    IoVal = 1;
                p = Constant.DllUTILS.LNT_SetIOValue(waterReversingDeviceVO.getCuAddr().byteValue(),
                        waterReversingDeviceVO.getChannelNo().byteValue(), IoVal, Constant.timeout);
                if(p==0)
                {
                    Constant.print("设置"+waterReversingDeviceVO.getCuAddr()+" "+waterReversingDeviceVO.getChannelNo()+"的通水换向状态:" + IoVal);
                }
            }
        }
    }

    @Override
    public int getFlowResult() throws Exception {
        String cmd = Constant.SMART_TS_DATA_PATH+"智能通水.exe";
        Process process = null;
        process = Runtime.getRuntime().exec(cmd,null,new File(Constant.SMART_TS_DATA_PATH));
        int status = 0;
        status = process.waitFor();
        System.out.println(status);
        InputStream in = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        line = br.readLine();
        while(line!=null) {
            System.out.println(line);
            line = br.readLine();
        }
        Constant.print("................执行通水调控计算....................");
        return status;
    }

    @Override
    public void controlProcess() {
        if(Constant.pSta!=0) return;
        List<WaterPipeVO> waterPipeList=waterPipeMapper.selectByComputing();
        for(WaterPipeVO waterPipe:waterPipeList)
        {
            SwFollowCurve swFollowCurve = swFollowCurveMapper.selectByTimeSbNo(TimeUtils.getNextDay(1),waterPipe.getSmallNo());
            if(swFollowCurve==null) continue;
            try {
                short p;
                double[] val={0};
                double temp;
                p=Constant.DllUTILS.LNT_ReadInIValue(Byte.parseByte(waterPipe.getCuAddr()),
                        waterPipe.getChannelNo(),1,val,Constant.timeout,3);
                if(p==0&&val[0]>3.9&&val[0]<=20)
                {
                    ControlProcess controlProcess = new ControlProcess();
                    controlProcess.setElectricity(swFollowCurve.getScFlow()/waterPipe.getBranchNum());
                    controlProcess.setTime(TimeUtils.getNowTime());
                    if(val[0]<=4) temp=0.;
                    else temp=(val[0]-4)*10/16;
                    controlProcess.setFlow(temp/waterPipe.getBranchNum());
                    Constant.print(waterPipe.getSmallNo()+" "+waterPipe.getWpNo() +"通水调控监控获取流量值:"+temp);
                    controlProcess.setWpNo(waterPipe.getWpNo());
                    controlProcess.setMbFlow(swFollowCurve.getMbFlow());
                    controlProcess.setMdBySelf();
                    controlProcess.setSbNo(waterPipe.getSmallNo());
                    p=Constant.DllUTILS.LNT_ReadOutIValue(Byte.parseByte(waterPipe.getCuAddr()),
                            waterPipe.getChannelNo(),1,val,Constant.timeout,3);
                    if(p==0&&val[0]>3.5&&val[0]<=20)
                    {
                        if(val[0]<=4) temp = 0.;
                        else temp = (val[0]-4)*100/16;
                        Constant.print(waterPipe.getSmallNo()+" "+waterPipe.getWpNo() +"通水调控监控获取开度:"+temp);
                        controlProcess.setOpening(temp);
                    }
                    WaterReversingDeviceVO waterReversingDevice = waterReversingDeviceMapper.selectBySbId(waterPipe.getSbId());
                    if(waterReversingDevice!=null)
                    {
                        byte[] SwitchValue={10};
                        p=Constant.DllUTILS.LNT_ReadIOValue(waterReversingDevice.getCuAddr().byteValue(),
                                waterReversingDevice.getChannelNo(),1,SwitchValue,Constant.timeout);
                        if(p==0&&(SwitchValue[0]==0||SwitchValue[0]==1))
                        {
                            Constant.print(waterPipe.getSmallNo()+"通水调控监控获取通水换向状态:"+SwitchValue[0]);
                            controlProcess.setDirection(SwitchValue[0]==0?"正向":"反向");
                        }
                    }
                    controlProcessMapper.insertSelective(controlProcess);
                }

            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }
        }
    }

    @Override
    public List<SwFollowCurve> exportListByQue(SwFollowCurveQue swFollowCurveQue) {
        return swFollowCurveMapper.selectList(swFollowCurveQue);
    }
}
