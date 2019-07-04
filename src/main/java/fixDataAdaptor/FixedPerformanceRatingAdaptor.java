package fixDataAdaptor;

import com.google.common.collect.Lists;
import Constants.ExperiencesConstants.Constants;
import entity.PerformanceRating;
import fixedEntity.FixedPerformanceRating;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FixedPerformanceRatingAdaptor {

    public static List<FixedPerformanceRating> getFixedPerformanceRating() {
        //TODO get performance rating raw data from DB and replace
        List<PerformanceRating> performanceRatingList = Lists.newArrayList();
        List<FixedPerformanceRating> fixedPerformanceRatingList = Lists.newArrayList();

        removeRatingsBefore2016(performanceRatingList);

        Map<String, List<PerformanceRating>> performanceRatingMap = performanceRatingList.stream().collect(
                Collectors.groupingBy(PerformanceRating::getWwid));

        for (Map.Entry<String, List<PerformanceRating>> entry : performanceRatingMap.entrySet()){
            FixedPerformanceRating fixedPerformanceRating = new FixedPerformanceRating();
            fixedPerformanceRating.setWwid(entry.getKey());

            for (PerformanceRating rating : entry.getValue()) {
                if (Constants.YEAR_END_2016.equals(rating.getReview_period_end_date())) {
                    fixedPerformanceRating.setOverallRating2016(rating.getOverall_rating());
                } else if (Constants.YEAR_END_2017.equals(rating.getReview_period_end_date())) {
                    fixedPerformanceRating.setOverallRating2017(rating.getOverall_rating());
                } else if (Constants.YEAR_END_2018.equals(rating.getReview_period_end_date())) {
                    fixedPerformanceRating.setOverallRating2018(rating.getOverall_rating());
                }
            }

            fixedPerformanceRatingList.add(fixedPerformanceRating);

        }

        return fixedPerformanceRatingList;
    }

    private static void removeRatingsBefore2016(List<PerformanceRating> performanceRatings) {
        Iterator<PerformanceRating> iter = performanceRatings.iterator();
        while(iter.hasNext()) {
            PerformanceRating performanceRating = iter.next();
            if (!Constants.YEAR_END_2016.equals(performanceRating.getReview_period_end_date()) &&
                    !Constants.YEAR_END_2017.equals(performanceRating.getReview_period_end_date()) &&
                    !Constants.YEAR_END_2018.equals(performanceRating.getReview_period_end_date())) {

                iter.remove();
            }
        }

    }

}
