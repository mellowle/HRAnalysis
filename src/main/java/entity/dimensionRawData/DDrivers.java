package entity.dimensionRawData;

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

    public DDrivers(String wwid, Integer balance, Integer challenge, Integer collaboration, Integer independence,
                    Integer power, Integer structure) {
        this.wwid = wwid;
        this.balance = balance;
        this.challenge = challenge;
        this.collaboration = collaboration;
        this.independence = independence;
        this.power = power;
        this.structure = structure;
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
