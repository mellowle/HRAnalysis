package Constants.ExperiencesConstants;

import entity.ScoreInterval;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExperiencesConstants {
    public final static String TABLE_NAME = "experiences";
    public static final String TABLE_NAME_SCORED = "d_experiences_scored";
    public static final String TABLE_INTERVAL = "d_experiences_interval";
    public static final String MBA = "Master of Business Administration (MBA)";
    public static final String YES = "Yes";
    public static final String NO = "No";
    public static final String SUCCESSFULLY_COMPLETED = "Successfully Completed";
    public static final String LATERAL_MOVE = "Lateral Move";
    public static final String PROMOTION = "Promotion";
    public static final String TRANSFER ="Transfer";
    public static final String WITHIN_COUNTRY = "within country";
    public static final String NEW_COUNTRY = "new country";
    public static final String YEAR_END_2016 = "Sat Dec 31 00:00:00 CST 2016";
    public static final String YEAR_END_2017 = "Sun Dec 31 00:00:00 CST 2017";
    public static final String YEAR_END_2018 = "Mon Dec 31 00:00:00 CST 2018";

    public static final Map<String, ScoreInterval> EXPERIENCES_SCORE_INTERVAL;
    public static final Integer NUMBER_OF_FACTS;
    private static final double EXPERIENCES_TOTAL_SCORE = 100;

    static {
        EXPERIENCES_SCORE_INTERVAL = new LinkedHashMap<>();
        EXPERIENCES_SCORE_INTERVAL.put("performance_rating2016", new ScoreInterval("performance_rating2016", 0.07 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.07 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("performance_rating2017", new ScoreInterval("performance_rating2017", 0.08 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.08 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("performance_rating2018", new ScoreInterval("performance_rating2018", 0.1 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.1 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("bonus_increment20162017", new ScoreInterval("bonus_increment20162017", 0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("bonus_increment20172018", new ScoreInterval("bonus_increment20172018", 0, 0.02 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("base_increment20172018", new ScoreInterval("base_increment20172018", 0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("base_increment20182019", new ScoreInterval("base_increment20182019", 0, 0.03 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("function_movements", new ScoreInterval("function_movements", 0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("lateral_movements", new ScoreInterval("lateral_movements", 0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("promotions", new ScoreInterval("promotions", 0, 0.04 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("region_movements", new ScoreInterval("region_movements", 0, 0.06 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("sector_movements", new ScoreInterval("sector_movements", 0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("country_movements", new ScoreInterval("country_movements", 0, 0.05 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("direct_report", new ScoreInterval("direct_report", 0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("hierarchy_count", new ScoreInterval("hierarchy_count", 0, 0.03 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("external_role_number", new ScoreInterval("external_role_number", 0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("external_length_of_service", new ScoreInterval("external_length_of_service", 0, 0.04 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("total_role_number", new ScoreInterval("total_role_number", 0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("total_working_years", new ScoreInterval("total_working_years", 0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("average_duration_of_each_role", new ScoreInterval("average_duration_of_each_role", 0, 0.01 * EXPERIENCES_TOTAL_SCORE));

        EXPERIENCES_SCORE_INTERVAL.put("customer_journey", new ScoreInterval("customer_journey", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("data_analytics", new ScoreInterval("data_analytics", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("innovation", new ScoreInterval("innovation", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("digital_leadership", new ScoreInterval("digital_leadership", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("digital_commerce", new ScoreInterval("digital_commerce", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("digital_products", new ScoreInterval("digital_products", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));
        EXPERIENCES_SCORE_INTERVAL.put("operational_efficiency", new ScoreInterval("operational_efficiency", 0, 0.1 * EXPERIENCES_TOTAL_SCORE / 7));

        EXPERIENCES_SCORE_INTERVAL.put("performance_comments2018", new ScoreInterval("performance_comments2018", 0, 0.1 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("stakeholder_feedback", new ScoreInterval("stakeholder_feedback", 0, 0.1 * EXPERIENCES_TOTAL_SCORE));

        NUMBER_OF_FACTS = EXPERIENCES_SCORE_INTERVAL.size();

        sumUpCheck();
    }

    private static void sumUpCheck() {
        BigDecimal result = new BigDecimal(0d);
        for (Map.Entry<String, ScoreInterval> entry : EXPERIENCES_SCORE_INTERVAL.entrySet()) {
            result = result.add(new BigDecimal(Double.toString(entry.getValue().getMax())));
        }
        if (result.doubleValue() != 100) {
            System.err.printf("Experiences Total Score is %s", result.doubleValue());
        }
    }

    public static void main(String... args) {
        System.out.println(EXPERIENCES_SCORE_INTERVAL);
        System.out.println(NUMBER_OF_FACTS);
        sumUpCheck();
    }
}
