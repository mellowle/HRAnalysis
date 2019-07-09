package entity.excelEntity;

public class DirectReport {
    private String wwid;
    private Integer direct_report;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getDirect_report() {
        return direct_report;
    }

    public void setDirect_report(Integer direct_report) {
        this.direct_report = direct_report;
    }

    @Override
    public String toString() {
        return "DirectReport{" +
                "wwid='" + wwid + '\'' +
                ", direct_report=" + direct_report +
                '}';
    }
}