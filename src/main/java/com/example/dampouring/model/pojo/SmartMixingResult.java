package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SmartMixingResult {
    private Integer id;

    private Integer mbid;
    @Excel(name = "拌合楼号",width = 20)
    public String mbNo;
    @Excel(name = "实测出击口温度",width = 20)
    private Double actualPortTemp; //实测出击口温度
    @Excel(name = "预测初机口温度",width = 20)
    private Double projectionsPortTemp; //预测初机口温度
    @Excel(name = "目标出机口温度",width = 20)
    private Double targetPortTemp; //目标出机口
    @Excel(name = "水温",width = 20)
    private Double waterTemp; //水温
    @Excel(name = "水泥温度",width = 20)
    private Double betonTemp; //水泥温度
    @Excel(name = "粉煤灰温度",width = 20)
    private Double flyashTemp; //粉煤灰温度
    @Excel(name = "特大石温度",width = 20)
    private Double tdsTemp;  //特大石温度
    @Excel(name = "大石温度",width = 20)
    private Double dsTemp;  //大石温度
    @Excel(name = "中石温度",width = 20)
    private Double zsTemp;  //中石温度
    @Excel(name = "小石温度",width = 20)
    private Double xsTemp; //小石温度
    @Excel(name = "砂温度",width = 20)
    private Double standTemp; //砂温度
    @Excel(name = "外加剂温度",width = 20)
    private Double additiveTemp; //外加剂温度
    @Excel(name = "自然拌合出机口温度",width = 20)
    private Double t01;  //预测初机口温度

    private Double ts;  //方案一应调整水温

    private Double tb; //方案二调整加冰量

    private Double gb; //

    private Double ts1; //方案一应调整水温

    private Double tb1; //方案二调整加冰量

    private Double tsr; //调整水温(出击口温度高于目标温度)

    private Double tg; //调整骨料温度

    private Double μ; //加冰率

    private String time;
    @Excel(name = "建议执行操作",width = 20)
    private String sf; //备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMbNo() {
        return mbNo;
    }

    public void setMbNo(String mbNo) {
        this.mbNo = mbNo;
    }

    public Integer getMbid() {
        return mbid;
    }

    public void setMbid(Integer mbid) {
        this.mbid = mbid;
    }

    public Double getActualPortTemp() {
        return actualPortTemp;
    }

    public void setActualPortTemp(Double actualPortTemp) {
        this.actualPortTemp = actualPortTemp;
    }

    public Double getProjectionsPortTemp() {
        return projectionsPortTemp;
    }

    public void setProjectionsPortTemp(Double projectionsPortTemp) {
        this.projectionsPortTemp = projectionsPortTemp;
    }

    public Double getTargetPortTemp() {
        return targetPortTemp;
    }

    public void setTargetPortTemp(Double targetPortTemp) {
        this.targetPortTemp = targetPortTemp;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Double getBetonTemp() {
        return betonTemp;
    }

    public void setBetonTemp(Double betonTemp) {
        this.betonTemp = betonTemp;
    }

    public Double getFlyashTemp() {
        return flyashTemp;
    }

    public void setFlyashTemp(Double flyashTemp) {
        this.flyashTemp = flyashTemp;
    }

    public Double getTdsTemp() {
        return tdsTemp;
    }

    public void setTdsTemp(Double tdsTemp) {
        this.tdsTemp = tdsTemp;
    }

    public Double getDsTemp() {
        return dsTemp;
    }

    public void setDsTemp(Double dsTemp) {
        this.dsTemp = dsTemp;
    }

    public Double getZsTemp() {
        return zsTemp;
    }

    public void setZsTemp(Double zsTemp) {
        this.zsTemp = zsTemp;
    }

    public Double getXsTemp() {
        return xsTemp;
    }

    public void setXsTemp(Double xsTemp) {
        this.xsTemp = xsTemp;
    }

    public Double getStandTemp() {
        return standTemp;
    }

    public void setStandTemp(Double standTemp) {
        this.standTemp = standTemp;
    }

    public Double getAdditiveTemp() {
        return additiveTemp;
    }

    public void setAdditiveTemp(Double additiveTemp) {
        this.additiveTemp = additiveTemp;
    }

    public Double getT01() {
        return t01;
    }

    public void setT01(Double t01) {
        this.t01 = t01;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

    public Double getTb() {
        return tb;
    }

    public void setTb(Double tb) {
        this.tb = tb;
    }

    public Double getGb() {
        return gb;
    }

    public void setGb(Double gb) {
        this.gb = gb;
    }

    public Double getTsr() {
        return tsr;
    }

    public void setTsr(Double tsr) {
        this.tsr = tsr;
    }

    public Double getTg() {
        return tg;
    }

    public void setTg(Double tg) {
        this.tg = tg;
    }

    public Double getΜ() {
        return μ;
    }

    public void setΜ(Double μ) {
        this.μ = μ;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf == null ? null : sf.trim();
    }

    public Double getTs1() {
        return ts1;
    }

    public void setTs1(Double ts1) {
        this.ts1 = ts1;
    }

    public Double getTb1() {
        return tb1;
    }

    public void setTb1(Double tb1) {
        this.tb1 = tb1;
    }

    public boolean checkData()
    {
        if(actualPortTemp==null||waterTemp==null||betonTemp==null||flyashTemp==null||standTemp==null
        ||additiveTemp==null||tdsTemp==null||dsTemp==null||zsTemp==null||xsTemp==null)
            return false;
        return true;
    }
    public void Calculate(SmartMixingPara smartMixingPara)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Double G1 = smartMixingPara.getG1();
        Double G2 = smartMixingPara.getG2();
        Double G3 = smartMixingPara.getG3();
        Double G4 = smartMixingPara.getG4();
        Double G5 = smartMixingPara.getG5();
        Double G6 = smartMixingPara.getG6();
        Double G7 = smartMixingPara.getG7();
        Double G8 = smartMixingPara.getG8();
        Double G9 = smartMixingPara.getG9();
        Double C1 = smartMixingPara.getC1();
        Double C2 = smartMixingPara.getC2();
        Double C3 = smartMixingPara.getC3();
        Double C4 = smartMixingPara.getC4();
        Double C5 = smartMixingPara.getC5();
        Double C6 = smartMixingPara.getC6();
        Double C7 = smartMixingPara.getC7();
        Double C8 = smartMixingPara.getC8();
        Double C9 = smartMixingPara.getC9();
        Double λtds = smartMixingPara.getΛtds();
        Double P = smartMixingPara.getP();

        Double T = smartMixingPara.getT();

        Double V = smartMixingPara.getV();

        Double η = smartMixingPara.getΗ();

        Double T01 = smartMixingPara.getT01();

        Double Tmins = smartMixingPara.getTmins();

        Double Tmaxs = smartMixingPara.getTmaxs();

        Double Gmaxb = smartMixingPara.getGmaxb();

        Double Qs = smartMixingPara.getQs();

        Double Qtds = smartMixingPara.getQtds();

        Double Qds = smartMixingPara.getQds();

        Double Qzs = smartMixingPara.getQzs();

        Double Qxs = smartMixingPara.getQxs();
        Double Q = 42*P*T/V;
        Double ΣGiCi = G1*C1+G2*C2+G3*C3+G4*C4+G5*C5+G6*C6+G7*C7+G8*C8+G9*C9;

        Double tzsw = (T01*ΣGiCi-λtds*tdsTemp*G2*(C2+ C1*Qtds)-
                dsTemp*G3*(C3+ C1*Qds)- zsTemp*G4*(C4+ C1*Qzs)- xsTemp*G5*(C5+ C1*Qxs)-
                standTemp*G6*(C6+ C1*Qs)- betonTemp*G7*C7- flyashTemp*G8*C8- additiveTemp*G9*C9-Q)/
                ((G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1);

        Double tzb = (waterTemp*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
                dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q-T01*ΣGiCi)/
                (335*η+waterTemp*C1);

        t01 =(waterTemp*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
            dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q)/ΣGiCi;
        targetPortTemp = T01;
        if(t01>T01)
        {
            tb1= tzb;
            sf="建议调整加冰量为"+df.format(tb1)+"kg/m³";
            μ = tb1/G1;
            if(μ<=Gmaxb)
                projectionsPortTemp =(waterTemp*(1-μ)*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
                        dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                        standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q-335*η*tb1)/ΣGiCi;
            if(μ>Gmaxb)
            {
                tb1 = null;
                ts1 = tzsw;
                sf="建议将水温调整为"+df.format(ts1)+"摄氏度";
                if(ts1>=Tmins)
                    projectionsPortTemp=(ts1*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
                            dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                            standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q)/ΣGiCi;
                if(ts1<Tmins)
                {
                    ts1=Tmins;
                    tb1=(Tmins*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
                            dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                            standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q-T01*ΣGiCi)/
                            (335*η+Tmins*C1);
                    μ = tb1/G1;
                    projectionsPortTemp =(ts1*(1-μ)*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1+λtds*tdsTemp*G2*(C2+ C1*Qtds)+
                            dsTemp*G3*(C3+ C1*Qds)+ zsTemp*G4*(C4+ C1*Qzs)+ xsTemp*G5*(C5+ C1*Qxs)+
                            standTemp*G6*(C6+ C1*Qs)+ betonTemp*G7*C7+ flyashTemp*G8*C8+ additiveTemp*G9*C9+Q-335*η*tb1)/ΣGiCi;
                    sf="建议将水温调整为6摄氏度，且将加冰量调整为"+df.format(tb1)+"kg/m³";
                    if(μ>Gmaxb)
                        sf="出机口温度不满足要求";
                }
            }
        }
        if(t01<T01)
        {
            tsr = tzsw;
            sf="建议将水温调整为"+df.format(tsr)+"摄氏度";
            if(tsr>Tmaxs)
            {
                tsr=null;
                tg = (T01*ΣGiCi-waterTemp*(G1-G2*Qtds-G3*Qds-G4*Qzs-G5*Qxs-G6*Qs)*C1-standTemp*G6*(C6+ C1*Qs)-
                        betonTemp*G7*C7- flyashTemp*G8*C8- additiveTemp*G9*C9-Q)/
                        (λtds*G2*(C2+ C1*Qtds)+ G3*(C3+ C1*Qds)+ G4*(C4+ C1*Qzs)+ G5*(C5+ C1*Qxs));
                sf="建议将骨料温度调整为"+df.format(tg)+"摄氏度";
            }
        }
    }
}