package entity.excelEntity;

public class Compensation {
    private String wwid;
    private Double bonus2016;
    private Double bonus2017;
    private Double bonus2018;
    private Double base2017;
    private Double base2018;
    private Double base2019;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getBonus2016() {
        return bonus2016;
    }

    public void setBonus2016(Double bonus2016) {
        this.bonus2016 = bonus2016;
    }

    public Double getBonus2017() {
        return bonus2017;
    }

    public void setBonus2017(Double bonus2017) {
        this.bonus2017 = bonus2017;
    }

    public Double getBonus2018() {
        return bonus2018;
    }

    public void setBonus2018(Double bonus2018) {
        this.bonus2018 = bonus2018;
    }

    public Double getBase2017() {
        return base2017;
    }

    public void setBase2017(Double base2017) {
        this.base2017 = base2017;
    }

    public Double getBase2018() {
        return base2018;
    }

    public void setBase2018(Double base2018) {
        this.base2018 = base2018;
    }

    public Double getBase2019() {
        return base2019;
    }

    public void setBase2019(Double base2019) {
        this.base2019 = base2019;
    }

    @Override
    public String toString() {
        return "Compensation{" +
                "wwid='" + wwid + '\'' +
                ", bonus2016=" + bonus2016 +
                ", bonus2017=" + bonus2017 +
                ", bonus2018=" + bonus2018 +
                ", base2017=" + base2017 +
                ", base2018=" + base2018 +
                ", base2019=" + base2019 +
                '}';
    }
}
