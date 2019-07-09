package entity.excelEntity;

import java.util.Date;

public class EmployeeDemographics {
    private String wwid;
    private Integer employee_pay_grade;
    private String home_location_code;
    private String position_id;
    private String job_profile;
    private Long job_profile_id;
    private String job_function;
    private String job_sub_function;
    private String sector;
    private Double time_in_position;
    private Double length_of_service_in_years;
    private Date original_hire_date;
    private Date hire_date_most_recent;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getEmployee_pay_grade() {
        return employee_pay_grade;
    }

    public void setEmployee_pay_grade(Integer employee_pay_grade) {
        this.employee_pay_grade = employee_pay_grade;
    }

    public String getHome_location_code() {
        return home_location_code;
    }

    public void setHome_location_code(String home_location_code) {
        this.home_location_code = home_location_code;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getJob_profile() {
        return job_profile;
    }

    public void setJob_profile(String job_profile) {
        this.job_profile = job_profile;
    }

    public Long getJob_profile_id() {
        return job_profile_id;
    }

    public void setJob_profile_id(Long job_profile_id) {
        this.job_profile_id = job_profile_id;
    }

    public String getJob_function() {
        return job_function;
    }

    public void setJob_function(String job_function) {
        this.job_function = job_function;
    }

    public String getJob_sub_function() {
        return job_sub_function;
    }

    public void setJob_sub_function(String job_sub_function) {
        this.job_sub_function = job_sub_function;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getTime_in_position() {
        return time_in_position;
    }

    public void setTime_in_position(Double time_in_position) {
        this.time_in_position = time_in_position;
    }

    public Double getLength_of_service_in_years() {
        return length_of_service_in_years;
    }

    public void setLength_of_service_in_years(Double length_of_service_in_years) {
        this.length_of_service_in_years = length_of_service_in_years;
    }

    public Date getOriginal_hire_date() {
        return original_hire_date;
    }

    public void setOriginal_hire_date(Date original_hire_date) {
        this.original_hire_date = original_hire_date;
    }

    public Date getHire_date_most_recent() {
        return hire_date_most_recent;
    }

    public void setHire_date_most_recent(Date hire_date_most_recent) {
        this.hire_date_most_recent = hire_date_most_recent;
    }

    @Override
    public String toString() {
        return "EmployeeDemographics{" +
                "wwid='" + wwid + '\'' +
                ", employee_pay_grade=" + employee_pay_grade +
                ", home_location_code='" + home_location_code + '\'' +
                ", position_id='" + position_id + '\'' +
                ", job_profile='" + job_profile + '\'' +
                ", job_profile_id=" + job_profile_id +
                ", job_function='" + job_function + '\'' +
                ", job_sub_function='" + job_sub_function + '\'' +
                ", sector='" + sector + '\'' +
                ", time_in_position=" + time_in_position +
                ", length_of_service_in_years=" + length_of_service_in_years +
                ", original_hire_date=" + original_hire_date +
                ", hire_date_most_recent=" + hire_date_most_recent +
                '}';
    }
}
