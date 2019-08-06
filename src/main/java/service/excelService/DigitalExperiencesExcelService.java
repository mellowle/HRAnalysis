package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.DigitalExperiences;
import entity.excelEntity.Traits;
import excelMapping.DigitalExperiencesColMapping;
import excelMapping.TraitsColMapping;

import java.util.*;
import java.util.stream.Collectors;

public class DigitalExperiencesExcelService extends AbstractExcelService {

    public DigitalExperiencesExcelService() {
        this.COLUMN_MAPPING = DigitalExperiencesColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = DigitalExperiencesColMapping.EXCEL_NAME;
        this.TABLE_NAME = DigitalExperiencesColMapping.TABLE_NAME;
        this.CLAZZ = DigitalExperiences.class;
    }

    public static void main(String... args) throws Exception {
        DigitalExperiencesExcelService c = new DigitalExperiencesExcelService();
        List<DigitalExperiences> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        List<DigitalExperiences> unique = results.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(DigitalExperiences::getWwid)))
                        , ArrayList::new));
        System.err.println(unique.size());
        c.initTable();
        c.insertRecords(unique);
        System.err.println("done");
    }

    public List<DigitalExperiences> getResults() throws Exception {
        List<DigitalExperiences> results = sheet2Entities(DigitalExperiences.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }
}