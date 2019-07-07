package excel.excelEntity;


import java.util.Date;

public class WorkerChangeHistory {
    public String wwid;
    public Date business_process_effective_date;
    public Date business_process_completed_date;
    public String business_process_status;
    public String business_process_type;
    public String business_process_reason;
    public String position_current;
    public String position_proposed;
    public String region_current;
    public String region_proposed;
    public String company_current;
    public String company_proposed;
    public String job_profile_current;
    public String job_profile_proposed;
    public String location_current;
    public String location_proposed;
    public String compensation_grade_current;
    public String compensation_grade_proposed;
    public String pay_group_change;
    public Double base_pay_current;
    public Double base_pay_proposed;
    public Double base_pay_change_amount;
    public Double base_pay_change_percent;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Date getBusiness_process_effective_date() {
        return business_process_effective_date;
    }

    public void setBusiness_process_effective_date(Date business_process_effective_date) {
        this.business_process_effective_date = business_process_effective_date;
    }

    public Date getBusiness_process_completed_date() {
        return business_process_completed_date;
    }

    public void setBusiness_process_completed_date(Date business_process_completed_date) {
        this.business_process_completed_date = business_process_completed_date;
    }

    public String getBusiness_process_status() {
        return business_process_status;
    }

    public void setBusiness_process_status(String business_process_status) {
        this.business_process_status = business_process_status;
    }

    public String getBusiness_process_type() {
        return business_process_type;
    }

    public void setBusiness_process_type(String business_process_type) {
        this.business_process_type = business_process_type;
    }

    public String getBusiness_process_reason() {
        return business_process_reason;
    }

    public void setBusiness_process_reason(String business_process_reason) {
        this.business_process_reason = business_process_reason;
    }

    public String getPosition_current() {
        return position_current;
    }

    public void setPosition_current(String position_current) {
        this.position_current = position_current;
    }

    public String getPosition_proposed() {
        return position_proposed;
    }

    public void setPosition_proposed(String position_proposed) {
        this.position_proposed = position_proposed;
    }

    public String getRegion_current() {
        return region_current;
    }

    public void setRegion_current(String region_current) {
        this.region_current = region_current;
    }

    public String getRegion_proposed() {
        return region_proposed;
    }

    public void setRegion_proposed(String region_proposed) {
        this.region_proposed = region_proposed;
    }

    public String getCompany_current() {
        return company_current;
    }

    public void setCompany_current(String company_current) {
        this.company_current = company_current;
    }

    public String getCompany_proposed() {
        return company_proposed;
    }

    public void setCompany_proposed(String company_proposed) {
        this.company_proposed = company_proposed;
    }

    public String getJob_profile_current() {
        return job_profile_current;
    }

    public void setJob_profile_current(String job_profile_current) {
        this.job_profile_current = job_profile_current;
    }

    public String getJob_profile_proposed() {
        return job_profile_proposed;
    }

    public void setJob_profile_proposed(String job_profile_proposed) {
        this.job_profile_proposed = job_profile_proposed;
    }

    public String getLocation_current() {
        return location_current;
    }

    public void setLocation_current(String location_current) {
        this.location_current = location_current;
    }

    public String getLocation_proposed() {
        return location_proposed;
    }

    public void setLocation_proposed(String location_proposed) {
        this.location_proposed = location_proposed;
    }

    public String getCompensation_grade_current() {
        return compensation_grade_current;
    }

    public void setCompensation_grade_current(String compensation_grade_current) {
        this.compensation_grade_current = compensation_grade_current;
    }

    public String getCompensation_grade_proposed() {
        return compensation_grade_proposed;
    }

    public void setCompensation_grade_proposed(String compensation_grade_proposed) {
        this.compensation_grade_proposed = compensation_grade_proposed;
    }

    public String getPay_group_change() {
        return pay_group_change;
    }

    public void setPay_group_change(String pay_group_change) {
        this.pay_group_change = pay_group_change;
    }

    public Double getBase_pay_current() {
        return base_pay_current;
    }

    public void setBase_pay_current(Double base_pay_current) {
        this.base_pay_current = base_pay_current;
    }

    public Double getBase_pay_proposed() {
        return base_pay_proposed;
    }

    public void setBase_pay_proposed(Double base_pay_proposed) {
        this.base_pay_proposed = base_pay_proposed;
    }

    public Double getBase_pay_change_amount() {
        return base_pay_change_amount;
    }

    public void setBase_pay_change_amount(Double base_pay_change_amount) {
        this.base_pay_change_amount = base_pay_change_amount;
    }

    public Double getBase_pay_change_percent() {
        return base_pay_change_percent;
    }

    public void setBase_pay_change_percent(Double base_pay_change_percent) {
        this.base_pay_change_percent = base_pay_change_percent;
    }

    @Override
    public String toString() {
        return "WorkerChangeHistory{" +
                "wwid='" + wwid + '\'' +
                ", business_process_effective_date=" + business_process_effective_date +
                ", business_process_completed_date=" + business_process_completed_date +
                ", business_process_status='" + business_process_status + '\'' +
                ", business_process_type='" + business_process_type + '\'' +
                ", business_process_reason='" + business_process_reason + '\'' +
                ", position_current='" + position_current + '\'' +
                ", position_proposed='" + position_proposed + '\'' +
                ", region_current='" + region_current + '\'' +
                ", region_proposed='" + region_proposed + '\'' +
                ", company_current='" + company_current + '\'' +
                ", company_proposed='" + company_proposed + '\'' +
                ", job_profile_current='" + job_profile_current + '\'' +
                ", job_profile_proposed='" + job_profile_proposed + '\'' +
                ", location_current='" + location_current + '\'' +
                ", location_proposed='" + location_proposed + '\'' +
                ", compensation_grade_current='" + compensation_grade_current + '\'' +
                ", compensation_grade_proposed='" + compensation_grade_proposed + '\'' +
                ", pay_group_change=" + pay_group_change +
                ", base_pay_current=" + base_pay_current +
                ", base_pay_proposed=" + base_pay_proposed +
                ", base_pay_change_amount=" + base_pay_change_amount +
                ", base_pay_change_percent=" + base_pay_change_percent +
                '}';
    }
}
