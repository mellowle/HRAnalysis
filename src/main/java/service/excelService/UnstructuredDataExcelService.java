package service.excelService;

import entity.excelEntity.UnstructuredData;

import java.util.List;

public class UnstructuredDataExcelService extends AbstractExcelService {

    public static void main(String... args) throws Exception {
        UnstructuredDataExcelService c = new UnstructuredDataExcelService();
        List<UnstructuredData> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<UnstructuredData> getResults() throws Exception {
//        List<UnstructuredData> results;
//        this.COLUMN_MAPPING = UnstructuredDataColMapping.COLUMN_MAPPING;
//        results = sheet2Entities(UnstructuredData.class);
        return sheet2Entities();
    }
}