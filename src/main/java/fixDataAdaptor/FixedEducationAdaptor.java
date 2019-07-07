package fixDataAdaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import Constants.ExperiencesConstants.ExperiencesConstants;
import dao.Mapper;
import excel.excelEntity.Education;
import fixedEntity.EducationFixed;
import org.apache.ibatis.session.SqlSession;
import excel.excelMapping.EducationColMapping;
import util.DataConnection;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FixedEducationAdaptor {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = EducationColMapping.TABLE_NAME_FIXED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<EducationFixed> getFixedEducationList() {
        //TODO get education list from DB and replace
        //get data from database
        List<Education> educationList = mapper.getAllEducation();
        sqlSession.commit();
        List<EducationFixed> educationFixedList = Lists.newArrayList();

        Map<String, List<Education>> educationMap = educationList.stream().collect(Collectors
                .groupingBy(Education::getWwid));


        for (Map.Entry<String, List<Education>> entry : educationMap.entrySet()) {
            HashSet educationSet = Sets.newHashSet();
            for (Education education : entry.getValue()) {
                educationSet.add(education.getHighest_degree_received());
            }

            EducationFixed educationFixed = new EducationFixed();
            educationFixed.setWwid(entry.getKey());
            if (educationSet.contains(ExperiencesConstants.MBA)) {
                educationFixed.setHighestEducation(ExperiencesConstants.MBA);
            }

            educationFixedList.add(educationFixed);

        }

        return educationFixedList;
    }

    //create table
    public static void generateScoreTable() {
        if (isExisted()) {
            dropTable();
        }
        createTable();

        List<EducationFixed> educationFixeds = getFixedEducationList();
        insertRecords(educationFixeds);


    }

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(EducationColMapping.COLUMN_MAPPING_FIXED));
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

    public static void insertRecords(List<EducationFixed> req) {
        try {
            req.forEach(educationFixed->{
                mapper.addFixedEducation(educationFixed);
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
