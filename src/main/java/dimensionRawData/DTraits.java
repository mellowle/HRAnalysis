package dimensionRawData;

import java.util.HashMap;
import java.util.Map;

public class DTraits {
    private String wwid;
    private Integer adaptability;
    private Integer affiliation;
    private Integer assertiveness;
    private Integer composure;
    private Integer confidence;
    private Integer credibility;
    private Integer curiosity;
    private Integer empathy;
    private Integer focus;
    private Integer humility;
    private Integer influence;
    private Integer need_for_achievement;
    private Integer openness_to_differences;
    private Integer optimism;
    private Integer persistence;
    private Integer risk_taking;
    private Integer situational_self_awareness;
    private Integer sociability;
    private Integer tolerance_of_ambiguity;
    private Integer trust;

    public DTraits(String wwid, String adaptability, String affiliation, String assertiveness,
                   String composure, String confidence, String credibility, String curiosity, String empathy,
                   String focus, String humility, String influence, String need_for_achievement,
                   String openness_to_differences, String optimism, String persistence, String risk_taking,
                   String situational_self_awareness, String sociability, String tolerance_of_ambiguity,
                   String trust) {
        this.wwid = wwid;
        this.adaptability = adaptability == null ? null : Double.valueOf(adaptability).intValue();
        this.affiliation = affiliation == null ? null : Double.valueOf(affiliation).intValue();
        this.assertiveness = assertiveness == null ? null : Double.valueOf(assertiveness).intValue();
        this.composure = composure == null ? null : Double.valueOf(composure).intValue();
        this.confidence = confidence == null ? null : Double.valueOf(confidence).intValue();
        this.credibility = credibility == null ? null : Double.valueOf(credibility).intValue();
        this.curiosity = curiosity == null ? null : Double.valueOf(curiosity).intValue();
        this.empathy = empathy == null ? null : Double.valueOf(empathy).intValue();
        this.focus = focus == null ? null : Double.valueOf(focus).intValue();
        this.humility = humility == null ? null : Double.valueOf(humility).intValue();
        this.influence = influence == null ? null : Double.valueOf(influence).intValue();
        this.need_for_achievement = need_for_achievement == null ? null : Double.valueOf(need_for_achievement).intValue();
        this.openness_to_differences = openness_to_differences == null ? null : Double.valueOf(openness_to_differences).intValue();
        this.optimism = optimism == null ? null : Double.valueOf(optimism).intValue();
        this.persistence = persistence == null ? null : Double.valueOf(persistence).intValue();
        this.risk_taking = risk_taking == null ? null : Double.valueOf(risk_taking).intValue();
        this.situational_self_awareness = situational_self_awareness == null ? null : Double.valueOf(situational_self_awareness).intValue();
        this.sociability = sociability == null ? null : Double.valueOf(sociability).intValue();
        this.tolerance_of_ambiguity = tolerance_of_ambiguity == null ? null : Double.valueOf(tolerance_of_ambiguity).intValue();
        this.trust = trust == null ? null : Double.valueOf(trust).intValue();

    }

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

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        this.adaptability = adaptability;
    }

    public Integer getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Integer affiliation) {
        this.affiliation = affiliation;
    }

    public Integer getAssertiveness() {
        return assertiveness;
    }

    public void setAssertiveness(Integer assertiveness) {
        this.assertiveness = assertiveness;
    }

    public Integer getComposure() {
        return composure;
    }

    public void setComposure(Integer composure) {
        this.composure = composure;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public Integer getCredibility() {
        return credibility;
    }

    public void setCredibility(Integer credibility) {
        this.credibility = credibility;
    }

    public Integer getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(Integer curiosity) {
        this.curiosity = curiosity;
    }

    public Integer getEmpathy() {
        return empathy;
    }

    public void setEmpathy(Integer empathy) {
        this.empathy = empathy;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public Integer getHumility() {
        return humility;
    }

    public void setHumility(Integer humility) {
        this.humility = humility;
    }

    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public Integer getNeed_for_achievement() {
        return need_for_achievement;
    }

    public void setNeed_for_achievement(Integer need_for_achievement) {
        this.need_for_achievement = need_for_achievement;
    }

    public Integer getOpenness_to_differences() {
        return openness_to_differences;
    }

    public void setOpenness_to_differences(Integer openness_to_differences) {
        this.openness_to_differences = openness_to_differences;
    }

    public Integer getOptimism() {
        return optimism;
    }

    public void setOptimism(Integer optimism) {
        this.optimism = optimism;
    }

    public Integer getPersistence() {
        return persistence;
    }

    public void setPersistence(Integer persistence) {
        this.persistence = persistence;
    }

    public Integer getRisk_taking() {
        return risk_taking;
    }

    public void setRisk_taking(Integer risk_taking) {
        this.risk_taking = risk_taking;
    }

    public Integer getSituational_self_awareness() {
        return situational_self_awareness;
    }

    public void setSituational_self_awareness(Integer situational_self_awareness) {
        this.situational_self_awareness = situational_self_awareness;
    }

    public Integer getSociability() {
        return sociability;
    }

    public void setSociability(Integer sociability) {
        this.sociability = sociability;
    }

    public Integer getTolerance_of_ambiguity() {
        return tolerance_of_ambiguity;
    }

    public void setTolerance_of_ambiguity(Integer tolerance_of_ambiguity) {
        this.tolerance_of_ambiguity = tolerance_of_ambiguity;
    }

    public Integer getTrust() {
        return trust;
    }

    public void setTrust(Integer trust) {
        this.trust = trust;
    }
}
