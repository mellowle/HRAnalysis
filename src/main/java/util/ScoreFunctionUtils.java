package util;

import Constants.ExperiencesConstants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

public class ScoreFunctionUtils {

    public static final int MBA_SCORE_5 = 5;
    public static final int MBA_SCORE_0 = 0;

    public static int isMBAScore(String highestDegreeReceived) {
        if (Constants.MBA.equals(highestDegreeReceived)) {
            return MBA_SCORE_5;
        } else {
            return MBA_SCORE_0;
        }

    }

    public static int teamSizeScore(String teamSize) {

        if (teamSize == null) {
            return 0;
        }

        double teamSizeInt = Double.valueOf(teamSize);
        if (teamSizeInt > 5) {
            return 5;
        } else if (teamSizeInt > 3 && teamSizeInt <= 5) {
            return 3;
        } else if (teamSizeInt > 1 && teamSizeInt <= 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double year2016PerformanceScore(RatingEnum year2016Performance) {
        if (year2016Performance == null) {
            return 3;
        } else {
            return year2016Performance.getScore();
        }
    }

    public static double year2017PerformanceScore(RatingEnum year2017Performance) {
        if (year2017Performance == null) {
            return 3;
        } else {
            return year2017Performance.getScore();
        }
    }

    public static double year2018PerformanceScore(RatingEnum year2018Performance) {
        if (year2018Performance == null) {
            return 3;
        } else {
            return year2018Performance.getScore();
        }
    }

    public static int year2017BonusIncrementScore(double bonusIncrement2017, double averageBaseIncrement2017) {
        if (bonusIncrement2017 > averageBaseIncrement2017) {
            return 2;
        }

        return 0;
    }

    public static int year2018BonusIncrementScore(double bonusIncrement2018, double averageBaseIncrement2018) {
        if (bonusIncrement2018 > averageBaseIncrement2018) {
            return 2;
        }

        return 0;
    }

    public static int functionMovementScore(Integer functionMovement) {

        if (functionMovement == null) {
            return 0;
        }

        if (functionMovement >= 5) {
            return 5;
        } else {
            return functionMovement;
        }
    }

    public static int lateralMovementScore(Integer lateralMovement) {
        if (lateralMovement == null) {
            return 0;
        }

        if (lateralMovement >= 5) {
            return 5;
        } else {
            return lateralMovement;
        }

    }

    public static int promotionScore(Integer promotion) {
        if (promotion == null) {
            return 0;
        }

        if (promotion >= 5) {
            return 5;
        } else {
            return promotion;
        }
    }

    public static int regionMovementScore(Integer regionMovement) {
        if (regionMovement == null) {
            return 0;
        }

        //TODO fix 0 to null
        if (regionMovement == null) {
            return 0;
        }
        if (regionMovement >= 5) {
            return 5;
        } else {
            return regionMovement;
        }

    }

    public static int sectorMovementScore(Integer sectorMovement) {
        if (sectorMovement == null) {
            return 0;
        }

        if (sectorMovement >= 5) {
            return 5;
        } else {
            return sectorMovement;
        }

    }

    public static int countryMovementScore(int countryMovement) {
        if (countryMovement >= 5) {
            return 5;
        } else {
            return countryMovement;
        }

    }

    public static int externalRoleNumberScore(String externalRoleNumber) {
        //TODO fix 0 to null
        if (StringUtils.isEmpty(externalRoleNumber) || externalRoleNumber == null) {
            return 0;
        }
        double externalRoleNumberInt = Double.valueOf(externalRoleNumber);
        if (externalRoleNumberInt >= 5) {
            return 5;
        } else if (externalRoleNumberInt == 4) {
            return 4;
        } else if (externalRoleNumberInt == 3) {
            return 3;
        } else if (externalRoleNumberInt == 2) {
            return 2;
        } else if (externalRoleNumberInt == 1) {
            return 1;
        }

        return 0;
    }

    public static int externalLengthOfServiceScore(String externalLengthOfService, Double averageExternalLengthOfService) {
        if (externalLengthOfService == null) {
            return 0;
        }

        double exterLengthOfServiceD = Double.valueOf(externalLengthOfService);

        if (exterLengthOfServiceD > averageExternalLengthOfService) {
            return 2;
        }

        return 0;
    }

    public static int totalRoleNumberScore(String totalRoleNumber) {

        if (totalRoleNumber == null || StringUtils.isEmpty(totalRoleNumber)) {
            return 0;
        }
        double totalRoleNumberi = Double.valueOf(totalRoleNumber);

        if (totalRoleNumberi <= 3) {
            return 0;
        } else if (totalRoleNumberi > 7 && totalRoleNumberi <= 9) {
            return 1;
        } else if (totalRoleNumberi > 5 && totalRoleNumberi <= 7) {
            return 3;
        } else if (totalRoleNumberi > 3 && totalRoleNumberi <= 5) {
            return 5;
        }

        return 0;
    }

    public static int totalWorkingYearsScore(String totalWorkingYears) {
        if (StringUtils.isEmpty(totalWorkingYears) || totalWorkingYears == null) {
            return 0;
        }
        double totalWokYers = Double.valueOf(totalWorkingYears);

        if (totalWokYers > 30) {
            return 1;
        } else if (totalWokYers > 20 && totalWokYers <= 30) {
            return 2;
        } else if (totalWokYers > 10 && totalWokYers <= 20) {
            return 3;
        } else if (totalWokYers <= 10) {
            return 5;
        }

        return 0;
    }

    public static int averageDurationOnEachRoleScore(String averageDurationOnEachRole) {
        if (averageDurationOnEachRole == null && StringUtils.isEmpty(averageDurationOnEachRole)){
            return 0;
        }

        double averageDuration = Double.valueOf(averageDurationOnEachRole);

        if (averageDuration > 0 && averageDuration <= 5) {
            return 5;
        } else if (averageDuration > 5 && averageDuration <= 10) {
            return 3;
        } else if (averageDuration > 10) {
            return 1;
        }

        return 0;
    }

    public static int numberOfReportingToCEOScore(String numberOfReportingToCEO) {
        if (StringUtils.isEmpty(numberOfReportingToCEO) || numberOfReportingToCEO == null) {
            return 0;
        }

        double hierarchyCount = Double.valueOf(numberOfReportingToCEO);

        if (hierarchyCount >= 10) {
            return 1;
        } else if (hierarchyCount > 8 && hierarchyCount <= 9) {
            return 2;
        } else if (hierarchyCount >6 && hierarchyCount <= 7) {
            return 4;
        } else if (hierarchyCount <= 5) {
            return 5;
        }

        return 0;
    }
}
