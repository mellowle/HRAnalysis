package domain;

import java.util.List;

public class CriticalExperience {

    private String wwid;
    private int functionMovement;
    private int lateralMovement;
    private int promotions;
    private int regionMovdments;
    private int countryMovements;
    private int sectorMovements;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public int getFunctionMovement() {
        return functionMovement;
    }

    public void setFunctionMovement(int functionMovement) {
        this.functionMovement = functionMovement;
    }

    public int getLateralMovement() {
        return lateralMovement;
    }

    public void setLateralMovement(int lateralMovement) {
        this.lateralMovement = lateralMovement;
    }

    public int getPromotions() {
        return promotions;
    }

    public void setPromotions(int promotions) {
        this.promotions = promotions;
    }

    public int getRegionMovdments() {
        return regionMovdments;
    }

    public void setRegionMovdments(int regionMovdments) {
        this.regionMovdments = regionMovdments;
    }

    public int getCountryMovements() {
        return countryMovements;
    }

    public void setCountryMovements(int countryMovements) {
        this.countryMovements = countryMovements;
    }

    public int getSectorMovements() {
        return sectorMovements;
    }

    public void setSectorMovements(int sectorMovements) {
        this.sectorMovements = sectorMovements;
    }
}
