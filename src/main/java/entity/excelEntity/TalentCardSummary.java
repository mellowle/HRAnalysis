package entity.excelEntity;

public class TalentCardSummary {
    private String wwid;
    private Integer graduation_year;
    private Integer external_role_number;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Integer getExternal_role_number() {
        return external_role_number;
    }

    public void setExternal_role_number(Integer external_role_number) {
        this.external_role_number = external_role_number;
    }

    @Override
    public String toString() {
        return "TalentCardSummary{" +
                "wwid='" + wwid + '\'' +
                ", graduation_year=" + graduation_year +
                ", external_role_number=" + external_role_number +
                '}';
    }
}
