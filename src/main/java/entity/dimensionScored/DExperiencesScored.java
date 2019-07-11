package entity.dimensionScored;

import Constants.ExperiencesConstants.ExperiencesConstants;

public class DExperiencesScored {
    private String wwid;

    private String employee_pay_grade;
    private String job_function;
    private String sector;
    private Double length_of_service_in_years;
    private String overall_rating2016;
    private String overall_rating2017;
    private String overall_rating2018;


//    private Double is_mba;
    private Double team_size;
    private Double performance_rating2016;
    private Double performance_rating2017;
    private Double performance_rating2018;
    private Double bonus_increment20162017;
    private Double bonus_increment20172018;

    private Double function_movements;
    private Double lateral_movements;
    private Double promotions;
    private Double region_movements;
    private Double country_movements;
    private Double sector_movements;

    private Double external_roles;
    private Double external_length_of_service;

    private Double role_number_ranking;
    private Double total_working_year_ranking;
    private Double average_time_of_each_role_ranking;

    private Double hierarchy_count;

    private Double performance_comments2018;
    private Double stakeholder_feedback;

    private Double data_completeness;

    private Double result;

    public void sumUp() {

        double resultScore = 0.0;
        double nonNullCounts = 0;
        //        if (this.is_mba != null) {
        //            resultScore += this.is_mba * ExperiencesConstants.MBA_WEIGHT;
        //            nonNullCounts++;
        //        }

        if (this.team_size != null) {
            resultScore += this.team_size * ExperiencesConstants.TEAM_SIZE_WEIGHT;
            nonNullCounts++;
        }

        if (this.performance_rating2016 != null) {
            resultScore += this.performance_rating2016 * ExperiencesConstants.PERFORMANCE_2016;
            nonNullCounts++;
        }

        if (this.performance_rating2017 != null) {
            resultScore += this.performance_rating2017 * ExperiencesConstants.PERFORMANCE_2017;
            nonNullCounts++;
        }

        if (this.performance_rating2018 != null) {
            resultScore += this.performance_rating2018 * ExperiencesConstants.PERFORMANCE_2018;
            nonNullCounts++;
        }

        if (this.bonus_increment20162017 != null) {
            resultScore += this.bonus_increment20162017 * ExperiencesConstants.BONUS_2017_WEIGHT;
            nonNullCounts++;
        }

        if (this.bonus_increment20172018 != null) {
            resultScore += this.bonus_increment20172018 * ExperiencesConstants.BONUS_2018_WEIGHT;
            nonNullCounts++;
        }

        if (this.function_movements != null) {
            resultScore += this.function_movements * ExperiencesConstants.FUNCTION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (this.lateral_movements != null) {
            resultScore += this.lateral_movements * ExperiencesConstants.LATERAL_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (this.promotions != null) {
            resultScore += this.promotions * ExperiencesConstants.PROMOTION_WEIGHT;
            nonNullCounts++;
        }

        if (this.region_movements != null) {
            resultScore += this.region_movements * ExperiencesConstants.REGION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (this.sector_movements != null) {
            resultScore += this.sector_movements * ExperiencesConstants.SECTOR_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (this.country_movements != null) {
            resultScore += this.country_movements * ExperiencesConstants.COUNTRY_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (this.external_roles != null) {
            resultScore += this.external_roles * ExperiencesConstants.EXTERNAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (this.external_length_of_service != null) {
            resultScore += this.external_length_of_service * ExperiencesConstants.EXTERNAL_LENGTH_SERVICE_WEIGHT;
            nonNullCounts++;
        }

        if (this.role_number_ranking != null) {
            resultScore += this.role_number_ranking * ExperiencesConstants.TOTAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (this.total_working_year_ranking != null) {
            resultScore += this.total_working_year_ranking * ExperiencesConstants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (this.average_time_of_each_role_ranking != null) {
            resultScore += this.average_time_of_each_role_ranking * ExperiencesConstants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (this.hierarchy_count != null) {
            resultScore += this.hierarchy_count * ExperiencesConstants.REPORTING_LINE_WEIGHT;
            nonNullCounts++;
        }

        if (this.performance_comments2018 != null) {
            resultScore += this.performance_comments2018 * ExperiencesConstants.PERFORMANCE_COMMENTS_WEIGHT;
            nonNullCounts++;
        }

        if (this.stakeholder_feedback != null) {
            resultScore += this.stakeholder_feedback * ExperiencesConstants.STAKEHOLDER_FEEDBACK_WEIGHT;
            nonNullCounts++;
        }

        this.result = resultScore / ExperiencesConstants.HIGHEST_SCORE_WITH_WEIGHT * 100;
        this.data_completeness = nonNullCounts / ExperiencesConstants.TOTAL_FACTORS;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getEmployee_pay_grade() {
        return employee_pay_grade;
    }

    public void setEmployee_pay_grade(String employee_pay_grade) {
        this.employee_pay_grade = employee_pay_grade;
    }

    public String getJob_function() {
        return job_function;
    }

    public void setJob_function(String job_function) {
        this.job_function = job_function;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getLength_of_service_in_years() {
        return length_of_service_in_years;
    }

    public void setLength_of_service_in_years(Double length_of_service_in_years) {
        this.length_of_service_in_years = length_of_service_in_years;
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

    //    public Double getIs_mba() {
//        return is_mba;
//    }
//
//    public void setIs_mba(Double is_mba) {
//        this.is_mba = is_mba;
//    }

    public Double getTeam_size() {
        return team_size;
    }

    public void setTeam_size(Double team_size) {
        this.team_size = team_size;
    }

    public Double getPerformance_rating2016() {
        return performance_rating2016;
    }

    public void setPerformance_rating2016(Double performance_rating2016) {
        this.performance_rating2016 = performance_rating2016;
    }

    public Double getPerformance_rating2017() {
        return performance_rating2017;
    }

    public void setPerformance_rating2017(Double performance_rating2017) {
        this.performance_rating2017 = performance_rating2017;
    }

    public Double getPerformance_rating2018() {
        return performance_rating2018;
    }

    public void setPerformance_rating2018(Double performance_rating2018) {
        this.performance_rating2018 = performance_rating2018;
    }

    public Double getBonus_increment20162017() {
        return bonus_increment20162017;
    }

    public void setBonus_increment20162017(Double bonus_increment20162017) {
        this.bonus_increment20162017 = bonus_increment20162017;
    }

    public Double getBonus_increment20172018() {
        return bonus_increment20172018;
    }

    public void setBonus_increment20172018(Double bonus_increment20172018) {
        this.bonus_increment20172018 = bonus_increment20172018;
    }

    public Double getFunction_movements() {
        return function_movements;
    }

    public void setFunction_movements(Double function_movements) {
        this.function_movements = function_movements;
    }

    public Double getLateral_movements() {
        return lateral_movements;
    }

    public void setLateral_movements(Double lateral_movements) {
        this.lateral_movements = lateral_movements;
    }

    public Double getPromotions() {
        return promotions;
    }

    public void setPromotions(Double promotions) {
        this.promotions = promotions;
    }

    public Double getRegion_movements() {
        return region_movements;
    }

    public void setRegion_movements(Double region_movements) {
        this.region_movements = region_movements;
    }

    public Double getCountry_movements() {
        return country_movements;
    }

    public void setCountry_movements(Double country_movements) {
        this.country_movements = country_movements;
    }

    public Double getSector_movements() {
        return sector_movements;
    }

    public void setSector_movements(Double sector_movements) {
        this.sector_movements = sector_movements;
    }

    public Double getExternal_roles() {
        return external_roles;
    }

    public void setExternal_roles(Double external_roles) {
        this.external_roles = external_roles;
    }

    public Double getExternal_length_of_service() {
        return external_length_of_service;
    }

    public void setExternal_length_of_service(Double external_length_of_service) {
        this.external_length_of_service = external_length_of_service;
    }

    public Double getRole_number_ranking() {
        return role_number_ranking;
    }

    public void setRole_number_ranking(Double role_number_ranking) {
        this.role_number_ranking = role_number_ranking;
    }

    public Double getTotal_working_year_ranking() {
        return total_working_year_ranking;
    }

    public void setTotal_working_year_ranking(Double total_working_year_ranking) {
        this.total_working_year_ranking = total_working_year_ranking;
    }

    public Double getAverage_time_of_each_role_ranking() {
        return average_time_of_each_role_ranking;
    }

    public void setAverage_time_of_each_role_ranking(Double average_time_of_each_role_ranking) {
        this.average_time_of_each_role_ranking = average_time_of_each_role_ranking;
    }

    public Double getHierarchy_count() {
        return hierarchy_count;
    }

    public void setHierarchy_count(Double hierarchy_count) {
        this.hierarchy_count = hierarchy_count;
    }

    public Double getPerformance_comments2018() {
        return performance_comments2018;
    }

    public void setPerformance_comments2018(Double performance_comments2018) {
        this.performance_comments2018 = performance_comments2018;
    }

    public Double getStakeholder_feedback() {
        return stakeholder_feedback;
    }

    public void setStakeholder_feedback(Double stakeholder_feedback) {
        this.stakeholder_feedback = stakeholder_feedback;
    }

    public Double getData_completeness() {
        return data_completeness;
    }

    public void setData_completeness(Double data_completeness) {
        this.data_completeness = data_completeness;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}