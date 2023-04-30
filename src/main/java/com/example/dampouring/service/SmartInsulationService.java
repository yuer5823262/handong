package com.example.dampouring.service;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.SmartBwAdviceVO;
import com.example.dampouring.query.SmartInsulationQue;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

public interface SmartInsulationService {

    PageInfo orUserSelect(SmartInsulationQue smartInsulationQue);


    List<SmartBwAdviceVO> bwAdvice();
    void writeBaowenTianqi();
    void writeCl();
    void writeTemp();
    void writeTESTINFOR() throws IOException;

    void writeBEIYONG() throws IOException;

    void getYuntu() throws Exception;

    List<TempMeasurementsAssess> getAirTemp();

    void history() throws IOException;

    void writeBwFile1();

    void writeBwFile2();

    void writeBwFile3();
}
