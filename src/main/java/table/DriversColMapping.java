package table;

import java.util.HashMap;
import java.util.Map;

public class DriversColMapping {
    public final static String TABLE_NAME = "drivers";
    public static Map<String, String> COLUMN_MAPPING;

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
