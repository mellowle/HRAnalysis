package util;

import KF4DConstants.KF4DConstants;
import dimensionRawData.DCompetencies;

import java.util.HashMap;
import java.util.Map;

public class KF4DScoreFunctionUtils {

    public static Map<String, Double> calcMissionCriticalScore(Map<String, Integer> missionCritical) {
        Map<String, Double> result = new HashMap<>();
        double strategic_mindset_point =
                KF4DConstants.POINT_STRATEGIC_MINDSET / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("strategic_mindset " + strategic_mindset_point);
        result.put("strategic_mindset", calcScoreWithUCP(missionCritical.get("strategic_mindset"), strategic_mindset_point,
                KF4DConstants.MAX_STRATEGIC_MINDSET, KF4DConstants.MIN_STRATEGIC_MINDSET));

        double global_perspective_point =
                KF4DConstants.POINT_GLOBAL_PERSPECTIVE / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("global_perspective " + global_perspective_point);
        result.put("global_perspective", calcScoreWithUCP(missionCritical.get("global_perspective"), global_perspective_point,
                KF4DConstants.MAX_GLOBAL_PERSPECTIVE, KF4DConstants.MIN_GLOBAL_PERSPECTIVE));

        double instills_trust_point =
                KF4DConstants.POINT_INSTILLS_TRUST / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("instills_trust " + instills_trust_point);
        result.put("instills_trust", calcScoreWithUCP(missionCritical.get("instills_trust"), instills_trust_point,
                KF4DConstants.MAX_INSTILLS_TRUST, KF4DConstants.MIN_INSTILLS_TRUST));

        double persuades_point =
                KF4DConstants.POINT_PERSUADES / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("persuades " + persuades_point);
        result.put("persuades", calcScoreWithUCP(missionCritical.get("persuades"), persuades_point,
                KF4DConstants.MAX_PERSUADES, KF4DConstants.MIN_PERSUADES));

        double communicates_effectively_point =
                KF4DConstants.POINT_COMMUNICATES_EFFECTIVELY / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("communicates_effectively " + communicates_effectively_point);
        result.put("communicates_effectively", calcScoreWithUCP(missionCritical.get("communicates_effectively"), communicates_effectively_point,
                KF4DConstants.MAX_COMMUNICATES_EFFECTIVELY, KF4DConstants.MIN_COMMUNICATES_EFFECTIVELY));

        double collaborates_point =
                KF4DConstants.POINT_COLLABORATES / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("collaborates " + collaborates_point);
        result.put("collaborates", calcScoreWithUCP(missionCritical.get("collaborates"), collaborates_point,
                KF4DConstants.MAX_COLLABORATES, KF4DConstants.MIN_COLLABORATES));

        double cultivates_innovation_point =
                KF4DConstants.POINT_CULTIVATES_INNOVATION / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("cultivates_innovation " + cultivates_innovation_point);
        result.put("cultivates_innovation", calcScoreWithUCP(missionCritical.get("cultivates_innovation"), cultivates_innovation_point,
                KF4DConstants.MAX_CULTIVATES_INNOVATION, KF4DConstants.MIN_CULTIVATES_INNOVATION));

        double nimble_learning_point =
                KF4DConstants.POINT_NIMBLE_LEARNING / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("nimble_learning " + nimble_learning_point);
        result.put("nimble_learning", calcScoreWithUCP(missionCritical.get("nimble_learning"), nimble_learning_point,
                KF4DConstants.MAX_NIMBLE_LEARNING, KF4DConstants.MIN_NIMBLE_LEARNING));

        double develops_talent_point =
                KF4DConstants.POINT_DEVELOPS_TALENT / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("develops_talent " + develops_talent_point);
        result.put("develops_talent", calcScoreWithUCP(missionCritical.get("develops_talent"), develops_talent_point,
                KF4DConstants.MAX_DEVELOPS_TALENT, KF4DConstants.MIN_DEVELOPS_TALENT));

        double situational_adaptability_point =
                KF4DConstants.POINT_SITUATIONAL_ADAPTABILITY / KF4DConstants.MISSION_CRITICAL_SUMUP * KF4DConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("situational_adaptability " + situational_adaptability_point);
        result.put("situational_adaptability", calcScoreWithUCP(missionCritical.get("situational_adaptability"), situational_adaptability_point,
                KF4DConstants.MAX_SITUATIONAL_ADAPTABILITY, KF4DConstants.MIN_SITUATIONAL_ADAPTABILITY));

        return result;
    }


    public static Map<String, Double> calcCriticalScore(Map<String, Integer> critical) {
        Map<String, Double> result = new HashMap<>();

        double builds_networks_point =
                KF4DConstants.POINT_BUILDS_NETWORKS / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(builds_networks_point);
        result.put("builds_networks", calcScoreWithZone(critical.get("builds_networks"), builds_networks_point, true));

        double decision_quality_point =
                KF4DConstants.POINT_DECISION_QUALITY / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(decision_quality_point);

        double being_resilient_point =
                KF4DConstants.POINT_BEING_RESILIENT / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(being_resilient_point);

        double courage_point =
                KF4DConstants.POINT_COURAGE / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(courage_point);

        double action_oriented_point =
                KF4DConstants.POINT_ACTION_ORIENTED / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(action_oriented_point);

        double manages_ambiguity_point =
                KF4DConstants.POINT_MANAGES_AMBIGUITY / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(manages_ambiguity_point);

        double interpersonal_savvy_point =
                KF4DConstants.POINT_INTERPERSONAL_SAVVY / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;

        System.err.println(interpersonal_savvy_point);

        double resourcefulness_point =
                KF4DConstants.POINT_RESOURCEFULNESS / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;

        System.err.println(resourcefulness_point);

        double self_development_point =
                KF4DConstants.POINT_SELF_DEVELOPMENT / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(self_development_point);

        double values_differences_point =
                KF4DConstants.POINT_VALUES_DIFFERENCES / KF4DConstants.CRITICAL_SUMUP * KF4DConstants.WEIGHT_CRITICAL * 100;
        System.err.println(values_differences_point);

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

        double drives_engagement_point =
                KF4DConstants.POINT_DRIVES_ENGAGEMENT / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(drives_engagement_point);
        double balances_stakeholders_point =
                KF4DConstants.POINT_BALANCES_STAKEHOLDERS / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(balances_stakeholders_point);
        double ensures_accountability_point =
                KF4DConstants.POINT_ENSURES_ACCOUNTABILITY / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(ensures_accountability_point);
        double drives_results_point =
                KF4DConstants.POINT_DRIVES_RESULTS / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(drives_results_point);

        double customer_focus_point =
                KF4DConstants.POINT_CUSTOMER_FOCUS / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(customer_focus_point);

        double manages_conflict_point =
                KF4DConstants.POINT_MANAGES_CONFLICT / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(manages_conflict_point);
        double builds_effective_teams_point =
                KF4DConstants.POINT_BUILDS_EFFECTIVE_TEAMS / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(builds_effective_teams_point);
        double plans_and_aligns_point =
                KF4DConstants.POINT_PLANS_AND_ALIGNS / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(plans_and_aligns_point);
        double directs_work_point =
                KF4DConstants.POINT_DIRECTS_WORK / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(directs_work_point);
        double optimizes_work_processes_point =
                KF4DConstants.POINT_OPTIMIZES_WORK_PROCESSES / KF4DConstants.LESS_CRITICAL_SUMUP * KF4DConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(optimizes_work_processes_point);
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


    private static double calcScoreWithUCP(int score, double points, double max, double min) {
        double result;
        double mean = (max + min) / 2;
        double pointsMinMax = (max - min) / (2 * 10) * points;
        double pointsMax10 = (10 - max) / 10 * points;
        double points0Min = min / 10 * points;

        if (score == mean) {
            result = points;
        }
        else if (score < mean && score >= min) {
            result = points - (mean - score) * pointsMinMax / (mean - min);
        }
        else if (score > mean && score <= max) {
            result = points - (score - mean) * pointsMinMax / (10 - max);
        }
        else if (score > max && score <= 10) {
            result = points - pointsMinMax - (score - max) * pointsMax10 / (10 - max);
        }
        else {
            result = points - pointsMinMax - pointsMax10 - (min - score) * points0Min / min;
        }
        return result;
    }

    private static double calcScoreWithZone(int score, double points, boolean isDerails) {
        double result;
        double pointsZeroZone = 0;
        double pointsLowZone = points / 3;
        double pointsMidZone;
        double pointsHighZone;
        if (isDerails) {
            pointsMidZone = points;
            pointsHighZone = points / 3 * 2;
        }
        else {
            pointsMidZone = points / 3 * 2;
            pointsHighZone = points;
        }

        if (score < 4) {
            result = pointsZeroZone;
        }
        else if (score >= 4 && score < 6) {
            result = pointsLowZone;
        }
        else if (score >= 6 && score < 8) {
            result = pointsMidZone;
        }
        else {
            result = pointsHighZone;
        }

        return result;
    }

    public static void main(String... args) {
        DCompetencies d = new DCompetencies();
        d.setStrategic_mindset(5);
        d.setGlobal_perspective(7);
        d.setInstills_trust(10);
        d.setPersuades(4);
        d.setCommunicates_effectively(7);
        d.setCollaborates(8);
        d.setCultivates_innovation(3);
        d.setNimble_learning(4);
        d.setDevelops_talent(7);
        d.setSituational_adaptability(5);
        Map<String, Integer> mC = d.getMissionCritical();
        System.err.println(mC);
        System.err.println(calcMissionCriticalScore(mC));
        System.err.println(mC);

        d.setBuilds_networks(8);
        d.setDecision_quality(5);
        d.setBeing_resilient(4);
        d.setCourage(7);
        d.setAction_oriented(5);
        d.setManages_ambiguity(6);
        d.setInterpersonal_savvy(2);
        d.setResourcefulness(3);
        d.setSelf_development(4);
        d.setValues_differences(4);
        Map<String, Integer> c = d.getCritical();
        System.err.println(c);
        System.err.println(calcCriticalScore(c));


        d.setDrives_engagement(6);
        ;
        d.setBalances_stakeholders(5);
        d.setEnsures_accountability(5);
        d.setDrives_results(4);
        d.setCustomer_focus(5);
        d.setManages_conflict(2);
        d.setBuilds_effective_teams(3);
        d.setPlans_and_aligns(4);
        d.setDirects_work(5);
        d.setOptimizes_work_processes(4);

        Map<String, Integer> lC = d.getLessCritical();
        System.err.println(calcLessCriticalScore(lC));


    }
}
