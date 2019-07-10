package service.excelService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import entity.excelEntity.PerformanceRating;
import entity.excelEntity.fixed.PerformanceRatingFixed;
import excelMapping.PerformanceRatingColMapping;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PerformanceRatingExcelService extends AbstractExcelService {

    public PerformanceRatingExcelService() {
        this.COLUMN_MAPPING = PerformanceRatingColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = PerformanceRatingColMapping.EXCEL_NAME;
        this.TABLE_NAME = PerformanceRatingColMapping.TABLE_NAME_FIXED;
        this.CLAZZ = PerformanceRatingFixed.class;
    }

    public static void main(String... args) throws Exception {
        PerformanceRatingExcelService c = new PerformanceRatingExcelService();
        List<PerformanceRatingFixed> results = c.getResultsFixed();
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

    private void removeRatingsBefore2016(List<PerformanceRating> performanceRatingList) {
        Iterator<PerformanceRating> it = performanceRatingList.iterator();
        while (it.hasNext()) {
            PerformanceRating performanceRating = it.next();
            if (performanceRating.getWwid().isEmpty()) {
                it.remove();
            }
            else if (!ExperiencesConstants.YEAR_END_2016.equals(performanceRating.getReview_period_end_date().toString()) &&
                    !ExperiencesConstants.YEAR_END_2017.equals(performanceRating.getReview_period_end_date().toString()) &&
                    !ExperiencesConstants.YEAR_END_2018.equals(performanceRating.getReview_period_end_date().toString())) {

                it.remove();
            }
        }
    }

    public List<PerformanceRating> getResults() throws Exception {
        return sheet2Entities(PerformanceRating.class);
    }

    public List<PerformanceRatingFixed> getResultsFixed() throws Exception {
        List<PerformanceRatingFixed> results = Lists.newArrayList();
        List<PerformanceRating> performanceRatingList = getResults();

        performanceRatingList = performanceRatingList.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());

        removeRatingsBefore2016(performanceRatingList);

        Map<String, List<PerformanceRating>> performanceRatingMap = performanceRatingList.stream().collect(
                Collectors.groupingBy(PerformanceRating::getWwid));

        for (Map.Entry<String, List<PerformanceRating>> entry : performanceRatingMap.entrySet()) {
            PerformanceRatingFixed performanceRatingFixed = new PerformanceRatingFixed();
            performanceRatingFixed.setWwid(entry.getKey());
            performanceRatingFixed.setOverall_rating2016("");
            performanceRatingFixed.setOverall_rating2017("");
            performanceRatingFixed.setOverall_rating2018("");

            for (PerformanceRating rating : entry.getValue()) {
                if (ExperiencesConstants.YEAR_END_2016.equals(rating.getReview_period_end_date().toString())) {
                    performanceRatingFixed.setOverall_rating2016(rating.getOverall_rating());
                }
                else if (ExperiencesConstants.YEAR_END_2017.equals(rating.getReview_period_end_date().toString())) {
                    performanceRatingFixed.setOverall_rating2017(rating.getOverall_rating());
                }
                else if (ExperiencesConstants.YEAR_END_2018.equals(rating.getReview_period_end_date().toString())) {
                    performanceRatingFixed.setOverall_rating2018(rating.getOverall_rating());
                }
            }
            performanceRatingFixed.resetInsufficientData();

            results.add(performanceRatingFixed);

        }

        return results;
    }
}
