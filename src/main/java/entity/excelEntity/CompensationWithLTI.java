package entity.excelEntity;

public class CompensationWithLTI {
    private String wwid;
    private Double base2017;
    private Double base2018;
    private Double base2019;
    private Double planed_lti2016;
    private Double planed_lti2017;
    private Double planed_lti2018;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
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

    public Double getPlaned_lti2016() {
        return planed_lti2016;
    }

    public void setPlaned_lti2016(Double planed_lti2016) {
        this.planed_lti2016 = planed_lti2016;
    }

    public Double getPlaned_lti2017() {
        return planed_lti2017;
    }

    public void setPlaned_lti2017(Double planed_lti2017) {
        this.planed_lti2017 = planed_lti2017;
    }

    public Double getPlaned_lti2018() {
        return planed_lti2018;
    }

    public void setPlaned_lti2018(Double planed_lti2018) {
        this.planed_lti2018 = planed_lti2018;
    }

    @Override
    public String toString() {
        return "CompensationWithLTI{" +
                "wwid='" + wwid + '\'' +
                ", base2017=" + base2017 +
                ", base2018=" + base2018 +
                ", base2019=" + base2019 +
                ", planed_lti2016=" + planed_lti2016 +
                ", planed_lti2017=" + planed_lti2017 +
                ", planed_lti2018=" + planed_lti2018 +
                '}';
    }
}
