package entity.excelEntity.fixed;

public class PerformanceRatingFixed {

    private String wwid;
    private String overall_rating2016;
    private String overall_rating2017;
    private String overall_rating2018;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getOverall_rating2016() {
        return overall_rating2016;
    }

    public void setOverall_rating2016(String overall_rating2016) {
        this.overall_rating2016 = overall_rating2016;
    }

    public String getOverall_rating2017() {
        return overall_rating2017;
    }

    public void setOverall_rating2017(String overall_rating2017) {
        this.overall_rating2017 = overall_rating2017;
    }

    public String getOverall_rating2018() {
        return overall_rating2018;
    }

    public void setOverall_rating2018(String overall_rating2018) {
        this.overall_rating2018 = overall_rating2018;
    }

    @Override
    public String toString() {
        return "PerformanceRatingFixed{" +
                "wwid='" + wwid + '\'' +
                ", overall_rating2016='" + overall_rating2016 + '\'' +
                ", overall_rating2017='" + overall_rating2017 + '\'' +
                ", overall_rating2018='" + overall_rating2018 + '\'' +
                '}';
    }

    public void resetInsufficientData() {
        if (this.overall_rating2018 != null && this.overall_rating2018.equals("Insufficient Data to Rate / Insufficient Data to Rate")) {
            this.overall_rating2016 = null;
            this.overall_rating2017 = null;
            this.overall_rating2018 = null;
        }

        if (this.overall_rating2017 != null && this.overall_rating2017.equals("Insufficient Data to Rate / Insufficient Data to Rate")) {
            this.overall_rating2017 = "";
        }

        if (this.overall_rating2016 != null && this.overall_rating2016.equals("Insufficient Data to Rate / Insufficient Data to Rate")) {
            this.overall_rating2016 = "";
        }
    }
}
