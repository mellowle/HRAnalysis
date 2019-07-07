package excel.excelService;

import excel.excelEntity.Compensation;
import excel.excelMapping.CompensationColMapping;

import java.util.List;

public class CompensationExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        CompensationExcelService c = new CompensationExcelService();
        List<Compensation> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<Compensation> getResults() throws Exception {
        List<Compensation> results;
        this.COLUMN_MAPPING = CompensationColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Compensation.class, CompensationColMapping.EXCEL_NAME);
        return results;
    }

}
