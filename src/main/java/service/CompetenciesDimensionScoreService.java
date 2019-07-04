package service;

import com.google.common.collect.Lists;
import dimensionRawData.DCompetencies;
import dimensionScored.DCompetenciesScored;
import util.KF4DScoreFunctionUtils;

import java.util.List;

public class CompetenciesDimensionScoreService {
    public static List<DCompetenciesScored> getExperienceScores() {
        List<DCompetenciesScored> competenciesScoredList = Lists.newArrayList();
        // TODO get DExperiences from DB and replace
        List<DCompetencies> dCompetenciesList = Lists.newArrayList();

        for (DCompetencies dCompetencies : dCompetenciesList) {
            DCompetenciesScored dCompetenciesScored = new DCompetenciesScored(dCompetencies.getWwid(),
                    KF4DScoreFunctionUtils.calcMissionCriticalScore(dCompetencies.getMissionCritical()),
                    KF4DScoreFunctionUtils.calcCriticalScore(dCompetencies.getCritical()),
                    KF4DScoreFunctionUtils.calcLessCriticalScore(dCompetencies.getLessCritical()));
            competenciesScoredList.add(dCompetenciesScored);
        }
        return competenciesScoredList;
    }

}
