package service.scoreService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.ExperiencesConstants.RatingEnum;
import com.google.common.collect.Lists;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DExperiencesScored;
import org.apache.commons.lang3.StringUtils;
import util.ScoreFunctionUtils;
import util.TableUtils;

import java.util.List;

public class ExperienceDimensionScoreService extends AbstractScoreService {

    public ExperienceDimensionScoreService() {
        this.TABLE_NAME_SCORED = ExperiencesConstants.TABLE_NAME;
        this.CLAZZ = DExperiences.class;
    }

    public static void main(String... args) throws Exception {
        ExperienceDimensionScoreService c = new ExperienceDimensionScoreService();
        List<DExperiencesScored> results = c.getScoredResults();
        System.out.println(results.size());
        c.resetTableNameAndClazz(ExperiencesConstants.TABLE_NAME_SCORED, DExperiencesScored.class);
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    private static PerformanceRatingScored getPerformanceScore(String performance2016, String performance2017,
                                                               String performance2018) {
        PerformanceRatingScored performanceRatingScored = new PerformanceRatingScored();
        if ((performance2016 == null && performance2017 == null && performance2018 == null)) {
            return null;
        }
        if (StringUtils.isEmpty(performance2016) && StringUtils.isEmpty(performance2017) && StringUtils.isEmpty(performance2018)) {
            return performanceRatingScored;
        }

        performanceRatingScored.setPerformance2016(RatingEnum.getRatingScore(performance2016));
        performanceRatingScored.setPerformance2017(RatingEnum.getRatingScore(performance2017));
        performanceRatingScored.setPerformance2018(RatingEnum.getRatingScore(performance2018));

        return performanceRatingScored;
    }

    private AverageAttributes getAverageAttributes(List<DExperiences> DExperiencesList) {

        AverageAttributes averageAttributes = new AverageAttributes();

        double totalIncremental2017 = 0.0;
        int incremental2017Count = 0;
        double totalIncremental2018 = 0.0;
        int incremental2018Count = 0;
        double totalExternalLengthOfService = 0.0;
        int externalLengthOfServiceCount = 0;

        for (DExperiences dexperiences : DExperiencesList) {

            if (dexperiences.getBonus2016() != null && dexperiences.getBonus2017() != null) {
                double incremental2017 = (dexperiences.getBonus2017() - dexperiences.getBonus2016()) / dexperiences.getBonus2016();
                totalIncremental2017 += incremental2017;
                incremental2017Count++;
            }

            averageAttributes.setAverageIncremental2017(totalIncremental2017 / incremental2017Count);

            if (dexperiences.getBonus2017() != null && dexperiences.getBonus2018() != null) {
                double incremental2018 = (dexperiences.getBonus2018() - dexperiences.getBonus2017()) / dexperiences.getBonus2017();
                totalIncremental2018 += incremental2018;
                incremental2017Count++;
            }

            averageAttributes.setAverageIncremental2018(totalIncremental2018 / incremental2018Count);

            if (dexperiences.getExternal_length_of_service() != null) {
                totalExternalLengthOfService += Double.valueOf(dexperiences.getExternal_length_of_service());
                externalLengthOfServiceCount++;
            }

            averageAttributes.setAverageExternalLengthOfService(totalExternalLengthOfService / externalLengthOfServiceCount);

        }
        return averageAttributes;
    }

    public List<DExperiences> getAllDExperiences() throws Exception {
        List<DExperiences> results = TableUtils.getAllRecords(DExperiences.class);
        System.out.println(results.size());
        initTable();
        insertRecords(results);
        System.err.println("done");
        return results;
    }

    public List<DExperiencesScored> getScoredResults() throws Exception {
        List<DExperiencesScored> scoredResults = Lists.newArrayList();

        List<DExperiences> results = getAllDExperiences();

        for (DExperiences dExperiences : results) {
            DExperiencesScored dExperiencesScored = new DExperiencesScored();
            dExperiencesScored.setWwid(dExperiences.getWwid());
            dExperiencesScored.setEmployee_pay_grade(dExperiences.getEmployee_pay_grade());
            dExperiencesScored.setJob_function(dExperiences.getJob_function());
            dExperiencesScored.setSector(dExperiences.getSector());
            dExperiencesScored.setLength_of_service_in_years(dExperiences.getLength_of_service_in_years());
//            dExperiencesScored.setIs_mba(ScoreFunctionUtils.isMBAScore(dExperiences.getHighest_degree_received()));
            dExperiencesScored.setTeam_size(ScoreFunctionUtils.teamSizeScore(dExperiences.getDirect_report()));

            PerformanceRatingScored performanceRatingScored = getPerformanceScore(dExperiences.getOverall_rating2016(),
                    dExperiences.getOverall_rating2017(), dExperiences.getOverall_rating2018());
            if (performanceRatingScored == null) {
                dExperiencesScored.setPerformance_rating2016(null);
                dExperiencesScored.setPerformance_rating2017(null);
                dExperiencesScored.setPerformance_rating2018(null);
            }
            else {
                dExperiencesScored.setPerformance_rating2016(performanceRatingScored.getPerformance2016());
                dExperiencesScored.setPerformance_rating2017(performanceRatingScored.getPerformance2017());
                dExperiencesScored.setPerformance_rating2018(performanceRatingScored.getPerformance2018());
            }

            double averageBonusIncrement2017 = getAverageAttributes(results).getAverageIncremental2017();
            double averageBonusIncrement2018 = getAverageAttributes(results).getAverageIncremental2018();

            dExperiencesScored.setBonus_increment20162017(ScoreFunctionUtils.year2017BonusIncrementScore(
                    ScoreFunctionUtils.getBonusIncremental(dExperiences.getBonus2016(), dExperiences.getBonus2017()), averageBonusIncrement2017));
            dExperiencesScored.setBonus_increment20172018(ScoreFunctionUtils.year2018BonusIncrementScore(
                    ScoreFunctionUtils.getBonusIncremental(dExperiences.getBonus2017(), dExperiences.getBonus2018()), averageBonusIncrement2018));

            dExperiencesScored.setFunction_movements(ScoreFunctionUtils.functionMovementScore(dExperiences.getFunction_movements()));
            dExperiencesScored.setLateral_movements(ScoreFunctionUtils.lateralMovementScore(dExperiences.getLateral_movements()));
            dExperiencesScored.setPromotions(ScoreFunctionUtils.promotionScore(dExperiences.getPromotions()));
            dExperiencesScored.setRegion_movements(ScoreFunctionUtils.regionMovementScore(dExperiences.getRegion_movements()));
            dExperiencesScored.setSector_movements(ScoreFunctionUtils.sectorMovementScore(dExperiences.getSector_movements()));
            dExperiencesScored.setCountry_movements(ScoreFunctionUtils.countryMovementScore(dExperiences.getCountry_movements()));

            dExperiencesScored.setExternal_roles(ScoreFunctionUtils.externalRoleNumberScore(dExperiences.getExternal_roles()));

            double averageExternalExperience = getAverageAttributes(results).getAverageExternalLengthOfService();
            dExperiencesScored.setExternal_length_of_service(ScoreFunctionUtils.externalLengthOfServiceScore(dExperiences.getExternal_length_of_service(), averageExternalExperience));

            dExperiencesScored.setRole_number_ranking(ScoreFunctionUtils.totalRoleNumberScore(dExperiences.getTotal_roles()));
            dExperiencesScored.setTotal_working_year_ranking(ScoreFunctionUtils.totalWorkingYearsScore(dExperiences.getTotal_working_year()));
            dExperiencesScored.setAverage_time_of_each_role_ranking(ScoreFunctionUtils.averageDurationOnEachRoleScore(dExperiences.getAverage_time_of_external_role()));

            dExperiencesScored.setHierarchy_count(ScoreFunctionUtils.numberOfReportingToCEOScore(dExperiences.getHierarchy_count()));

            //unstructured data
            dExperiencesScored.setPerformance_comments2018(dExperiences.getPerformance_comments2018());
            dExperiencesScored.setStakeholder_feedback(dExperiences.getStakeholder_feedback());


            dExperiencesScored.sumUp();

            scoredResults.add(dExperiencesScored);
        }

        return scoredResults;
    }

    public void resetTableNameAndClazz(String tableName, Class clazz) {
        this.TABLE_NAME_SCORED = tableName;
        this.CLAZZ = clazz;
    }
}

class AverageAttributes {
    private double averageIncremental2017;
    private double averageIncremental2018;
    private double averageExternalLengthOfService;

    public double getAverageExternalLengthOfService() {
        return averageExternalLengthOfService;
    }

    public void setAverageExternalLengthOfService(double averageExternalLengthOfService) {
        this.averageExternalLengthOfService = averageExternalLengthOfService;
    }

    public double getAverageIncremental2017() {
        return averageIncremental2017;
    }

    public void setAverageIncremental2017(double averageIncremental2017) {
        this.averageIncremental2017 = averageIncremental2017;
    }

    public double getAverageIncremental2018() {
        return averageIncremental2018;
    }

    public void setAverageIncremental2018(double averageIncremental2018) {
        this.averageIncremental2018 = averageIncremental2018;
    }

}

class PerformanceRatingScored {

    private Double performance2016;
    private Double performance2017;
    private Double performance2018;

    public Double getPerformance2016() {
        return performance2016;
    }

    public void setPerformance2016(Double performance2016) {
        this.performance2016 = performance2016;
    }

    public Double getPerformance2017() {
        return performance2017;
    }

    public void setPerformance2017(Double performance2017) {
        this.performance2017 = performance2017;
    }

    public Double getPerformance2018() {
        return performance2018;
    }

    public void setPerformance2018(Double performance2018) {
        this.performance2018 = performance2018;
    }
}