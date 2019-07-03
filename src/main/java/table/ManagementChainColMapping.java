package table;

import java.util.HashMap;
import java.util.Map;

public class ManagementChainColMapping {
    public final static String TABLE_NAME = "management_chain";
    public static Map<String, String> COLUMN_MAPPING;
    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID (WWID)");
        COLUMN_MAPPING.put("management_chain_level_01", "Management Chain - Level 01");
        COLUMN_MAPPING.put("management_chain_level_02", "Management Chain - Level 02");
        COLUMN_MAPPING.put("management_chain_level_03", "Management Chain - Level 03");
        COLUMN_MAPPING.put("management_chain_level_04", "Management Chain - Level 04");
        COLUMN_MAPPING.put("management_chain_level_05", "Management Chain - Level 05");
        COLUMN_MAPPING.put("management_chain_level_06", "Management Chain - Level 06");
        COLUMN_MAPPING.put("management_chain_level_07", "Management Chain - Level 07");
        COLUMN_MAPPING.put("management_chain_level_08", "Management Chain - Level 08");
        COLUMN_MAPPING.put("management_chain_level_09", "Management Chain - Level 09");
    }
}
