package entity.excelEntity;

/** @deprecated */
public class Education {
    private String wwid;
    private String highest_degree_received;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getHighest_degree_received() {
        return highest_degree_received;
    }

    public void setHighest_degree_received(String highest_degree_received) {
        this.highest_degree_received = highest_degree_received;
    }

    @Override
    public String toString() {
        return "Education{" +
                "wwid='" + wwid + '\'' +
                ", highest_degree_received='" + highest_degree_received + '\'' +
                '}';
    }
}
