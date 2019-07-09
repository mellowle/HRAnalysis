package entity.excelEntity;

public class Compensation {
    private String wwid;
    private Double bonus2016;
    private Double bonus2017;
    private Double bonus2018;

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


    @Override
    public String toString() {
        return "Compensation{" +
                "wwid='" + wwid + '\'' +
                ", bonus2016=" + bonus2016 +
                ", bonus2017=" + bonus2017 +
                ", bonus2018=" + bonus2018 +
                '}';
    }
}
