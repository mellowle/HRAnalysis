package dimensionRawData;

import java.util.HashMap;
import java.util.Map;

public class DTraits {
    private String wwid;
    private int adaptability;
    private int affiliation;
    private int assertiveness;
    private int composure;
    private int confidence;
    private int credibility;
    private int curiosity;
    private int empathy;
    private int focus;
    private int humility;
    private int influence;
    private int need_for_achievement;
    private int openness_to_differences;
    private int optimism;
    private int persistence;
    private int risk_taking;
    private int situational_self_awareness;
    private int sociability;
    private int tolerance_of_ambiguity;
    private int trust;

    public Map<String, Integer> getTraits() {
        Map<String, Integer> result = new HashMap<>();
        result.put("adaptability", this.adaptability);
        result.put("affiliation", this.affiliation);
        result.put("assertiveness", this.assertiveness);
        result.put("composure", this.composure);
        result.put("confidence", this.confidence);
        result.put("credibility", this.credibility);
        result.put("curiosity", this.curiosity);
        result.put("empathy", this.empathy);
        result.put("focus", this.focus);
        result.put("humility", this.humility);
        result.put("influence", this.influence);
        result.put("need_for_achievement", this.need_for_achievement);
        result.put("openness_to_differences", this.openness_to_differences);
        result.put("optimism", this.optimism);
        result.put("persistence", this.persistence);
        result.put("risk_taking", this.risk_taking);
        result.put("situational_self_awareness", this.situational_self_awareness);
        result.put("sociability", this.sociability);
        result.put("tolerance_of_ambiguity", this.tolerance_of_ambiguity);
        result.put("trust", this.trust);
        return result;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(int affiliation) {
        this.affiliation = affiliation;
    }

    public int getAssertiveness() {
        return assertiveness;
    }

    public void setAssertiveness(int assertiveness) {
        this.assertiveness = assertiveness;
    }

    public int getComposure() {
        return composure;
    }

    public void setComposure(int composure) {
        this.composure = composure;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getCredibility() {
        return credibility;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }

    public int getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(int curiosity) {
        this.curiosity = curiosity;
    }

    public int getEmpathy() {
        return empathy;
    }

    public void setEmpathy(int empathy) {
        this.empathy = empathy;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getHumility() {
        return humility;
    }

    public void setHumility(int humility) {
        this.humility = humility;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public int getNeed_for_achievement() {
        return need_for_achievement;
    }

    public void setNeed_for_achievement(int need_for_achievement) {
        this.need_for_achievement = need_for_achievement;
    }

    public int getOpenness_to_differences() {
        return openness_to_differences;
    }

    public void setOpenness_to_differences(int openness_to_differences) {
        this.openness_to_differences = openness_to_differences;
    }

    public int getOptimism() {
        return optimism;
    }

    public void setOptimism(int optimism) {
        this.optimism = optimism;
    }

    public int getPersistence() {
        return persistence;
    }

    public void setPersistence(int persistence) {
        this.persistence = persistence;
    }

    public int getRisk_taking() {
        return risk_taking;
    }

    public void setRisk_taking(int risk_taking) {
        this.risk_taking = risk_taking;
    }

    public int getSituational_self_awareness() {
        return situational_self_awareness;
    }

    public void setSituational_self_awareness(int situational_self_awareness) {
        this.situational_self_awareness = situational_self_awareness;
    }

    public int getSociability() {
        return sociability;
    }

    public void setSociability(int sociability) {
        this.sociability = sociability;
    }

    public int getTolerance_of_ambiguity() {
        return tolerance_of_ambiguity;
    }

    public void setTolerance_of_ambiguity(int tolerance_of_ambiguity) {
        this.tolerance_of_ambiguity = tolerance_of_ambiguity;
    }

    public int getTrust() {
        return trust;
    }

    public void setTrust(int trust) {
        this.trust = trust;
    }
}
