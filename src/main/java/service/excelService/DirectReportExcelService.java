package service.excelService;

import entity.excelEntity.DirectReport;

import java.util.List;

public class DirectReportExcelService extends AbstractExcelService {

    public static void main(String... args) throws Exception {
        DirectReportExcelService c = new DirectReportExcelService();
        List<DirectReport> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<DirectReport> getResults() throws Exception {
//        List<DirectReport> results;
//        this.COLUMN_MAPPING = DirectReportColMapping.COLUMN_MAPPING;
//        results = sheet2Entities(DirectReport.class);
        return sheet2Entities();
    }
}
