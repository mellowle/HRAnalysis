package Constants.KF4DConstants;

import entity.ScoreInterval;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompetenciesConstants {
    public static final Map<String, ScoreInterval> COMPETENCIES_SCORE_INTERVAL;
    public static final String TABLE_INTERVAL = "d_competencies_interval";
    public static final double WEIGHT_MISSION_CRITICAL = 0.5;
    public static final double WEIGHT_CRITICAL = 0.3;
    public static final double WEIGHT_LESS_CRITICAL = 0.2;

    public static final double POINT_STRATEGIC_MINDSET = 19;
    public static final double POINT_GLOBAL_PERSPECTIVE = 18;
    public static final double POINT_INSTILLS_TRUST = 17;
    public static final double POINT_PERSUADES = 16;
    public static final double POINT_COMMUNICATES_EFFECTIVELY = 15;
    public static final double POINT_COLLABORATES = 14;
    public static final double POINT_CULTIVATES_INNOVATION = 13;
    public static final double POINT_NIMBLE_LEARNING = 12;
    public static final double POINT_DEVELOPS_TALENT = 11;
    public static final double POINT_SITUATIONAL_ADAPTABILITY = 10;
    public static final double MISSION_CRITICAL_SUMUP = POINT_STRATEGIC_MINDSET + POINT_GLOBAL_PERSPECTIVE
            + POINT_INSTILLS_TRUST + POINT_PERSUADES
            + POINT_COMMUNICATES_EFFECTIVELY + POINT_COLLABORATES
            + POINT_CULTIVATES_INNOVATION + POINT_NIMBLE_LEARNING
            + POINT_DEVELOPS_TALENT + POINT_SITUATIONAL_ADAPTABILITY;

    public static final double MAX_STRATEGIC_MINDSET = 8.75;
    public static final double MAX_GLOBAL_PERSPECTIVE = 9;
    public static final double MAX_INSTILLS_TRUST = 8.5;
    public static final double MAX_PERSUADES = 8.75;
    public static final double MAX_COMMUNICATES_EFFECTIVELY = 9;
    public static final double MAX_COLLABORATES = 8;
    public static final double MAX_CULTIVATES_INNOVATION = 8.5;
    public static final double MAX_NIMBLE_LEARNING = 8;
    public static final double MAX_DEVELOPS_TALENT = 8.75;
    public static final double MAX_SITUATIONAL_ADAPTABILITY = 8.5;
    public static final double MIN_STRATEGIC_MINDSET = 5.5;
    public static final double MIN_GLOBAL_PERSPECTIVE = 6;
    public static final double MIN_INSTILLS_TRUST = 5;
    public static final double MIN_PERSUADES = 5.5;
    public static final double MIN_COMMUNICATES_EFFECTIVELY = 6;
    public static final double MIN_COLLABORATES = 4.5;
    public static final double MIN_CULTIVATES_INNOVATION = 5;
    public static final double MIN_NIMBLE_LEARNING = 4.5;
    public static final double MIN_DEVELOPS_TALENT = 5.5;
    public static final double MIN_SITUATIONAL_ADAPTABILITY = 5;

    public static final double POINT_BUILDS_NETWORKS = 35;
    public static final double POINT_DECISION_QUALITY = 34;
    public static final double POINT_BEING_RESILIENT = 33;
    public static final double POINT_COURAGE = 32;
    public static final double POINT_ACTION_ORIENTED = 31;
    public static final double POINT_MANAGES_AMBIGUITY = 30;
    public static final double POINT_INTERPERSONAL_SAVVY = 29;
    public static final double POINT_RESOURCEFULNESS = 28;
    public static final double POINT_SELF_DEVELOPMENT = 27;
    public static final double POINT_VALUES_DIFFERENCES = 26;
    public static final double CRITICAL_SUMUP = POINT_BUILDS_NETWORKS + POINT_DECISION_QUALITY
            + POINT_BEING_RESILIENT + POINT_COURAGE
            + POINT_ACTION_ORIENTED + POINT_MANAGES_AMBIGUITY
            + POINT_INTERPERSONAL_SAVVY + POINT_RESOURCEFULNESS
            + POINT_SELF_DEVELOPMENT + POINT_VALUES_DIFFERENCES;

    public static final double POINT_DRIVES_ENGAGEMENT = 21;
    public static final double POINT_BALANCES_STAKEHOLDERS = 20;
    public static final double POINT_ENSURES_ACCOUNTABILITY = 19;
    public static final double POINT_DRIVES_RESULTS = 18;
    public static final double POINT_CUSTOMER_FOCUS = 17;
    public static final double POINT_MANAGES_CONFLICT = 16;
    public static final double POINT_BUILDS_EFFECTIVE_TEAMS = 15;
    public static final double POINT_PLANS_AND_ALIGNS = 14;
    public static final double POINT_DIRECTS_WORK = 13;
    public static final double POINT_OPTIMIZES_WORK_PROCESSES = 12;
    public static final double LESS_CRITICAL_SUMUP = POINT_DRIVES_ENGAGEMENT + POINT_BALANCES_STAKEHOLDERS
            + POINT_ENSURES_ACCOUNTABILITY + POINT_DRIVES_RESULTS
            + POINT_CUSTOMER_FOCUS + POINT_MANAGES_CONFLICT
            + POINT_BUILDS_EFFECTIVE_TEAMS + POINT_PLANS_AND_ALIGNS
            + POINT_DIRECTS_WORK + POINT_OPTIMIZES_WORK_PROCESSES;

    static {
        COMPETENCIES_SCORE_INTERVAL = new LinkedHashMap<>();
        COMPETENCIES_SCORE_INTERVAL.put("strategic_mindset", new ScoreInterval("strategic_mindset", 0, CompetenciesConstants.POINT_STRATEGIC_MINDSET / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("global_perspective", new ScoreInterval("global_perspective", 0, CompetenciesConstants.POINT_GLOBAL_PERSPECTIVE / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("instills_trust", new ScoreInterval("instills_trust", 0, CompetenciesConstants.POINT_INSTILLS_TRUST / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("persuades", new ScoreInterval("persuades", 0, CompetenciesConstants.POINT_PERSUADES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("communicates_effectively", new ScoreInterval("communicates_effectively", 0, CompetenciesConstants.POINT_COMMUNICATES_EFFECTIVELY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("collaborates", new ScoreInterval("collaborates", 0, CompetenciesConstants.POINT_COLLABORATES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("cultivates_innovation", new ScoreInterval("cultivates_innovation", 0, CompetenciesConstants.POINT_CULTIVATES_INNOVATION / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("nimble_learning", new ScoreInterval("nimble_learning", 0, CompetenciesConstants.POINT_NIMBLE_LEARNING / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("develops_talent", new ScoreInterval("develops_talent", 0, CompetenciesConstants.POINT_DEVELOPS_TALENT / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("situational_adaptability", new ScoreInterval("situational_adaptability", 0, CompetenciesConstants.POINT_SITUATIONAL_ADAPTABILITY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100));


        COMPETENCIES_SCORE_INTERVAL.put("builds_networks", new ScoreInterval("builds_networks", 0, CompetenciesConstants.POINT_BUILDS_NETWORKS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("decision_quality", new ScoreInterval("decision_quality", 0, CompetenciesConstants.POINT_DECISION_QUALITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("being_resilient", new ScoreInterval("being_resilient", 0, CompetenciesConstants.POINT_BEING_RESILIENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("courage", new ScoreInterval("courage", 0, CompetenciesConstants.POINT_COURAGE / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("action_oriented", new ScoreInterval("action_oriented", 0, CompetenciesConstants.POINT_ACTION_ORIENTED / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("manages_ambiguity", new ScoreInterval("manages_ambiguity", 0, CompetenciesConstants.POINT_MANAGES_AMBIGUITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("interpersonal_savvy", new ScoreInterval("interpersonal_savvy", 0, CompetenciesConstants.POINT_INTERPERSONAL_SAVVY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("resourcefulness", new ScoreInterval("resourcefulness", 0, CompetenciesConstants.POINT_RESOURCEFULNESS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("self_development", new ScoreInterval("self_development", 0, CompetenciesConstants.POINT_SELF_DEVELOPMENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("values_differences", new ScoreInterval("values_differences", 0, CompetenciesConstants.POINT_VALUES_DIFFERENCES / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100));


        COMPETENCIES_SCORE_INTERVAL.put("drives_engagement", new ScoreInterval("drives_engagement", 0 , CompetenciesConstants.POINT_DRIVES_ENGAGEMENT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("balances_stakeholders", new ScoreInterval("balances_stakeholders", 0 , CompetenciesConstants.POINT_BALANCES_STAKEHOLDERS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("ensures_accountability", new ScoreInterval("ensures_accountability", 0 , CompetenciesConstants.POINT_ENSURES_ACCOUNTABILITY / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("drives_results", new ScoreInterval("drives_results", 0 , CompetenciesConstants.POINT_DRIVES_RESULTS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("customer_focus", new ScoreInterval("customer_focus", 0 , CompetenciesConstants.POINT_CUSTOMER_FOCUS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("manages_conflict", new ScoreInterval("manages_conflict", 0 , CompetenciesConstants.POINT_MANAGES_CONFLICT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("builds_effective_teams", new ScoreInterval("builds_effective_teams", 0 , CompetenciesConstants.POINT_BUILDS_EFFECTIVE_TEAMS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("plans_and_aligns", new ScoreInterval("plans_and_aligns", 0 , CompetenciesConstants.POINT_PLANS_AND_ALIGNS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("directs_work", new ScoreInterval("directs_work", 0 , CompetenciesConstants.POINT_DIRECTS_WORK / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));
        COMPETENCIES_SCORE_INTERVAL.put("optimizes_work_processes", new ScoreInterval("optimizes_work_processes", 0 , CompetenciesConstants.POINT_OPTIMIZES_WORK_PROCESSES / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100));


    }

    public static void main(String... args){
        System.out.println(COMPETENCIES_SCORE_INTERVAL);
    }

}
