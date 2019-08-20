package entity.excelEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Education education = (Education) o;

        return new EqualsBuilder()
                .append(wwid, education.wwid)
                .append(highest_degree_received, education.highest_degree_received)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(wwid)
                .append(highest_degree_received)
                .toHashCode();
    }
}
