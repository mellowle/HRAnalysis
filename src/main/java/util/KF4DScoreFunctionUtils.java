package util;

import Constants.KF4DConstants.CompetenciesConstants;
import Constants.KF4DConstants.DriversConstants;
import Constants.KF4DConstants.TraitsConstants;
import entity.dimensionScored.DCompetenciesScored;
import entity.dimensionScored.DDriversScored;
import entity.dimensionScored.DTraitsScored;

import java.util.HashMap;
import java.util.Map;

public class KF4DScoreFunctionUtils {

    public static Map<String, Double> calcMissionCriticalScore(Map<String, Integer> missionCritical) {
        Map<String, Double> result = new HashMap<>();

        //        result.put("strategic_mindset", calcScoreWithUCPZone(missionCritical.get("strategic_mindset"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("strategic_mindset").getMax(),
        //                CompetenciesConstants.MAX_STRATEGIC_MINDSET, CompetenciesConstants.MIN_STRATEGIC_MINDSET));
        //        result.put("global_perspective", calcScoreWithUCPZone(missionCritical.get("global_perspective"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("global_perspective").getMax(),
        //                CompetenciesConstants.MAX_GLOBAL_PERSPECTIVE, CompetenciesConstants.MIN_GLOBAL_PERSPECTIVE));
        //        result.put("instills_trust", calcScoreWithUCPZone(missionCritical.get("instills_trust"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("instills_trust").getMax(),
        //                CompetenciesConstants.MAX_INSTILLS_TRUST, CompetenciesConstants.MIN_INSTILLS_TRUST));
        //        result.put("persuades", calcScoreWithUCPZone(missionCritical.get("persuades"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("persuades").getMax(),
        //                CompetenciesConstants.MAX_PERSUADES, CompetenciesConstants.MIN_PERSUADES));
        //        result.put("communicates_effectively", calcScoreWithUCPZone(missionCritical.get("communicates_effectively"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("communicates_effectively").getMax(),
        //                CompetenciesConstants.MAX_COMMUNICATES_EFFECTIVELY, CompetenciesConstants.MIN_COMMUNICATES_EFFECTIVELY));
        //        result.put("collaborates", calcScoreWithUCPZone(missionCritical.get("collaborates"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("collaborates").getMax(),
        //                CompetenciesConstants.MAX_COLLABORATES, CompetenciesConstants.MIN_COLLABORATES));
        //        result.put("cultivates_innovation", calcScoreWithUCPZone(missionCritical.get("cultivates_innovation"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("cultivates_innovation").getMax(),
        //                CompetenciesConstants.MAX_CULTIVATES_INNOVATION, CompetenciesConstants.MIN_CULTIVATES_INNOVATION));
        //        result.put("nimble_learning", calcScoreWithUCPZone(missionCritical.get("nimble_learning"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("nimble_learning").getMax(),
        //                CompetenciesConstants.MAX_NIMBLE_LEARNING, CompetenciesConstants.MIN_NIMBLE_LEARNING));
        //        result.put("develops_talent", calcScoreWithUCPZone(missionCritical.get("develops_talent"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("develops_talent").getMax(),
        //                CompetenciesConstants.MAX_DEVELOPS_TALENT, CompetenciesConstants.MIN_DEVELOPS_TALENT));
        //        result.put("situational_adaptability", calcScoreWithUCPZone(missionCritical.get("situational_adaptability"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("situational_adaptability").getMax(),
        //                CompetenciesConstants.MAX_SITUATIONAL_ADAPTABILITY, CompetenciesConstants.MIN_SITUATIONAL_ADAPTABILITY));

        result.put("strategic_mindset", calcScoreTheHigherTheBetter(missionCritical.get("strategic_mindset"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("strategic_mindset").getMax()));
        result.put("global_perspective", calcScoreTheHigherTheBetter(missionCritical.get("global_perspective"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("global_perspective").getMax()));
        result.put("instills_trust", calcScoreTheHigherTheBetter(missionCritical.get("instills_trust"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("instills_trust").getMax()));
        result.put("persuades", calcScoreTheHigherTheBetter(missionCritical.get("persuades"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("persuades").getMax()));
        result.put("communicates_effectively", calcScoreTheHigherTheBetter(missionCritical.get("communicates_effectively"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("communicates_effectively").getMax()));
        result.put("collaborates", calcScoreTheHigherTheBetter(missionCritical.get("collaborates"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("collaborates").getMax()));
        result.put("cultivates_innovation", calcScoreTheHigherTheBetter(missionCritical.get("cultivates_innovation"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("cultivates_innovation").getMax()));
        result.put("nimble_learning", calcScoreTheHigherTheBetter(missionCritical.get("nimble_learning"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("nimble_learning").getMax()));
        result.put("develops_talent", calcScoreTheHigherTheBetter(missionCritical.get("develops_talent"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("develops_talent").getMax()));
        result.put("situational_adaptability", calcScoreTheHigherTheBetter(missionCritical.get("situational_adaptability"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("situational_adaptability").getMax()));

        return result;
    }


    public static Map<String, Double> calcCriticalScore(Map<String, Integer> critical) {
        Map<String, Double> result = new HashMap<>();

        //        result.put("builds_networks", calcScoreWithZone(critical.get("builds_networks"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("builds_networks").getMax(), true));
        //        result.put("decision_quality", calcScoreWithZone(critical.get("decision_quality"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("decision_quality").getMax(), false));
        //        result.put("being_resilient", calcScoreWithZone(critical.get("being_resilient"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("being_resilient").getMax(), false));
        //        result.put("courage", calcScoreWithZone(critical.get("courage"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("courage").getMax(), false));
        //        result.put("action_oriented", calcScoreWithZone(critical.get("action_oriented"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("action_oriented").getMax(), true));
        //        result.put("manages_ambiguity", calcScoreWithZone(critical.get("manages_ambiguity"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("manages_ambiguity").getMax(), false));
        //        result.put("interpersonal_savvy", calcScoreWithZone(critical.get("interpersonal_savvy"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("interpersonal_savvy").getMax(), false));
        //        result.put("resourcefulness", calcScoreWithZone(critical.get("resourcefulness"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("resourcefulness").getMax(), false));
        //        result.put("self_development", calcScoreWithZone(critical.get("self_development"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("self_development").getMax(), false));
        //        result.put("values_differences", calcScoreWithZone(critical.get("values_differences"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("values_differences").getMax(), false));

        result.put("builds_networks", calcScoreTheHigherTheBetter(critical.get("builds_networks"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("builds_networks").getMax()));
        result.put("decision_quality", calcScoreTheHigherTheBetter(critical.get("decision_quality"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("decision_quality").getMax()));
        result.put("being_resilient", calcScoreTheHigherTheBetter(critical.get("being_resilient"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("being_resilient").getMax()));
        result.put("courage", calcScoreTheHigherTheBetter(critical.get("courage"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("courage").getMax()));
        result.put("action_oriented", calcScoreTheHigherTheBetter(critical.get("action_oriented"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("action_oriented").getMax()));
        result.put("manages_ambiguity", calcScoreTheHigherTheBetter(critical.get("manages_ambiguity"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("manages_ambiguity").getMax()));
        result.put("interpersonal_savvy", calcScoreTheHigherTheBetter(critical.get("interpersonal_savvy"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("interpersonal_savvy").getMax()));
        result.put("resourcefulness", calcScoreTheHigherTheBetter(critical.get("resourcefulness"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("resourcefulness").getMax()));
        result.put("self_development", calcScoreTheHigherTheBetter(critical.get("self_development"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("self_development").getMax()));
        result.put("values_differences", calcScoreTheHigherTheBetter(critical.get("values_differences"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("values_differences").getMax()));

        return result;
    }


    public static Map<String, Double> calcLessCriticalScore(Map<String, Integer> lessCritical) {
        Map<String, Double> result = new HashMap<>();

        //        result.put("drives_engagement", calcScoreWithZone(lessCritical.get("drives_engagement"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("drives_engagement").getMax(), false));
        //        result.put("balances_stakeholders", calcScoreWithZone(lessCritical.get("balances_stakeholders"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("balances_stakeholders").getMax(), true));
        //        result.put("ensures_accountability", calcScoreWithZone(lessCritical.get("ensures_accountability"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("ensures_accountability").getMax(), false));
        //        result.put("drives_results", calcScoreWithZone(lessCritical.get("drives_results"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("drives_results").getMax(), true));
        //        result.put("customer_focus", calcScoreWithZone(lessCritical.get("customer_focus"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("customer_focus").getMax(), false));
        //        result.put("manages_conflict", calcScoreWithZone(lessCritical.get("manages_conflict"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("manages_conflict").getMax(), false));
        //        result.put("builds_effective_teams", calcScoreWithZone(lessCritical.get("builds_effective_teams"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("builds_effective_teams").getMax(), false));
        //        result.put("plans_and_aligns", calcScoreWithZone(lessCritical.get("plans_and_aligns"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("plans_and_aligns").getMax(), true));
        //        result.put("directs_work", calcScoreWithZone(lessCritical.get("directs_work"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("directs_work").getMax(), true));
        //        result.put("optimizes_work_processes", calcScoreWithZone(lessCritical.get("optimizes_work_processes"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("optimizes_work_processes").getMax(), false));

        result.put("drives_engagement", calcScoreTheHigherTheBetter(lessCritical.get("drives_engagement"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("drives_engagement").getMax()));
        result.put("balances_stakeholders", calcScoreTheHigherTheBetter(lessCritical.get("balances_stakeholders"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("balances_stakeholders").getMax()));
        result.put("ensures_accountability", calcScoreTheHigherTheBetter(lessCritical.get("ensures_accountability"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("ensures_accountability").getMax()));
        result.put("drives_results", calcScoreTheHigherTheBetter(lessCritical.get("drives_results"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("drives_results").getMax()));
        result.put("customer_focus", calcScoreTheHigherTheBetter(lessCritical.get("customer_focus"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("customer_focus").getMax()));
        result.put("manages_conflict", calcScoreTheHigherTheBetter(lessCritical.get("manages_conflict"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("manages_conflict").getMax()));
        result.put("builds_effective_teams", calcScoreTheHigherTheBetter(lessCritical.get("builds_effective_teams"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("builds_effective_teams").getMax()));
        result.put("plans_and_aligns", calcScoreTheHigherTheBetter(lessCritical.get("plans_and_aligns"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("plans_and_aligns").getMax()));
        result.put("directs_work", calcScoreTheHigherTheBetter(lessCritical.get("directs_work"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("directs_work").getMax()));
        result.put("optimizes_work_processes", calcScoreTheHigherTheBetter(lessCritical.get("optimizes_work_processes"), CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.get("optimizes_work_processes").getMax()));

        return result;
    }

    public static Map<String, Double> calcTraitsScore(Map<String, Integer> traits) {
        Map<String, Double> result = new HashMap<>();

        //        result.put("adaptability", calcScoreWithUCPPoint(traits.get("adaptability"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("adaptability").getMax(), TraitsConstants.UCP_ADAPTABILITY));
        //        result.put("affiliation", calcScoreWithUCPPoint(traits.get("affiliation"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("affiliation").getMax(), TraitsConstants.UCP_AFFILIATION));
        //        result.put("assertiveness", calcScoreWithUCPPoint(traits.get("assertiveness"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("assertiveness").getMax(), TraitsConstants.UCP_ASSERTIVENESS));
        //        result.put("composure", calcScoreWithUCPPoint(traits.get("composure"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("composure").getMax(), TraitsConstants.UCP_COMPOSURE));
        //        result.put("confidence", calcScoreWithUCPPoint(traits.get("confidence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("confidence").getMax(), TraitsConstants.UCP_CONFIDENCE));
        //        result.put("credibility", calcScoreWithUCPPoint(traits.get("credibility"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("credibility").getMax(), TraitsConstants.UCP_CREDIBILITY));
        //        result.put("curiosity", calcScoreWithUCPPoint(traits.get("curiosity"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("curiosity").getMax(), TraitsConstants.UCP_CURIOSITY));
        //        result.put("empathy", calcScoreWithUCPPoint(traits.get("empathy"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("empathy").getMax(), TraitsConstants.UCP_EMPATHY));
        //        result.put("focus", calcScoreWithUCPPoint(traits.get("focus"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("focus").getMax(), TraitsConstants.UCP_FOCUS));
        //        result.put("humility", calcScoreWithUCPPoint(traits.get("humility"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("humility").getMax(), TraitsConstants.UCP_HUMILITY));
        //        result.put("influence", calcScoreWithUCPPoint(traits.get("influence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("influence").getMax(), TraitsConstants.UCP_INFLUENCE));
        //        result.put("need_for_achievement", calcScoreWithUCPPoint(traits.get("need_for_achievement"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("need_for_achievement").getMax(), TraitsConstants.UCP_NEED_FOR_ACHIEVEMENT));
        //        result.put("openness_to_differences", calcScoreWithUCPPoint(traits.get("openness_to_differences"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("openness_to_differences").getMax(), TraitsConstants.UCP_OPENNESS_TO_DIFFERENCES));
        //        result.put("optimism", calcScoreWithUCPPoint(traits.get("optimism"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("optimism").getMax(), TraitsConstants.UCP_OPTIMISM));
        //        result.put("persistence", calcScoreWithUCPPoint(traits.get("persistence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("persistence").getMax(), TraitsConstants.UCP_PERSISTENCE));
        //        result.put("risk_taking", calcScoreWithUCPPoint(traits.get("risk_taking"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("risk_taking").getMax(), TraitsConstants.UCP_RISK_TAKING));
        //        result.put("situational_self_awareness", calcScoreWithUCPPoint(traits.get("situational_self_awareness"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("situational_self_awareness").getMax(), TraitsConstants.UCP_SITUATIONAL_SELF_AWARENESS));
        //        result.put("sociability", calcScoreWithUCPPoint(traits.get("sociability"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("sociability").getMax(), TraitsConstants.UCP_SOCIABILITY));
        //        result.put("tolerance_of_ambiguity", calcScoreWithUCPPoint(traits.get("tolerance_of_ambiguity"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("tolerance_of_ambiguity").getMax(), TraitsConstants.UCP_TOLERANCE_OF_AMBIGUITY));
        //        result.put("trust", calcScoreWithUCPPoint(traits.get("trust"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("trust").getMax(), TraitsConstants.UCP_TRUST));

        result.put("adaptability", calcScoreTheHigherTheBetter(traits.get("adaptability"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("adaptability").getMax()));
        result.put("affiliation", calcScoreTheHigherTheBetter(traits.get("affiliation"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("affiliation").getMax()));
        result.put("assertiveness", calcScoreTheHigherTheBetter(traits.get("assertiveness"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("assertiveness").getMax()));
        result.put("composure", calcScoreTheHigherTheBetter(traits.get("composure"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("composure").getMax()));
        result.put("confidence", calcScoreTheHigherTheBetter(traits.get("confidence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("confidence").getMax()));
        result.put("credibility", calcScoreTheHigherTheBetter(traits.get("credibility"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("credibility").getMax()));
        result.put("curiosity", calcScoreTheHigherTheBetter(traits.get("curiosity"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("curiosity").getMax()));
        result.put("empathy", calcScoreTheHigherTheBetter(traits.get("empathy"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("empathy").getMax()));
        result.put("focus", calcScoreTheHigherTheBetter(traits.get("focus"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("focus").getMax()));
        result.put("humility", calcScoreTheHigherTheBetter(traits.get("humility"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("humility").getMax()));
        result.put("influence", calcScoreTheHigherTheBetter(traits.get("influence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("influence").getMax()));
        result.put("need_for_achievement", calcScoreTheHigherTheBetter(traits.get("need_for_achievement"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("need_for_achievement").getMax()));
        result.put("openness_to_differences", calcScoreTheHigherTheBetter(traits.get("openness_to_differences"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("openness_to_differences").getMax()));
        result.put("optimism", calcScoreTheHigherTheBetter(traits.get("optimism"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("optimism").getMax()));
        result.put("persistence", calcScoreTheHigherTheBetter(traits.get("persistence"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("persistence").getMax()));
        result.put("risk_taking", calcScoreTheHigherTheBetter(traits.get("risk_taking"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("risk_taking").getMax()));
        result.put("situational_self_awareness", calcScoreTheHigherTheBetter(traits.get("situational_self_awareness"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("situational_self_awareness").getMax()));
        result.put("sociability", calcScoreTheHigherTheBetter(traits.get("sociability"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("sociability").getMax()));
        result.put("tolerance_of_ambiguity", calcScoreTheHigherTheBetter(traits.get("tolerance_of_ambiguity"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("tolerance_of_ambiguity").getMax()));
        result.put("trust", calcScoreTheHigherTheBetter(traits.get("trust"), TraitsConstants.TRAITS_SCORE_INTERVAL.get("trust").getMax()));

        return result;

    }

    public static Map<String, Double> calcDriversScore(Map<String, Integer> drivers) {
        Map<String, Double> result = new HashMap<>();

        result.put("balance", calcScoreWithUCPPoint(drivers.get("balance"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("balance").getMax(), DriversConstants.UCP_BALANCE));
        result.put("challenge", calcScoreWithUCPPoint(drivers.get("challenge"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("challenge").getMax(), DriversConstants.UCP_CHALLENGE));
        result.put("collaboration", calcScoreWithUCPPoint(drivers.get("collaboration"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("collaboration").getMax(), DriversConstants.UCP_COLLABORATION));
        result.put("independence", calcScoreWithUCPPoint(drivers.get("independence"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("independence").getMax(), DriversConstants.UCP_INDEPENDENCE));
        result.put("power", calcScoreWithUCPPoint(drivers.get("power"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("power").getMax(), DriversConstants.UCP_POWER));
        result.put("structure", calcScoreWithUCPPoint(drivers.get("structure"), DriversConstants.DRIVERS_SCORE_INTERVAL.get("structure").getMax(), DriversConstants.UCP_STRUCTURE));

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

    private static Double calcScoreTheHigherTheBetter(Integer score, Double points) {
        Double result;

        if (score == null) {
            return null;
        }

        result = score / 10d * points;

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

    public static void sumUpCompetencies(DCompetenciesScored dCompetenciesScored) {
        Double result;
        if (dCompetenciesScored.getStrategic_mindset() != null) {
            result = dCompetenciesScored.getStrategic_mindset()
                    + dCompetenciesScored.getGlobal_perspective()
                    + dCompetenciesScored.getInstills_trust()
                    + dCompetenciesScored.getPersuades()
                    + dCompetenciesScored.getCommunicates_effectively()
                    + dCompetenciesScored.getCollaborates()
                    + dCompetenciesScored.getCultivates_innovation()
                    + dCompetenciesScored.getNimble_learning()
                    + dCompetenciesScored.getDevelops_talent()
                    + dCompetenciesScored.getSituational_adaptability()

                    + dCompetenciesScored.getBuilds_networks()
                    + dCompetenciesScored.getDecision_quality()
                    + dCompetenciesScored.getBeing_resilient()
                    + dCompetenciesScored.getCourage()
                    + dCompetenciesScored.getAction_oriented()
                    + dCompetenciesScored.getManages_ambiguity()
                    + dCompetenciesScored.getInterpersonal_savvy()
                    + dCompetenciesScored.getResourcefulness()
                    + dCompetenciesScored.getSelf_development()
                    + dCompetenciesScored.getValues_differences()

                    + dCompetenciesScored.getDrives_engagement()
                    + dCompetenciesScored.getBalances_stakeholders()
                    + dCompetenciesScored.getEnsures_accountability()
                    + dCompetenciesScored.getDrives_results()
                    + dCompetenciesScored.getCustomer_focus()
                    + dCompetenciesScored.getManages_conflict()
                    + dCompetenciesScored.getBuilds_effective_teams()
                    + dCompetenciesScored.getPlans_and_aligns()
                    + dCompetenciesScored.getDirects_work()
                    + dCompetenciesScored.getOptimizes_work_processes();
        }
        else {
            result = null;
        }
        dCompetenciesScored.setResult(result);

    }

    public static void sumUpTraits(DTraitsScored dTraitsScored) {
        Double result;
        if (dTraitsScored.getAdaptability() != null) {
            result = dTraitsScored.getAdaptability()
                    + dTraitsScored.getAffiliation()
                    + dTraitsScored.getAssertiveness()
                    + dTraitsScored.getComposure()
                    + dTraitsScored.getConfidence()
                    + dTraitsScored.getCredibility()
                    + dTraitsScored.getCuriosity()
                    + dTraitsScored.getEmpathy()
                    + dTraitsScored.getFocus()
                    + dTraitsScored.getHumility()
                    + dTraitsScored.getInfluence()
                    + dTraitsScored.getNeed_for_achievement()
                    + dTraitsScored.getOpenness_to_differences()
                    + dTraitsScored.getOptimism()
                    + dTraitsScored.getPersistence()
                    + dTraitsScored.getRisk_taking()
                    + dTraitsScored.getSituational_self_awareness()
                    + dTraitsScored.getSociability()
                    + dTraitsScored.getTolerance_of_ambiguity()
                    + dTraitsScored.getTrust();
        }
        else {
            result = null;
        }
        dTraitsScored.setResult(result);
    }

    public static void sumUpDrivers(DDriversScored dDriversScored) {
        Double result;
        if (dDriversScored.getBalance() != null) {
            result = dDriversScored.getBalance()
                    + dDriversScored.getChallenge()
                    + dDriversScored.getCollaboration()
                    + dDriversScored.getIndependence()
                    + dDriversScored.getPower()
                    + dDriversScored.getStructure();
        }
        else {
            result = null;
        }
        dDriversScored.setResult(result);
    }

}
