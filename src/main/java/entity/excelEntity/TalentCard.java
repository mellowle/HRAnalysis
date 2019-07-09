package entity.excelEntity;

public class TalentCard {
    private String wwid;
    private Integer jnj_roles;
    private Integer external_roles;
    private Integer total_roles;
    private Double average_time_of_jnj_role;
    private Double average_time_of_external_role;
    private Double total_working_year;
    private Double external_length_of_service;
    private Double average_time_of_each_role;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getJnj_roles() {
        return jnj_roles;
    }

    public void setJnj_roles(Integer jnj_roles) {
        this.jnj_roles = jnj_roles;
    }

    public Integer getExternal_roles() {
        return external_roles;
    }

    public void setExternal_roles(Integer external_roles) {
        this.external_roles = external_roles;
    }

    public Integer getTotal_roles() {
        return total_roles;
    }

    public void setTotal_roles(Integer total_roles) {
        this.total_roles = total_roles;
    }

    public Double getAverage_time_of_jnj_role() {
        return average_time_of_jnj_role;
    }

    public void setAverage_time_of_jnj_role(Double average_time_of_jnj_role) {
        this.average_time_of_jnj_role = average_time_of_jnj_role;
    }

    public Double getAverage_time_of_external_role() {
        return average_time_of_external_role;
    }

    public void setAverage_time_of_external_role(Double average_time_of_external_role) {
        this.average_time_of_external_role = average_time_of_external_role;
    }

    public Double getTotal_working_year() {
        return total_working_year;
    }

    public void setTotal_working_year(Double total_working_year) {
        this.total_working_year = total_working_year;
    }

    public Double getExternal_length_of_service() {
        return external_length_of_service;
    }

    public void setExternal_length_of_service(Double external_length_of_service) {
        this.external_length_of_service = external_length_of_service;
    }

    public Double getAverage_time_of_each_role() {
        return average_time_of_each_role;
    }

    public void setAverage_time_of_each_role(Double average_time_of_each_role) {
        this.average_time_of_each_role = average_time_of_each_role;
    }

    @Override
    public String toString() {
        return "TalentCard{" +
                "wwid='" + wwid + '\'' +
                ", jnj_roles=" + jnj_roles +
                ", external_roles=" + external_roles +
                ", total_roles=" + total_roles +
                ", average_time_of_jnj_role=" + average_time_of_jnj_role +
                ", average_time_of_external_role=" + average_time_of_external_role +
                ", total_working_year=" + total_working_year +
                ", external_length_of_service=" + external_length_of_service +
                ", average_time_of_each_role=" + average_time_of_each_role +
                '}';
    }
}
