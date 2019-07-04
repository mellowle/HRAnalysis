package service;

import com.google.common.collect.Lists;
import dimensionRawData.DExperiences;
import dimensionScored.DExperiencesScored;
import util.RatingEnum;
import util.ScoreFunctionUtils;

import java.util.List;

public class ExperienceDimensionScoreService {

//    public static List<DExperiencesScored> getExperienceScores() {
//        List<DExperiencesScored> experiencesScoredList = Lists.newArrayList();
//        //TODO get DExperiences from DB and replace
//        List<DExperiences> DExperiencesList = Lists.newArrayList();
//
////        for (DExperiences dexperience : DExperiencesList) {
////            DExperiencesScored experiencesScored = new DExperiencesScored();
////            experiencesScored.setWwid(dexperience.getWwid());
////            experiencesScored.setIsMBA(ScoreFunctionUtils.isMBAScore(dexperience.getHighestDegreeReceived()));
////            experiencesScored.setTeamSize(ScoreFunctionUtils.teamSizeScore(dexperience.getDirectReport()));
////            experiencesScored.setPerformance2016(RatingEnum.getRatingScore(dexperience.getOverallRating2016()));
////            experiencesScored.setPerformance2017(RatingEnum.getRatingScore(dexperience.getOverallRating2017()));
////            experiencesScored.setPerformance2018(RatingEnum.getRatingScore(dexperience.getOverallRating2018()));
////            experiencesScored.setBonusIncrement20162017(ScoreFunctionUtils.year2017BaseIncrementScore(dexperience.));
////            experiencesScored.setBonusIncrement20172018(ScoreFunctionUtils.year2018BaseIncrementScore(dexperience.));
////            experiencesScored.setFunctionMovements(ScoreFunctionUtils.functionMovementScore(dexperience.getFunctionMovements()));
////            experiencesScored.setLateralMovements(ScoreFunctionUtils.lateralMovementScore(dexperience.getLateralMovements()));
////            experiencesScored.setPromotions(ScoreFunctionUtils.promotionScore(dexperience.getPromotions()));
////            experiencesScored.setReginMovements(ScoreFunctionUtils.regionMovementScore(dexperience.getRegionMovdments()));
////            experiencesScored.setSectorMovements(ScoreFunctionUtils.sectorMovementScore(dexperience.getSectorMovements()));
////            experiencesScored.setCountryMovements(ScoreFunctionUtils.countryMovementScore(dexperience.getCountryMovements()));
////            experiencesScored.setRoleNumberExternal(ScoreFunctionUtils.externalRoleNumberScore(dexperience.getNumberOfExternalRoles()));
////            experiencesScored.setLengthOfServiceExternal(ScoreFunctionUtils.externalLengthOfServiceScore(dexperience.getExternalLengthOfService()));
////            experiencesScored.setRoleNumberRanking(ScoreFunctionUtils.totalRoleNumberScore(dexperience.get));
////            experiencesScored.setTotalWorkingYearRanking();
////            experiencesScored.setAverageDurationOfEachRoleRanking();
////            experiencesScored.setHierarchy2Alex();
////
////            //TODO 2 unstructured data
////            experiencesScored.setPerformanceComments2018();
////            experiencesScored.setStakeholderFeedback();
////
////            experiencesScored.setResult();
////            experiencesScored.setDataCompleteness();
//        }
//    }
}
