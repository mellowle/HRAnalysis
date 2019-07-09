package service.excelService;

import entity.excelEntity.Competencies;
import excelMapping.CompetenciesColMapping;

import java.util.List;

public class CompetenciesExcelService extends Row2EntityService {

    public CompetenciesExcelService(){
        this.COLUMN_MAPPING = CompetenciesColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = CompetenciesColMapping.EXCEL_NAME;
        this.TABLE_NAME = CompetenciesColMapping.TABLE_NAME;
        this.CLAZZ = Competencies.class;
    }

    public static void main(String... args) throws Exception {
        CompetenciesExcelService c = new CompetenciesExcelService();
        List<Competencies> results = c.getResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
    }

    public List<Competencies> getResults() throws Exception {
        List<Competencies> results;
        this.COLUMN_MAPPING = CompetenciesColMapping.COLUMN_MAPPING;
        results = sheet2Entities(Competencies.class);
        return results;
    }

}
