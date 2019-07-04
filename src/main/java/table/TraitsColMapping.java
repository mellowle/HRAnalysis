package table;

import java.util.HashMap;
import java.util.Map;

public class TraitsColMapping {
    public final static String TABLE_NAME = "traits";
    public final static String TABLE_NAME_SCORED = "dimension_traits_score";
    public static Map<String, String> COLUMN_MAPPING;
    public static Map<String, String> COLUMN_MAPPING_SCORED;

    static {
        COLUMN_MAPPING = new HashMap<>();
        COLUMN_MAPPING.put("wwid", "wwid");
        COLUMN_MAPPING.put("adaptability", "Adaptability Sten");
        COLUMN_MAPPING.put("affiliation", "Affiliation Sten");
        COLUMN_MAPPING.put("assertiveness", "Assertiveness Sten");
        COLUMN_MAPPING.put("composure", "Composure Sten");
        COLUMN_MAPPING.put("confidence", "Confidence Sten");
        COLUMN_MAPPING.put("credibility", "Credibility Sten");
        COLUMN_MAPPING.put("curiosity", "Curiosity Sten");
        COLUMN_MAPPING.put("empathy", "Empathy Sten");
        COLUMN_MAPPING.put("focus", "Focus Sten");
        COLUMN_MAPPING.put("humility", "Humility Sten");
        COLUMN_MAPPING.put("influence", "Influence Sten");
        COLUMN_MAPPING.put("need_for_achievement", "Need for Achievement Sten");
        COLUMN_MAPPING.put("openness_to_differences", "Openness to Differences Sten");
        COLUMN_MAPPING.put("optimism", "Optimism Sten");
        COLUMN_MAPPING.put("persistence", "Persistence Sten");
        COLUMN_MAPPING.put("risk_taking", "Risk Taking Sten");
        COLUMN_MAPPING.put("situational_self_awareness", "Situational Self-Awareness Sten");
        COLUMN_MAPPING.put("sociability", "Sociability Sten");
        COLUMN_MAPPING.put("tolerance_of_ambiguity", "Tolerance of Ambiguity Sten");
        COLUMN_MAPPING.put("trust", "Trust Sten");

        COLUMN_MAPPING_SCORED = new HashMap<>();
        COLUMN_MAPPING_SCORED.put("wwid", "wwid");
        COLUMN_MAPPING_SCORED.put("adaptability", "Adaptability Sten");
        COLUMN_MAPPING_SCORED.put("affiliation", "Affiliation Sten");
        COLUMN_MAPPING_SCORED.put("assertiveness", "Assertiveness Sten");
        COLUMN_MAPPING_SCORED.put("composure", "Composure Sten");
        COLUMN_MAPPING_SCORED.put("confidence", "Confidence Sten");
        COLUMN_MAPPING_SCORED.put("credibility", "Credibility Sten");
        COLUMN_MAPPING_SCORED.put("curiosity", "Curiosity Sten");
        COLUMN_MAPPING_SCORED.put("empathy", "Empathy Sten");
        COLUMN_MAPPING_SCORED.put("focus", "Focus Sten");
        COLUMN_MAPPING_SCORED.put("humility", "Humility Sten");
        COLUMN_MAPPING_SCORED.put("influence", "Influence Sten");
        COLUMN_MAPPING_SCORED.put("need_for_achievement", "Need for Achievement Sten");
        COLUMN_MAPPING_SCORED.put("openness_to_differences", "Openness to Differences Sten");
        COLUMN_MAPPING_SCORED.put("optimism", "Optimism Sten");
        COLUMN_MAPPING_SCORED.put("persistence", "Persistence Sten");
        COLUMN_MAPPING_SCORED.put("risk_taking", "Risk Taking Sten");
        COLUMN_MAPPING_SCORED.put("situational_self_awareness", "Situational Self-Awareness Sten");
        COLUMN_MAPPING_SCORED.put("sociability", "Sociability Sten");
        COLUMN_MAPPING_SCORED.put("tolerance_of_ambiguity", "Tolerance of Ambiguity Sten");
        COLUMN_MAPPING_SCORED.put("trust", "Trust Sten");
        COLUMN_MAPPING_SCORED.put("result", "result");

    }
}
