package entity.excelEntity;

public class DigitalExperiences {
    private String wwid;
    private Double customer_journey;
    private Double data_analytics;
    private Double innovation;
    private Double digital_leadership;
    private Double digital_commerce;
    private Double digital_products;
    private Double operational_efficiency;
    private Double overall_digital_experience_percentile;

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public Double getCustomer_journey() {
        return customer_journey;
    }

    public void setCustomer_journey(Double customer_journey) {
        this.customer_journey = customer_journey;
    }

    public Double getData_analytics() {
        return data_analytics;
    }

    public void setData_analytics(Double data_analytics) {
        this.data_analytics = data_analytics;
    }

    public Double getInnovation() {
        return innovation;
    }

    public void setInnovation(Double innovation) {
        this.innovation = innovation;
    }

    public Double getDigital_leadership() {
        return digital_leadership;
    }

    public void setDigital_leadership(Double digital_leadership) {
        this.digital_leadership = digital_leadership;
    }

    public Double getDigital_commerce() {
        return digital_commerce;
    }

    public void setDigital_commerce(Double digital_commerce) {
        this.digital_commerce = digital_commerce;
    }

    public Double getDigital_products() {
        return digital_products;
    }

    public void setDigital_products(Double digital_products) {
        this.digital_products = digital_products;
    }

    public Double getOperational_efficiency() {
        return operational_efficiency;
    }

    public void setOperational_efficiency(Double operational_efficiency) {
        this.operational_efficiency = operational_efficiency;
    }

    public Double getOverall_digital_experience_percentile() {
        return overall_digital_experience_percentile;
    }

    public void setOverall_digital_experience_percentile(Double overall_digital_experience_percentile) {
        this.overall_digital_experience_percentile = overall_digital_experience_percentile;
    }

    @Override
    public String toString() {
        return "DigitalExperiences{" +
                "wwid='" + wwid + '\'' +
                ", customer_journey=" + customer_journey +
                ", data_analytics=" + data_analytics +
                ", innovation=" + innovation +
                ", digital_leadership=" + digital_leadership +
                ", digital_commerce=" + digital_commerce +
                ", digital_products=" + digital_products +
                ", operational_efficiency=" + operational_efficiency +
                ", overall_digital_experience_percentile=" + overall_digital_experience_percentile +
                '}';
    }
}
