package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class UnstructuredDataColMapping {
    public final static String EXCEL_NAME = "MergedUnstructuredData.xlsx";
    public final static String TABLE_NAME = "unstructured_data";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("performance_comments2018", "2018 Year-end performance comments rating");
        COLUMN_MAPPING.put("stakeholder_feedback", "Stakeholder feedback rating");
    }
}
