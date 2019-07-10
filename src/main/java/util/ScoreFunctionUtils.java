package util;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.ExperiencesConstants.RatingEnum;

public class ScoreFunctionUtils {

    public static final Double MBA_SCORE_5 = 5d;
    public static final Double MBA_SCORE_0 = 0d;

    public static Double isMBAScore(String highestDegreeReceived) {
        if (highestDegreeReceived == null) {
            return null;
        }
        if (ExperiencesConstants.MBA.equals(highestDegreeReceived)) {
            return MBA_SCORE_5;
        }
        else {
            return MBA_SCORE_0;
        }
    }

    public static Double teamSizeScore(Integer teamSize) {

        if (teamSize == null) {
            return null;
        }

        if (teamSize > 5) {
            return 5d;
        }
        else if (teamSize > 3 && teamSize <= 5) {
            return 3d;
        }
        else if (teamSize > 1 && teamSize <= 3) {
            return 1d;
        }
        else {
            return 0d;
        }
    }

    public static Double year2016PerformanceScore(RatingEnum year2016Performance) {
        if (year2016Performance == null) {
            return 3d;
        }
        else {
            return year2016Performance.getScore();
        }
    }

    public static double year2017PerformanceScore(RatingEnum year2017Performance) {
        if (year2017Performance == null) {
            return 3;
        }
        else {
            return year2017Performance.getScore();
        }
    }

    public static double year2018PerformanceScore(RatingEnum year2018Performance) {
        if (year2018Performance == null) {
            return 3;
        }
        else {
            return year2018Performance.getScore();
        }
    }

    public static Double year2017BonusIncrementScore(Double bonusIncrement2017, Double averageBaseIncrement2017) {
        if (bonusIncrement2017 == null) {
            return null;
        }
        if (bonusIncrement2017 > averageBaseIncrement2017) {
            return 2d;
        }

        return 0d;
    }

    public static Double year2018BonusIncrementScore(Double bonusIncrement2018, Double averageBaseIncrement2018) {
        if (bonusIncrement2018 == null) {
            return null;
        }
        if (bonusIncrement2018 > averageBaseIncrement2018) {
            return 2d;
        }

        return 0d;
    }

    public static Double functionMovementScore(Integer functionMovements) {

        if (functionMovements == null) {
            return null;
        }

        if (functionMovements >= 5) {
            return 5d;
        }
        else {
            return functionMovements.doubleValue();
        }
    }

    public static Double lateralMovementScore(Integer lateralMovements) {
        if (lateralMovements == null) {
            return null;
        }

        if (lateralMovements >= 5) {
            return 5d;
        }
        else {
            return lateralMovements.doubleValue();
        }

    }

    public static Double promotionScore(Integer promotions) {
        if (promotions == null) {
            return null;
        }

        if (promotions >= 5) {
            return 5d;
        }
        else {
            return promotions.doubleValue();
        }
    }

    public static Double regionMovementScore(Integer regionMovements) {
        if (regionMovements == null) {
            return null;
        }

        if (regionMovements >= 5) {
            return 5d;
        }
        else {
            return regionMovements.doubleValue();
        }

    }

    public static Double sectorMovementScore(Integer sectorMovements) {
        if (sectorMovements == null) {
            return null;
        }

        if (sectorMovements >= 5) {
            return 5d;
        }
        else {
            return sectorMovements.doubleValue();
        }

    }

    public static Double countryMovementScore(Integer countryMovements) {
        if (countryMovements == null) {
            return null;
        }

        if (countryMovements >= 5) {
            return 5d;
        }
        else {
            return countryMovements.doubleValue();
        }

    }

    public static Double externalRoleNumberScore(Integer externalRoleNumber) {
        if (externalRoleNumber == null) {
            return null;
        }

        if (externalRoleNumber >= 5) {
            return 5d;
        }
        else {
            return externalRoleNumber.doubleValue();
        }

    }

    public static Double externalLengthOfServiceScore(Double externalLengthOfService,
                                                       Double averageExternalLengthOfService) {
        if (externalLengthOfService == null) {
            return null;
        }

        if (externalLengthOfService > averageExternalLengthOfService) {
            return 2d;
        }

        return 0d;
    }

    public static Double totalRoleNumberScore(Integer totalRoleNumber) {

        if (totalRoleNumber == null) {
            return null;
        }

        if (totalRoleNumber <= 3) {
            return 0d;
        }
        else if (totalRoleNumber > 7 && totalRoleNumber <= 9) {
            return 1d;
        }
        else if (totalRoleNumber > 5 && totalRoleNumber <= 7) {
            return 3d;
        }
        else if (totalRoleNumber > 3 && totalRoleNumber <= 5) {
            return 5d;
        }

        return 0d;
    }

    public static Double totalWorkingYearsScore(Double totalWorkingYears) {
        if (totalWorkingYears == null) {
            return null;
        }

        if (totalWorkingYears > 30) {
            return 1d;
        }
        else if (totalWorkingYears > 20 && totalWorkingYears <= 30) {
            return 2d;
        }
        else if (totalWorkingYears > 10 && totalWorkingYears <= 20) {
            return 3d;
        }
        else if (totalWorkingYears <= 10) {
            return 5d;
        }

        return 0d;
    }

    public static Double averageDurationOnEachRoleScore(Double averageDurationOnEachRole) {
        if (averageDurationOnEachRole == null) {
            return null;
        }

        if (averageDurationOnEachRole > 0 && averageDurationOnEachRole <= 5) {
            return 5d;
        }
        else if (averageDurationOnEachRole > 5 && averageDurationOnEachRole <= 10) {
            return 3d;
        }
        else if (averageDurationOnEachRole > 10) {
            return 1d;
        }

        return 0d;
    }

    public static Double numberOfReportingToCEOScore(Integer hierarchyCount) {
        if (hierarchyCount == null) {
            return null;
        }

        if (hierarchyCount >= 10) {
            return 1d;
        }
        else if (hierarchyCount > 8 && hierarchyCount <= 9) {
            return 2d;
        }
        else if (hierarchyCount > 6 && hierarchyCount <= 7) {
            return 4d;
        }
        else if (hierarchyCount <= 5) {
            return 5d;
        }

        return 0d;
    }

    public static Double getBonusIncremental(Double bonusPrevious, Double bonusNow) {
        if (bonusPrevious != null && bonusNow != null) {
            double incremental = bonusNow - bonusPrevious;
            return incremental / bonusPrevious;
        }

        return null;
    }
}
