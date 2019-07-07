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
        COLUMN_MAPPING.put("jnj_roles", "JnJRoles");
        COLUMN_MAPPING.put("external_roles", "ExternalRoles");
        COLUMN_MAPPING.put("total_roles", "TotalRoles");
        COLUMN_MAPPING.put("average_time_of_jnj_role", "AverageTimeOfJnJRole");
        COLUMN_MAPPING.put("average_time_of_external_role", "AverageTimeOfExternalRole");
        COLUMN_MAPPING.put("total_working_year", "TotalWorkingYear");
        COLUMN_MAPPING.put("external_length_of_service", "ExternalLengthOfService");
        COLUMN_MAPPING.put("average_time_of_each_role", "AverageTimeOfEachRole");
    }
}
