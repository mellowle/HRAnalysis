package service.scoreService;

import com.google.common.collect.Lists;
import entity.dimensionRawData.DDrivers;
import entity.dimensionScored.DDriversScored;
import entity.excelEntity.Drivers;
import excelMapping.DriversColMapping;
import util.KF4DScoreFunctionUtils;
import util.TableUtils;

import java.util.List;

public class DriversDimensionScoreService extends AbstractScoreService {

    public DriversDimensionScoreService() {
        this.TABLE_NAME_SCORED = DriversColMapping.TABLE_NAME_SCORED;
        this.CLAZZ = DDriversScored.class;
    }

    public static void main(String... args) throws Exception {
        DriversDimensionScoreService c = new DriversDimensionScoreService();
        List<DDriversScored> results = c.getScoredResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public static List<DDriversScored> getScoredResults() throws Exception {
        List<DDriversScored> scoredResults = Lists.newArrayList();

        List<DDrivers> dDriversList = Lists.newArrayList();

        List<Drivers> results = TableUtils.getAllRecords(Drivers.class);

        results.forEach(drivers->{
            DDrivers dDrivers = new DDrivers(drivers.getWwid(), drivers.getBalance(), drivers.getChallenge(), drivers.getCollaboration(), drivers.getIndependence(), drivers.getPower(), drivers.getStructure());
            dDriversList.add(dDrivers);
        });

        for (DDrivers dDrivers : dDriversList) {
            DDriversScored dTraitsScored = new DDriversScored(dDrivers.getWwid(), KF4DScoreFunctionUtils.calcDriversScore(dDrivers.getDrivers()));
            scoredResults.add(dTraitsScored);
        }

        return scoredResults;
    }
}
