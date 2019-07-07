package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDemographicsColMapping {
    public final static String EXCEL_NAME = "MergedEmployeeDemographics.xlsx";
    public final static String TABLE_NAME = "employee_demographics";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("employee_pay_grade", "Employee Pay Grade");
        COLUMN_MAPPING.put("home_location_code", "Home Location Code (Primary)");
        COLUMN_MAPPING.put("position_id", "Position ID (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_profile", "Job Profile (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_profile_id", "Job Profile ID (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_function", "Job Function (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_sub_function", "Job Sub-Function (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("sector", "Sector (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("time_in_position", "Time in Position (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("length_of_service_in_years", "Length of Service in Years including Partial Year - Position");
        COLUMN_MAPPING.put("original_hire_date", "Original Hire Date");
        COLUMN_MAPPING.put("hire_date_most_recent", "Hire Date (Most Recent)");
    }
}
