package entity;


import java.sql.Date;

public class WorkerChangeHsitory {
    public String wwid;
    public Date business_process_effective_date;
    public String business_process_status;
    public String business_process_type;
    public String business_process_reason;
    public Date business_process_completed_date;
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
    public boolean pay_group_change;
    public float base_pay_current;
    public float base_pay_proposed;
    public float base_pay_change_amount;
    public float base_pay_change_percent;
}
