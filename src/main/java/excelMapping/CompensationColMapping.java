package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class CompensationColMapping {
    public final static String EXCEL_NAME = "MergedCompensation.xlsx";
    public final static String TABLE_NAME = "compensation";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("bonus2016", "Bonus/Sales Incentive for 2016");
        COLUMN_MAPPING.put("bonus2017", "Bonus/Sales Incentive for 2017");
        COLUMN_MAPPING.put("bonus2018", "Bonus/Sales Incentive for 2018");
        COLUMN_MAPPING.put("base2017", "Mar. 1 2017 Base");
        COLUMN_MAPPING.put("base2018", "Mar 1, 2018 Base");
        COLUMN_MAPPING.put("base2019", "Mar. 1 2019 Base");
    }
}