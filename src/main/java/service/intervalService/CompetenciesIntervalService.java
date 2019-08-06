package service.intervalService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import Constants.KF4DConstants.CompetenciesConstants;
import com.google.common.collect.Lists;
import entity.ScoreInterval;

import java.util.List;
import java.util.Map;

public class CompetenciesIntervalService extends AbstractIntervalService {

    public CompetenciesIntervalService() {
        this.TABLE_NAME = CompetenciesConstants.TABLE_INTERVAL;
        this.CLAZZ = ScoreInterval.class;
    }

    public static void main(String... args) throws Exception {
        CompetenciesIntervalService c = new CompetenciesIntervalService();
        List<ScoreInterval> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results, "DCompetenciesInterval");
        System.err.println("done");
    }

    public List<ScoreInterval> getResults() {
        List<ScoreInterval> results = Lists.newArrayList();

        for (Map.Entry<String, ScoreInterval> entry : CompetenciesConstants.COMPETENCIES_SCORE_INTERVAL.entrySet()) {
            results.add(entry.getValue());
        }

        return results;
    }

}
