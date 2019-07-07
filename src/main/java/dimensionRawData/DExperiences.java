package dimensionRawData;

public class DExperiences {

    private String wwid;
    private String highest_degree_received;
    private Integer direct_report;

    private String overall_rating2016;
    private String overall_rating2017;
    private String overall_rating2018;

    private Double bonus2016;
    private Double bonus2017;
    private Double bonus2018;

    private Integer function_movements;
    private Integer lateral_movements;
    private Integer promotions;
    private Integer region_movements;
    private Integer country_movements;
    private Integer sector_movements;

    private Integer jnj_roles;
    private Integer external_roles;
    private Integer total_roles;
    private Double average_time_of_jnj_role;
    private Double average_time_of_external_role;
    private Double total_working_year;
    private Double external_length_of_service;
    private Double average_time_of_each_role;

    private Integer hierarchy_count;

    private Double performance_comments;
    private Double feedback;

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

    public Integer getDirect_report() {
        return direct_report;
    }

    public void setDirect_report(Integer direct_report) {
        this.direct_report = direct_report;
    }

    public String getOverall_rating2016() {
        return overall_rating2016;
    }

    public void setOverall_rating2016(String overall_rating2016) {
        this.overall_rating2016 = overall_rating2016;
    }

    public String getOverall_rating2017() {
        return overall_rating2017;
    }

    public void setOverall_rating2017(String overall_rating2017) {
        this.overall_rating2017 = overall_rating2017;
    }

    public String getOverall_rating2018() {
        return overall_rating2018;
    }

    public void setOverall_rating2018(String overall_rating2018) {
        this.overall_rating2018 = overall_rating2018;
    }

    public Double getBonus2016() {
        return bonus2016;
    }

    public void setBonus2016(Double bonus2016) {
        this.bonus2016 = bonus2016;
    }

    public Double getBonus2017() {
        return bonus2017;
    }

    public void setBonus2017(Double bonus2017) {
        this.bonus2017 = bonus2017;
    }

    public Double getBonus2018() {
        return bonus2018;
    }

    public void setBonus2018(Double bonus2018) {
        this.bonus2018 = bonus2018;
    }

    public Integer getFunction_movements() {
        return function_movements;
    }

    public void setFunction_movements(Integer function_movements) {
        this.function_movements = function_movements;
    }

    public Integer getLateral_movements() {
        return lateral_movements;
    }

    public void setLateral_movements(Integer lateral_movements) {
        this.lateral_movements = lateral_movements;
    }

    public Integer getPromotions() {
        return promotions;
    }

    public void setPromotions(Integer promotions) {
        this.promotions = promotions;
    }

    public Integer getRegion_movements() {
        return region_movements;
    }

    public void setRegion_movements(Integer region_movements) {
        this.region_movements = region_movements;
    }

    public Integer getCountry_movements() {
        return country_movements;
    }

    public void setCountry_movements(Integer country_movements) {
        this.country_movements = country_movements;
    }

    public Integer getSector_movements() {
        return sector_movements;
    }

    public void setSector_movements(Integer sector_movements) {
        this.sector_movements = sector_movements;
    }

    public Integer getJnj_roles() {
        return jnj_roles;
    }

    public void setJnj_roles(Integer jnj_roles) {
        this.jnj_roles = jnj_roles;
    }

    public Integer getExternal_roles() {
        return external_roles;
    }

    public void setExternal_roles(Integer external_roles) {
        this.external_roles = external_roles;
    }

    public Integer getTotal_roles() {
        return total_roles;
    }

    public void setTotal_roles(Integer total_roles) {
        this.total_roles = total_roles;
    }

    public Double getAverage_time_of_jnj_role() {
        return average_time_of_jnj_role;
    }

    public void setAverage_time_of_jnj_role(Double average_time_of_jnj_role) {
        this.average_time_of_jnj_role = average_time_of_jnj_role;
    }

    public Double getAverage_time_of_external_role() {
        return average_time_of_external_role;
    }

    public void setAverage_time_of_external_role(Double average_time_of_external_role) {
        this.average_time_of_external_role = average_time_of_external_role;
    }

    public Double getTotal_working_year() {
        return total_working_year;
    }

    public void setTotal_working_year(Double total_working_year) {
        this.total_working_year = total_working_year;
    }

    public Double getExternal_length_of_service() {
        return external_length_of_service;
    }

    public void setExternal_length_of_service(Double external_length_of_service) {
        this.external_length_of_service = external_length_of_service;
    }

    public Double getAverage_time_of_each_role() {
        return average_time_of_each_role;
    }

    public void setAverage_time_of_each_role(Double average_time_of_each_role) {
        this.average_time_of_each_role = average_time_of_each_role;
    }

    public Integer getHierarchy_count() {
        return hierarchy_count;
    }

    public void setHierarchy_count(Integer hierarchy_count) {
        this.hierarchy_count = hierarchy_count;
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
        return "DExperiences{" +
                "wwid='" + wwid + '\'' +
                ", highest_degree_received='" + highest_degree_received + '\'' +
                ", direct_report=" + direct_report +
                ", overall_rating2016='" + overall_rating2016 + '\'' +
                ", overall_rating2017='" + overall_rating2017 + '\'' +
                ", overall_rating2018='" + overall_rating2018 + '\'' +
                ", bonus2016=" + bonus2016 +
                ", bonus2017=" + bonus2017 +
                ", bonus2018=" + bonus2018 +
                ", function_movements=" + function_movements +
                ", lateral_movements=" + lateral_movements +
                ", promotions=" + promotions +
                ", region_movements=" + region_movements +
                ", country_movements=" + country_movements +
                ", sector_movements=" + sector_movements +
                ", jnj_roles=" + jnj_roles +
                ", external_roles=" + external_roles +
                ", total_roles=" + total_roles +
                ", average_time_of_jnj_role=" + average_time_of_jnj_role +
                ", average_time_of_external_role=" + average_time_of_external_role +
                ", total_working_year=" + total_working_year +
                ", external_length_of_service=" + external_length_of_service +
                ", average_time_of_each_role=" + average_time_of_each_role +
                ", hierarchy_count=" + hierarchy_count +
                ", performance_comments=" + performance_comments +
                ", feedback=" + feedback +
                '}';
    }
}