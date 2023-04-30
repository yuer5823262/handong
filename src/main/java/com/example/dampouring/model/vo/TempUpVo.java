package com.example.dampouring.model.vo;

public class TempUpVo {
    String sbNo;
    Double exportMachineTemp;
    Double inBoundTemp;
    Double pouringTemp;
    Double inBoundUp;
    Double pouringUp;

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Double getExportMachineTemp() {
        return exportMachineTemp;
    }

    public void setExportMachineTemp(Double exportMachineTemp) {
        this.exportMachineTemp = exportMachineTemp;
    }

    public Double getInBoundTemp() {
        return inBoundTemp;
    }

    public void setInBoundTemp(Double inBoundTemp) {
        this.inBoundTemp = inBoundTemp;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Double getInBoundUp() {
        return inBoundUp;
    }

    public void setInBoundUp(Double inBoundUp) {
        this.inBoundUp = inBoundUp;
    }

    public Double getPouringUp() {
        return pouringUp;
    }

    public void setPouringUp(Double pouringUp) {
        this.pouringUp = pouringUp;
    }
}
