package fixDataAdaptor;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import dao.Mapper;
import excel.excelEntity.PerformanceRating;
import fixedEntity.PerformanceRatingFixed;
import org.apache.ibatis.session.SqlSession;
import excel.excelMapping.PerformanceRatingColMapping;
import util.DataConnection;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FixedPerformanceRatingAdaptor {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = PerformanceRatingColMapping.TABLE_NAME_FIXED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerformanceRatingFixed> getFixedPerformanceRating() {
        //TODO get performance rating raw data from DB and replace
        List<PerformanceRating> performanceRatingList = mapper.getAllPerformanceRating();
        sqlSession.commit();
        List<PerformanceRatingFixed> performanceRatingFixedList = Lists.newArrayList();

        removeRatingsBefore2016(performanceRatingList);

        Map<String, List<PerformanceRating>> performanceRatingMap = performanceRatingList.stream().collect(
                Collectors.groupingBy(PerformanceRating::getWwid));

        for (Map.Entry<String, List<PerformanceRating>> entry : performanceRatingMap.entrySet()){
            PerformanceRatingFixed performanceRatingFixed = new PerformanceRatingFixed();
            performanceRatingFixed.setWwid(entry.getKey());

            for (PerformanceRating rating : entry.getValue()) {
//                if (ExperiencesConstants.YEAR_END_2016.equals(rating.getReview_period_end_date())) {
//                    performanceRatingFixed.setOverallRating2016(rating.getOverall_rating());
//                } else if (ExperiencesConstants.YEAR_END_2017.equals(rating.getReview_period_end_date())) {
//                    performanceRatingFixed.setOverallRating2017(rating.getOverall_rating());
//                } else if (ExperiencesConstants.YEAR_END_2018.equals(rating.getReview_period_end_date())) {
//                    performanceRatingFixed.setOverallRating2018(rating.getOverall_rating());
//                }
            }

            performanceRatingFixedList.add(performanceRatingFixed);

        }

        return performanceRatingFixedList;
    }

    private static void removeRatingsBefore2016(List<PerformanceRating> performanceRatings) {
        Iterator<PerformanceRating> iter = performanceRatings.iterator();
        while(iter.hasNext()) {
            PerformanceRating performanceRating = iter.next();
            if (!ExperiencesConstants.YEAR_END_2016.equals(performanceRating.getReview_period_end_date()) &&
                    !ExperiencesConstants.YEAR_END_2017.equals(performanceRating.getReview_period_end_date()) &&
                    !ExperiencesConstants.YEAR_END_2018.equals(performanceRating.getReview_period_end_date())) {

                iter.remove();
            }
        }

    }
    public static void generateScoreTable() {
        if (isExisted()) {
            dropTable();
        }
        createTable();

        List<PerformanceRatingFixed> performanceRatingFixed = getFixedPerformanceRating();
        insertRecords(performanceRatingFixed);
    }

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(PerformanceRatingColMapping.COLUMN_MAPPING_FIXED));
    }

    //通过map,生成数据库列
    private static List<Map<String, String>> generateColList(Map<String, String> map) {
        List<Map<String, String>> cols = new LinkedList<>();
        map.forEach((col, v)->{
            Map<String, String> colMap = new HashMap<>();
            colMap.put("code", col);
            colMap.put("type", "STRING");
            colMap.put("length", "500");
            cols.add(colMap);
        });
        return cols;
    }

    public static void insertRecords(List<PerformanceRatingFixed> req) {
        try {
            req.forEach(performanceRatingFixed->{
                mapper.addFixedPerformanceRating(performanceRatingFixed);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        generateScoreTable();
    }
}
