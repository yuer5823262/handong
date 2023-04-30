package com.example.dampouring.service.impl;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.SmallStorageBinMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.EquipmentAlert;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.ControllerUnitValueVO;
import com.example.dampouring.model.vo.EquipmentAlertVO;
import com.example.dampouring.query.EquipmentAlertQue;
import com.example.dampouring.service.EquipmentAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EquipmentAlertServiceImpl implements EquipmentAlertService {
    @Autowired
    com.example.dampouring.model.dao.EquipmentAlertMapper EquipmentAlertMapper;
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(EquipmentAlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<EquipmentAlertVO> InboundTempInfo = EquipmentAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            EquipmentAlert EquipmentAlert = EquipmentAlertMapper.selectByPrimaryKey(id);
            if(EquipmentAlert==null) continue;
            if(mark == 0)
            {
                EquipmentAlert.setHasDispose("0");
                EquipmentAlert.setOperator("");
                EquipmentAlert.setOpTime("");
            }
            else
            {
                if(EquipmentAlert.getOperator()==null||EquipmentAlert.getOperator().equals(""))
                {
                    EquipmentAlert.setOperator(username);
                    EquipmentAlert.setOpTime(TimeUtils.getNowTime());
                }
                EquipmentAlert.setHasDispose(type);
            }
            EquipmentAlertMapper.updateByPrimaryKeySelective(EquipmentAlert);
        }
    }

    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = EquipmentAlertMapper.list(type);
        return result;
    }

    @Override
    public void TDequipmentAlert() {
//        EquipmentAlert equipmentAlert = new EquipmentAlert();
//        equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//        equipmentAlert.setAlertType("现场停电");
//        equipmentAlert.setAlertContent("传感器都读不到数据，可能停电");
//        equipmentAlert.setHasDispose("0");
//        EquipmentAlertMapper.insertSelective(equipmentAlert);
        AlertBase alertBase = new AlertBase();
        alertBase.setTypeNo(3);
        alertBase.setTime(TimeUtils.getNowTime());
        alertBase.setType("现场停电");
        alertBase.setContent("传感器都读不到数据，可能停电");
        alertBase.setState(0);
        alertBaseMapper.insertSelective(alertBase);
        ConnectionUtil.Send(alertBase.toString());
    }

    @Override
    public void TXequipmentAlert(List<ControllerUnitValueVO> txgzList) {
        for(ControllerUnitValueVO controllerUnitValueVO:txgzList)
        {
//            EquipmentAlert equipmentAlert = new EquipmentAlert();
//            equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//            equipmentAlert.setAlertType("通信故障");
//            equipmentAlert.setHasDispose("0");
//            equipmentAlert.setAlertContent(controllerUnitValueVO.getCuType()+
//                    "地址为"+controllerUnitValueVO.getCuAddr()+"的传感器通信错误");
//            EquipmentAlertMapper.insertSelective(equipmentAlert);

            AlertBase alertBase = new AlertBase();
            alertBase.setTypeNo(3);
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setType("通信故障");
            alertBase.setContent(controllerUnitValueVO.getCuType()+
                    "地址为"+controllerUnitValueVO.getCuAddr()+"的传感器通信错误");
            alertBase.setState(0);
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }

    @Override
    public void GZequipmentAlert(List<ControllerUnitValueVO> cgqgzList) {
        for(ControllerUnitValueVO controllerUnitValueVO:cgqgzList)
        {
//            EquipmentAlert equipmentAlert = new EquipmentAlert();
//            equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//            equipmentAlert.setAlertType("传感器故障");
//            equipmentAlert.setHasDispose("0");
//            equipmentAlert.setAlertContent(controllerUnitValueVO.getCuType()+
//                    "地址为"+controllerUnitValueVO.getCuAddr()+"的传感器故障");
//            EquipmentAlertMapper.insertSelective(equipmentAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTypeNo(3);
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setType("传感器故障");
            alertBase.setContent(controllerUnitValueVO.getCuType()+
                    "地址为"+controllerUnitValueVO.getCuAddr()+"的传感器故障");
            alertBase.setState(0);
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }

    @Override
    public void YCequipmentAlert(WaterPipeFlowInfo waterPipeFlowInfo,Integer sbId) {
        if(waterPipeFlowInfo.getEnterMpa()==null || waterPipeFlowInfo.getOutMpa()==null)
            return;
        Double yc = waterPipeFlowInfo.getEnterMpa()-waterPipeFlowInfo.getOutMpa();
        if(Math.abs(yc)>0.3)
        {
            SmallStorageBin smallStorageBin = smallStorageBinMapper.selectByPrimaryKey(sbId);
            if(smallStorageBin==null) return;
            AlertBase alertBase = new AlertBase();
            alertBase.setTypeNo(3);
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setType("压差不足");
            alertBase.setContent(smallStorageBin.getSmallSbNo()+"压差大于0.3,达到"+yc);
            alertBase.setState(0);
            alertBase.setPosition(smallStorageBin.getSmallSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
//            EquipmentAlert equipmentAlert = new EquipmentAlert();
//            equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//            equipmentAlert.setAlertType("压差不足");
//            equipmentAlert.setHasDispose("0");
//            equipmentAlert.setPosition(smallStorageBin.getSmallSbNo());
//            equipmentAlert.setAlertContent(smallStorageBin.getSmallSbNo()+"压差大于0.3,达到"+yc);
//            EquipmentAlertMapper.insertSelective(equipmentAlert);
        }
    }

    @Override
    public void pipeAlert(Double val, Integer sbId) {
        SmallStorageBin smallStorageBin = smallStorageBinMapper.selectByPrimaryKey(sbId);
        if(smallStorageBin==null) return;
        try {
            if(val>=3.3&&val<=3.5)
            {
//                EquipmentAlert equipmentAlert = new EquipmentAlert();
//                equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//                equipmentAlert.setAlertType("空管报警");
//                equipmentAlert.setHasDispose("0");
//                equipmentAlert.setPosition(smallStorageBin.getSmallSbNo());
//                equipmentAlert.setAlertContent(smallStorageBin.getSmallSbNo()+"空管");
//                EquipmentAlertMapper.insertSelective(equipmentAlert);
                AlertBase alertBase = new AlertBase();
                alertBase.setTypeNo(3);
                alertBase.setTime(TimeUtils.getNowTime());
                alertBase.setType("空管报警");
                alertBase.setContent(smallStorageBin.getSmallSbNo()+"空管");
                alertBase.setState(0);
                alertBase.setPosition(smallStorageBin.getSmallSbNo());
                alertBaseMapper.insertSelective(alertBase);
                ConnectionUtil.Send(alertBase.toString());
            }
            if(val>20.1||val<=3.3)
            {
//                EquipmentAlert equipmentAlert = new EquipmentAlert();
//                equipmentAlert.setAlertTime(TimeUtils.getNowTime());
//                equipmentAlert.setAlertType("流量计故障");
//                equipmentAlert.setHasDispose("0");
//                equipmentAlert.setPosition(smallStorageBin.getSmallSbNo());
//                equipmentAlert.setAlertContent(smallStorageBin.getSmallSbNo()+"流量计故障");
//                EquipmentAlertMapper.insertSelective(equipmentAlert);
                AlertBase alertBase = new AlertBase();
                alertBase.setTypeNo(3);
                alertBase.setTime(TimeUtils.getNowTime());
                alertBase.setType("流量计故障");
                alertBase.setContent(smallStorageBin.getSmallSbNo()+"流量计故障");
                alertBase.setState(0);
                alertBase.setPosition(smallStorageBin.getSmallSbNo());
                alertBaseMapper.insertSelective(alertBase);
                ConnectionUtil.Send(alertBase.toString());
            }

        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }



}
