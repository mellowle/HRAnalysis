package entity.dimensionScored;

public class FinalScore {
    private String wwid;
    private Double competencies_score;
    private Double experiences_score;
    private Double traits_score;
    private Double drivers_score;
    private Double competencies_and_experiences;
    private Double traits_and_drivers;

    public void sumUp() {
        this.competencies_and_experiences = this.competencies_score * 0.6 + this.experiences_score * 0.4;
        this.traits_and_drivers = this.traits_score * 0.6 + this.drivers_score * 0.4;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getCompetencies_score() {
        return competencies_score;
    }

    public void setCompetencies_score(Double competencies_score) {
        this.competencies_score = competencies_score;
    }

    public Double getExperiences_score() {
        return experiences_score;
    }

    public void setExperiences_score(Double experiences_score) {
        this.experiences_score = experiences_score;
    }

    public Double getTraits_score() {
        return traits_score;
    }

    public void setTraits_score(Double traits_score) {
        this.traits_score = traits_score;
    }

    public Double getDrivers_score() {
        return drivers_score;
    }

    public void setDrivers_score(Double drivers_score) {
        this.drivers_score = drivers_score;
    }

    public Double getCompetencies_and_experiences() {
        return competencies_and_experiences;
    }

    public void setCompetencies_and_experiences(Double competencies_and_experiences) {
        this.competencies_and_experiences = competencies_and_experiences;
    }

    public Double getTraits_and_drivers() {
        return traits_and_drivers;
    }

    public void setTraits_and_drivers(Double traits_and_drivers) {
        this.traits_and_drivers = traits_and_drivers;
    }

    @Override
    public String toString() {
        return "FinalScore{" +
                "wwid='" + wwid + '\'' +
                ", competencies_score=" + competencies_score +
                ", experiences_score=" + experiences_score +
                ", traits_score=" + traits_score +
                ", drivers_score=" + drivers_score +
                ", competencies_and_experiences=" + competencies_and_experiences +
                ", traits_and_drivers=" + traits_and_drivers +
                '}';
    }
}
