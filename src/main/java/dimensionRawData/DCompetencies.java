package dimensionRawData;

import java.util.HashMap;
import java.util.Map;

public class DCompetencies {
    private String wwid;
    private Integer action_oriented;
    private Integer balances_stakeholders;
    private Integer being_resilient;
    private Integer builds_effective_teams;
    private Integer builds_networks;
    private Integer collaborates;
    private Integer communicates_effectively;
    private Integer courage;
    private Integer cultivates_innovation;
    private Integer customer_focus;
    private Integer decision_quality;
    private Integer develops_talent;
    private Integer directs_work;
    private Integer drives_engagement;
    private Integer drives_results;
    private Integer ensures_accountability;
    private Integer global_perspective;
    private Integer instills_trust;
    private Integer interpersonal_savvy;
    private Integer manages_ambiguity;
    private Integer manages_conflict;
    private Integer nimble_learning;
    private Integer optimizes_work_processes;
    private Integer persuades;
    private Integer plans_and_aligns;
    private Integer resourcefulness;
    private Integer self_development;
    private Integer situational_adaptability;
    private Integer strategic_mindset;
    private Integer values_differences;

    public DCompetencies(String wwid, String action_oriented, String balances_stakeholders,
                         String being_resilient, String builds_effective_teams, String builds_networks,
                         String collaborates, String communicates_effectively, String courage,
                         String cultivates_innovation, String customer_focus, String decision_quality,
                         String develops_talent, String directs_work, String drives_engagement,
                         String drives_results, String ensures_accountability, String global_perspective,
                         String instills_trust, String interpersonal_savvy, String manages_ambiguity,
                         String manages_conflict, String nimble_learning, String optimizes_work_processes,
                         String persuades, String plans_and_aligns, String resourcefulness,
                         String self_development, String situational_adaptability, String strategic_mindset,
                         String values_differences) {
        this.wwid = wwid;
        this.action_oriented = action_oriented == null ? null : Double.valueOf(action_oriented).intValue();
        this.balances_stakeholders = balances_stakeholders == null ? null : Double.valueOf(balances_stakeholders).intValue();
        this.being_resilient = being_resilient == null ? null : Double.valueOf(being_resilient).intValue();
        this.builds_effective_teams = builds_effective_teams == null ? null : Double.valueOf(builds_effective_teams).intValue();
        this.builds_networks = builds_networks == null ? null : Double.valueOf(builds_networks).intValue();
        this.collaborates = collaborates == null ? null : Double.valueOf(collaborates).intValue();
        this.communicates_effectively = communicates_effectively == null ? null : Double.valueOf(communicates_effectively).intValue();
        this.courage = courage == null ? null : Double.valueOf(courage).intValue();
        this.cultivates_innovation = cultivates_innovation == null ? null : Double.valueOf(cultivates_innovation).intValue();
        this.customer_focus = customer_focus == null ? null : Double.valueOf(customer_focus).intValue();
        this.decision_quality = decision_quality == null ? null : Double.valueOf(decision_quality).intValue();
        this.develops_talent = develops_talent == null ? null : Double.valueOf(develops_talent).intValue();
        this.directs_work = directs_work == null ? null : Double.valueOf(directs_work).intValue();
        this.drives_engagement = drives_engagement == null ? null : Double.valueOf(drives_engagement).intValue();
        this.drives_results = drives_results == null ? null : Double.valueOf(drives_results).intValue();
        this.ensures_accountability = ensures_accountability == null ? null : Double.valueOf(ensures_accountability).intValue();
        this.global_perspective = global_perspective == null ? null : Double.valueOf(global_perspective).intValue();
        this.instills_trust = instills_trust == null ? null : Double.valueOf(instills_trust).intValue();
        this.interpersonal_savvy = interpersonal_savvy == null ? null : Double.valueOf(interpersonal_savvy).intValue();
        this.manages_ambiguity = manages_ambiguity == null ? null : Double.valueOf(manages_ambiguity).intValue();
        this.manages_conflict = manages_conflict == null ? null : Double.valueOf(manages_conflict).intValue();
        this.nimble_learning = nimble_learning == null ? null : Double.valueOf(nimble_learning).intValue();
        this.optimizes_work_processes = optimizes_work_processes == null ? null : Double.valueOf(optimizes_work_processes).intValue();
        this.persuades = persuades == null ? null : Double.valueOf(persuades).intValue();
        this.plans_and_aligns = plans_and_aligns == null ? null : Double.valueOf(plans_and_aligns).intValue();
        this.resourcefulness = resourcefulness == null ? null : Double.valueOf(resourcefulness).intValue();
        this.self_development = self_development == null ? null : Double.valueOf(self_development).intValue();
        this.situational_adaptability = situational_adaptability == null ? null : Double.valueOf(situational_adaptability).intValue();
        this.strategic_mindset = strategic_mindset == null ? null : Double.valueOf(strategic_mindset).intValue();
        this.values_differences = values_differences == null ? null : Double.valueOf(values_differences).intValue();

    }

    public Map<String, Integer> getMissionCritical() {
        Map<String, Integer> result = new HashMap<>();
        result.put("strategic_mindset", this.strategic_mindset);
        result.put("global_perspective", this.global_perspective);
        result.put("instills_trust", this.instills_trust);
        result.put("persuades", this.persuades);
        result.put("communicates_effectively", this.communicates_effectively);
        result.put("collaborates", this.collaborates);
        result.put("cultivates_innovation", this.cultivates_innovation);
        result.put("nimble_learning", this.nimble_learning);
        result.put("develops_talent", this.develops_talent);
        result.put("situational_adaptability", this.situational_adaptability);
        return result;
    }

    public Map<String, Integer> getCritical() {
        Map<String, Integer> result = new HashMap<>();
        result.put("builds_networks", this.builds_networks);
        result.put("decision_quality", this.decision_quality);
        result.put("being_resilient", this.being_resilient);
        result.put("courage", this.courage);
        result.put("action_oriented", this.action_oriented);
        result.put("manages_ambiguity", this.manages_ambiguity);
        result.put("interpersonal_savvy", this.interpersonal_savvy);
        result.put("resourcefulness", this.resourcefulness);
        result.put("self_development", this.self_development);
        result.put("values_differences", this.values_differences);
        return result;
    }

    public Map<String, Integer> getLessCritical() {
        Map<String, Integer> result = new HashMap<>();
        result.put("drives_engagement", this.drives_engagement);
        result.put("balances_stakeholders", this.balances_stakeholders);
        result.put("ensures_accountability", this.ensures_accountability);
        result.put("drives_results", this.drives_results);
        result.put("customer_focus", this.customer_focus);
        result.put("manages_conflict", this.manages_conflict);
        result.put("builds_effective_teams", this.builds_effective_teams);
        result.put("plans_and_aligns", this.plans_and_aligns);
        result.put("directs_work", this.directs_work);
        result.put("optimizes_work_processes", this.optimizes_work_processes);
        return result;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getAction_oriented() {
        return action_oriented;
    }

    public void setAction_oriented(Integer action_oriented) {
        this.action_oriented = action_oriented;
    }

    public Integer getBalances_stakeholders() {
        return balances_stakeholders;
    }

    public void setBalances_stakeholders(Integer balances_stakeholders) {
        this.balances_stakeholders = balances_stakeholders;
    }

    public Integer getBeing_resilient() {
        return being_resilient;
    }

    public void setBeing_resilient(Integer being_resilient) {
        this.being_resilient = being_resilient;
    }

    public Integer getBuilds_effective_teams() {
        return builds_effective_teams;
    }

    public void setBuilds_effective_teams(Integer builds_effective_teams) {
        this.builds_effective_teams = builds_effective_teams;
    }

    public Integer getBuilds_networks() {
        return builds_networks;
    }

    public void setBuilds_networks(Integer builds_networks) {
        this.builds_networks = builds_networks;
    }

    public Integer getCollaborates() {
        return collaborates;
    }

    public void setCollaborates(Integer collaborates) {
        this.collaborates = collaborates;
    }

    public Integer getCommunicates_effectively() {
        return communicates_effectively;
    }

    public void setCommunicates_effectively(Integer communicates_effectively) {
        this.communicates_effectively = communicates_effectively;
    }

    public Integer getCourage() {
        return courage;
    }

    public void setCourage(Integer courage) {
        this.courage = courage;
    }

    public Integer getCultivates_innovation() {
        return cultivates_innovation;
    }

    public void setCultivates_innovation(Integer cultivates_innovation) {
        this.cultivates_innovation = cultivates_innovation;
    }

    public Integer getCustomer_focus() {
        return customer_focus;
    }

    public void setCustomer_focus(Integer customer_focus) {
        this.customer_focus = customer_focus;
    }

    public Integer getDecision_quality() {
        return decision_quality;
    }

    public void setDecision_quality(Integer decision_quality) {
        this.decision_quality = decision_quality;
    }

    public Integer getDevelops_talent() {
        return develops_talent;
    }

    public void setDevelops_talent(Integer develops_talent) {
        this.develops_talent = develops_talent;
    }

    public Integer getDirects_work() {
        return directs_work;
    }

    public void setDirects_work(Integer directs_work) {
        this.directs_work = directs_work;
    }

    public Integer getDrives_engagement() {
        return drives_engagement;
    }

    public void setDrives_engagement(Integer drives_engagement) {
        this.drives_engagement = drives_engagement;
    }

    public Integer getDrives_results() {
        return drives_results;
    }

    public void setDrives_results(Integer drives_results) {
        this.drives_results = drives_results;
    }

    public Integer getEnsures_accountability() {
        return ensures_accountability;
    }

    public void setEnsures_accountability(Integer ensures_accountability) {
        this.ensures_accountability = ensures_accountability;
    }

    public Integer getGlobal_perspective() {
        return global_perspective;
    }

    public void setGlobal_perspective(Integer global_perspective) {
        this.global_perspective = global_perspective;
    }

    public Integer getInstills_trust() {
        return instills_trust;
    }

    public void setInstills_trust(Integer instills_trust) {
        this.instills_trust = instills_trust;
    }

    public Integer getInterpersonal_savvy() {
        return interpersonal_savvy;
    }

    public void setInterpersonal_savvy(Integer interpersonal_savvy) {
        this.interpersonal_savvy = interpersonal_savvy;
    }

    public Integer getManages_ambiguity() {
        return manages_ambiguity;
    }

    public void setManages_ambiguity(Integer manages_ambiguity) {
        this.manages_ambiguity = manages_ambiguity;
    }

    public Integer getManages_conflict() {
        return manages_conflict;
    }

    public void setManages_conflict(Integer manages_conflict) {
        this.manages_conflict = manages_conflict;
    }

    public Integer getNimble_learning() {
        return nimble_learning;
    }

    public void setNimble_learning(Integer nimble_learning) {
        this.nimble_learning = nimble_learning;
    }

    public Integer getOptimizes_work_processes() {
        return optimizes_work_processes;
    }

    public void setOptimizes_work_processes(Integer optimizes_work_processes) {
        this.optimizes_work_processes = optimizes_work_processes;
    }

    public Integer getPersuades() {
        return persuades;
    }

    public void setPersuades(Integer persuades) {
        this.persuades = persuades;
    }

    public Integer getPlans_and_aligns() {
        return plans_and_aligns;
    }

    public void setPlans_and_aligns(Integer plans_and_aligns) {
        this.plans_and_aligns = plans_and_aligns;
    }

    public Integer getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(Integer resourcefulness) {
        this.resourcefulness = resourcefulness;
    }

    public Integer getSelf_development() {
        return self_development;
    }

    public void setSelf_development(Integer self_development) {
        this.self_development = self_development;
    }

    public Integer getSituational_adaptability() {
        return situational_adaptability;
    }

    public void setSituational_adaptability(Integer situational_adaptability) {
        this.situational_adaptability = situational_adaptability;
    }

    public Integer getStrategic_mindset() {
        return strategic_mindset;
    }

    public void setStrategic_mindset(Integer strategic_mindset) {
        this.strategic_mindset = strategic_mindset;
    }

    public Integer getValues_differences() {
        return values_differences;
    }

    public void setValues_differences(Integer values_differences) {
        this.values_differences = values_differences;
    }
}
