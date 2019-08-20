package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class KF4DAggregatedResultsColMapping {
    public final static String EXCEL_NAME = "KF4DAggregatedResults.xlsx";
    public final static String TABLE_NAME = "kf4d_aggregated_results";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("band", "Band");
        COLUMN_MAPPING.put("sector", "Sector");
    }
}
