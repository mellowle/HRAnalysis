package dimensionRawData;

import java.util.HashMap;
import java.util.Map;

public class DDrivers {
    private String wwid;
    private Integer balance;
    private Integer challenge;
    private Integer collaboration;
    private Integer independence;
    private Integer power;
    private Integer structure;

    public DDrivers(String wwid, String balance, String challenge, String collaboration, String independence,
                    String power, String structure) {
        this.wwid = wwid;
        this.balance = balance == null ? null : Double.valueOf(balance).intValue();
        this.challenge = challenge == null ? null : Double.valueOf(challenge).intValue();
        this.collaboration = collaboration == null ? null : Double.valueOf(collaboration).intValue();
        this.independence = independence == null ? null : Double.valueOf(independence).intValue();
        this.power = power == null ? null : Double.valueOf(power).intValue();
        this.structure = structure == null ? null : Double.valueOf(structure).intValue();
    }

    public Map<String, Integer> getDrivers() {
        Map<String, Integer> result = new HashMap<>();
        result.put("balance", this.balance);
        result.put("challenge", this.challenge);
        result.put("collaboration", this.collaboration);
        result.put("independence", this.independence);
        result.put("power", this.power);
        result.put("structure", this.structure);
        return result;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getChallenge() {
        return challenge;
    }

    public void setChallenge(Integer challenge) {
        this.challenge = challenge;
    }

    public Integer getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(Integer collaboration) {
        this.collaboration = collaboration;
    }

    public Integer getIndependence() {
        return independence;
    }

    public void setIndependence(Integer independence) {
        this.independence = independence;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getStructure() {
        return structure;
    }

    public void setStructure(Integer structure) {
        this.structure = structure;
    }
}
