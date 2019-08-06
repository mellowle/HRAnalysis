package service.intervalService;

import Constants.KF4DConstants.DriversConstants;
import com.google.common.collect.Lists;
import entity.ScoreInterval;

import java.util.List;
import java.util.Map;

public class DriversIntervalService extends AbstractIntervalService {

    public DriversIntervalService() {
        this.TABLE_NAME = DriversConstants.TABLE_INTERVAL;
        this.CLAZZ = ScoreInterval.class;
    }

    public static void main(String... args) throws Exception {
        DriversIntervalService c = new DriversIntervalService();
        List<ScoreInterval> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results, "DDriversInterval");
        System.err.println("done");
    }

    public List<ScoreInterval> getResults() {
        List<ScoreInterval> results = Lists.newArrayList();

        for (Map.Entry<String, ScoreInterval> entry : DriversConstants.DRIVERS_SCORE_INTERVAL.entrySet()) {
            results.add(entry.getValue());
        }

        return results;
    }

}
