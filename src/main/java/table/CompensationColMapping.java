package table;

import java.util.HashMap;
import java.util.Map;

public class CompensationColMapping {
    public final static String TABLE_NAME = "compensation";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("2017_base", "Mar. 1 2017 Base");
        COLUMN_MAPPING.put("2018_base", "Mar 1, 2018 Base");
        COLUMN_MAPPING.put("2019_base", "Mar. 1 2019 Base ");
        COLUMN_MAPPING.put("2016_bonus", "Bonus for 2016");
        COLUMN_MAPPING.put("2017_bonus", "Bonus for 2017");
        COLUMN_MAPPING.put("2018_bonus", "Bonus for 2018");
    }
}
