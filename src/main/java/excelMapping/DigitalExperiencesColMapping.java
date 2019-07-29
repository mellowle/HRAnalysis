package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class DigitalExperiencesColMapping {
    public final static String EXCEL_NAME = "MergedDigitalExperiencesData.xlsx";
    public final static String TABLE_NAME = "digital_experiences";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("customer_journey", "Customer Journey");
        COLUMN_MAPPING.put("data_analytics", "Data Analytics");
        COLUMN_MAPPING.put("innovation", "Innovation");
        COLUMN_MAPPING.put("digital_leadership", "Digital Leadership");
        COLUMN_MAPPING.put("digital_commerce", "Digital Commerce");
        COLUMN_MAPPING.put("digital_products", "Digital Products");
        COLUMN_MAPPING.put("operational_efficiency", "Operational Efficiency");
        COLUMN_MAPPING.put("overall_digital_experience_percentile", "Overall Digital Experience Percentile");
    }
}
