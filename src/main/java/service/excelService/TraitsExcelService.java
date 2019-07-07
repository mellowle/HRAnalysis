package service.excelService;

import entity.excelEntity.Traits;
import excelMapping.TraitsColMapping;

import java.util.List;

public class TraitsExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        TraitsExcelService c = new TraitsExcelService();
        List<Traits> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<Traits> getResults() throws Exception {
        List<Traits> results;
        this.COLUMN_MAPPING = TraitsColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Traits.class, TraitsColMapping.EXCEL_NAME);
        return results;
    }
}