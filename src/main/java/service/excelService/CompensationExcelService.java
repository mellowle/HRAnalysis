package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.Compensation;
import excelMapping.CompensationColMapping;

import java.util.List;
import java.util.Set;

public class CompensationExcelService extends AbstractExcelService {

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
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        System.err.println(tmp.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<Compensation> getResults() throws Exception {
        return sheet2Entities(Compensation.class);
    }
}
