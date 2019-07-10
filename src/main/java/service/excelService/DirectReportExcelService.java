package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.DirectReport;
import excelMapping.DirectReportColMapping;

import java.util.*;
import java.util.stream.Collectors;

public class DirectReportExcelService extends AbstractExcelService {

    public DirectReportExcelService(){
        this.COLUMN_MAPPING = DirectReportColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = DirectReportColMapping.EXCEL_NAME;
        this.TABLE_NAME = DirectReportColMapping.TABLE_NAME;
        this.CLAZZ = DirectReport.class;
    }

    public static void main(String... args) throws Exception {
        DirectReportExcelService c = new DirectReportExcelService();
        List<DirectReport> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        List<DirectReport> unique = results.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(DirectReport::getWwid)))
                        , ArrayList::new));
        System.err.println(unique.size());
        c.initTable();
        c.insertRecords(unique);
        System.err.println("done");
    }

    public List<DirectReport> getResults() throws Exception {
        List<DirectReport> results = sheet2Entities(DirectReport.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }
}
