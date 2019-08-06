package entity.dimensionScored;

import java.util.Map;

public class DCompetenciesScored {
    private String wwid;
    private Double strategic_mindset;
    private Double global_perspective;
    private Double instills_trust;
    private Double persuades;
    private Double communicates_effectively;
    private Double collaborates;
    private Double cultivates_innovation;
    private Double nimble_learning;
    private Double develops_talent;
    private Double situational_adaptability;

    private Double builds_networks;
    private Double decision_quality;
    private Double being_resilient;
    private Double courage;
    private Double action_oriented;
    private Double manages_ambiguity;
    private Double interpersonal_savvy;
    private Double resourcefulness;
    private Double self_development;
    private Double values_differences;

    private Double drives_engagement;
    private Double balances_stakeholders;
    private Double ensures_accountability;
    private Double drives_results;
    private Double customer_focus;
    private Double manages_conflict;
    private Double builds_effective_teams;
    private Double plans_and_aligns;
    private Double directs_work;
    private Double optimizes_work_processes;

    private Double result;

    public DCompetenciesScored(String wwid, Map<String, Double> missionCritical, Map<String, Double> critical,
                               Map<String, Double> lessCritical) {
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

        this.builds_networks = critical.get("builds_networks");
        this.decision_quality = critical.get("decision_quality");
        this.being_resilient = critical.get("being_resilient");
        this.courage = critical.get("courage");
        this.action_oriented = critical.get("action_oriented");
        this.manages_ambiguity = critical.get("manages_ambiguity");
        this.interpersonal_savvy = critical.get("interpersonal_savvy");
        this.resourcefulness = critical.get("resourcefulness");
        this.self_development = critical.get("self_development");
        this.values_differences = critical.get("values_differences");

        this.drives_engagement = lessCritical.get("drives_engagement");
        this.balances_stakeholders = lessCritical.get("balances_stakeholders");
        this.ensures_accountability = lessCritical.get("ensures_accountability");
        this.drives_results = lessCritical.get("drives_results");
        this.customer_focus = lessCritical.get("customer_focus");
        this.manages_conflict = lessCritical.get("manages_conflict");
        this.builds_effective_teams = lessCritical.get("builds_effective_teams");
        this.plans_and_aligns = lessCritical.get("plans_and_aligns");
        this.directs_work = lessCritical.get("directs_work");
        this.optimizes_work_processes = lessCritical.get("optimizes_work_processes");

    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getAction_oriented() {
        return action_oriented;
    }

    public void setAction_oriented(Double action_oriented) {
        this.action_oriented = action_oriented;
    }

    public Double getBalances_stakeholders() {
        return balances_stakeholders;
    }

    public void setBalances_stakeholders(Double balances_stakeholders) {
        this.balances_stakeholders = balances_stakeholders;
    }

    public Double getBeing_resilient() {
        return being_resilient;
    }

    public void setBeing_resilient(Double being_resilient) {
        this.being_resilient = being_resilient;
    }

    public Double getBuilds_effective_teams() {
        return builds_effective_teams;
    }

    public void setBuilds_effective_teams(Double builds_effective_teams) {
        this.builds_effective_teams = builds_effective_teams;
    }

    public Double getBuilds_networks() {
        return builds_networks;
    }

    public void setBuilds_networks(Double builds_networks) {
        this.builds_networks = builds_networks;
    }

    public Double getCollaborates() {
        return collaborates;
    }

    public void setCollaborates(Double collaborates) {
        this.collaborates = collaborates;
    }

    public Double getCommunicates_effectively() {
        return communicates_effectively;
    }

    public void setCommunicates_effectively(Double communicates_effectively) {
        this.communicates_effectively = communicates_effectively;
    }

    public Double getCourage() {
        return courage;
    }

    public void setCourage(Double courage) {
        this.courage = courage;
    }

    public Double getCultivates_innovation() {
        return cultivates_innovation;
    }

    public void setCultivates_innovation(Double cultivates_innovation) {
        this.cultivates_innovation = cultivates_innovation;
    }

    public Double getCustomer_focus() {
        return customer_focus;
    }

    public void setCustomer_focus(Double customer_focus) {
        this.customer_focus = customer_focus;
    }

    public Double getDecision_quality() {
        return decision_quality;
    }

    public void setDecision_quality(Double decision_quality) {
        this.decision_quality = decision_quality;
    }

    public Double getDevelops_talent() {
        return develops_talent;
    }

    public void setDevelops_talent(Double develops_talent) {
        this.develops_talent = develops_talent;
    }

    public Double getDirects_work() {
        return directs_work;
    }

    public void setDirects_work(Double directs_work) {
        this.directs_work = directs_work;
    }

    public Double getDrives_engagement() {
        return drives_engagement;
    }

    public void setDrives_engagement(Double drives_engagement) {
        this.drives_engagement = drives_engagement;
    }

    public Double getDrives_results() {
        return drives_results;
    }

    public void setDrives_results(Double drives_results) {
        this.drives_results = drives_results;
    }

    public Double getEnsures_accountability() {
        return ensures_accountability;
    }

    public void setEnsures_accountability(Double ensures_accountability) {
        this.ensures_accountability = ensures_accountability;
    }

    public Double getGlobal_perspective() {
        return global_perspective;
    }

    public void setGlobal_perspective(Double global_perspective) {
        this.global_perspective = global_perspective;
    }

    public Double getInstills_trust() {
        return instills_trust;
    }

    public void setInstills_trust(Double instills_trust) {
        this.instills_trust = instills_trust;
    }

    public Double getInterpersonal_savvy() {
        return interpersonal_savvy;
    }

    public void setInterpersonal_savvy(Double interpersonal_savvy) {
        this.interpersonal_savvy = interpersonal_savvy;
    }

    public Double getManages_ambiguity() {
        return manages_ambiguity;
    }

    public void setManages_ambiguity(Double manages_ambiguity) {
        this.manages_ambiguity = manages_ambiguity;
    }

    public Double getManages_conflict() {
        return manages_conflict;
    }

    public void setManages_conflict(Double manages_conflict) {
        this.manages_conflict = manages_conflict;
    }

    public Double getNimble_learning() {
        return nimble_learning;
    }

    public void setNimble_learning(Double nimble_learning) {
        this.nimble_learning = nimble_learning;
    }

    public Double getOptimizes_work_processes() {
        return optimizes_work_processes;
    }

    public void setOptimizes_work_processes(Double optimizes_work_processes) {
        this.optimizes_work_processes = optimizes_work_processes;
    }

    public Double getPersuades() {
        return persuades;
    }

    public void setPersuades(Double persuades) {
        this.persuades = persuades;
    }

    public Double getPlans_and_aligns() {
        return plans_and_aligns;
    }

    public void setPlans_and_aligns(Double plans_and_aligns) {
        this.plans_and_aligns = plans_and_aligns;
    }

    public Double getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(Double resourcefulness) {
        this.resourcefulness = resourcefulness;
    }

    public Double getSelf_development() {
        return self_development;
    }

    public void setSelf_development(Double self_development) {
        this.self_development = self_development;
    }

    public Double getSituational_adaptability() {
        return situational_adaptability;
    }

    public void setSituational_adaptability(Double situational_adaptability) {
        this.situational_adaptability = situational_adaptability;
    }

    public Double getStrategic_mindset() {
        return strategic_mindset;
    }

    public void setStrategic_mindset(Double strategic_mindset) {
        this.strategic_mindset = strategic_mindset;
    }

    public Double getValues_differences() {
        return values_differences;
    }

    public void setValues_differences(Double values_differences) {
        this.values_differences = values_differences;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
