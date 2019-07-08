package entity.dimensionScored;

import java.util.Map;

public class DDriversScored {
    private String wwid;
    private Double balance;
    private Double challenge;
    private Double collaboration;
    private Double independence;
    private Double power;
    private Double structure;
    private Double result;

    public DDriversScored(String wwid, Map<String, Double> drivers) {
        this.wwid = wwid;
        this.balance = drivers.get("balance");
        this.challenge = drivers.get("challenge");
        this.collaboration = drivers.get("collaboration");
        this.independence = drivers.get("independence");
        this.power = drivers.get("power");
        this.structure = drivers.get("structure");

        sumUp();
    }

    private void sumUp() {
        if (balance != null) {
            this.result = this.balance
                    + this.challenge
                    + this.collaboration
                    + this.independence
                    + this.power
                    + this.structure;
        }
        else {
            this.result = null;
        }

    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getChallenge() {
        return challenge;
    }

    public void setChallenge(Double challenge) {
        this.challenge = challenge;
    }

    public Double getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(Double collaboration) {
        this.collaboration = collaboration;
    }

    public Double getIndependence() {
        return independence;
    }

    public void setIndependence(Double independence) {
        this.independence = independence;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getStructure() {
        return structure;
    }

    public void setStructure(Double structure) {
        this.structure = structure;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
