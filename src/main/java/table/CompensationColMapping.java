package table;

import java.util.HashMap;
import java.util.Map;

public class CompensationColMapping {
    public final static String TABLE_NAME = "compensation";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("base_2017", "Mar. 1 2017 Base");
        COLUMN_MAPPING.put("base_2018", "Mar 1, 2018 Base");
        COLUMN_MAPPING.put("base_2019", "Mar. 1 2019 Base ");
        COLUMN_MAPPING.put("bonus_2016", "Bonus for 2016");
        COLUMN_MAPPING.put("bonus_2017", "Bonus for 2017");
        COLUMN_MAPPING.put("bonus_2018", "Bonus for 2018");
    }
}
