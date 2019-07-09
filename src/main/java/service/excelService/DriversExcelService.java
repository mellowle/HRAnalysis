package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.Drivers;
import excelMapping.DriversColMapping;

import java.util.List;
import java.util.Set;

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
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        System.err.println(tmp.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<Drivers> getResults() throws Exception {
        return sheet2Entities(Drivers.class);
    }
}
