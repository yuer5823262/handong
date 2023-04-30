package com.example.dampouring.model.vo;

public class SmartBwAdviceVO {
    String dsNo;
    String materials;
    String materialsMark;
    Integer ply;
    Integer currentPly;
    Integer plies;
    Integer futurePly;
    Integer futurePlies;
    String reMark;

    public String getDsNo() {
        return dsNo;
    }

    public void setDsNo(String dsNo) {
        this.dsNo = dsNo;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getMaterialsMark() {
        return materialsMark;
    }

    public void setMaterialsMark(String materialsMark) {
        this.materialsMark = materialsMark;
    }

    public Integer getPly() {
        if(ply!=null)
            return ply;
        else
            return 1;
    }

    public void setPly(Integer ply) {
        this.ply = ply;
    }

    public Integer getCurrentPly() {
        return currentPly;
    }

    public void setCurrentPly(Integer currentPly) {
        this.currentPly = currentPly;
    }

    public Integer getPlies() {
        return plies;
    }

    public void setPlies(Integer plies) {
        this.plies = plies;
    }

    public Integer getFuturePly() {
        return futurePly;
    }

    public void setFuturePly(Integer futurePly) {
        this.futurePly = futurePly;
    }

    public Integer getFuturePlies() {
        return futurePlies;
    }

    public void setFuturePlies(Integer futurePlies) {
        this.futurePlies = futurePlies;
    }

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
    }
}
