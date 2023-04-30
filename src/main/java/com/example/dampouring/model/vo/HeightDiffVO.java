package com.example.dampouring.model.vo;

public class HeightDiffVO {
    Double adjacentMaxDifference;
    Double lowestElevation;
    Double highestElevation;
    Double damBottomElevation;
    Double damTopElevation;

    public Double getAdjacentMaxDifference() {
        return adjacentMaxDifference;
    }

    public void setAdjacentMaxDifference(Double adjacentMaxDifference) {
        this.adjacentMaxDifference = adjacentMaxDifference;
    }

    public Double getLowestElevation() {
        return lowestElevation;
    }

    public void setLowestElevation(Double lowestElevation) {
        this.lowestElevation = lowestElevation;
    }

    public Double getHighestElevation() {
        return highestElevation;
    }

    public void setHighestElevation(Double highestElevation) {
        this.highestElevation = highestElevation;
    }

    public Double getDamBottomElevation() {
        return damBottomElevation;
    }

    public void setDamBottomElevation(Double damBottomElevation) {
        this.damBottomElevation = damBottomElevation;
    }

    public Double getDamTopElevation() {
        return damTopElevation;
    }

    public void setDamTopElevation(Double damTopElevation) {
        this.damTopElevation = damTopElevation;
    }
}
