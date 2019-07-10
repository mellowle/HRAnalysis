package service.scoreService;

import Constants.PojectConstants;
import entity.dimensionScored.FinalScore;
import util.TableUtils;

import java.util.List;

public class TotalScoreService extends AbstractScoreService {

    public TotalScoreService() {
        this.TABLE_NAME_SCORED = PojectConstants.FINAL_TABLE_NAME;
        this.CLAZZ = FinalScore.class;
    }

    public static void main(String... args) throws Exception {
        TotalScoreService c = new TotalScoreService();
        List<FinalScore> results = c.getScoredResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<FinalScore> getScoredResults() throws Exception {
        List<FinalScore> scoredResults = TableUtils.getAllRecords(FinalScore.class);
        scoredResults.forEach(scoredResult->{
            scoredResult.sumUp();
        });
        return scoredResults;
    }
}
