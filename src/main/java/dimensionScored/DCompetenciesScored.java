package dimensionScored;

import java.util.Map;

public class DCompetenciesScored {
    private String wwid;
    private double action_oriented;
    private double balances_stakeholders;
    private double being_resilient;
    private double builds_effective_teams;
    private double builds_networks;
    private double collaborates;
    private double communicates_effectively;
    private double courage;
    private double cultivates_innovation;
    private double customer_focus;
    private double decision_quality;
    private double develops_talent;
    private double directs_work;
    private double drives_engagement;
    private double drives_results;
    private double ensures_accountability;
    private double global_perspective;
    private double instills_trust;
    private double interpersonal_savvy;
    private double manages_ambiguity;
    private double manages_conflict;
    private double nimble_learning;
    private double optimizes_work_processes;
    private double persuades;
    private double plans_and_aligns;
    private double resourcefulness;
    private double self_development;
    private double situational_adaptability;
    private double strategic_mindset;
    private double values_differences;
    private double result;

    public DCompetenciesScored(String wwid, Map<String,Double> missionCritical, Map<String, Double> critical, Map<String,Double> lessCritical) {
        this.wwid = wwid;
        this.strategic_mindset = missionCritical.get("strategic_mindset");
        this.global_perspective = missionCritical.get("global_perspective");
        this.instills_trust = missionCritical.get("instills_trust");
        this.persuades = missionCritical.get("persuades");
        this.communicates_effectively = missionCritical.get("communicates_effectively");
        this.collaborates = missionCritical.get("collaborates");
        this.cultivates_innovation = missionCritical.get("cultivates_innovation");
        this.nimble_learning = missionCritical.get("nimble_learning");
        this.develops_talent = missionCritical.get("develops_talent");
        this.situational_adaptability = missionCritical.get("situational_adaptability");
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public double getAction_oriented() {
        return action_oriented;
    }

    public void setAction_oriented(double action_oriented) {
        this.action_oriented = action_oriented;
    }

    public double getBalances_stakeholders() {
        return balances_stakeholders;
    }

    public void setBalances_stakeholders(double balances_stakeholders) {
        this.balances_stakeholders = balances_stakeholders;
    }

    public double getBeing_resilient() {
        return being_resilient;
    }

    public void setBeing_resilient(double being_resilient) {
        this.being_resilient = being_resilient;
    }

    public double getBuilds_effective_teams() {
        return builds_effective_teams;
    }

    public void setBuilds_effective_teams(double builds_effective_teams) {
        this.builds_effective_teams = builds_effective_teams;
    }

    public double getBuilds_networks() {
        return builds_networks;
    }

    public void setBuilds_networks(double builds_networks) {
        this.builds_networks = builds_networks;
    }

    public double getCollaborates() {
        return collaborates;
    }

    public void setCollaborates(double collaborates) {
        this.collaborates = collaborates;
    }

    public double getCommunicates_effectively() {
        return communicates_effectively;
    }

    public void setCommunicates_effectively(double communicates_effectively) {
        this.communicates_effectively = communicates_effectively;
    }

    public double getCourage() {
        return courage;
    }

    public void setCourage(double courage) {
        this.courage = courage;
    }

    public double getCultivates_innovation() {
        return cultivates_innovation;
    }

    public void setCultivates_innovation(double cultivates_innovation) {
        this.cultivates_innovation = cultivates_innovation;
    }

    public double getCustomer_focus() {
        return customer_focus;
    }

    public void setCustomer_focus(double customer_focus) {
        this.customer_focus = customer_focus;
    }

    public double getDecision_quality() {
        return decision_quality;
    }

    public void setDecision_quality(double decision_quality) {
        this.decision_quality = decision_quality;
    }

    public double getDevelops_talent() {
        return develops_talent;
    }

    public void setDevelops_talent(double develops_talent) {
        this.develops_talent = develops_talent;
    }

    public double getDirects_work() {
        return directs_work;
    }

    public void setDirects_work(double directs_work) {
        this.directs_work = directs_work;
    }

    public double getDrives_engagement() {
        return drives_engagement;
    }

    public void setDrives_engagement(double drives_engagement) {
        this.drives_engagement = drives_engagement;
    }

    public double getDrives_results() {
        return drives_results;
    }

    public void setDrives_results(double drives_results) {
        this.drives_results = drives_results;
    }

    public double getEnsures_accountability() {
        return ensures_accountability;
    }

    public void setEnsures_accountability(double ensures_accountability) {
        this.ensures_accountability = ensures_accountability;
    }

    public double getGlobal_perspective() {
        return global_perspective;
    }

    public void setGlobal_perspective(double global_perspective) {
        this.global_perspective = global_perspective;
    }

    public double getInstills_trust() {
        return instills_trust;
    }

    public void setInstills_trust(double instills_trust) {
        this.instills_trust = instills_trust;
    }

    public double getInterpersonal_savvy() {
        return interpersonal_savvy;
    }

    public void setInterpersonal_savvy(double interpersonal_savvy) {
        this.interpersonal_savvy = interpersonal_savvy;
    }

    public double getManages_ambiguity() {
        return manages_ambiguity;
    }

    public void setManages_ambiguity(double manages_ambiguity) {
        this.manages_ambiguity = manages_ambiguity;
    }

    public double getManages_conflict() {
        return manages_conflict;
    }

    public void setManages_conflict(double manages_conflict) {
        this.manages_conflict = manages_conflict;
    }

    public double getNimble_learning() {
        return nimble_learning;
    }

    public void setNimble_learning(double nimble_learning) {
        this.nimble_learning = nimble_learning;
    }

    public double getOptimizes_work_processes() {
        return optimizes_work_processes;
    }

    public void setOptimizes_work_processes(double optimizes_work_processes) {
        this.optimizes_work_processes = optimizes_work_processes;
    }

    public double getPersuades() {
        return persuades;
    }

    public void setPersuades(double persuades) {
        this.persuades = persuades;
    }

    public double getPlans_and_aligns() {
        return plans_and_aligns;
    }

    public void setPlans_and_aligns(double plans_and_aligns) {
        this.plans_and_aligns = plans_and_aligns;
    }

    public double getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(double resourcefulness) {
        this.resourcefulness = resourcefulness;
    }

    public double getSelf_development() {
        return self_development;
    }

    public void setSelf_development(double self_development) {
        this.self_development = self_development;
    }

    public double getSituational_adaptability() {
        return situational_adaptability;
    }

    public void setSituational_adaptability(double situational_adaptability) {
        this.situational_adaptability = situational_adaptability;
    }

    public double getStrategic_mindset() {
        return strategic_mindset;
    }

    public void setStrategic_mindset(double strategic_mindset) {
        this.strategic_mindset = strategic_mindset;
    }

    public double getValues_differences() {
        return values_differences;
    }

    public void setValues_differences(double values_differences) {
        this.values_differences = values_differences;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
