package table;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDemographicsColMapping {
    public final static String TABLE_NAME = "employee_demographics";
    public static Map<String, String> COLUMN_MAPPING;
    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("EXCEL_HEADER", "TABLE_HEADER");
    }
}
