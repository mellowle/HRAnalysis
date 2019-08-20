package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class ltiColMapping {
    public final static String EXCEL_NAME = "MergedCompensationWithLTI.xlsx";
    public final static String TABLE_NAME = "compensation_with_lti";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "Employee ID");
        COLUMN_MAPPING.put("base2017", "Mar. 1 2017 Base");
        COLUMN_MAPPING.put("base2018", "Mar 1, 2018 Base");
        COLUMN_MAPPING.put("base2019", "Mar. 1 2019 Base");
        COLUMN_MAPPING.put("planed_lti2016", "Planned LTI% YE2016");
        COLUMN_MAPPING.put("planed_lti2017", "Planned LTI% YE2017");
        COLUMN_MAPPING.put("planed_lti2018", "Planned LTI% YE2018");
    }
}
