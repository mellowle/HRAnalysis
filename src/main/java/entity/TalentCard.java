package entity;

public class TalentCard {
    private String wwid;
    private int number_of_jnj_roles;
    private int average_time_of_jnj_roles;
    private int number_of_external_roles;
    private int average_time_of_external_roles;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public int getNumber_of_jnj_roles() {
        return number_of_jnj_roles;
    }

    public void setNumber_of_jnj_roles(int number_of_jnj_roles) {
        this.number_of_jnj_roles = number_of_jnj_roles;
    }

    public int getAverage_time_of_jnj_roles() {
        return average_time_of_jnj_roles;
    }

    public void setAverage_time_of_jnj_roles(int average_time_of_jnj_roles) {
        this.average_time_of_jnj_roles = average_time_of_jnj_roles;
    }

    public int getNumber_of_external_roles() {
        return number_of_external_roles;
    }

    public void setNumber_of_external_roles(int number_of_external_roles) {
        this.number_of_external_roles = number_of_external_roles;
    }

    public int getAverage_time_of_external_roles() {
        return average_time_of_external_roles;
    }

    public void setAverage_time_of_external_roles(int average_time_of_external_roles) {
        this.average_time_of_external_roles = average_time_of_external_roles;
    }
}
