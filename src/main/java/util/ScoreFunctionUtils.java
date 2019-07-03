package service;

import constants.Constants;
import constants.RatingEnum;

public class ScoreFunctionUtils {

    public static final double MBA_SCORE_5 = 5;
    public static final double MBA_SCORE_0 = 0;

    public static double isMBAScore(String highestDegreeReceived) {
        if (Constants.MBA.equals(highestDegreeReceived)) {
            return MBA_SCORE_5;
        } else {
            return MBA_SCORE_0;
        }

    }

    public static double teamSizeScore(int teamSize) {
        if (teamSize > 5) {
            return 5;
        } else if (teamSize > 3 && teamSize <= 5) {
            return 3;
        } else if (teamSize > 1 && teamSize <= 3) {
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

    public static double year2017BaseIncrementScore(double baseIncrement2017, double averageBaseIncrement2017) {
        if (baseIncrement2017 > averageBaseIncrement2017) {
            return 2;
        }

        return 0;
    }

    public static double year2018BaseIncrementScore(double baseIncrement2018, double averageBaseIncrement2018) {
        if (baseIncrement2018 > averageBaseIncrement2018) {
            return 2;
        }

        return 0;
    }

    public static double functionMovementScore(String functionMovement) {
        if (Constants.YES.equals(functionMovement)) {
            return 1;
        }

        return 0;
    }

    public static double lateralMovementScore(String lateralMovement) {
        if (Constants.YES.equals(lateralMovement)) {
            return 1;
        }

        return 0;
    }

    public static double promotionScore(String promotion) {
        if (Constants.YES.equals(promotion)) {
            return 1;
        }

        return 0;
    }

    public static double regionMovementScore(String regionMovement) {
        if (Constants.YES.equals(regionMovement)) {
            return 1;
        }

        return 0;
    }

    public static double sectorMovementScore(String sectorMovement) {
        if (Constants.YES.equals(sectorMovement)) {
            return 1;
        }

        return 0;
    }

    public static double countryMovementScore(String countryMovement) {
        if (Constants.YES.equals(countryMovement)) {
            return 1;
        }

        return 0;
    }

    public static double externalRoleNumberScore(int externalRoleNumber) {
        if (externalRoleNumber >= 5) {
            return 5;
        } else if (externalRoleNumber == 4) {
            return 4;
        } else if (externalRoleNumber == 3) {
            return 3;
        } else if (externalRoleNumber == 2) {
            return 2;
        } else if (externalRoleNumber == 1) {
            return 1;
        }

        return 0;
    }

    public static double externalLengthOfServiceScore(double externalLengthOfService, double averageExternalLengthOfService) {
        if (externalLengthOfService > averageExternalLengthOfService) {
            return 2;
        }

        return 0;
    }

    public static double totalRoleNumberScore(int totalRoleNumber) {
        if (totalRoleNumber <= 3) {
            return 0;
        } else if (totalRoleNumber > 7 && totalRoleNumber <= 9) {
            return 1;
        } else if (totalRoleNumber > 5 && totalRoleNumber <= 7) {
            return 3;
        } else if (totalRoleNumber > 3 && totalRoleNumber <= 5) {
            return 5;
        }

        return 0;
    }

    public static double totalWorkingYearsScore(double totalWorkingYears) {
        if (totalWorkingYears > 30) {
            return 1;
        } else if (totalWorkingYears > 20 && totalWorkingYears <= 30) {
            return 2;
        } else if (totalWorkingYears > 10 && totalWorkingYears <= 20) {
            return 3;
        } else if (totalWorkingYears <= 10) {
            return 5;
        }

        return 0;
    }

    public static double averageDurationOnEachRoleScore(double averageDurationOnEachRole) {
        if (averageDurationOnEachRole > 0 && averageDurationOnEachRole <= 5) {
            return 5;
        } else if (averageDurationOnEachRole > 5 && averageDurationOnEachRole <= 10) {
            return 3;
        } else if (averageDurationOnEachRole > 10) {
            return 1;
        }

        return 0;
    }

    public static double numberOfReportingToCEOScore(int numberOfReportingToCEO) {
        if (numberOfReportingToCEO >= 10) {
            return 1;
        } else if (numberOfReportingToCEO > 8 && numberOfReportingToCEO <= 9) {
            return 2;
        } else if (numberOfReportingToCEO >6 && numberOfReportingToCEO <= 7) {
            return 4;
        } else if (numberOfReportingToCEO <= 5) {
            return 5;
        }

        return 0;
    }
}
