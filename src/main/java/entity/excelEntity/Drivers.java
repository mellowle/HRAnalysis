package entity.excelEntity;

public class Drivers {
    public String wwid;
    public Integer balance;
    public Integer challenge;
    public Integer collaboration;
    public Integer independence;
    public Integer power;
    public Integer structure;

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

    @Override
    public String toString() {
        return "Drivers{" +
                "wwid='" + wwid + '\'' +
                ", balance=" + balance +
                ", challenge=" + challenge +
                ", collaboration=" + collaboration +
                ", independence=" + independence +
                ", power=" + power +
                ", structure=" + structure +
                '}';
    }
}
