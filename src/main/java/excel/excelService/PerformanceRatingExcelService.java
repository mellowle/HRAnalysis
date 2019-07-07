package excel.excelService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import excel.excelEntity.PerformanceRating;
import excel.excelMapping.PerformanceRatingColMapping;
import fixedEntity.PerformanceRatingFixed;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PerformanceRatingExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        PerformanceRatingExcelService c = new PerformanceRatingExcelService();
        List<PerformanceRatingFixed> results = c.getResultsFixed();
        results.forEach(System.err::println);
        System.out.println(results.size());
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
        List<PerformanceRating> results;
        this.COLUMN_MAPPING = PerformanceRatingColMapping.COLUMN_MAPPING;
        results = sheet2Entities(PerformanceRating.class, PerformanceRatingColMapping.EXCEL_NAME);
        return results;
    }

    public List<PerformanceRatingFixed> getResultsFixed() throws Exception {
        List<PerformanceRatingFixed> results = Lists.newArrayList();
        List<PerformanceRating> performanceRatingList = getResults();

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

            results.add(performanceRatingFixed);

        }

        return results;
    }
}
