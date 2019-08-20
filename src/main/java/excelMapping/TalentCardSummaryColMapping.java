package excelMapping;

import java.util.HashMap;
import java.util.Map;

public class TalentCardSummaryColMapping {
    public final static String EXCEL_NAME = "talentCardSummary.xlsx";
    public final static String TABLE_NAME = "talent_card_summary";
    public static Map<String, String> COLUMN_MAPPING;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("graduation_year", "graduation_year");
        COLUMN_MAPPING.put("external_role_number", "external_role_number");
    }
}
