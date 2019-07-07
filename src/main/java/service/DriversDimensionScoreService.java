package service;

import com.google.common.collect.Lists;
import dao.Mapper;
import dimensionRawData.DDrivers;
import dimensionScored.DDriversScored;
import excel.excelEntity.Drivers;
import org.apache.ibatis.session.SqlSession;
import excel.excelMapping.DriversColMapping;
import util.DataConnection;
import util.KF4DScoreFunctionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DriversDimensionScoreService {
    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = DriversColMapping.TABLE_NAME_SCORED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DDriversScored> getDriversScores() {
        List<DDriversScored> dDriversScoredList = Lists.newArrayList();

        try {
            List<DDrivers> dDriversList = Lists.newArrayList();

            List<Drivers> results = mapper.getJoinedDrivers();
            sqlSession.commit();
            results.forEach(drivers->{
                DDrivers dDrivers = new DDrivers(drivers.getWwid(), drivers.getBalance(), drivers.getChallenge(), drivers.getCollaboration(), drivers.getIndependence(), drivers.getPower(), drivers.getStructure());
                dDriversList.add(dDrivers);
            });

            for (DDrivers dDrivers : dDriversList) {
                DDriversScored dTraitsScored = new DDriversScored(dDrivers.getWwid(), KF4DScoreFunctionUtils.calcDriversScore(dDrivers.getDrivers()));
                dDriversScoredList.add(dTraitsScored);
            }
            return dDriversScoredList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void generateScoreTable() {
        if (isExisted()) {
            dropTable();
        }

        createTable();

        List<DDriversScored> dDriversScoredList = getDriversScores();
        insertRecords(dDriversScoredList);

    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(DriversColMapping.COLUMN_MAPPING_SCORED));
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

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void insertRecords(List<DDriversScored> req) {
        try {
            req.forEach(dDriversScored->{
                mapper.addDriversScored(dDriversScored);
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
