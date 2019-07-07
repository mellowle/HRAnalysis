package excel.excelMapping;

import java.util.HashMap;
import java.util.Map;

public class PerformanceRatingColMapping {
    public final static String EXCEL_NAME = "MergedEmployeePerformanceRatings.xlsx";
    public final static String TABLE_NAME = "performance_rating";
    public static final String TABLE_NAME_FIXED = "performance_rating_fixed";
    public static final Map<String, String> COLUMN_MAPPING_FIXED;
    public static Map<String, String> COLUMN_MAPPING;

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
        COLUMN_MAPPING_FIXED.put("overall_rating2016", "Review Period - Start Date");
        COLUMN_MAPPING_FIXED.put("overall_rating2017", "Review Period - End Date");
        COLUMN_MAPPING_FIXED.put("overall_rating2018", "Results Rating");
    }
}
