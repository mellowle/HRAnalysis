package util;

import constants.Constants;
import util.RatingEnum;

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

    public static int teamSizeScore(int teamSize) {
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

    public static int functionMovementScore(int functionMovement) {

        if (functionMovement >= 5) {
            return 5;
        } else {
            return functionMovement;
        }
    }

    public static int lateralMovementScore(int lateralMovement) {
        if (lateralMovement >= 5) {
            return 5;
        } else {
            return lateralMovement;
        }

    }

    public static int promotionScore(int promotion) {
        if (promotion >= 5) {
            return 5;
        } else {
            return promotion;
        }
    }

    public static int regionMovementScore(int regionMovement) {
        if (regionMovement >= 5) {
            return 5;
        } else {
            return regionMovement;
        }

    }

    public static int sectorMovementScore(int sectorMovement) {
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

    public static int externalRoleNumberScore(int externalRoleNumber) {
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

    public static int externalLengthOfServiceScore(double externalLengthOfService, double averageExternalLengthOfService) {
        if (externalLengthOfService > averageExternalLengthOfService) {
            return 2;
        }

        return 0;
    }

    public static int totalRoleNumberScore(int totalRoleNumber) {
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

    public static int totalWorkingYearsScore(double totalWorkingYears) {
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

    public static int averageDurationOnEachRoleScore(double averageDurationOnEachRole) {
        if (averageDurationOnEachRole > 0 && averageDurationOnEachRole <= 5) {
            return 5;
        } else if (averageDurationOnEachRole > 5 && averageDurationOnEachRole <= 10) {
            return 3;
        } else if (averageDurationOnEachRole > 10) {
            return 1;
        }

        return 0;
    }

    public static int numberOfReportingToCEOScore(int numberOfReportingToCEO) {
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
