package service.excelService;

import entity.excelEntity.Traits;
import excelMapping.TraitsColMapping;

import java.util.List;

public class TraitsExcelService extends Row2EntityService {

    public TraitsExcelService() {
        this.COLUMN_MAPPING = TraitsColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = TraitsColMapping.EXCEL_NAME;
        this.TABLE_NAME = TraitsColMapping.TABLE_NAME;
        this.CLAZZ = Traits.class;
    }

    public static void main(String... args) throws Exception {
        TraitsExcelService c = new TraitsExcelService();
        List<Traits> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
    }

    public List<Traits> getResults() throws Exception {
        List<Traits> results;
        this.COLUMN_MAPPING = TraitsColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Traits.class);
        return results;
    }
}