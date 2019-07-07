package excel.excelService;

import excel.excelEntity.ManagementChain;
import excel.excelMapping.ManagementChainColMapping;

import java.util.List;

public class ManagementChainExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        ManagementChainExcelService c = new ManagementChainExcelService();
        List<ManagementChain> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<ManagementChain> getResults() throws Exception {
        List<ManagementChain> results;
        this.COLUMN_MAPPING = ManagementChainColMapping.COLUMN_MAPPING;
        results = sheet2Entities(ManagementChain.class, ManagementChainColMapping.EXCEL_NAME);
        results.forEach(result->{
            result.setHierarchy_count();
        });
        return results;
    }
}
