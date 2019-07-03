package table;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDemographicsColMapping {
    public final static String TABLE_NAME = "employee_demographics";
    public static Map<String, String> COLUMN_MAPPING;
    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid,STRING", "WWID");
        COLUMN_MAPPING.put("employee_pay_grade,INT", "Employee Pay Grade");
        COLUMN_MAPPING.put("home_location_code,STRING", "Home Location Code (Primary)");
        COLUMN_MAPPING.put("position_id,LONG", "Position ID (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_profile,STRING", "Job Profile (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_profile_id,LONG", "Job Profile ID (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_function,STRING", "Job Function (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("job_sub_function,STRING", "Job Sub-Function (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("sector,STRING", "Sector (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("time_in_position,FLOAT,", "Time in Position (IA: Host/All Other: Primary)");
        COLUMN_MAPPING.put("length_of_service_in_years,FLOAT", "Length of Service in Years including Partial Year - Position");
        COLUMN_MAPPING.put("original_hire_date,DATE", "Original Hire Date");
        COLUMN_MAPPING.put("hire_date_most_recent,DATE", "Hire Date (Most Recent)");
    }
}
