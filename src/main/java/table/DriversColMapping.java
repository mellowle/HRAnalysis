package table;

import java.util.HashMap;
import java.util.Map;

public class DriversColMapping {
    public final static String TABLE_NAME = "competencies";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("drivers_balance", "Balance Sten");
        COLUMN_MAPPING.put("drivers_challenge", "Challenge Sten");
        COLUMN_MAPPING.put("drivers_collaboration", "Collaboration Sten");
        COLUMN_MAPPING.put("drivers_independence", "Independence Sten");
        COLUMN_MAPPING.put("drivers_power", "Power Sten");
        COLUMN_MAPPING.put("drivers_structure", "Structure Sten");
    }
}
