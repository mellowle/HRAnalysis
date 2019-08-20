package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.TalentCardSummary;
import excelMapping.TalentCardSummaryColMapping;

import java.util.List;
import java.util.Set;

public class TalentCardSummaryExcelService extends AbstractExcelService {
    public TalentCardSummaryExcelService() {
        this.COLUMN_MAPPING = TalentCardSummaryColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = TalentCardSummaryColMapping.EXCEL_NAME;
        this.TABLE_NAME = TalentCardSummaryColMapping.TABLE_NAME;
        this.CLAZZ = TalentCardSummary.class;
    }

    public static void main(String... args) throws Exception {
        TalentCardSummaryExcelService c = new TalentCardSummaryExcelService();
        List<TalentCardSummary> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        System.err.println(tmp.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<TalentCardSummary> getResults() throws Exception {
        List<TalentCardSummary> results = sheet2Entities(TalentCardSummary.class);
        return results;
    }
}