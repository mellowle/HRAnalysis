package service.scoreService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import dao.Mapper;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DExperiencesScored;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import util.DataConnection;
import Constants.ExperiencesConstants.RatingEnum;
import util.ScoreFunctionUtils;

import java.io.IOException;
import java.util.List;

public class ExperienceDimensionScoreService {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    //public static String tableName = DriversColMapping.TABLE_NAME_SCORED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        getExperienceScores();
    }

    public static List<DExperiencesScored> getExperienceScores() {
        List<DExperiencesScored> experiencesScoredList = Lists.newArrayList();
        List<DExperiences> dExperiencesList = mapper.getAllExperiences();

        for (DExperiences dExperience : dExperiencesList) {
            DExperiencesScored experiencesScored = new DExperiencesScored();
            experiencesScored.setWwid(dExperience.getWwid());
            experiencesScored.setIsMBA(ScoreFunctionUtils.isMBAScore(dExperience.getHighest_degree_received()));
            experiencesScored.setTeamSize(ScoreFunctionUtils.teamSizeScore(dExperience.getDirect_report()));

            PerformanceRatingScored performanceRatingScored = getPerformanceScore(dExperience.getOverall_rating2016(),
                    dExperience.getOverall_rating2017(), dExperience.getOverall_rating2018());
            if(performanceRatingScored == null){
                experiencesScored.setPerformance2016(null);
                experiencesScored.setPerformance2017(null);
                experiencesScored.setPerformance2018(null);
            }else{
                experiencesScored.setPerformance2016(performanceRatingScored.getPerformance2016());
                experiencesScored.setPerformance2017(performanceRatingScored.getPerformance2017());
                experiencesScored.setPerformance2018(performanceRatingScored.getPerformance2018());
            }

            double averageBonusIncrement2017 = getAverageAttributes(dExperiencesList).getAverageIncremental2017();
            double averageBonusIncrement2018 = getAverageAttributes(dExperiencesList).getAverageIncremental2018();

            experiencesScored.setBonusIncrement20162017(ScoreFunctionUtils.year2017BonusIncrementScore(
                    getBonusIncremental2017(dExperience.getBonus2016(), dExperience.getBonus2017()), averageBonusIncrement2017));
            experiencesScored.setBonusIncrement20172018(ScoreFunctionUtils.year2018BonusIncrementScore(
                    getBonusIncremental2018(dExperience.getBonus2017(),dExperience.getBonus2018()), averageBonusIncrement2018));

            experiencesScored.setFunctionMovements(ScoreFunctionUtils.functionMovementScore(dExperience.getFunction_movements()));
            experiencesScored.setLateralMovements(ScoreFunctionUtils.lateralMovementScore(dExperience.getLateral_movements()));
            experiencesScored.setPromotions(ScoreFunctionUtils.promotionScore(dExperience.getPromotions()));
            experiencesScored.setReginMovements(ScoreFunctionUtils.regionMovementScore(dExperience.getRegion_movements()));
            experiencesScored.setSectorMovements(ScoreFunctionUtils.sectorMovementScore(dExperience.getSector_movements()));
            experiencesScored.setCountryMovements(ScoreFunctionUtils.countryMovementScore(dExperience.getCountry_movements()));

            experiencesScored.setRoleNumberExternal(ScoreFunctionUtils.externalRoleNumberScore(dExperience.getExternal_roles()));

            double averageExternalExperience = getAverageAttributes(dExperiencesList).getAverageExternalLengthOfService();
            experiencesScored.setLengthOfServiceExternal(ScoreFunctionUtils.externalLengthOfServiceScore(dExperience.getExternal_length_of_service(),averageExternalExperience));

            experiencesScored.setRoleNumberRanking(ScoreFunctionUtils.totalRoleNumberScore(dExperience.getTotal_roles()));
            experiencesScored.setTotalWorkingYearRanking(ScoreFunctionUtils.totalWorkingYearsScore(dExperience.getTotal_working_year()));
            experiencesScored.setAverageDurationOfEachRoleRanking(ScoreFunctionUtils.averageDurationOnEachRoleScore(dExperience.getAverage_time_of_external_role()));
            experiencesScored.setHierarchy2Alex(ScoreFunctionUtils.numberOfReportingToCEOScore(dExperience.getHierarchy_count()));

            //unstructured data
            if(dExperience.getPerformance_comments() !=null){
                experiencesScored.setPerformanceComments2018(dExperience.getPerformance_comments());
            }else{
                experiencesScored.setPerformanceComments2018(null);
            }
            if(dExperience.getFeedback() !=null){
                experiencesScored.setStakeholderFeedback(dExperience.getFeedback());
            }else{
                experiencesScored.setStakeholderFeedback(null);
            }


            experiencesScored.setResult(getResultScoreWithWeight(experiencesScored).getResultScore());
            experiencesScored.setDataCompleteness(getResultScoreWithWeight(experiencesScored).getDataCompleteness());

            experiencesScoredList.add(experiencesScored);
        }

        return experiencesScoredList;
    }

    private static Double getBonusIncremental2017(Double bonus2016, Double bonus2017) {
        if (bonus2016 != null && bonus2017!=null) {
            double incremental = bonus2017 - bonus2016;
            return incremental/bonus2016;
        }

        return null;
    }

    private static Double getBonusIncremental2018(Double bonus2017, Double bonus2018) {
        if (bonus2017 !=null && bonus2018 != null){
            double incremental = bonus2018 - bonus2017;
            return incremental/bonus2017;
        }

        return null;

    }

    private static AverageAttributes getAverageAttributes(List<DExperiences> DExperiencesList) {

        AverageAttributes averageAttributes = new AverageAttributes();

        double totalIncremental2017 = 0.0;
        int incremental2017Count = 0;
        double totalIncremental2018 = 0.0;
        int incremental2018Count = 0;
        double totalExternalLengthOfService = 0.0;
        int externalLengthOfServiceCount = 0;

        for (DExperiences dexperiences : DExperiencesList) {

            if (dexperiences.getBonus2016() != null && dexperiences.getBonus2017()!= null) {
                double incremental2017 = (dexperiences.getBonus2017() - dexperiences.getBonus2016()) / dexperiences.getBonus2016();
                totalIncremental2017 += incremental2017;
                incremental2017Count++;
            }

            averageAttributes.setAverageIncremental2017(totalIncremental2017/incremental2017Count);

            if (dexperiences.getBonus2017() != null && dexperiences.getBonus2018() != null) {
                double incremental2018 = (dexperiences.getBonus2018() - dexperiences.getBonus2017()) / dexperiences.getBonus2017();
                totalIncremental2018 += incremental2018;
                incremental2017Count++;
            }

            averageAttributes.setAverageIncremental2018(totalIncremental2018/incremental2018Count);

            if (dexperiences.getExternal_length_of_service() != null) {
                totalExternalLengthOfService += Double.valueOf(dexperiences.getExternal_length_of_service());
                externalLengthOfServiceCount++;
            }

            averageAttributes.setAverageExternalLengthOfService(totalExternalLengthOfService/externalLengthOfServiceCount);

        }
        return averageAttributes;
    }

    private static ResultAndCompleteness getResultScoreWithWeight(DExperiencesScored experiencesScore) {
        ResultAndCompleteness resultAndCompleteness = new ResultAndCompleteness();

        double resultScore = 0.0;
        int nonNullCounts = 0;
        if (experiencesScore.getIsMBA() != null) {
            resultScore += experiencesScore.getIsMBA() * ExperiencesConstants.MBA_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getTeamSize() != null) {
            resultScore += experiencesScore.getTeamSize() * ExperiencesConstants.TEAM_SIZE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2016() != null) {
            resultScore += experiencesScore.getPerformance2016() * ExperiencesConstants.PERFORMANCE_2016;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2017() != null) {
            resultScore += experiencesScore.getPerformance2017() * ExperiencesConstants.PERFORMANCE_2017;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2018() != null) {
            resultScore += experiencesScore.getPerformance2018() * ExperiencesConstants.PERFORMANCE_2018;
            nonNullCounts++;
        }

        if (experiencesScore.getBonusIncrement20162017() != null) {
            resultScore += experiencesScore.getBonusIncrement20162017() * ExperiencesConstants.BONUS_2017_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getBonusIncrement20172018() != null) {
            resultScore += experiencesScore.getBonusIncrement20172018() * ExperiencesConstants.BONUS_2018_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getFunctionMovements() != null) {
            resultScore += experiencesScore.getFunctionMovements() * ExperiencesConstants.FUNCTION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getLateralMovements() != null) {
            resultScore += experiencesScore.getLateralMovements() * ExperiencesConstants.LATERAL_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPromotions() != null) {
            resultScore += experiencesScore.getPromotions() * ExperiencesConstants.PROMOTION_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getReginMovements() != null) {
            resultScore += experiencesScore.getReginMovements() * ExperiencesConstants.REGION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getSectorMovements() != null) {
            resultScore += experiencesScore.getSectorMovements() * ExperiencesConstants.SECTOR_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getCountryMovements() != null) {
            resultScore += experiencesScore.getCountryMovements() * ExperiencesConstants.COUNTRY_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getRoleNumberExternal() != null) {
            resultScore += experiencesScore.getRoleNumberExternal() * ExperiencesConstants.EXTERNAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getLengthOfServiceExternal() != null) {
            resultScore += experiencesScore.getLengthOfServiceExternal() * ExperiencesConstants.EXTERNAL_LENGTH_SERVICE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getRoleNumberRanking() != null) {
            resultScore += experiencesScore.getRoleNumberRanking() * ExperiencesConstants.TOTAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getTotalWorkingYearRanking() != null) {
            resultScore += experiencesScore.getTotalWorkingYearRanking() * ExperiencesConstants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getAverageDurationOfEachRoleRanking() != null) {
            resultScore += experiencesScore.getAverageDurationOfEachRoleRanking() * ExperiencesConstants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getHierarchy2Alex() != null) {
            resultScore += experiencesScore.getHierarchy2Alex() * ExperiencesConstants.REPORTING_LINE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformanceComments2018() != null) {
            resultScore += experiencesScore.getPerformanceComments2018() * ExperiencesConstants.PERFORMANCE_COMMENTS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getStakeholderFeedback() != null) {
            resultScore += experiencesScore.getStakeholderFeedback() * ExperiencesConstants.STAKEHOLDER_FEEDBACK_WEIGHT;
            nonNullCounts++;
        }

        resultAndCompleteness.setResultScore(resultScore / ExperiencesConstants.HIGHEST_SCORE_WITH_WEIGHT * 100);
        resultAndCompleteness.setDataCompleteness(nonNullCounts / ExperiencesConstants.TOTAL_FACTORS);

        return resultAndCompleteness;
    }

    private static PerformanceRatingScored getPerformanceScore(String performance2016, String performance2017, String performance2018) {
        PerformanceRatingScored performanceRatingScored = new PerformanceRatingScored();
        if((performance2016 == null && performance2017 == null && performance2018 == null)){
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

class ResultAndCompleteness {
    private double resultScore;
    private double dataCompleteness;

    public double getResultScore() {
        return resultScore;
    }

    public void setResultScore(double resultScore) {
        this.resultScore = resultScore;
    }

    public double getDataCompleteness() {
        return dataCompleteness;
    }

    public void setDataCompleteness(double dataCompleteness) {
        this.dataCompleteness = dataCompleteness;
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