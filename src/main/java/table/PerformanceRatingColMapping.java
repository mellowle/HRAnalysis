package table;

import java.util.HashMap;
import java.util.Map;

public class PerformanceRatingColMapping {
    public final static String TABLE_NAME = "performance_rating";
    public static Map<String, String> COLUMN_MAPPING;
    public static final String TABLE_NAME_FIXED = "performance_rating_fixed";
    public static final Map<String,String> COLUMN_MAPPING_FIXED;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID (WWID)");
        COLUMN_MAPPING.put("review_period_start_date", "Review Period - Start Date");
        COLUMN_MAPPING.put("review_period_end_date", "Review Period - End Date");
        COLUMN_MAPPING.put("results_rating", "Results Rating");
        COLUMN_MAPPING.put("leadership_rating", "Leadership Rating");
        COLUMN_MAPPING.put("overall_rating", "Overall Rating");

        COLUMN_MAPPING_FIXED = new HashMap<>();
        COLUMN_MAPPING_FIXED.put("wwid", "Employee ID (WWID)");
        COLUMN_MAPPING_FIXED.put("reviewPeriodStartDate", "Review Period - Start Date");
        COLUMN_MAPPING_FIXED.put("reviewPeriodEndDate", "Review Period - End Date");
        COLUMN_MAPPING_FIXED.put("resultsRating", "Results Rating");
        COLUMN_MAPPING_FIXED.put("leadershipRating", "Leadership Rating");
        COLUMN_MAPPING_FIXED.put("overallRating", "Overall Rating");
    }
}
