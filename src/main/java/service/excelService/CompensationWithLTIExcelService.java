package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.CompensationWithLTI;
import excelMapping.ltiColMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompensationWithLTIExcelService extends AbstractExcelService {

    public CompensationWithLTIExcelService() {
        this.COLUMN_MAPPING = ltiColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = ltiColMapping.EXCEL_NAME;
        this.TABLE_NAME = ltiColMapping.TABLE_NAME;
        this.CLAZZ = CompensationWithLTI.class;
    }

    public static void main(String... args) throws Exception {
        CompensationWithLTIExcelService c = new CompensationWithLTIExcelService();
        List<CompensationWithLTI> results = c.getResults();
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

    public List<CompensationWithLTI> getResults() throws Exception {
        List<CompensationWithLTI> results = sheet2Entities(CompensationWithLTI.class);


        results = results.stream().filter(i->i.getWwid() != null)
                .filter(i->!((i.getBase2017() == null || i.getBase2017() == 0)
                        && (i.getBase2018() == null || i.getBase2018() == 0)
                        && (i.getBase2019() == null || i.getBase2019() == 0)))
                .collect(Collectors.toList());


        return results;
    }
}
