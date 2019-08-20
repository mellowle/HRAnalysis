package entity.excelEntity;

public class KF4DEmployeeDemographics {
    private String wwid;
    private String band;
    private String sector;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "KF4DEmployeeDemographics{" +
                "wwid='" + wwid + '\'' +
                ", band='" + band + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
