package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.KF4DEmployeeDemographics;
import excelMapping.KF4DAggregatedResultsColMapping;

import java.util.List;
import java.util.Set;

public class KF4DEmployeeDemographicsExcelService extends AbstractExcelService {
    public KF4DEmployeeDemographicsExcelService() {
        this.COLUMN_MAPPING = KF4DAggregatedResultsColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = KF4DAggregatedResultsColMapping.EXCEL_NAME;
        this.TABLE_NAME = KF4DAggregatedResultsColMapping.TABLE_NAME;
        this.CLAZZ = KF4DEmployeeDemographics.class;
    }

    public static void main(String... args) throws Exception {
        KF4DEmployeeDemographicsExcelService c = new KF4DEmployeeDemographicsExcelService();
        List<KF4DEmployeeDemographics> results = c.getResults();
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

    public List<KF4DEmployeeDemographics> getResults() throws Exception {
        List<KF4DEmployeeDemographics> results = sheet2Entities(KF4DEmployeeDemographics.class);
        return results;
    }
}