package service.excelService;

import entity.excelEntity.Compensation;
import excelMapping.CompensationColMapping;
import util.TableUtils;

import java.util.List;

public class CompensationExcelService extends Row2EntityService {

    public CompensationExcelService(){
        this.COLUMN_MAPPING = CompensationColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = CompensationColMapping.EXCEL_NAME;
        this.TABLE_NAME = CompensationColMapping.TABLE_NAME;
        this.CLAZZ = Compensation.class;
    }

    public static void main(String... args) throws Exception {
        CompensationExcelService c = new CompensationExcelService();
        List<Compensation> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
    }

    public List<Compensation> getResults() throws Exception {
        List<Compensation> results;
        results = sheet2Entities(Compensation.class);
        return results;
    }


}
