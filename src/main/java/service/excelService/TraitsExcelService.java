package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.Traits;
import excelMapping.TraitsColMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TraitsExcelService extends AbstractExcelService {

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
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        System.err.println(tmp.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<Traits> getResults() throws Exception {
        List<Traits> results = sheet2Entities(Traits.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }
}