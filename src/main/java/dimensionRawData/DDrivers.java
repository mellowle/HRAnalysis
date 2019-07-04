package dimensionRawData;

import java.util.HashMap;
import java.util.Map;

public class DDrivers {
    private String wwid;
    private int balance;
    private int challenge;
    private int collaboration;
    private int independence;
    private int power;
    private int structure;

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getChallenge() {
        return challenge;
    }

    public void setChallenge(int challenge) {
        this.challenge = challenge;
    }

    public int getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(int collaboration) {
        this.collaboration = collaboration;
    }

    public int getIndependence() {
        return independence;
    }

    public void setIndependence(int independence) {
        this.independence = independence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getStructure() {
        return structure;
    }

    public void setStructure(int structure) {
        this.structure = structure;
    }
}
