package service.excelService;

import entity.excelEntity.EmployeeDemographics;
import excelMapping.EmployeeDemographicsColMapping;

import java.util.List;

public class EmployeeDemographicsExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        EmployeeDemographicsExcelService c = new EmployeeDemographicsExcelService();
        List<EmployeeDemographics> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<EmployeeDemographics> getResults() throws Exception {
        List<EmployeeDemographics> results;
        this.COLUMN_MAPPING = EmployeeDemographicsColMapping.COLUMN_MAPPING;
        results = sheet2Entities(EmployeeDemographics.class);
        return results;
    }
}
