package table;

import java.util.HashMap;
import java.util.Map;

public class PerformanceRatingColMapping {
    public final static String TABLE_NAME = "performance_rating";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID (WWID)");
        COLUMN_MAPPING.put("review_period_start_date", "Review Period - Start Date");
        COLUMN_MAPPING.put("review_period_end_date", "Review Period - End Date");
        COLUMN_MAPPING.put("results_rating", "Results Rating");
        COLUMN_MAPPING.put("leadership_rating", "Leadership Rating");
        COLUMN_MAPPING.put("overall_rating", "Overall Rating");
    }
}
