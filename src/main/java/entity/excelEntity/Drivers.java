package entity.excelEntity;

public class Drivers {
    private String wwid;
    private Integer balance;
    private Integer challenge;
    private Integer collaboration;
    private Integer independence;
    private Integer power;
    private Integer structure;

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
