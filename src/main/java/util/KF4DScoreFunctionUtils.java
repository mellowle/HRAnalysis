package util;

import KF4DConstants.CompetenciesConstants;
import KF4DConstants.DriversConstants;
import KF4DConstants.TraitsConstants;

import java.util.HashMap;
import java.util.Map;

public class KF4DScoreFunctionUtils {

    public static Map<String, Double> calcMissionCriticalScore(Map<String, Integer> missionCritical) {
        Map<String, Double> result = new HashMap<>();

        Double strategic_mindset_point =
                CompetenciesConstants.POINT_STRATEGIC_MINDSET / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double global_perspective_point =
                CompetenciesConstants.POINT_GLOBAL_PERSPECTIVE / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double instills_trust_point =
                CompetenciesConstants.POINT_INSTILLS_TRUST / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double persuades_point =
                CompetenciesConstants.POINT_PERSUADES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double communicates_effectively_point =
                CompetenciesConstants.POINT_COMMUNICATES_EFFECTIVELY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double collaborates_point =
                CompetenciesConstants.POINT_COLLABORATES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double cultivates_innovation_point =
                CompetenciesConstants.POINT_CULTIVATES_INNOVATION / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double nimble_learning_point =
                CompetenciesConstants.POINT_NIMBLE_LEARNING / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double develops_talent_point =
                CompetenciesConstants.POINT_DEVELOPS_TALENT / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        Double situational_adaptability_point =
                CompetenciesConstants.POINT_SITUATIONAL_ADAPTABILITY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;

        result.put("strategic_mindset", calcScoreWithUCPZone(missionCritical.get("strategic_mindset"), strategic_mindset_point,
                CompetenciesConstants.MAX_STRATEGIC_MINDSET, CompetenciesConstants.MIN_STRATEGIC_MINDSET));
        result.put("global_perspective", calcScoreWithUCPZone(missionCritical.get("global_perspective"), global_perspective_point,
                CompetenciesConstants.MAX_GLOBAL_PERSPECTIVE, CompetenciesConstants.MIN_GLOBAL_PERSPECTIVE));
        result.put("instills_trust", calcScoreWithUCPZone(missionCritical.get("instills_trust"), instills_trust_point,
                CompetenciesConstants.MAX_INSTILLS_TRUST, CompetenciesConstants.MIN_INSTILLS_TRUST));
        result.put("persuades", calcScoreWithUCPZone(missionCritical.get("persuades"), persuades_point,
                CompetenciesConstants.MAX_PERSUADES, CompetenciesConstants.MIN_PERSUADES));
        result.put("communicates_effectively", calcScoreWithUCPZone(missionCritical.get("communicates_effectively"), communicates_effectively_point,
                CompetenciesConstants.MAX_COMMUNICATES_EFFECTIVELY, CompetenciesConstants.MIN_COMMUNICATES_EFFECTIVELY));
        result.put("collaborates", calcScoreWithUCPZone(missionCritical.get("collaborates"), collaborates_point,
                CompetenciesConstants.MAX_COLLABORATES, CompetenciesConstants.MIN_COLLABORATES));
        result.put("cultivates_innovation", calcScoreWithUCPZone(missionCritical.get("cultivates_innovation"), cultivates_innovation_point,
                CompetenciesConstants.MAX_CULTIVATES_INNOVATION, CompetenciesConstants.MIN_CULTIVATES_INNOVATION));
        result.put("nimble_learning", calcScoreWithUCPZone(missionCritical.get("nimble_learning"), nimble_learning_point,
                CompetenciesConstants.MAX_NIMBLE_LEARNING, CompetenciesConstants.MIN_NIMBLE_LEARNING));
        result.put("develops_talent", calcScoreWithUCPZone(missionCritical.get("develops_talent"), develops_talent_point,
                CompetenciesConstants.MAX_DEVELOPS_TALENT, CompetenciesConstants.MIN_DEVELOPS_TALENT));
        result.put("situational_adaptability", calcScoreWithUCPZone(missionCritical.get("situational_adaptability"), situational_adaptability_point,
                CompetenciesConstants.MAX_SITUATIONAL_ADAPTABILITY, CompetenciesConstants.MIN_SITUATIONAL_ADAPTABILITY));

        return result;
    }


    public static Map<String, Double> calcCriticalScore(Map<String, Integer> critical) {
        Map<String, Double> result = new HashMap<>();

        Double builds_networks_point =
                CompetenciesConstants.POINT_BUILDS_NETWORKS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double decision_quality_point =
                CompetenciesConstants.POINT_DECISION_QUALITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double being_resilient_point =
                CompetenciesConstants.POINT_BEING_RESILIENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double courage_point =
                CompetenciesConstants.POINT_COURAGE / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double action_oriented_point =
                CompetenciesConstants.POINT_ACTION_ORIENTED / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double manages_ambiguity_point =
                CompetenciesConstants.POINT_MANAGES_AMBIGUITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double interpersonal_savvy_point =
                CompetenciesConstants.POINT_INTERPERSONAL_SAVVY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double resourcefulness_point =
                CompetenciesConstants.POINT_RESOURCEFULNESS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double self_development_point =
                CompetenciesConstants.POINT_SELF_DEVELOPMENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        Double values_differences_point =
                CompetenciesConstants.POINT_VALUES_DIFFERENCES / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;

        result.put("builds_networks", calcScoreWithZone(critical.get("builds_networks"), builds_networks_point, true));
        result.put("decision_quality", calcScoreWithZone(critical.get("decision_quality"), decision_quality_point, false));
        result.put("being_resilient", calcScoreWithZone(critical.get("being_resilient"), being_resilient_point, false));
        result.put("courage", calcScoreWithZone(critical.get("courage"), courage_point, false));
        result.put("action_oriented", calcScoreWithZone(critical.get("action_oriented"), action_oriented_point, true));
        result.put("manages_ambiguity", calcScoreWithZone(critical.get("manages_ambiguity"), manages_ambiguity_point, false));
        result.put("interpersonal_savvy", calcScoreWithZone(critical.get("interpersonal_savvy"), interpersonal_savvy_point, false));
        result.put("resourcefulness", calcScoreWithZone(critical.get("resourcefulness"), resourcefulness_point, false));
        result.put("self_development", calcScoreWithZone(critical.get("self_development"), self_development_point, false));
        result.put("values_differences", calcScoreWithZone(critical.get("values_differences"), values_differences_point, false));

        return result;
    }


    public static Map<String, Double> calcLessCriticalScore(Map<String, Integer> lessCritical) {
        Map<String, Double> result = new HashMap<>();

        Double drives_engagement_point =
                CompetenciesConstants.POINT_DRIVES_ENGAGEMENT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double balances_stakeholders_point =
                CompetenciesConstants.POINT_BALANCES_STAKEHOLDERS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double ensures_accountability_point =
                CompetenciesConstants.POINT_ENSURES_ACCOUNTABILITY / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double drives_results_point =
                CompetenciesConstants.POINT_DRIVES_RESULTS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double customer_focus_point =
                CompetenciesConstants.POINT_CUSTOMER_FOCUS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double manages_conflict_point =
                CompetenciesConstants.POINT_MANAGES_CONFLICT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double builds_effective_teams_point =
                CompetenciesConstants.POINT_BUILDS_EFFECTIVE_TEAMS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double plans_and_aligns_point =
                CompetenciesConstants.POINT_PLANS_AND_ALIGNS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double directs_work_point =
                CompetenciesConstants.POINT_DIRECTS_WORK / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        Double optimizes_work_processes_point =
                CompetenciesConstants.POINT_OPTIMIZES_WORK_PROCESSES / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;

        result.put("drives_engagement", calcScoreWithZone(lessCritical.get("drives_engagement"), drives_engagement_point, false));
        result.put("balances_stakeholders", calcScoreWithZone(lessCritical.get("balances_stakeholders"), balances_stakeholders_point, true));
        result.put("ensures_accountability", calcScoreWithZone(lessCritical.get("ensures_accountability"), ensures_accountability_point, false));
        result.put("drives_results", calcScoreWithZone(lessCritical.get("drives_results"), drives_results_point, true));
        result.put("customer_focus", calcScoreWithZone(lessCritical.get("customer_focus"), customer_focus_point, false));
        result.put("manages_conflict", calcScoreWithZone(lessCritical.get("manages_conflict"), manages_conflict_point, false));
        result.put("builds_effective_teams", calcScoreWithZone(lessCritical.get("builds_effective_teams"), builds_effective_teams_point, false));
        result.put("plans_and_aligns", calcScoreWithZone(lessCritical.get("plans_and_aligns"), plans_and_aligns_point, true));
        result.put("directs_work", calcScoreWithZone(lessCritical.get("directs_work"), directs_work_point, true));
        result.put("optimizes_work_processes", calcScoreWithZone(lessCritical.get("optimizes_work_processes"), optimizes_work_processes_point, false));

        return result;
    }

    public static Map<String, Double> calcTraitsScore(Map<String, Integer> traits) {
        Map<String, Double> result = new HashMap<>();

        result.put("adaptability", calcScoreWithUCPPoint(traits.get("adaptability"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_ADAPTABILITY));
        result.put("affiliation", calcScoreWithUCPPoint(traits.get("affiliation"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_AFFILIATION));
        result.put("assertiveness", calcScoreWithUCPPoint(traits.get("assertiveness"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_ASSERTIVENESS));
        result.put("composure", calcScoreWithUCPPoint(traits.get("composure"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_COMPOSURE));
        result.put("confidence", calcScoreWithUCPPoint(traits.get("confidence"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_CONFIDENCE));
        result.put("credibility", calcScoreWithUCPPoint(traits.get("credibility"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_CREDIBILITY));
        result.put("curiosity", calcScoreWithUCPPoint(traits.get("curiosity"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_CURIOSITY));
        result.put("empathy", calcScoreWithUCPPoint(traits.get("empathy"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_EMPATHY));
        result.put("focus", calcScoreWithUCPPoint(traits.get("focus"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_FOCUS));
        result.put("humility", calcScoreWithUCPPoint(traits.get("humility"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_HUMILITY));
        result.put("influence", calcScoreWithUCPPoint(traits.get("influence"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_INFLUENCE));
        result.put("need_for_achievement", calcScoreWithUCPPoint(traits.get("need_for_achievement"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_NEED_FOR_ACHIEVEMENT));
        result.put("openness_to_differences", calcScoreWithUCPPoint(traits.get("openness_to_differences"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_OPENNESS_TO_DIFFERENCES));
        result.put("optimism", calcScoreWithUCPPoint(traits.get("optimism"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_OPTIMISM));
        result.put("persistence", calcScoreWithUCPPoint(traits.get("persistence"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_PERSISTENCE));
        result.put("risk_taking", calcScoreWithUCPPoint(traits.get("risk_taking"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_RISK_TAKING));
        result.put("situational_self_awareness", calcScoreWithUCPPoint(traits.get("situational_self_awareness"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_SITUATIONAL_SELF_AWARENESS));
        result.put("sociability", calcScoreWithUCPPoint(traits.get("sociability"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_SOCIABILITY));
        result.put("tolerance_of_ambiguity", calcScoreWithUCPPoint(traits.get("tolerance_of_ambiguity"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_TOLERANCE_OF_AMBIGUITY));
        result.put("trust", calcScoreWithUCPPoint(traits.get("trust"), TraitsConstants.POINT_TRAIT, TraitsConstants.UCP_TRUST));

        return result;

    }

    public static Map<String, Double> calcDriversScore(Map<String, Integer> drivers) {
        Map<String, Double> result = new HashMap<>();

        result.put("balance", calcScoreWithUCPPoint(drivers.get("balance"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_BALANCE));
        result.put("challenge", calcScoreWithUCPPoint(drivers.get("challenge"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_CHALLENGE));
        result.put("collaboration", calcScoreWithUCPPoint(drivers.get("collaboration"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_COLLABORATION));
        result.put("independence", calcScoreWithUCPPoint(drivers.get("independence"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_INDEPENDENCE));
        result.put("power", calcScoreWithUCPPoint(drivers.get("power"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_POWER));
        result.put("structure", calcScoreWithUCPPoint(drivers.get("structure"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_STRUCTURE));

        return result;
    }

    private static Double calcScoreWithUCPPoint(Integer score, Double points, Double ucp) {
        Double result;

        if (score == null) {
            return null;
        }

        Double pointsUCP10 = (10 - ucp) / 10 * points;
        Double points0UCP = ucp / 10 * points;

        if (score.doubleValue() == ucp) {
            result = points;
        }
        else if (score.doubleValue() > ucp && score.doubleValue() <= 10) {
            result = points - (score - ucp) * pointsUCP10 / (10 - ucp);
        }
        else {
            result = points - pointsUCP10 - (ucp - score) * points0UCP / ucp;
        }

        return result;
    }

    private static Double calcScoreWithUCPZone(Integer score, Double points, Double max, Double min) {
        Double result;

        if (score == null) {
            return null;
        }

        Double mean = (max + min) / 2;
        Double pointsMinMax = (max - min) / (2 * 10) * points;
        Double pointsMax10 = (10 - max) / 10 * points;
        Double points0Min = min / 10 * points;

        if (score.doubleValue() == mean) {
            result = points;
        }
        else if (score.doubleValue() < mean && score.doubleValue() >= min) {
            result = points - (mean - score) * pointsMinMax / (mean - min);
        }
        else if (score.doubleValue() > mean && score.doubleValue() <= max) {
            result = points - (score - mean) * pointsMinMax / (10 - max);
        }
        else if (score.doubleValue() > max && score.doubleValue() <= 10) {
            result = points - pointsMinMax - (score - max) * pointsMax10 / (10 - max);
        }
        else {
            result = points - pointsMinMax - pointsMax10 - (min - score) * points0Min / min;
        }

        return result;
    }

    private static Double calcScoreWithZone(Integer score, Double points, boolean isDerails) {
        Double result;

        if (score == null) {
            return null;
        }

        Double pointsZeroZone = 0d;
        Double pointsLowZone = points / 3;
        Double pointsMidZone;
        Double pointsHighZone;

        if (isDerails) {
            pointsMidZone = points;
            pointsHighZone = points / 3 * 2;
        }

        else {
            pointsMidZone = points / 3 * 2;
            pointsHighZone = points;
        }

        if (score.doubleValue() < 4) {
            result = pointsZeroZone;
        }
        else if (score.doubleValue() >= 4 && score.doubleValue() < 6) {
            result = pointsLowZone;
        }
        else if (score.doubleValue() >= 6 && score.doubleValue() < 8) {
            result = pointsMidZone;
        }
        else {
            result = pointsHighZone;
        }

        return result;
    }

}
