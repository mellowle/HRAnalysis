package service.scoreService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.ExperiencesConstants.RatingEnum;
import com.google.common.collect.Lists;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DExperiencesScored;
import entity.excelEntity.fixed.ExperiencesAverageAttributes;
import entity.excelEntity.fixed.PerformanceRatingScored;
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

        performanceRatingScored.setPerformance2016(RatingEnum.getRatingScore(performance2016));
        performanceRatingScored.setPerformance2017(RatingEnum.getRatingScore(performance2017));
        performanceRatingScored.setPerformance2018(RatingEnum.getRatingScore(performance2018));

        return performanceRatingScored;
    }

    private ExperiencesAverageAttributes getAverageAttributes(List<DExperiences> DExperiencesList) {

        ExperiencesAverageAttributes experiencesAverageAttributes = new ExperiencesAverageAttributes();

        double totalIncremental2017 = 0.0;
        int incremental2017Count = 0;
        double totalIncremental2018 = 0.0;
        int incremental2018Count = 0;
        double totalExternalLengthOfService = 0.0;
        int externalLengthOfServiceCount = 0;

        for (DExperiences dexperiences : DExperiencesList) {

            if (dexperiences.getBonus2016() != null && dexperiences.getBonus2017() != null && dexperiences.getBonus2016() != 0d) {
                double incremental2017 = (dexperiences.getBonus2017() - dexperiences.getBonus2016()) / dexperiences.getBonus2016();
                totalIncremental2017 += incremental2017;
                incremental2017Count++;
            }


            if (dexperiences.getBonus2017() != null && dexperiences.getBonus2018() != null && dexperiences.getBonus2017() != 0d) {
                double incremental2018 = (dexperiences.getBonus2018() - dexperiences.getBonus2017()) / dexperiences.getBonus2017();
                totalIncremental2018 += incremental2018;
                incremental2018Count++;
            }


            if (dexperiences.getExternal_length_of_service() != null) {
                totalExternalLengthOfService += Double.valueOf(dexperiences.getExternal_length_of_service());
                externalLengthOfServiceCount++;
            }


        }
        experiencesAverageAttributes.setAverageIncremental2017(totalIncremental2017 / incremental2017Count);
        experiencesAverageAttributes.setAverageIncremental2018(totalIncremental2018 / incremental2018Count);
        experiencesAverageAttributes.setAverageExternalLengthOfService(totalExternalLengthOfService / externalLengthOfServiceCount);
        return experiencesAverageAttributes;
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
            dExperiencesScored.setOverall_rating2016(dExperiences.getOverall_rating2016());
            dExperiencesScored.setOverall_rating2017(dExperiences.getOverall_rating2017());
            dExperiencesScored.setOverall_rating2018(dExperiences.getOverall_rating2018());
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



