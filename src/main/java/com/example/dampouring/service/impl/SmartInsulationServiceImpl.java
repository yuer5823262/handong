package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.SmartInsulationMapper;
import com.example.dampouring.model.dao.TempMeasurementsAssessMapper;
import com.example.dampouring.model.pojo.TempMeasurementsAssess;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.SmartInsulationQue;
import com.example.dampouring.service.SmartInsulationService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TianqiUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class SmartInsulationServiceImpl implements SmartInsulationService {
    @Autowired
    SmartInsulationMapper smartInsulationMapper;
    @Autowired
    TempMeasurementsAssessMapper tempMeasurementsAssessMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Override
    public PageInfo orUserSelect(SmartInsulationQue smartInsulationQue) {
        PageHelper.startPage(smartInsulationQue.getPageNum(), smartInsulationQue.getPageSize());
        List<SmartInsulationVO> InboundTempInfo = smartInsulationMapper.selectList(smartInsulationQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public List<SmartBwAdviceVO> bwAdvice() {
        List<SmartBwAdviceVO> smartBwAdviceVOList =  smartInsulationMapper.bwAdvice();
        return smartBwAdviceVOList;
    }

    @Override
    public void writeBaowenTianqi() {
        String fileName = Constant.SMART_BW_DATA_PATH+"AIRTEM.txt";
        List<String> result = new ArrayList<>();
        List<TempMeasurementsAssess> tempMeasurementsAssessList = tempMeasurementsAssessMapper.select30Day(30);
        Integer count=1;
        DecimalFormat df = new DecimalFormat("#.00");
        for(TempMeasurementsAssess tempMeasurementsAssess: tempMeasurementsAssessList)
        {
            result.add(count+" "+ tempMeasurementsAssess.getTime().replace("-"," ")+" "+df.format(tempMeasurementsAssess.getAvgTemp())+" "+
                    df.format(tempMeasurementsAssess.getDifferenceTemp()/2));
            count++;
        }
        List<TianqiVO>tianqiVOS = TianqiUtils.getTiqnqi();
        if(tianqiVOS==null) return;
        for(int i = 7;i< tianqiVOS.size();i++)
        {
            TianqiVO tianqiVO = tianqiVOS.get(i);
            Double avgTemp = (tianqiVO.getMaxTemperature()+tianqiVO.getMinTemperature())/2;
            Double diffTemp = (tianqiVO.getMaxTemperature()-tianqiVO.getMinTemperature())/2;
            result.add(count+" "+ TimeUtils.getNextDay(i).replace("-"," ")+" "+avgTemp+" "+diffTemp+"");
            count++;
        }
        count--;
        result.add(0, count +"");
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void writeCl() {
        String fileName = Constant.SMART_BW_DATA_PATH+"BWMNO.DAT";
        List<String> result = new ArrayList<>();
        List<PouringBaseVO> pouringBaseVOList = pouringBaseMapper.selectList();
        for(PouringBaseVO pouringBaseVO:pouringBaseVOList)
        {
            result.add(pouringBaseVO.getSmallSbNo()+" "+pouringBaseVO.getMarkNumber());
        }
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void writeTemp() {
        String fileName = Constant.SMART_BW_DATA_PATH+"BWTEMP.DAT";
        List<String> result = new ArrayList<>();
        List<BwTempVO> bwTempVOList = smartInsulationMapper.writeTemp();
        Integer dsNo = bwTempVOList.get(0).getDsNo();
        result.add(dsNo+"");
        Integer count = 1;
        for (BwTempVO bwTempVO:bwTempVOList)
        {
            if(dsNo!=bwTempVO.getDsNo())
            {
                count++;
                dsNo = bwTempVO.getDsNo();
                result.add(dsNo+"");
            }
            result.add(bwTempVO.toStr());
        }
        result.add(0,""+count);
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void writeTESTINFOR() throws IOException {
        String fileName = Constant.SMART_BW_DATA_PATH+"TESTINFOR.TXT";
        List<String> result = new ArrayList<>();
        List<TESTINFORVO> bwTempVOList = smartInsulationMapper.writeTESTINFOR();
        if(bwTempVOList.size()==0) return;
        //正确 可删除多个
        Iterator<TESTINFORVO> iterator = bwTempVOList.iterator();
        while (iterator.hasNext()) {
            TESTINFORVO s = iterator.next();
            if (s.checkData()) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }
        int aaa = 0;
        String dsNo=bwTempVOList.get(0).getDsNo();
        for(int i = 0;i<bwTempVOList.size();i++)
        {
            if(!bwTempVOList.get(i).getDsNo().equals(dsNo))
            {
                dsNo=bwTempVOList.get(i).getDsNo();
                if(aaa==1)
                {
                    TESTINFORVO testinforvoTemp = new TESTINFORVO();
                    BeanUtils.copyProperties(bwTempVOList.get(i-1),testinforvoTemp);
                    String nextDay = TimeUtils.byTimeNextDay(bwTempVOList.get(i-1).getPouringTime(),-2);
                    testinforvoTemp.setPouringTime(bwTempVOList.get(i-1).getPouringTime());
                    bwTempVOList.get(i-1).setPouringTime(nextDay);
                    Double zj = (Double.parseDouble(bwTempVOList.get(i-1).geteEnd())+
                            Double.parseDouble(bwTempVOList.get(i-1).geteSta()))/2;
                    testinforvoTemp.seteSta(zj.toString());
                    testinforvoTemp.seteEnd(bwTempVOList.get(i-1).geteEnd());
                    bwTempVOList.get(i-1).seteEnd(zj.toString());
                    bwTempVOList.add(i-1,testinforvoTemp);
                    i++;
                }
                aaa=0;
            }
            aaa++;
        }
        if(aaa==1)
        {
            TESTINFORVO testinforvoTemp = new TESTINFORVO();
            BeanUtils.copyProperties(bwTempVOList.get(bwTempVOList.size()-1),testinforvoTemp);
            String nextDay = TimeUtils.byTimeNextDay(bwTempVOList.get(bwTempVOList.size()-1).getPouringTime(),-2);
            testinforvoTemp.setPouringTime(bwTempVOList.get(bwTempVOList.size()-1).getPouringTime());
            bwTempVOList.get(bwTempVOList.size()-1).setPouringTime(nextDay);
            Double zj = (Double.parseDouble(bwTempVOList.get(bwTempVOList.size()-1).geteEnd())+
                    Double.parseDouble(bwTempVOList.get(bwTempVOList.size()-1).geteSta()))/2;
            testinforvoTemp.seteSta(zj.toString());
            testinforvoTemp.seteEnd(bwTempVOList.get(bwTempVOList.size()-1).geteEnd());
            bwTempVOList.get(bwTempVOList.size()-1).seteEnd(zj.toString());
            bwTempVOList.add(bwTempVOList.size()-1,testinforvoTemp);
        }

        dsNo=bwTempVOList.get(0).getDsNo();
        Integer dsCount = 1;
        Integer mark = 0;
        Integer count = 0;
        for(TESTINFORVO testinforvo:bwTempVOList)
        {
            if(!testinforvo.getDsNo().equals(dsNo))
            {
                result.add(mark,dsNo+ " " + (count-mark));
                count++;
                mark=count;
                dsNo=testinforvo.getDsNo();
                dsCount++;
            }
            count++;
            result.add(testinforvo.toStr());
        }
        result.add(mark,dsNo+ " " + (count-mark));
        result.add(0,dsCount+"");
        DatUtils.writeFile(result,fileName);
    }
    @Override
    public void writeBEIYONG() throws IOException {
        String fileName = Constant.SMART_BW_DATA_PATH+"BEIYONG.TXT";
        List<String> result = new ArrayList<>();
        List<BEIYONGVO> bwTempVOList = smartInsulationMapper.writeBEIYONG();
        if(bwTempVOList.size()==0) return;
        String dsNo=bwTempVOList.get(0).getDsNo();
        Integer dsCount = 1;
        Integer mark = 0;
        Integer count = 0;
        for(BEIYONGVO testinforvo:bwTempVOList)
        {
            if(!testinforvo.getDsNo().equals(dsNo))
            {
                result.add(mark,dsNo+ " " + (count-mark));
                count++;
                mark=count;
                dsNo=testinforvo.getDsNo();
                dsCount++;
            }
            count++;
            result.add(testinforvo.toStr());
        }
        result.add(mark,dsNo+ " " + (count-mark));
        result.add(0,dsCount+"");
        DatUtils.writeFile(result,fileName);
    }
    @Override
    public void getYuntu() throws Exception{
        Constant.print(".....................huayuntu.......................");
        String pyPath = Constant.SMART_BW_DATA_PATH+"yuntu.py";
        String cmd = "python "+pyPath;
        Process process = null;
        process = Runtime.getRuntime().exec(cmd);
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
        Constant.print(".....................huayuntujieshu.......................");
    }

    @Override
    public List<TempMeasurementsAssess> getAirTemp() {
        List<TempMeasurementsAssess> tempMeasurementsAssessList = tempMeasurementsAssessMapper.select30Day(30);
        tempMeasurementsAssessList.forEach(t->t.setDifferenceTemp(t.getDifferenceTemp()/2));
        List<TianqiVO>tianqiVOS = TianqiUtils.getTiqnqi();
        if(tianqiVOS==null)
        {
            throw new DamPourException(30002,"天气预报信息获取失败");
        }
        for(int i = 7;i<tianqiVOS.size();i++)
        {
            TianqiVO tianqiVO = tianqiVOS.get(i);
            Double avgTemp = (tianqiVO.getMaxTemperature()+tianqiVO.getMinTemperature())/2;
            Double diffTemp = (tianqiVO.getMaxTemperature()-tianqiVO.getMinTemperature())/2;
            TempMeasurementsAssess tempMeasurementsAssess = new TempMeasurementsAssess();
            tempMeasurementsAssess.setTopTemp(tianqiVO.getMaxTemperature());
            tempMeasurementsAssess.setBottomTemp(tianqiVO.getMinTemperature());
            tempMeasurementsAssess.setAvgTemp(avgTemp);
            tempMeasurementsAssess.setDifferenceTemp(diffTemp);
            tempMeasurementsAssess.setTime(TimeUtils.getNextDay(i));
            tempMeasurementsAssessList.add(tempMeasurementsAssess);
        }
        return tempMeasurementsAssessList;
    }

    @Override
    public void history() throws IOException {
        String time= TimeUtils.getNowTime().substring(0,13);
        List<String> files = new ArrayList<>();
        files.add("BWRES.DAT");
        files.add("DANTI.DAT");
        files.add("LINES.DAT");
        files.add("MDANG.DAT");
        files.add("ZEROS.DAT");
        files.add("AIRTEM.txt");
        files.add("TESTINFOR.TXT");
        String bwDir = Constant.SMART_BW_DATA_PATH;
        String history = Constant.SMART_BW_DATA_PATH+"history\\";
        File fileMk = new File(history+time+"SECRES");
        fileMk.mkdir();
        copy(bwDir+"SECRES",history+time+"SECRES");
        copy(bwDir+"yuntu",history+time+"SECRES");
        for (String file:files)
        {
            File source = new File(bwDir+file);
            File dest = new File(history+time+file);
            try {
                Files.copy(source.toPath(), dest.toPath());
            } catch (IOException e) {
                Constant.logger.error("错误:",e);
            }
        }
    }


    public static void copy(String src, String dest) throws IOException {
        File file = new File(src);
        if (!file.exists()) {
            //可以起到一个抛出异常中断程序的效果
            throw new RuntimeException("找不到指定路径下的文件或文件夹" + src);
        }
        //初始化I/O流
        InputStream in = null;
        OutputStream out = null;
        //如果文件夹是目录，则在指定路径下新建目录，如果是文件则直接复制
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            String cur = dest + File.separatorChar + file.getName();
            File file1 = new File(cur);
            if (!file1.mkdir()) {
                throw new RuntimeException("非法路径" + dest);
            }
            for (File file2 : files) {
                copy(file2.getAbsolutePath(), file1.getAbsolutePath());
            }
        } else {
            in = new FileInputStream(file);
            out = new FileOutputStream(dest + File.separatorChar + file.getName());
            //缓存数组
            byte[] a = new byte[1024];
            int len = -1;
            while ((len = in.read(a)) != -1) {
                out.write(a);
            }
            //将缓存写入目标文件
            out.flush();
            //先创建先释放，后创建后释放
            out.close();
            in.close();
        }
    }


    @Override
    public void writeBwFile1() {
        String fileName = Constant.SMART_BW_DATA_PATH+"bw1.TXT";
        List<BwFilePourTemp> bwFilePourTempList =  smartInsulationMapper.writeBwFile1();
        List<String> result = new ArrayList<>();
        int dsNo = -1;
        int dsCount = 0;
        result.add("0");
        int jgCount = 1;
        for(BwFilePourTemp bwFilePourTemp:bwFilePourTempList)
        {
            if(bwFilePourTemp.getDsNo()!=dsNo)
            {
                jgCount = 1;
                dsCount++;
                dsNo = bwFilePourTemp.getDsNo();
                result.add(String.valueOf(dsCount));
            }
            String temp = jgCount+" "+bwFilePourTemp.getCloseTime().substring(0,16).replace("-"," ").replace(":"," ")+" "+bwFilePourTemp.getPourTemp();
            jgCount++;
            result.add(temp);
        }
        result.set(0, String.valueOf(dsCount));
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("保温文件写入错误",e);
        }
    }
    @Override
    public void writeBwFile2() {
        String fileName = Constant.SMART_BW_DATA_PATH+"bw2.TXT";
        List<BwFileFaceTempVO> bwFilePourTempList =  smartInsulationMapper.writeBwFile2();
        List<String> result = new ArrayList<>();
        int dsNo = -1;
        int dsCount = 0;
        result.add("0");
        String tempTime = "";
        for(BwFileFaceTempVO bwFilePourTemp:bwFilePourTempList)
        {
            if(bwFilePourTemp.getDsNo()!=dsNo)
            {
                dsCount++;
                dsNo = bwFilePourTemp.getDsNo();
                result.add(String.valueOf(dsCount));
            }
            if(bwFilePourTemp.getTime().equals(tempTime))
            {
                result.set(result.size()-1, result.get(result.size()-1)+" "+bwFilePourTemp.getAvgTemp());
            }
            else
            {
                String temp =bwFilePourTemp.getTime().replace("-"," ")+" 30"+" "+bwFilePourTemp.getAvgTemp();

                result.add(temp);
                tempTime  = bwFilePourTemp.getTime();
            }

        }
        result.set(0, String.valueOf(dsCount));
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("保温文件写入错误",e);
        }

    }
    @Override
    public void writeBwFile3() {
        String fileName = Constant.SMART_BW_DATA_PATH+"bw3.TXT";
        List<BwFileFlowVO> bwFilePourTempList =  smartInsulationMapper.writeBwFile3();
        List<String> result = new ArrayList<>();
        int dsNo = -1;
        int dsCount = 0;
        result.add("0");
        int jgCount = 0;
        Map<Integer,Integer> sbMap = new HashMap<>();
        for(BwFileFlowVO bwFilePourTemp:bwFilePourTempList)
        {
            if(bwFilePourTemp.getDsNo()!=dsNo)
            {
                dsCount++;
                dsNo = bwFilePourTemp.getDsNo();
                result.add(String.valueOf(dsCount));
                jgCount = 0;
            }
            if(!sbMap.containsKey(bwFilePourTemp.getSbId()))
            {
                jgCount+=1;
                sbMap.put(bwFilePourTemp.getSbId(),jgCount);
            }
            String temp =bwFilePourTemp.getTime().substring(0,13).replace("-"," ")+" 30"+" "+sbMap.get(bwFilePourTemp.getSbId())+" "+ bwFilePourTemp.getTemp()+" "+bwFilePourTemp.getFlow();
            result.add(temp);
        }
        result.set(0, String.valueOf(dsCount));
        try {
            DatUtils.writeFile(result,fileName);
        } catch (IOException e) {
            Constant.logger.error("保温文件写入错误",e);
        }
    }

}
