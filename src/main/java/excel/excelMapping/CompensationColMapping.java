package excel.excelMapping;

import java.util.HashMap;
import java.util.Map;

public class CompensationColMapping {
    public final static String EXCEL_NAME = "MergedCompensation.xlsx";
    public final static String TABLE_NAME = "compensation";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("bonus2016", "Bonus for 2016");
        COLUMN_MAPPING.put("bonus2017", "Bonus for 2017");
        COLUMN_MAPPING.put("bonus2018", "Bonus for 2018");
    }
}