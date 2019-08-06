package Constants.KF4DConstants;

import entity.ScoreInterval;

import java.util.LinkedHashMap;
import java.util.Map;

public class TraitsConstants {

    public static final Map<String, ScoreInterval> TRAITS_SCORE_INTERVAL;
    public static final String TABLE_INTERVAL = "d_traits_interval";

    public static final double POINT_TRAIT = 100d / 20;

    public static final double UCP_ADAPTABILITY = 8;
    public static final double UCP_AFFILIATION = 6.5;
    public static final double UCP_ASSERTIVENESS = 6;
    public static final double UCP_COMPOSURE = 6.5;
    public static final double UCP_CONFIDENCE = 6.5;
    public static final double UCP_CREDIBILITY = 7.5;
    public static final double UCP_CURIOSITY = 8;
    public static final double UCP_EMPATHY = 5;
    public static final double UCP_FOCUS = 3;
    public static final double UCP_HUMILITY = 6;
    public static final double UCP_INFLUENCE = 6;
    public static final double UCP_NEED_FOR_ACHIEVEMENT = 8;
    public static final double UCP_OPENNESS_TO_DIFFERENCES = 6;
    public static final double UCP_OPTIMISM = 7;
    public static final double UCP_PERSISTENCE = 6.5;
    public static final double UCP_RISK_TAKING = 8;
    public static final double UCP_SITUATIONAL_SELF_AWARENESS = 6;
    public static final double UCP_SOCIABILITY = 6;
    public static final double UCP_TOLERANCE_OF_AMBIGUITY = 8.5;
    public static final double UCP_TRUST = 6.5;


    static {
        TRAITS_SCORE_INTERVAL = new LinkedHashMap<>();
        TRAITS_SCORE_INTERVAL.put("adaptability", new ScoreInterval("adaptability",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("affiliation", new ScoreInterval("affiliation",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("assertiveness", new ScoreInterval("assertiveness",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("composure", new ScoreInterval("composure",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("confidence", new ScoreInterval("confidence",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("credibility", new ScoreInterval("credibility",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("curiosity", new ScoreInterval("curiosity",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("empathy", new ScoreInterval("empathy",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("focus", new ScoreInterval("focus",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("humility", new ScoreInterval("humility",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("influence", new ScoreInterval("influence",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("need_for_achievement", new ScoreInterval("need_for_achievement",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("openness_to_differences", new ScoreInterval("openness_to_differences",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("optimism", new ScoreInterval("optimism",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("persistence", new ScoreInterval("persistence",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("risk_taking", new ScoreInterval("risk_taking",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("situational_self_awareness", new ScoreInterval("situational_self_awareness",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("sociability", new ScoreInterval("sociability",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("tolerance_of_ambiguity", new ScoreInterval("tolerance_of_ambiguity",0, TraitsConstants.POINT_TRAIT));
        TRAITS_SCORE_INTERVAL.put("trust", new ScoreInterval("trust",0, TraitsConstants.POINT_TRAIT));


    }
}
