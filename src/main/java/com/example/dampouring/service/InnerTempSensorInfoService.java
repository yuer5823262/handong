package com.example.dampouring.service;

import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.request.InnerTempSensorInfoAdd;
import com.example.dampouring.model.request.RemoteDev;
import com.example.dampouring.model.vo.CoolingRateVo;
import com.example.dampouring.model.vo.DamTempVO;
import com.example.dampouring.model.vo.InnerTempMonitorVO;
import com.example.dampouring.model.vo.InnerTempSensorInfoVO;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface InnerTempSensorInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(InnerTempSensorInfoQue InnerTempSensorInfoQue);

    PageInfo CoolingRate(InnerTempSensorInfoQue innerTempSensorInfoQue);

    List<CoolingRateVo> CoolingRateExportList(InnerTempSensorInfoQue innerTempSensorInfoQue);

    PageInfo maxTemp(TopTempAssessQue topTempAssessQue);

    List<InnerTempSensorInfoVO> exportList();


    void add(InnerTempSensorInfoAdd innerTempSensorInfoAdd);

    List<DamTempVO> damTemp(DamTempQue damTempQue);

    List<InnerTempMonitorVO> tempMonitor();

    void addAll(List<InnerTempSensorInfo> list);
    @Async
    void timeAvgTemp(String time);

    void addByRemoteDev(RemoteDev remoteDev);

    List<InnerTempSensorInfoVO> exportListByque(InnerTempSensorInfoQue innerTempSensorInfoQue);
}
