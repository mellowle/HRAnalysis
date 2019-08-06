package service.intervalService;

import Constants.KF4DConstants.CompetenciesConstants;
import Constants.KF4DConstants.TraitsConstants;
import com.google.common.collect.Lists;
import entity.ScoreInterval;

import java.util.List;
import java.util.Map;

public class TraitsIntervalService extends AbstractIntervalService {

    public TraitsIntervalService() {
        this.TABLE_NAME = TraitsConstants.TABLE_INTERVAL;
        this.CLAZZ = ScoreInterval.class;
    }

    public static void main(String... args) throws Exception {
        TraitsIntervalService c = new TraitsIntervalService();
        List<ScoreInterval> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results, "DTraitsInterval");
        System.err.println("done");
    }

    public List<ScoreInterval> getResults() {
        List<ScoreInterval> results = Lists.newArrayList();

        for (Map.Entry<String, ScoreInterval> entry : TraitsConstants.TRAITS_SCORE_INTERVAL.entrySet()) {
            results.add(entry.getValue());
        }

        return results;
    }

}
