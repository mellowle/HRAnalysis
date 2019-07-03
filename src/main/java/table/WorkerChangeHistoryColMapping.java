package table;

import java.util.HashMap;
import java.util.Map;

public class WorkerChangeHistoryColMapping {
    public final static String TABLE_NAME = "worker_change_history";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("business_process_effective_date", "Business Process Effective Date");
        COLUMN_MAPPING.put("business_process_status", "Business Process Status");
        COLUMN_MAPPING.put("business_process_type", "Business Process Type");
        COLUMN_MAPPING.put("business_process_reason", "Business Process Reason");
        COLUMN_MAPPING.put("business_process_completed_date", "Business Process Completed Date");
        COLUMN_MAPPING.put("position_current", "Position - Current");
        COLUMN_MAPPING.put("position_proposed", "Position - Proposed");
        COLUMN_MAPPING.put("region_current", "Region - Current");
        COLUMN_MAPPING.put("region_proposed", "Region - Proposed");
        COLUMN_MAPPING.put("company_current", "Company -  Current");
        COLUMN_MAPPING.put("company_proposed", "Company - Proposed");
        COLUMN_MAPPING.put("job_profile_current", "Job Profile - Current");
        COLUMN_MAPPING.put("job_profile_proposed", "Job Profile - Proposed");
        COLUMN_MAPPING.put("location_current", "Location - Current");
        COLUMN_MAPPING.put("location_proposed", "Location - Proposed");
        COLUMN_MAPPING.put("compensation_grade_current", "Compensation Grade - Current");
        COLUMN_MAPPING.put("compensation_grade_proposed", "Compensation Grade - Proposed");
        COLUMN_MAPPING.put("pay_group_change", "Pay Group Change");
        COLUMN_MAPPING.put("base_pay_current", "Base Pay - Current");
        COLUMN_MAPPING.put("base_pay_proposed", "Base Pay - Proposed");
        COLUMN_MAPPING.put("base_pay_change_amount", "Base Pay Change - Amount");
        COLUMN_MAPPING.put("base_pay_change_percent", "Base Pay Change - Percent");
    }
}
