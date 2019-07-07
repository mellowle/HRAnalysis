package excel.excelService;

import excel.excelEntity.Competencies;
import excel.excelMapping.CompetenciesColMapping;

import java.util.List;

public class CompetenciesExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        CompetenciesExcelService c = new CompetenciesExcelService();
        List<Competencies> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<Competencies> getResults() throws Exception {
        List<Competencies> results;
        this.COLUMN_MAPPING = CompetenciesColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Competencies.class, CompetenciesColMapping.EXCEL_NAME);
        return results;
    }
}
