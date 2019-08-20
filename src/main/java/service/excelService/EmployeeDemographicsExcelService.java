package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.EmployeeDemographics;
import excelMapping.EmployeeDemographicsColMapping;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDemographicsExcelService extends AbstractExcelService {

    public EmployeeDemographicsExcelService(){
        this.COLUMN_MAPPING = EmployeeDemographicsColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = EmployeeDemographicsColMapping.EXCEL_NAME;
        this.TABLE_NAME = EmployeeDemographicsColMapping.TABLE_NAME;
        this.CLAZZ = EmployeeDemographics.class;
    }

    public static void main(String... args) throws Exception {
        EmployeeDemographicsExcelService c = new EmployeeDemographicsExcelService();
        List<EmployeeDemographics> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        List<EmployeeDemographics> unique = results.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(EmployeeDemographics::getWwid)))
                        , ArrayList::new));
        System.err.println(unique.size());
        c.initTable();
        c.insertRecords(unique);
        System.err.println("done");
    }

    public List<EmployeeDemographics> getResults() throws Exception {
        List<EmployeeDemographics> results = sheet2Entities(EmployeeDemographics.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        for(EmployeeDemographics employeeDemographics: results){
            employeeDemographics.setTotal_working_years(employeeDemographics.getAge()-22);
        }
        return results;
    }
}
