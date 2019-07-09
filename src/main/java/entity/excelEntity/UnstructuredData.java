package entity.excelEntity;

public class UnstructuredData {
    private String wwid;
    private Double performance_comments;
    private Double feedback;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getPerformance_comments() {
        return performance_comments;
    }

    public void setPerformance_comments(Double performance_comments) {
        this.performance_comments = performance_comments;
    }

    public Double getFeedback() {
        return feedback;
    }

    public void setFeedback(Double feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "UnstructuredData{" +
                "wwid='" + wwid + '\'' +
                ", performance_comments=" + performance_comments +
                ", feedback=" + feedback +
                '}';
    }
}
