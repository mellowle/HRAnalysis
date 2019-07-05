package entity;

public class TalentCard {
    private String wwid;
    private String number_of_jnj_roles;
    private String average_time_of_jnj_roles;
    private String number_of_external_roles;
    private String average_time_of_external_roles;
    private String externalLengthOfService;
    private String totalRoleNumber;
    private String totalWorkingYears;
    private String averageTimeOfEachRole;

    public void setExternalLengthOfService() {
        if (number_of_external_roles != null && average_time_of_external_roles != null) {
            this.externalLengthOfService = String.valueOf(Double.valueOf(number_of_external_roles) * Double.valueOf(average_time_of_external_roles));
        }
    }

    public void setTotalRoleNumber() {
        if (number_of_jnj_roles != null && number_of_external_roles != null) {
            this.totalRoleNumber = String.valueOf(Double.valueOf(number_of_jnj_roles) + Double.valueOf(number_of_external_roles));
        }

    }

    public void setTotalWorkingYears() {
        if (number_of_jnj_roles != null
                && average_time_of_jnj_roles != null
                && number_of_external_roles != null
                & average_time_of_external_roles != null) {
            this.totalWorkingYears = String.valueOf(
                    Double.valueOf(number_of_jnj_roles) * Double.valueOf(average_time_of_jnj_roles)
                            + Double.valueOf(number_of_external_roles) * Double.valueOf(average_time_of_external_roles)
            );
        }

    }

    public void setAverageTimeOfEachRole() {
        if (number_of_jnj_roles != null
                && average_time_of_jnj_roles != null
                && number_of_external_roles != null
                & average_time_of_external_roles != null) {
            this.averageTimeOfEachRole = String.valueOf(
                    (Double.valueOf(number_of_jnj_roles) * Double.valueOf(average_time_of_jnj_roles)
                            + Double.valueOf(number_of_external_roles) * Double.valueOf(average_time_of_external_roles)) /
                            (Double.valueOf(number_of_jnj_roles) + Double.valueOf(number_of_external_roles))
            );
        }

    }
    
    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getNumber_of_jnj_roles() {
        return number_of_jnj_roles;
    }

    public void setNumber_of_jnj_roles(String number_of_jnj_roles) {
        this.number_of_jnj_roles = number_of_jnj_roles;
    }

    public String getAverage_time_of_jnj_roles() {
        return average_time_of_jnj_roles;
    }

    public void setAverage_time_of_jnj_roles(String average_time_of_jnj_roles) {
        this.average_time_of_jnj_roles = average_time_of_jnj_roles;
    }

    public String getNumber_of_external_roles() {
        return number_of_external_roles;
    }

    public void setNumber_of_external_roles(String number_of_external_roles) {
        this.number_of_external_roles = number_of_external_roles;
    }

    public String getAverage_time_of_external_roles() {
        return average_time_of_external_roles;
    }

    public void setAverage_time_of_external_roles(String average_time_of_external_roles) {
        this.average_time_of_external_roles = average_time_of_external_roles;
    }
}
