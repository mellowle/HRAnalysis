package service;

import com.google.common.collect.Lists;
import dimensionRawData.DDrivers;
import dimensionScored.DDriversScored;
import util.KF4DScoreFunctionUtils;

import java.util.List;

public class DriversDimensionScoreService {
    public static List<DDriversScored> getDriversScores() {
        List<DDriversScored> dDriversScoredList = Lists.newArrayList();
        // TODO get DExperiences from DB and replace
        List<DDrivers> dDriversList = Lists.newArrayList();

        for (DDrivers dDrivers : dDriversList) {
            DDriversScored dTraitsScored = new DDriversScored(dDrivers.getWwid(), KF4DScoreFunctionUtils.calcDriversScore(dDrivers.getDrivers()));
            dDriversScoredList.add(dTraitsScored);
        }
        return dDriversScoredList;
    }
}
