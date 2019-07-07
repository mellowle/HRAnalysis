package service.excelService;

import entity.excelEntity.UnstructuredData;
import excelMapping.UnstructuredDataColMapping;

import java.util.List;

public class UnstructuredDataExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        UnstructuredDataExcelService c = new UnstructuredDataExcelService();
        List<UnstructuredData> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<UnstructuredData> getResults() throws Exception {
        List<UnstructuredData> results;
        this.COLUMN_MAPPING = UnstructuredDataColMapping.COLUMN_MAPPING;
        results = sheet2Entities(UnstructuredData.class, UnstructuredDataColMapping.EXCEL_NAME);
        return results;
    }
}