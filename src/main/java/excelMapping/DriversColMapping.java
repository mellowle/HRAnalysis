package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class DriversColMapping {
    public final static String EXCEL_NAME = "KF4DEncoded.xlsx";
    public final static String TABLE_NAME = "drivers";
    public static final String TABLE_NAME_SCORED = "d_drivers_scored";
    public static Map<String, String> COLUMN_MAPPING;
    public static Map<String, String> COLUMN_MAPPING_SCORED;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("balance", "Balance Sten");
        COLUMN_MAPPING.put("challenge", "Challenge Sten");
        COLUMN_MAPPING.put("collaboration", "Collaboration Sten");
        COLUMN_MAPPING.put("independence", "Independence Sten");
        COLUMN_MAPPING.put("power", "Power Sten");
        COLUMN_MAPPING.put("structure", "Structure Sten");
    }
}
