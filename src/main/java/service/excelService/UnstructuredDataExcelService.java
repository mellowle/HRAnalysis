package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.UnstructuredData;
import excelMapping.UnstructuredDataColMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnstructuredDataExcelService extends AbstractExcelService {

    public UnstructuredDataExcelService() {
        this.COLUMN_MAPPING = UnstructuredDataColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = UnstructuredDataColMapping.EXCEL_NAME;
        this.TABLE_NAME = UnstructuredDataColMapping.TABLE_NAME;
        this.CLAZZ = UnstructuredData.class;
    }

    public static void main(String... args) throws Exception {
        UnstructuredDataExcelService c = new UnstructuredDataExcelService();
        List<UnstructuredData> results = c.getResults();
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

    public List<UnstructuredData> getResults() throws Exception {
        List<UnstructuredData> results = sheet2Entities(UnstructuredData.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }
}