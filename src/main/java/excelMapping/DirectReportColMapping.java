package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class DirectReportColMapping {
    public final static String EXCEL_NAME = "MergedDirectReports.xlsx";
    public final static String TABLE_NAME = "direct_report";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "WWID");
        COLUMN_MAPPING.put("direct_report", "Number of Direct Reports");
    }
}
