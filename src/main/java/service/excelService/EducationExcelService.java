package service.excelService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import entity.excelEntity.Education;
import excelMapping.EducationColMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EducationExcelService extends AbstractExcelService {

    public EducationExcelService(){
        this.COLUMN_MAPPING = EducationColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = EducationColMapping.EXCEL_NAME;
        this.TABLE_NAME = EducationColMapping.TABLE_NAME;
        this.CLAZZ = Education.class;
    }

    public static void main(String... args) throws Exception {
        EducationExcelService c = new EducationExcelService();
        List<Education> results = c.getResultsFixed();
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

    public List<Education> getResultsFixed() throws Exception {
        List<Education> results = Lists.newArrayList();
        List<Education> educationList = getResults();

        Map<String, List<Education>> educationMap = educationList.stream().collect(Collectors
                .groupingBy(Education::getWwid));

        for (Map.Entry<String, List<Education>> entry : educationMap.entrySet()) {
            HashSet educationSet = Sets.newHashSet();
            for (Education education : entry.getValue()) {
                educationSet.add(education.getHighest_degree_received());
            }

            Education education = new Education();
            education.setWwid(entry.getKey());
            if (educationSet.contains(ExperiencesConstants.MBA)) {
                education.setHighest_degree_received(ExperiencesConstants.MBA);
            }
            else {
                education.setHighest_degree_received("");
            }
            results.add(education);
        }

        return results;
    }

    public List<Education> getResults() throws Exception {
        return sheet2Entities(Education.class);
    }
}
