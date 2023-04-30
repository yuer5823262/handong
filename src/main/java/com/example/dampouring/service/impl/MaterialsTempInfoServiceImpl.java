package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.MaterialsTempInfoMapper;
import com.example.dampouring.model.pojo.MaterialsTempInfo;
import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.query.MaterialsTempInfoQue;
import com.example.dampouring.service.MaterialsTempInfoService;
import com.example.dampouring.service.SmartMixingResultService;
import com.example.dampouring.util.ConnectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsTempInfoServiceImpl implements MaterialsTempInfoService {
    @Autowired
    MaterialsTempInfoMapper MaterialsTempInfoMapper;
    @Autowired
    SmartMixingResultService smartMixingResultService;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MaterialsTempInfo> MaterialsTempInfo = MaterialsTempInfoMapper.List();
        PageInfo pageInfo = new PageInfo(MaterialsTempInfo);
        return pageInfo;
    }

    @Override
    public PageInfo orUserSelect(MaterialsTempInfoQue MaterialsTempInfoQue) {
        PageHelper.startPage(MaterialsTempInfoQue.getPageNum(), MaterialsTempInfoQue.getPageSize());
        List<MaterialsTempInfo> MaterialsTempInfo = MaterialsTempInfoMapper.selectList(MaterialsTempInfoQue);
        PageInfo pageInfo = new PageInfo(MaterialsTempInfo);
        return pageInfo;
    }

    @Override
    public List<MaterialsTempInfo> exportList() {
        List<MaterialsTempInfo> MaterialsTempInfo = MaterialsTempInfoMapper.List();
        return MaterialsTempInfo;
    }

    @Override
    public void insert(MixingTempBc mixingTempBc) {
        try {
            MaterialsTempInfo materialsTempInfo = new MaterialsTempInfo();
            materialsTempInfo.setType(mixingTempBc.getGllqlx());
            materialsTempInfo.setMaterials(mixingTempBc.getGllx());
            materialsTempInfo.setPosition(mixingTempBc.getGlclwz());
            materialsTempInfo.setTime(mixingTempBc.getCwsj());
            materialsTempInfo.setTemperature(mixingTempBc.getClwd().doubleValue());
            materialsTempInfo.setOperator(mixingTempBc.getUserid().toString());
            MaterialsTempInfoMapper.insertSelective(materialsTempInfo);
            ConnectionUtil.Send(materialsTempInfo.toMqStr());
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void addAll(List<MaterialsTempInfo> list) {
        for(MaterialsTempInfo materialsTempInfo:list)
        {
            MaterialsTempInfoMapper.insertSelective(materialsTempInfo);
        }
    }

    @Override
    public List<MaterialsTempInfo> exportListByQue(MaterialsTempInfoQue materialsTempInfoQue) {
        return MaterialsTempInfoMapper.selectList(materialsTempInfoQue);
    }
}
