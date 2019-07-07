package util;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.ExperiencesConstants.RatingEnum;

public class ScoreFunctionUtils {

    public static final int MBA_SCORE_5 = 5;
    public static final int MBA_SCORE_0 = 0;

    public static Integer isMBAScore(String highestDegreeReceived) {
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

    public static Integer teamSizeScore(Integer teamSize) {

        if (teamSize == null) {
            return null;
        }

        if (teamSize > 5) {
            return 5;
        }
        else if (teamSize > 3 && teamSize <= 5) {
            return 3;
        }
        else if (teamSize > 1 && teamSize <= 3) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static double year2016PerformanceScore(RatingEnum year2016Performance) {
        if (year2016Performance == null) {
            return 3;
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

    public static Integer year2017BonusIncrementScore(Double bonusIncrement2017, double averageBaseIncrement2017) {
        if (bonusIncrement2017 == null) {
            return null;
        }
        if (bonusIncrement2017 > averageBaseIncrement2017) {
            return 2;
        }

        return 0;
    }

    public static Integer year2018BonusIncrementScore(Double bonusIncrement2018, double averageBaseIncrement2018) {
        if (bonusIncrement2018 == null) {
            return null;
        }
        if (bonusIncrement2018 > averageBaseIncrement2018) {
            return 2;
        }

        return 0;
    }

    public static Integer functionMovementScore(Integer functionMovements) {

        if (functionMovements == null) {
            return null;
        }

        if (functionMovements >= 5) {
            return 5;
        }
        else {
            return functionMovements;
        }
    }

    public static Integer lateralMovementScore(Integer lateralMovements) {
        if (lateralMovements == null) {
            return null;
        }

        if (lateralMovements >= 5) {
            return 5;
        }
        else {
            return lateralMovements;
        }

    }

    public static Integer promotionScore(Integer promotions) {
        if (promotions == null) {
            return null;
        }

        if (promotions >= 5) {
            return 5;
        }
        else {
            return promotions;
        }
    }

    public static Integer regionMovementScore(Integer regionMovements) {
        if (regionMovements == null) {
            return null;
        }

        if (regionMovements >= 5) {
            return 5;
        }
        else {
            return regionMovements;
        }

    }

    public static Integer sectorMovementScore(Integer sectorMovements) {
        if (sectorMovements == null) {
            return null;
        }

        if (sectorMovements >= 5) {
            return 5;
        }
        else {
            return sectorMovements;
        }

    }

    public static Integer countryMovementScore(Integer countryMovements) {
        if (countryMovements == null) {
            return null;
        }

        if (countryMovements >= 5) {
            return 5;
        }
        else {
            return countryMovements;
        }

    }

    public static Integer externalRoleNumberScore(Integer externalRoleNumber) {
        if (externalRoleNumber == null) {
            return null;
        }

        if (externalRoleNumber >= 5) {
            return 5;
        }
        else {
            return externalRoleNumber;
        }

    }

    public static Integer externalLengthOfServiceScore(Double externalLengthOfService,
                                                       double averageExternalLengthOfService) {
        if (externalLengthOfService == null) {
            return null;
        }

        if (externalLengthOfService > averageExternalLengthOfService) {
            return 2;
        }

        return 0;
    }

    public static Integer totalRoleNumberScore(Integer totalRoleNumber) {

        if (totalRoleNumber == null) {
            return null;
        }

        if (totalRoleNumber <= 3) {
            return 0;
        }
        else if (totalRoleNumber > 7 && totalRoleNumber <= 9) {
            return 1;
        }
        else if (totalRoleNumber > 5 && totalRoleNumber <= 7) {
            return 3;
        }
        else if (totalRoleNumber > 3 && totalRoleNumber <= 5) {
            return 5;
        }

        return 0;
    }

    public static Integer totalWorkingYearsScore(Double totalWorkingYears) {
        if (totalWorkingYears == null) {
            return null;
        }

        if (totalWorkingYears > 30) {
            return 1;
        }
        else if (totalWorkingYears > 20 && totalWorkingYears <= 30) {
            return 2;
        }
        else if (totalWorkingYears > 10 && totalWorkingYears <= 20) {
            return 3;
        }
        else if (totalWorkingYears <= 10) {
            return 5;
        }

        return 0;
    }

    public static Integer averageDurationOnEachRoleScore(Double averageDurationOnEachRole) {
        if (averageDurationOnEachRole == null) {
            return null;
        }

        if (averageDurationOnEachRole > 0 && averageDurationOnEachRole <= 5) {
            return 5;
        }
        else if (averageDurationOnEachRole > 5 && averageDurationOnEachRole <= 10) {
            return 3;
        }
        else if (averageDurationOnEachRole > 10) {
            return 1;
        }

        return 0;
    }

    public static Integer numberOfReportingToCEOScore(Integer hierarchyCount) {
        if (hierarchyCount == null) {
            return null;
        }

        if (hierarchyCount >= 10) {
            return 1;
        }
        else if (hierarchyCount > 8 && hierarchyCount <= 9) {
            return 2;
        }
        else if (hierarchyCount > 6 && hierarchyCount <= 7) {
            return 4;
        }
        else if (hierarchyCount <= 5) {
            return 5;
        }

        return 0;
    }
}
