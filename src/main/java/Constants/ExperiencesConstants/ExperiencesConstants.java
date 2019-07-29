package Constants.ExperiencesConstants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExperiencesConstants {
    public final static String TABLE_NAME = "experiences";
    public static final String TABLE_NAME_SCORED = "d_experiences_scored";
    public static final String MBA = "Master of Business Administration (MBA)";
    public static final String YES = "Yes";
    public static final String NO = "No";
    public static final String RESCINDED = "Rescinded";
    public static final String YEAR_END_2016 = "Sat Dec 31 00:00:00 CST 2016";
    public static final String YEAR_END_2017 = "Sun Dec 31 00:00:00 CST 2017";
    public static final String YEAR_END_2018 = "Mon Dec 31 00:00:00 CST 2018";

    public static final Map<String, ScoreInterval> EXPERIENCES_SCORE_INTERVAL;
    private static final double EXPERIENCES_TOTAL_SCORE = 100;
    public static final Integer NUMBER_OF_FACTS;

    static {
        EXPERIENCES_SCORE_INTERVAL = new HashMap<>();
        EXPERIENCES_SCORE_INTERVAL.put("PERFORMANCE_RATING2016", new ScoreInterval(0.07 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.07 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("PERFORMANCE_RATING2017", new ScoreInterval(0.08 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.08 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("PERFORMANCE_RATING2018", new ScoreInterval(0.1 * EXPERIENCES_TOTAL_SCORE / 4 * (-2), 0.1 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("BONUS_INCREMENT20162017", new ScoreInterval(0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("BONUS_INCREMENT20172018", new ScoreInterval(0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("BASE_increment20172018", new ScoreInterval(0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("BASE_increment20182019", new ScoreInterval(0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("FUNCTION_MOVEMENTS", new ScoreInterval(0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("LATERAL_MOVEMENTS", new ScoreInterval(0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("PROMOTIONS", new ScoreInterval(0, 0.04 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("REGION_MOVEMENTS", new ScoreInterval(0, 0.06 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("SECTOR_MOVEMENTS", new ScoreInterval(0, 0.02 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("COUNTRY_MOVEMENTS", new ScoreInterval(0, 0.05 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("TEAM_SIZE", new ScoreInterval(0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("HIERARCHY_COUNT", new ScoreInterval(0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("EXTERNAL_ROLE_NUMBER", new ScoreInterval(0, 0.03 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("EXTERNAL_LENGTH_OF_SERVICE", new ScoreInterval(0, 0.04 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("TOTAL_ROLE_NUMBER", new ScoreInterval(0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("TOTAL_WORKING_YEARS", new ScoreInterval(0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("AVERAGE_DURATION_OF_EACH_ROLE", new ScoreInterval(0, 0.01 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("DIGITAL_EXPERIENCES", new ScoreInterval(0, 0.1 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("PERFORMANCE_COMMENTS2018", new ScoreInterval(0, 0.1 * EXPERIENCES_TOTAL_SCORE));
        EXPERIENCES_SCORE_INTERVAL.put("STAKEHOLDER_FEEDBACK", new ScoreInterval(0, 0.1 * EXPERIENCES_TOTAL_SCORE));

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
        sumUpCheck();
    }
}
