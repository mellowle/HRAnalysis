package table;

import java.util.HashMap;
import java.util.Map;

public class DirectReportColMapping {
    public final static String TABLE_NAME = "direct_report";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("direct_report", "Direct Report");
    }
}
