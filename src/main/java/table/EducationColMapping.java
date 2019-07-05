package table;

import java.util.HashMap;
import java.util.Map;

public class EducationColMapping {
    public final static String TABLE_NAME = "education";
    public static final Map<String,String> COLUMN_MAPPING_FIXED;
    public static final String TABLE_NAME_FIXED = "education_fixed";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("highest_degree_received", "Highest Degree Received");

        COLUMN_MAPPING_FIXED = new HashMap<>();
        COLUMN_MAPPING_FIXED.put("wwid", "WWID");
        COLUMN_MAPPING_FIXED.put("highestEducation", "Highest Degree Received");
    }
}
