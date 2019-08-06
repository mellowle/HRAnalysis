package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class TalentCardColMapping {
    public final static String EXCEL_NAME = "JobHistory.xlsx";
    public final static String TABLE_NAME = "talent_card";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("jnj_role_number", "JnJRoles");
        COLUMN_MAPPING.put("external_role_number", "ExternalRoles");
        COLUMN_MAPPING.put("total_role_number", "TotalRoles");
        COLUMN_MAPPING.put("average_duration_of_jnj_role", "AverageTimeOfJnJRole");
        COLUMN_MAPPING.put("average_duration_of_external_role", "AverageTimeOfExternalRole");
        COLUMN_MAPPING.put("average_duration_of_each_role", "AverageTimeOfEachRole");
        COLUMN_MAPPING.put("total_working_years", "TotalWorkingYear");
        COLUMN_MAPPING.put("external_length_of_service", "ExternalLengthOfService");
    }
}
