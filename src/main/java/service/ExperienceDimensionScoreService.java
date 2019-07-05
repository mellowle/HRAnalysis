package service;

import com.google.common.collect.Lists;
import dimensionRawData.DExperiences;
import dimensionScored.DExperiencesScored;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import util.RatingEnum;
import util.ScoreFunctionUtils;

import java.util.List;
import Constants.ExperiencesConstants.Constants;

public class ExperienceDimensionScoreService {

    public static List<DExperiencesScored> getExperienceScores() {
        List<DExperiencesScored> experiencesScoredList = Lists.newArrayList();
        //TODO get DExperiences from DB and replace
        List<DExperiences> DExperiencesList = Lists.newArrayList();

        for (DExperiences dexperience : DExperiencesList) {
            DExperiencesScored experiencesScored = new DExperiencesScored();
            experiencesScored.setWwid(dexperience.getWwid());
            experiencesScored.setIsMBA(ScoreFunctionUtils.isMBAScore(dexperience.getHighestDegreeReceived()));
            experiencesScored.setTeamSize(ScoreFunctionUtils.teamSizeScore(dexperience.getDirectReport()));
            experiencesScored.setPerformance2016(getPerformanceScore(dexperience.getOverallRating2016(),
                    dexperience.getOverallRating2017(), dexperience.getOverallRating2018()).getPerformance2016());
            experiencesScored.setPerformance2017(getPerformanceScore(dexperience.getOverallRating2016(),
                    dexperience.getOverallRating2017(), dexperience.getOverallRating2018()).getPerformance2017());
            experiencesScored.setPerformance2018(getPerformanceScore(dexperience.getOverallRating2016(),
                    dexperience.getOverallRating2017(), dexperience.getOverallRating2018()).getPerformance2018());
            double averageBonusIncrement2017 = getAverageAttributes(DExperiencesList).getAverageIncremental2017();
            double averageBonusIncrement2018 = getAverageAttributes(DExperiencesList).getAverageIncremental2018();
            experiencesScored.setBonusIncrement20162017(ScoreFunctionUtils.year2017BonusIncrementScore(
                    getBonusIncremental2017(dexperience.getBonus2016(), dexperience.getBonus2017()), averageBonusIncrement2017));
            experiencesScored.setBonusIncrement20172018(ScoreFunctionUtils.year2018BonusIncrementScore(
                    getBonusIncremental2018(dexperience.getBonus2017(),dexperience.getBase2018()), averageBonusIncrement2018));
            experiencesScored.setFunctionMovements(ScoreFunctionUtils.functionMovementScore(dexperience.getFunctionMovements()));
            experiencesScored.setLateralMovements(ScoreFunctionUtils.lateralMovementScore(dexperience.getLateralMovements()));
            experiencesScored.setPromotions(ScoreFunctionUtils.promotionScore(dexperience.getPromotions()));
            experiencesScored.setReginMovements(ScoreFunctionUtils.regionMovementScore(dexperience.getRegionMovdments()));
            experiencesScored.setSectorMovements(ScoreFunctionUtils.sectorMovementScore(dexperience.getSectorMovements()));
            experiencesScored.setCountryMovements(ScoreFunctionUtils.countryMovementScore(dexperience.getCountryMovements()));
            experiencesScored.setRoleNumberExternal(ScoreFunctionUtils.externalRoleNumberScore(dexperience.getNumberOfExternalRoles()));
            double averageExternalExperience = getAverageAttributes(DExperiencesList).getAverageExternalLengthOfService();
            experiencesScored.setLengthOfServiceExternal(ScoreFunctionUtils.externalLengthOfServiceScore(dexperience.getExternalLengthOfService(),averageExternalExperience));
            experiencesScored.setRoleNumberRanking(ScoreFunctionUtils.totalRoleNumberScore(dexperience.getTotalRoleNumber()));
            experiencesScored.setTotalWorkingYearRanking(ScoreFunctionUtils.totalWorkingYearsScore(dexperience.getTotalWorkingYears()));
            experiencesScored.setAverageDurationOfEachRoleRanking(ScoreFunctionUtils.averageDurationOnEachRoleScore(dexperience.getAverageTimeOfEachRole()));
            experiencesScored.setHierarchy2Alex(ScoreFunctionUtils.numberOfReportingToCEOScore(dexperience.getHierarchy2Alex()));

            //unstructured data
            experiencesScored.setPerformanceComments2018(dexperience.getPerformanceCommentsRating());
            experiencesScored.setStakeholderFeedback(dexperience.getStakeholderFeedback());

            experiencesScored.setResult(getResultScoreWithWeight(experiencesScored).getResultScore());
            experiencesScored.setDataCompleteness(getResultScoreWithWeight(experiencesScored).getDataCompleteness());

            experiencesScoredList.add(experiencesScored);
        }

        return experiencesScoredList;
    }

    private static double getBonusIncremental2017(double bonus2016, double bonus2017) {

        double incremental = bonus2017 - bonus2016;
        return incremental/bonus2016;
    }

    private static double getBonusIncremental2018(double bonus2017, double bonus2018) {

        double incremental = bonus2018 - bonus2017;
        return incremental/bonus2017;
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

            if (dexperiences.getExternalLengthOfService() != null) {
                totalExternalLengthOfService += dexperiences.getExternalLengthOfService();
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
            resultScore += experiencesScore.getIsMBA() * Constants.MBA_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getTeamSize() != null) {
            resultScore += experiencesScore.getTeamSize() * Constants.TEAM_SIZE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2016() != null) {
            resultScore += experiencesScore.getPerformance2016() * Constants.PERFORMANCE_2016;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2017() != null) {
            resultScore += experiencesScore.getPerformance2017() * Constants.PERFORMANCE_2017;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformance2018() != null) {
            resultScore += experiencesScore.getPerformance2018() * Constants.PERFORMANCE_2018;
            nonNullCounts++;
        }

        if (experiencesScore.getBonusIncrement20162017() != null) {
            resultScore += experiencesScore.getBonusIncrement20162017() * Constants.BONUS_2017_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getBonusIncrement20172018() != null) {
            resultScore += experiencesScore.getBonusIncrement20172018() * Constants.BONUS_2018_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getFunctionMovements() != null) {
            resultScore += experiencesScore.getFunctionMovements() * Constants.FUNCTION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getLateralMovements() != null) {
            resultScore += experiencesScore.getLateralMovements() * Constants.LATERAL_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPromotions() != null) {
            resultScore += experiencesScore.getPromotions() * Constants.PROMOTION_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getReginMovements() != null) {
            resultScore += experiencesScore.getReginMovements() * Constants.REGION_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getSectorMovements() != null) {
            resultScore += experiencesScore.getSectorMovements() * Constants.SECTOR_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getCountryMovements() != null) {
            resultScore += experiencesScore.getCountryMovements() * Constants.COUNTRY_MOVEMENT_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getRoleNumberExternal() != null) {
            resultScore += experiencesScore.getRoleNumberExternal() * Constants.EXTERNAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getLengthOfServiceExternal() != null) {
            resultScore += experiencesScore.getLengthOfServiceExternal() * Constants.EXTERNAL_LENGTH_SERVICE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getRoleNumberRanking() != null) {
            resultScore += experiencesScore.getRoleNumberRanking() * Constants.TOTAL_ROLE_NUMBER_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getTotalWorkingYearRanking() != null) {
            resultScore += experiencesScore.getTotalWorkingYearRanking() * Constants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getAverageDurationOfEachRoleRanking() != null) {
            resultScore += experiencesScore.getAverageDurationOfEachRoleRanking() * Constants.TOTAL_WORKING_YEARS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getHierarchy2Alex() != null) {
            resultScore += experiencesScore.getHierarchy2Alex() * Constants.REPORTING_LINE_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getPerformanceComments2018() != null) {
            resultScore += experiencesScore.getPerformanceComments2018() * Constants.PERFORMANCE_COMMENTS_WEIGHT;
            nonNullCounts++;
        }

        if (experiencesScore.getStakeholderFeedback() != null) {
            resultScore += experiencesScore.getStakeholderFeedback() * Constants.STAKEHOLDER_FEEDBACK_WEIGHT;
            nonNullCounts++;
        }

        resultAndCompleteness.setResultScore(resultScore / Constants.HIGHEST_SCORE_WITH_WEIGHT * 100);
        resultAndCompleteness.setDataCompleteness(nonNullCounts / Constants.TOTAL_FACTORS);

        return resultAndCompleteness;
    }

    private static PerformanceRating getPerformanceScore(String performance2016, String performance2017, String performance2018) {
        PerformanceRating performanceRating = new PerformanceRating();
        if (StringUtils.isEmpty(performance2016) && StringUtils.isEmpty(performance2017) && StringUtils.isEmpty(performance2018)) {
            return performanceRating;
        }

        performanceRating.setPerformance2016(RatingEnum.getRatingScore(performance2016));
        performanceRating.setPerformance2017(RatingEnum.getRatingScore(performance2017));
        performanceRating.setPerformance2018(RatingEnum.getRatingScore(performance2018));
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

class PerformanceRating {

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