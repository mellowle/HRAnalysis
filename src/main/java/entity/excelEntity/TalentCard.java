package entity.excelEntity;

public class TalentCard {
    private String wwid;
    private Integer jnj_role_number;
    private Integer external_role_number;
    private Integer total_role_number;
    private Double average_duration_of_jnj_role;
    private Double average_duration_of_external_role;
    private Double average_duration_of_each_role;
    private Double total_working_years;
    private Double external_length_of_service;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getJnj_role_number() {
        return jnj_role_number;
    }

    public void setJnj_role_number(Integer jnj_role_number) {
        this.jnj_role_number = jnj_role_number;
    }

    public Integer getExternal_role_number() {
        return external_role_number;
    }

    public void setExternal_role_number(Integer external_role_number) {
        this.external_role_number = external_role_number;
    }

    public Integer getTotal_role_number() {
        return total_role_number;
    }

    public void setTotal_role_number(Integer total_role_number) {
        this.total_role_number = total_role_number;
    }

    public Double getAverage_duration_of_jnj_role() {
        return average_duration_of_jnj_role;
    }

    public void setAverage_duration_of_jnj_role(Double average_duration_of_jnj_role) {
        this.average_duration_of_jnj_role = average_duration_of_jnj_role;
    }

    public Double getAverage_duration_of_external_role() {
        return average_duration_of_external_role;
    }

    public void setAverage_duration_of_external_role(Double average_duration_of_external_role) {
        this.average_duration_of_external_role = average_duration_of_external_role;
    }

    public Double getAverage_duration_of_each_role() {
        return average_duration_of_each_role;
    }

    public void setAverage_duration_of_each_role(Double average_duration_of_each_role) {
        this.average_duration_of_each_role = average_duration_of_each_role;
    }

    public Double getTotal_working_years() {
        return total_working_years;
    }

    public void setTotal_working_years(Double total_working_years) {
        this.total_working_years = total_working_years;
    }

    public Double getExternal_length_of_service() {
        return external_length_of_service;
    }

    public void setExternal_length_of_service(Double external_length_of_service) {
        this.external_length_of_service = external_length_of_service;
    }

    @Override
    public String toString() {
        return "TalentCard{" +
                "wwid='" + wwid + '\'' +
                ", jnj_role_number=" + jnj_role_number +
                ", external_role_number=" + external_role_number +
                ", total_role_number=" + total_role_number +
                ", average_duration_of_jnj_role=" + average_duration_of_jnj_role +
                ", average_duration_of_external_role=" + average_duration_of_external_role +
                ", average_duration_of_each_role=" + average_duration_of_each_role +
                ", total_working_years=" + total_working_years +
                ", external_length_of_service=" + external_length_of_service +
                '}';
    }
}
