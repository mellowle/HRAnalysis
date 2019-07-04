package service;

import com.google.common.collect.Lists;
import dimensionRawData.DTraits;
import dimensionScored.DTraitsScored;
import util.KF4DScoreFunctionUtils;

import java.util.List;

public class TraitsDimensionScoreService {
    public static List<DTraitsScored> getTraitsScores() {
        List<DTraitsScored> dTraitsScoredList = Lists.newArrayList();
        // TODO get DExperiences from DB and replace
        List<DTraits> dTraitsList = Lists.newArrayList();

        for (DTraits dTraits : dTraitsList) {
            DTraitsScored dTraitsScored = new DTraitsScored(dTraits.getWwid(), KF4DScoreFunctionUtils.calcTraitsScore(dTraits.getTraits()));
            dTraitsScoredList.add(dTraitsScored);
        }
        return dTraitsScoredList;
    }
}
