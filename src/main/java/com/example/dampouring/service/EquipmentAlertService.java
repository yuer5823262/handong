package com.example.dampouring.service;

import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.ControllerUnitValueVO;
import com.example.dampouring.query.EquipmentAlertQue;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

public interface EquipmentAlertService {
    PageInfo orUserSelect(EquipmentAlertQue alertQue);

    void processing(Integer[] ids, String username,String type,Integer mark);

    List<AlertBaseVO> list(Integer type);
    void TDequipmentAlert();

    void TXequipmentAlert(List<ControllerUnitValueVO> txgzList);

    void GZequipmentAlert(List<ControllerUnitValueVO> cgqgzList);
    void YCequipmentAlert(WaterPipeFlowInfo waterPipeFlowInfo, Integer sbId);

    void pipeAlert(Double val, Integer sbId);
}
