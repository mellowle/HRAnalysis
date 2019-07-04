package service;

import com.google.common.collect.Lists;
import dimensionRawData.DCompetencies;
import dimensionScored.DCompetenciesScored;
import util.KF4DScoreFunctionUtils;

import java.util.List;

public class CompetenciesDimensionScoreService {
    public static List<DCompetenciesScored> getExperienceScores() {
        List<DCompetenciesScored> competenciesScored = Lists.newArrayList();
        // TODO get DExperiences from DB and replace
        List<DCompetencies> DCompetenciesList = Lists.newArrayList();

        for(DCompetencies competencies : DCompetenciesList){
            DCompetenciesScored dCompetenciesScored = new DCompetenciesScored();
            KF4DScoreFunctionUtils.calcMissionCriticalScore(competencies.getMissionCritical());
            KF4DScoreFunctionUtils.calcCriticalScore(competencies.getCritical());
            KF4DScoreFunctionUtils.calcLessCriticalScore(competencies.getLessCritical());

        }
        return null;
    }

}
