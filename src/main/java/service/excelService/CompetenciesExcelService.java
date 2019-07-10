package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.Competencies;
import excelMapping.CompetenciesColMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompetenciesExcelService extends AbstractExcelService {

    public CompetenciesExcelService() {
        this.COLUMN_MAPPING = CompetenciesColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = CompetenciesColMapping.EXCEL_NAME;
        this.TABLE_NAME = CompetenciesColMapping.TABLE_NAME;
        this.CLAZZ = Competencies.class;
    }

    public static void main(String... args) throws Exception {
        CompetenciesExcelService c = new CompetenciesExcelService();
        List<Competencies> results = c.getResults();
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

    public List<Competencies> getResults() throws Exception {
        List<Competencies> results = sheet2Entities(Competencies.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }

}
