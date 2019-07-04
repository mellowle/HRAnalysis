package util;

import KF4DConstants.CompetenciesConstants;
import KF4DConstants.DriversConstants;
import KF4DConstants.TraitsConstants;
import dimensionRawData.DDrivers;
import entity.Drivers;

import java.util.HashMap;
import java.util.Map;

public class KF4DScoreFunctionUtils {

    public static Map<String, Double> calcMissionCriticalScore(Map<String, Integer> missionCritical) {
        Map<String, Double> result = new HashMap<>();
        double strategic_mindset_point =
                CompetenciesConstants.POINT_STRATEGIC_MINDSET / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("strategic_mindset " + strategic_mindset_point);
        result.put("strategic_mindset", calcScoreWithUCPZone(missionCritical.get("strategic_mindset"), strategic_mindset_point,
                CompetenciesConstants.MAX_STRATEGIC_MINDSET, CompetenciesConstants.MIN_STRATEGIC_MINDSET));

        double global_perspective_point =
                CompetenciesConstants.POINT_GLOBAL_PERSPECTIVE / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("global_perspective " + global_perspective_point);
        result.put("global_perspective", calcScoreWithUCPZone(missionCritical.get("global_perspective"), global_perspective_point,
                CompetenciesConstants.MAX_GLOBAL_PERSPECTIVE, CompetenciesConstants.MIN_GLOBAL_PERSPECTIVE));

        double instills_trust_point =
                CompetenciesConstants.POINT_INSTILLS_TRUST / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("instills_trust " + instills_trust_point);
        result.put("instills_trust", calcScoreWithUCPZone(missionCritical.get("instills_trust"), instills_trust_point,
                CompetenciesConstants.MAX_INSTILLS_TRUST, CompetenciesConstants.MIN_INSTILLS_TRUST));

        double persuades_point =
                CompetenciesConstants.POINT_PERSUADES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("persuades " + persuades_point);
        result.put("persuades", calcScoreWithUCPZone(missionCritical.get("persuades"), persuades_point,
                CompetenciesConstants.MAX_PERSUADES, CompetenciesConstants.MIN_PERSUADES));

        double communicates_effectively_point =
                CompetenciesConstants.POINT_COMMUNICATES_EFFECTIVELY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("communicates_effectively " + communicates_effectively_point);
        result.put("communicates_effectively", calcScoreWithUCPZone(missionCritical.get("communicates_effectively"), communicates_effectively_point,
                CompetenciesConstants.MAX_COMMUNICATES_EFFECTIVELY, CompetenciesConstants.MIN_COMMUNICATES_EFFECTIVELY));

        double collaborates_point =
                CompetenciesConstants.POINT_COLLABORATES / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("collaborates " + collaborates_point);
        result.put("collaborates", calcScoreWithUCPZone(missionCritical.get("collaborates"), collaborates_point,
                CompetenciesConstants.MAX_COLLABORATES, CompetenciesConstants.MIN_COLLABORATES));

        double cultivates_innovation_point =
                CompetenciesConstants.POINT_CULTIVATES_INNOVATION / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("cultivates_innovation " + cultivates_innovation_point);
        result.put("cultivates_innovation", calcScoreWithUCPZone(missionCritical.get("cultivates_innovation"), cultivates_innovation_point,
                CompetenciesConstants.MAX_CULTIVATES_INNOVATION, CompetenciesConstants.MIN_CULTIVATES_INNOVATION));

        double nimble_learning_point =
                CompetenciesConstants.POINT_NIMBLE_LEARNING / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("nimble_learning " + nimble_learning_point);
        result.put("nimble_learning", calcScoreWithUCPZone(missionCritical.get("nimble_learning"), nimble_learning_point,
                CompetenciesConstants.MAX_NIMBLE_LEARNING, CompetenciesConstants.MIN_NIMBLE_LEARNING));

        double develops_talent_point =
                CompetenciesConstants.POINT_DEVELOPS_TALENT / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("develops_talent " + develops_talent_point);
        result.put("develops_talent", calcScoreWithUCPZone(missionCritical.get("develops_talent"), develops_talent_point,
                CompetenciesConstants.MAX_DEVELOPS_TALENT, CompetenciesConstants.MIN_DEVELOPS_TALENT));

        double situational_adaptability_point =
                CompetenciesConstants.POINT_SITUATIONAL_ADAPTABILITY / CompetenciesConstants.MISSION_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_MISSION_CRITICAL * 100;
        System.err.println("situational_adaptability " + situational_adaptability_point);
        result.put("situational_adaptability", calcScoreWithUCPZone(missionCritical.get("situational_adaptability"), situational_adaptability_point,
                CompetenciesConstants.MAX_SITUATIONAL_ADAPTABILITY, CompetenciesConstants.MIN_SITUATIONAL_ADAPTABILITY));

        return result;
    }


    public static Map<String, Double> calcCriticalScore(Map<String, Integer> critical) {
        Map<String, Double> result = new HashMap<>();

        double builds_networks_point =
                CompetenciesConstants.POINT_BUILDS_NETWORKS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(builds_networks_point);
        result.put("builds_networks", calcScoreWithZone(critical.get("builds_networks"), builds_networks_point, true));

        double decision_quality_point =
                CompetenciesConstants.POINT_DECISION_QUALITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(decision_quality_point);

        double being_resilient_point =
                CompetenciesConstants.POINT_BEING_RESILIENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(being_resilient_point);

        double courage_point =
                CompetenciesConstants.POINT_COURAGE / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(courage_point);

        double action_oriented_point =
                CompetenciesConstants.POINT_ACTION_ORIENTED / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(action_oriented_point);

        double manages_ambiguity_point =
                CompetenciesConstants.POINT_MANAGES_AMBIGUITY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(manages_ambiguity_point);

        double interpersonal_savvy_point =
                CompetenciesConstants.POINT_INTERPERSONAL_SAVVY / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;

        System.err.println(interpersonal_savvy_point);

        double resourcefulness_point =
                CompetenciesConstants.POINT_RESOURCEFULNESS / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;

        System.err.println(resourcefulness_point);

        double self_development_point =
                CompetenciesConstants.POINT_SELF_DEVELOPMENT / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
        System.err.println(self_development_point);

        double values_differences_point =
                CompetenciesConstants.POINT_VALUES_DIFFERENCES / CompetenciesConstants.CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_CRITICAL * 100;
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
                CompetenciesConstants.POINT_DRIVES_ENGAGEMENT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(drives_engagement_point);
        double balances_stakeholders_point =
                CompetenciesConstants.POINT_BALANCES_STAKEHOLDERS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(balances_stakeholders_point);
        double ensures_accountability_point =
                CompetenciesConstants.POINT_ENSURES_ACCOUNTABILITY / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(ensures_accountability_point);
        double drives_results_point =
                CompetenciesConstants.POINT_DRIVES_RESULTS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(drives_results_point);

        double customer_focus_point =
                CompetenciesConstants.POINT_CUSTOMER_FOCUS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(customer_focus_point);

        double manages_conflict_point =
                CompetenciesConstants.POINT_MANAGES_CONFLICT / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(manages_conflict_point);
        double builds_effective_teams_point =
                CompetenciesConstants.POINT_BUILDS_EFFECTIVE_TEAMS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(builds_effective_teams_point);
        double plans_and_aligns_point =
                CompetenciesConstants.POINT_PLANS_AND_ALIGNS / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(plans_and_aligns_point);
        double directs_work_point =
                CompetenciesConstants.POINT_DIRECTS_WORK / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
        System.err.println(directs_work_point);
        double optimizes_work_processes_point =
                CompetenciesConstants.POINT_OPTIMIZES_WORK_PROCESSES / CompetenciesConstants.LESS_CRITICAL_SUMUP * CompetenciesConstants.WEIGHT_LESS_CRITICAL * 100;
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

    public static Map<String, Double> calcDriversScore(Map<String, Integer> drivers){
        Map<String, Double> result = new HashMap<>();

        result.put("balance", calcScoreWithUCPPoint(drivers.get("balance"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_BALANCE));
        result.put("challenge", calcScoreWithUCPPoint(drivers.get("challenge"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_CHALLENGE));
        result.put("collaboration", calcScoreWithUCPPoint(drivers.get("collaboration"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_COLLABORATION));
        result.put("independence", calcScoreWithUCPPoint(drivers.get("independence"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_INDEPENDENCE));
        result.put("power", calcScoreWithUCPPoint(drivers.get("power"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_POWER));
        result.put("structure", calcScoreWithUCPPoint(drivers.get("structure"), DriversConstants.POINT_DRIVER, DriversConstants.UCP_STRUCTURE));

        return result;
    }

    private static double calcScoreWithUCPPoint(int score, double points, double ucp) {
        double result;
        double pointsUCP10 = (10 - ucp) / 10 * points;
        double points0UCP = ucp / 10 * points;
        if (score == ucp) {
            result = points;
        }
        else if (score > ucp && score <= 10) {
            result = points - (score - ucp) * pointsUCP10 / (10 - ucp);
        }
        else {
            result = points - pointsUCP10 - (ucp - score) * points0UCP / ucp;
        }

        return result;
    }

    private static double calcScoreWithUCPZone(int score, double points, double max, double min) {
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

        DDrivers d = new DDrivers();
        d.setBalance(4);
        d.setChallenge(6);
        d.setCollaboration(5);
        d.setIndependence(7);
        d.setPower(8);
        d.setStructure(5);

        System.err.println(DriversConstants.POINT_DRIVER);
        System.err.println(TraitsConstants.POINT_TRAIT);
        Map<String, Integer> ds = d.getDrivers();
        System.err.println(ds);
        System.err.println(calcDriversScore(ds));
        //        DCompetencies d = new DCompetencies();
        //        d.setStrategic_mindset(5);
        //        d.setGlobal_perspective(7);
        //        d.setInstills_trust(10);
        //        d.setPersuades(4);
        //        d.setCommunicates_effectively(7);
        //        d.setCollaborates(8);
        //        d.setCultivates_innovation(3);
        //        d.setNimble_learning(4);
        //        d.setDevelops_talent(7);
        //        d.setSituational_adaptability(5);
        //        Map<String, Integer> mC = d.getMissionCritical();
        //        System.err.println(mC);
        //        System.err.println(calcMissionCriticalScore(mC));
        //        System.err.println(mC);
        //
        //        d.setBuilds_networks(8);
        //        d.setDecision_quality(5);
        //        d.setBeing_resilient(4);
        //        d.setCourage(7);
        //        d.setAction_oriented(5);
        //        d.setManages_ambiguity(6);
        //        d.setInterpersonal_savvy(2);
        //        d.setResourcefulness(3);
        //        d.setSelf_development(4);
        //        d.setValues_differences(4);
        //        Map<String, Integer> c = d.getCritical();
        //        System.err.println(c);
        //        System.err.println(calcCriticalScore(c));
        //
        //
        //        d.setDrives_engagement(6);
        //        d.setBalances_stakeholders(5);
        //        d.setEnsures_accountability(5);
        //        d.setDrives_results(4);
        //        d.setCustomer_focus(5);
        //        d.setManages_conflict(2);
        //        d.setBuilds_effective_teams(3);
        //        d.setPlans_and_aligns(4);
        //        d.setDirects_work(5);
        //        d.setOptimizes_work_processes(4);
        //
        //        Map<String, Integer> lC = d.getLessCritical();
        //        System.err.println(calcLessCriticalScore(lC));

//        DTraits t = new DTraits();
//
//        t.setAdaptability(5);
//        t.setAffiliation(5);
//        t.setAssertiveness(8);
//        t.setComposure(6);
//
//        t.setConfidence(3);
//        t.setCredibility(7);
//        t.setCuriosity(5);
//        t.setEmpathy(8);
//
//        t.setFocus(9);
//        t.setHumility(6);
//        t.setInfluence(8);
//        t.setNeed_for_achievement(7);
//
//        t.setOpenness_to_differences(2);
//        t.setOptimism(5);
//        t.setPersistence(8);
//        t.setRisk_taking(3);
//
//        t.setSituational_self_awareness(2);
//        t.setSociability(6);
//        t.setTolerance_of_ambiguity(6);
//        t.setTrust(5);
//
//        Map<String, Integer> ts = t.getTraits();
//        System.err.println(calcTraitsScore(ts));

        //        result.put("adaptability", this.adaptability);
        //        result.put("affiliation", this.affiliation);
        //        result.put("assertiveness", this.assertiveness);
        //        result.put("composure", this.composure);
        //        result.put("confidence", this.confidence);
        //        result.put("credibility", this.credibility);
        //        result.put("curiosity", this.curiosity);
        //        result.put("empathy", this.empathy);
        //        result.put("focus", this.focus);
        //        result.put("humility", this.humility);
        //        result.put("influence", this.influence);
        //        result.put("need_for_achievement", this.need_for_achievement);
        //        result.put("openness_to_differences", this.openness_to_differences);
        //        result.put("optimism", this.optimism);
        //        result.put("persistence", this.persistence);
        //        result.put("risk_taking", this.risk_taking);
        //        result.put("situational_self_awareness", this.situational_self_awareness);
        //        result.put("sociability", this.sociability);
        //        result.put("tolerance_of_ambiguity", this.tolerance_of_ambiguity);
        //        result.put("trust", this.trust);


    }
}
