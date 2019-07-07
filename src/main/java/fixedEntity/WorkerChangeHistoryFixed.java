package fixedEntity;

public class WorkerChangeHistoryFixed {

    private String wwid;
    private Integer function_movements;
    private Integer lateral_movements;
    private Integer promotions;
    private Integer region_movements;
    private Integer country_movements;
    private Integer sector_movements;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getFunction_movements() {
        return function_movements;
    }

    public void setFunction_movements(Integer function_movements) {
        this.function_movements = function_movements;
    }

    public Integer getLateral_movements() {
        return lateral_movements;
    }

    public void setLateral_movements(Integer lateral_movements) {
        this.lateral_movements = lateral_movements;
    }

    public Integer getPromotions() {
        return promotions;
    }

    public void setPromotions(Integer promotions) {
        this.promotions = promotions;
    }

    public Integer getRegion_movements() {
        return region_movements;
    }

    public void setRegion_movements(Integer region_movements) {
        this.region_movements = region_movements;
    }

    public Integer getCountry_movements() {
        return country_movements;
    }

    public void setCountry_movements(Integer country_movements) {
        this.country_movements = country_movements;
    }

    public Integer getSector_movements() {
        return sector_movements;
    }

    public void setSector_movements(Integer sector_movements) {
        this.sector_movements = sector_movements;
    }

    @Override
    public String toString() {
        return "WorkerChangeHistoryFixed{" +
                "wwid='" + wwid + '\'' +
                ", function_movements=" + function_movements +
                ", lateral_movements=" + lateral_movements +
                ", promotions=" + promotions +
                ", region_movements=" + region_movements +
                ", country_movements=" + country_movements +
                ", sector_movements=" + sector_movements +
                '}';
    }
}
