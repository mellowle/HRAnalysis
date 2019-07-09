package service.excelService;

import entity.excelEntity.Drivers;
import excelMapping.DriversColMapping;

import java.util.List;

public class DriversExcelService extends AbstractExcelService {

    public DriversExcelService() {
        this.COLUMN_MAPPING = DriversColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = DriversColMapping.EXCEL_NAME;
        this.TABLE_NAME = DriversColMapping.TABLE_NAME;
        this.CLAZZ = Drivers.class;
    }

    public static void main(String... args) throws Exception {
        DriversExcelService c = new DriversExcelService();
        List<Drivers> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<Drivers> getResults() throws Exception {
        return sheet2Entities();
    }
}
