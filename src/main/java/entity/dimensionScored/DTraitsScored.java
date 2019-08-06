package entity.dimensionScored;

import java.util.Map;

public class DTraitsScored {
    private String wwid;
    private Double adaptability;
    private Double affiliation;
    private Double assertiveness;
    private Double composure;
    private Double confidence;
    private Double credibility;
    private Double curiosity;
    private Double empathy;
    private Double focus;
    private Double humility;
    private Double influence;
    private Double need_for_achievement;
    private Double openness_to_differences;
    private Double optimism;
    private Double persistence;
    private Double risk_taking;
    private Double situational_self_awareness;
    private Double sociability;
    private Double tolerance_of_ambiguity;
    private Double trust;
    private Double result;

    public DTraitsScored(String wwid, Map<String, Double> traits) {
        this.wwid = wwid;
        this.adaptability = traits.get("adaptability");
        this.affiliation = traits.get("affiliation");
        this.assertiveness = traits.get("assertiveness");
        this.composure = traits.get("composure");
        this.confidence = traits.get("confidence");
        this.credibility = traits.get("credibility");
        this.curiosity = traits.get("curiosity");
        this.empathy = traits.get("empathy");
        this.focus = traits.get("focus");
        this.humility = traits.get("humility");
        this.influence = traits.get("influence");
        this.need_for_achievement = traits.get("need_for_achievement");
        this.openness_to_differences = traits.get("openness_to_differences");
        this.optimism = traits.get("optimism");
        this.persistence = traits.get("persistence");
        this.risk_taking = traits.get("risk_taking");
        this.situational_self_awareness = traits.get("situational_self_awareness");
        this.sociability = traits.get("sociability");
        this.tolerance_of_ambiguity = traits.get("tolerance_of_ambiguity");
        this.trust = traits.get("trust");

    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Double adaptability) {
        this.adaptability = adaptability;
    }

    public Double getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Double affiliation) {
        this.affiliation = affiliation;
    }

    public Double getAssertiveness() {
        return assertiveness;
    }

    public void setAssertiveness(Double assertiveness) {
        this.assertiveness = assertiveness;
    }

    public Double getComposure() {
        return composure;
    }

    public void setComposure(Double composure) {
        this.composure = composure;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getCredibility() {
        return credibility;
    }

    public void setCredibility(Double credibility) {
        this.credibility = credibility;
    }

    public Double getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(Double curiosity) {
        this.curiosity = curiosity;
    }

    public Double getEmpathy() {
        return empathy;
    }

    public void setEmpathy(Double empathy) {
        this.empathy = empathy;
    }

    public Double getFocus() {
        return focus;
    }

    public void setFocus(Double focus) {
        this.focus = focus;
    }

    public Double getHumility() {
        return humility;
    }

    public void setHumility(Double humility) {
        this.humility = humility;
    }

    public Double getInfluence() {
        return influence;
    }

    public void setInfluence(Double influence) {
        this.influence = influence;
    }

    public Double getNeed_for_achievement() {
        return need_for_achievement;
    }

    public void setNeed_for_achievement(Double need_for_achievement) {
        this.need_for_achievement = need_for_achievement;
    }

    public Double getOpenness_to_differences() {
        return openness_to_differences;
    }

    public void setOpenness_to_differences(Double openness_to_differences) {
        this.openness_to_differences = openness_to_differences;
    }

    public Double getOptimism() {
        return optimism;
    }

    public void setOptimism(Double optimism) {
        this.optimism = optimism;
    }

    public Double getPersistence() {
        return persistence;
    }

    public void setPersistence(Double persistence) {
        this.persistence = persistence;
    }

    public Double getRisk_taking() {
        return risk_taking;
    }

    public void setRisk_taking(Double risk_taking) {
        this.risk_taking = risk_taking;
    }

    public Double getSituational_self_awareness() {
        return situational_self_awareness;
    }

    public void setSituational_self_awareness(Double situational_self_awareness) {
        this.situational_self_awareness = situational_self_awareness;
    }

    public Double getSociability() {
        return sociability;
    }

    public void setSociability(Double sociability) {
        this.sociability = sociability;
    }

    public Double getTolerance_of_ambiguity() {
        return tolerance_of_ambiguity;
    }

    public void setTolerance_of_ambiguity(Double tolerance_of_ambiguity) {
        this.tolerance_of_ambiguity = tolerance_of_ambiguity;
    }

    public Double getTrust() {
        return trust;
    }

    public void setTrust(Double trust) {
        this.trust = trust;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
