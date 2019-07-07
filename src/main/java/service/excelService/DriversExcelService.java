package service.excelService;

import entity.excelEntity.Drivers;
import excelMapping.DriversColMapping;

import java.util.List;

public class DriversExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        DriversExcelService c = new DriversExcelService();
        List<Drivers> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<Drivers> getResults() throws Exception {
        List<Drivers> results;
        this.COLUMN_MAPPING = DriversColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Drivers.class, DriversColMapping.EXCEL_NAME);
        return results;
    }
}
