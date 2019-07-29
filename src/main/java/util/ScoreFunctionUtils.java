package util;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.ExperiencesConstants.RatingEnum;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DExperiencesScored;
import entity.excelEntity.fixed.ExperiencesAverageAttributes;

import java.util.List;

public class ScoreFunctionUtils {

    //    public static final Double MBA_SCORE_5 = 5d;
    //    public static final Double MBA_SCORE_0 = 0d;
    //
    //    public static Double isMBAScore(String highestDegreeReceived) {
    //        if (highestDegreeReceived == null) {
    //            return null;
    //        }
    //        if (ExperiencesConstants.MBA.equals(highestDegreeReceived)) {
    //            return MBA_SCORE_5;
    //        }
    //        else {
    //            return MBA_SCORE_0;
    //        }
    //    }

    public static DExperiencesScored socrePerformance(DExperiences dExperiences,
                                                      DExperiencesScored dExperiencesScored) {

        if (dExperiences.getOverall_rating2016() == null
                && dExperiences.getOverall_rating2017() == null
                && dExperiences.getOverall_rating2018() == null) {
            dExperiencesScored.setPerformance_rating2016(null);
            dExperiencesScored.setPerformance_rating2017(null);
            dExperiencesScored.setPerformance_rating2018(null);
        }
        else {
            dExperiencesScored.setPerformance_rating2016(RatingEnum.getRatingScore(dExperiences.getOverall_rating2016()) / 4 * ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("PERFORMANCE_RATING2016").getMax());
            dExperiencesScored.setPerformance_rating2017(RatingEnum.getRatingScore(dExperiences.getOverall_rating2017()) / 4 * ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("PERFORMANCE_RATING2017").getMax());
            dExperiencesScored.setPerformance_rating2018(RatingEnum.getRatingScore(dExperiences.getOverall_rating2018()) / 4 * ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("PERFORMANCE_RATING2018").getMax());
        }

        return dExperiencesScored;
    }

    public static ExperiencesAverageAttributes getAverageAttributes(List<DExperiences> dExperiencesList) {

        ExperiencesAverageAttributes experiencesAverageAttributes = new ExperiencesAverageAttributes();

        double totalBonusIncrement20162017 = 0;
        int totalBonusIncrementCount20162017 = 0;

        double totalBonusIncrement20172018 = 0;
        int totalBonusIncrementCount20172018 = 0;

        double totalBaseIncrement20172018 = 0;
        int totalBaseIncrementCount20172018 = 0;

        double totalBaseIncrement20182019 = 0;
        int totalBaseIncrementCount20182019 = 0;

        double totalExternalLengthOfService = 0;
        int externalLengthOfServiceCount = 0;


        double bonusIncrement20162017;
        double bonusIncrement20172018;
        double baseIncrement20172018;
        double baseIncrement20182019;
        for (DExperiences dexperiences : dExperiencesList) {

            if (dexperiences.getBonus2016() != null && dexperiences.getBonus2016() != 0 && dexperiences.getBonus2017() != null) {
                bonusIncrement20162017 = (dexperiences.getBonus2017() - dexperiences.getBonus2016()) / dexperiences.getBonus2016();
                totalBonusIncrement20162017 += bonusIncrement20162017;
                totalBonusIncrementCount20162017++;
            }

            if (dexperiences.getBonus2017() != null && dexperiences.getBonus2017() != 0 && dexperiences.getBonus2018() != null) {
                bonusIncrement20172018 = (dexperiences.getBonus2018() - dexperiences.getBonus2017()) / dexperiences.getBonus2017();
                totalBonusIncrement20172018 += bonusIncrement20172018;
                totalBonusIncrementCount20172018++;
            }

            if (dexperiences.getBase2017() != null && dexperiences.getBase2017() != 0 && dexperiences.getBase2018() != null) {
                baseIncrement20172018 = (dexperiences.getBase2018() - dexperiences.getBase2017()) / dexperiences.getBase2017();
                totalBaseIncrement20172018 += baseIncrement20172018;
                totalBaseIncrementCount20172018++;
            }

            if (dexperiences.getBase2018() != null && dexperiences.getBase2018() != 0 && dexperiences.getBase2019() != null) {
                baseIncrement20182019 = (dexperiences.getBase2019() - dexperiences.getBase2018()) / dexperiences.getBase2018();
                totalBaseIncrement20182019 += baseIncrement20182019;
                totalBaseIncrementCount20182019++;
            }

            if (dexperiences.getExternal_length_of_service() != null) {
                totalExternalLengthOfService += dexperiences.getExternal_length_of_service();
                externalLengthOfServiceCount++;
            }
        }

        experiencesAverageAttributes.setBonusIncrement20162017(totalBonusIncrement20162017 / totalBonusIncrementCount20162017);
        experiencesAverageAttributes.setBonusIncrement20172018(totalBonusIncrement20172018 / totalBonusIncrementCount20172018);
        experiencesAverageAttributes.setBaseIncrement20172018(totalBaseIncrement20172018 / totalBaseIncrementCount20172018);
        experiencesAverageAttributes.setBaseIncrement20182019(totalBaseIncrement20182019 / totalBaseIncrementCount20182019);
        experiencesAverageAttributes.setExternalLengthOfService(totalExternalLengthOfService / externalLengthOfServiceCount);
        return experiencesAverageAttributes;
    }

    public static Double scoreIncrement(Double prev, Double now, Double average, String key) {
        double increment;
        if (prev != null && prev != 0 && now != null) {
            increment = (now - prev) / prev;
            return scoreWithAverage(increment, average, key);
        }
        else {
            return null;
        }
    }

    public static Double scoreWithAverage(Double value, Double average, String key) {

        if (value == null) {
            return null;
        }

        if (value >= average) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get(key).getMax();
        }
        else {
            return 0d;
        }
    }

    public static Double scoreFunctionMovements(Integer functionMovements) {

        if (functionMovements == null) {
            return null;
        }

        if (functionMovements >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("FUNCTION_MOVEMENTS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("FUNCTION_MOVEMENTS").getMax() / 5 * functionMovements.doubleValue();
        }
    }

    public static Double scoreLateralMovements(Integer lateralMovements) {

        if (lateralMovements == null) {
            return null;
        }

        if (lateralMovements >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("LATERAL_MOVEMENTS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("LATERAL_MOVEMENTS").getMax() / 5 * lateralMovements.doubleValue();
        }

    }

    public static Double scorePromotions(Integer promotions) {

        if (promotions == null) {
            return null;
        }

        if (promotions >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("PROMOTIONS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("PROMOTIONS").getMax() / 5 * promotions.doubleValue();
        }
    }

    public static Double scoreRegionMovements(Integer regionMovements) {

        if (regionMovements == null) {
            return null;
        }

        if (regionMovements >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("REGION_MOVEMENTS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("REGION_MOVEMENTS").getMax() / 5 * regionMovements.doubleValue();
        }

    }

    public static Double scoreSectorMovements(Integer sectorMovements) {

        if (sectorMovements == null) {
            return null;
        }

        if (sectorMovements >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("SECTOR_MOVEMENTS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("SECTOR_MOVEMENTS").getMax() / 5 * sectorMovements.doubleValue();
        }

    }

    public static Double scoreCountryMovements(Integer countryMovements) {

        if (countryMovements == null) {
            return null;
        }

        if (countryMovements >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("COUNTRY_MOVEMENTS").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("COUNTRY_MOVEMENTS").getMax() / 5 * countryMovements.doubleValue();
        }

    }

    public static Double scoreTeamSize(Integer teamSize) {

        if (teamSize == null) {
            return null;
        }

        if (teamSize >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TEAM_SIZE").getMax();
        }
        else if (teamSize > 3) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TEAM_SIZE").getMax() / 5 * 3;
        }
        else if (teamSize > 1) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TEAM_SIZE").getMax() / 5;
        }
        else {
            return 0d;
        }
    }

    public static Double scoreHierarchyCount(Integer hierarchyCount) {

        if (hierarchyCount == null) {
            return null;
        }

        if (hierarchyCount >= 10) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("HIERARCHY_COUNT").getMax() / 5;
        }
        else if (hierarchyCount > 8) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("HIERARCHY_COUNT").getMax() / 5 * 2;
        }
        else if (hierarchyCount > 6) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("HIERARCHY_COUNT").getMax() / 5 * 4;
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("HIERARCHY_COUNT").getMax();
        }
    }

    public static Double scoreExternalRoleNumber(Integer externalRoleNumber) {

        if (externalRoleNumber == null) {
            return null;
        }

        if (externalRoleNumber >= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("EXTERNAL_ROLE_NUMBER").getMax();
        }
        else {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("EXTERNAL_ROLE_NUMBER").getMax() / 5 * externalRoleNumber.doubleValue();
        }
    }

    public static Double scoreTotalRoleNumber(Integer totalRoleNumber) {

        if (totalRoleNumber == null) {
            return null;
        }

        if (totalRoleNumber <= 3) {
            return 0d;
        }
        else if (totalRoleNumber > 7 && totalRoleNumber <= 9) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_ROLE_NUMBER").getMax() / 5;
        }
        else if (totalRoleNumber > 5 && totalRoleNumber <= 7) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_ROLE_NUMBER").getMax() / 5 * 3;
        }
        else if (totalRoleNumber <= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_ROLE_NUMBER").getMax();
        }

        return 0d;
    }

    public static Double scoreTotalWorkingYears(Double totalWorkingYears) {

        if (totalWorkingYears == null) {
            return null;
        }

        if (totalWorkingYears > 30) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_WORKING_YEARS").getMax() / 5;
        }
        else if (totalWorkingYears > 20 && totalWorkingYears <= 30) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_WORKING_YEARS").getMax() / 5 * 2;
        }
        else if (totalWorkingYears > 10 && totalWorkingYears <= 20) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_WORKING_YEARS").getMax() / 5 * 3;
        }
        else if (totalWorkingYears <= 10) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("TOTAL_WORKING_YEARS").getMax();
        }

        return 0d;
    }

    public static Double scoreAverageDurationOfEachRole(Double averageDurationOfEachRole) {

        if (averageDurationOfEachRole == null) {
            return null;
        }

        if (averageDurationOfEachRole > 0 && averageDurationOfEachRole <= 5) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("AVERAGE_DURATION_OF_EACH_ROLE").getMax();
        }
        else if (averageDurationOfEachRole > 5 && averageDurationOfEachRole <= 10) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("AVERAGE_DURATION_OF_EACH_ROLE").getMax() / 5 * 3;
        }
        else if (averageDurationOfEachRole > 10) {
            return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("AVERAGE_DURATION_OF_EACH_ROLE").getMax() / 5;
        }

        return 0d;
    }

    public static Double scoreDigitalExperiences(Double digitalExperiences) {

        if (digitalExperiences == null) {
            return null;
        }

        return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get("DIGITAL_EXPERIENCES").getMax() * digitalExperiences;
    }

    public static Double scoreUnstructuredData(Double score, String key) {

        if (score == null) {
            return null;
        }

        return ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.get(key).getMax() / 5 * score;
    }

    public static void sumUpExperiences(DExperiencesScored dExperiencesScored) {

        double result = 0;
        double notNullCount = 0;

        if (dExperiencesScored.getPerformance_rating2016() != null) {
            result += dExperiencesScored.getPerformance_rating2016();
            notNullCount++;
        }

        if (dExperiencesScored.getPerformance_rating2017() != null) {
            result += dExperiencesScored.getPerformance_rating2017();
            notNullCount++;
        }

        if (dExperiencesScored.getPerformance_comments2018() != null) {
            result += dExperiencesScored.getPerformance_comments2018();
            notNullCount++;
        }

        if (dExperiencesScored.getBonus_increment20162017() != null) {
            result += dExperiencesScored.getBonus_increment20162017();
            notNullCount++;
        }

        if (dExperiencesScored.getBonus_increment20172018() != null) {
            result += dExperiencesScored.getBonus_increment20172018();
            notNullCount++;
        }

        if (dExperiencesScored.getBase_increment20172018() != null) {
            result += dExperiencesScored.getBase_increment20172018();
        }

        if (dExperiencesScored.getBase_increment20182019() != null) {
            result += dExperiencesScored.getBase_increment20182019();
        }

        if (dExperiencesScored.getFunction_movements() != null) {
            result += dExperiencesScored.getFunction_movements();
            notNullCount++;
        }

        if (dExperiencesScored.getLateral_movements() != null) {
            result += dExperiencesScored.getLateral_movements();
            notNullCount++;
        }

        if (dExperiencesScored.getPromotions() != null) {
            result += dExperiencesScored.getPromotions();
            notNullCount++;
        }

        if (dExperiencesScored.getRegion_movements() != null) {
            result += dExperiencesScored.getRegion_movements();
            notNullCount++;
        }

        if (dExperiencesScored.getSector_movements() != null) {
            result += dExperiencesScored.getSector_movements();
            notNullCount++;
        }

        if (dExperiencesScored.getCountry_movements() != null) {
            result += dExperiencesScored.getCountry_movements();
            notNullCount++;
        }

        if (dExperiencesScored.getTeam_size() != null) {
            result += dExperiencesScored.getTeam_size();
        }

        if (dExperiencesScored.getHierarchy_count() != null) {
            result += dExperiencesScored.getHierarchy_count();
        }

        if (dExperiencesScored.getExternal_roles() != null) {
            result += dExperiencesScored.getExternal_roles();
            notNullCount++;
        }

        if (dExperiencesScored.getExternal_length_of_service() != null) {
            result += dExperiencesScored.getExternal_length_of_service();
            notNullCount++;
        }

        if (dExperiencesScored.getRole_number_ranking() != null) {
            result += dExperiencesScored.getRole_number_ranking();
            notNullCount++;
        }

        if (dExperiencesScored.getTotal_working_year_ranking() != null) {
            result += dExperiencesScored.getTotal_working_year_ranking();
            notNullCount++;
        }

        if (dExperiencesScored.getAverage_time_of_each_role_ranking() != null) {
            result += dExperiencesScored.getAverage_time_of_each_role_ranking();
            notNullCount++;
        }

        if (dExperiencesScored.getDigital_experiences() != null) {
            result += dExperiencesScored.getDigital_experiences();
            notNullCount++;
        }

        if (dExperiencesScored.getPerformance_comments2018() != null) {
            result += dExperiencesScored.getPerformance_comments2018();
            notNullCount++;
        }

        if (dExperiencesScored.getStakeholder_feedback() != null) {
            result += dExperiencesScored.getStakeholder_feedback();
            notNullCount++;
        }

        dExperiencesScored.setResult(result);
        dExperiencesScored.setData_completeness(notNullCount / ExperiencesConstants.NUMBER_OF_FACTS);

    }

    public static void main(String... args) {

        //testing

    }
}
