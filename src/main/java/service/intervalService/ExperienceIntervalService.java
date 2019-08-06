package service.intervalService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import entity.ScoreInterval;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class ExperienceIntervalService extends AbstractIntervalService {

    public ExperienceIntervalService() {
        this.TABLE_NAME = ExperiencesConstants.TABLE_INTERVAL;
        this.CLAZZ = ScoreInterval.class;
    }

    public static void main(String... args) throws Exception {
        ExperienceIntervalService c = new ExperienceIntervalService();
        List<ScoreInterval> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results, "DExperiencesInterval");
        System.err.println("done");
    }

    public List<ScoreInterval> getResults() {
        List<ScoreInterval> results = Lists.newArrayList();

        for (Map.Entry<String, ScoreInterval> entry : ExperiencesConstants.EXPERIENCES_SCORE_INTERVAL.entrySet()) {
            results.add(entry.getValue());
        }

        return results;
    }

}
