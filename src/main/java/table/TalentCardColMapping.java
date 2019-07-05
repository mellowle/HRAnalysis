package table;

import java.util.HashMap;
import java.util.Map;

public class TalentCardColMapping {
    public final static String TABLE_NAME = "talent_card";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("number_of_jnj_roles", "NumberOfJnJRoles");
        COLUMN_MAPPING.put("average_time_of_jnj_roles", "AverageTimeOfJnJRole");
        COLUMN_MAPPING.put("number_of_external_roles", "NumberOfExternalRoles");
        COLUMN_MAPPING.put("average_time_of_external_roles", "AverageTimeOfExternalRoles");
        COLUMN_MAPPING.put("external_length_of_service", "external_length_of_service");
        COLUMN_MAPPING.put("total_role_number", "total_role_number");
        COLUMN_MAPPING.put("total_working_years", "total_working_years");
        COLUMN_MAPPING.put("average_time_of_each_role", "average_time_of_each_role");
    }
}
