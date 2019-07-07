package fixDataAdaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import Constants.ExperiencesConstants.ExperiencesConstants;
import dao.Mapper;
import excel.excelEntity.WorkerChangeHistory;
import fixedEntity.WorkerChangeHistoryFixed;
import org.apache.ibatis.session.SqlSession;
import excel.excelMapping.WorkerChangeHistoryColMapping;
import util.DataConnection;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FixedWorkChangeHistoryAdapter {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = WorkerChangeHistoryColMapping.TABLE_NAME_FIXED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<WorkerChangeHistoryFixed> getFixedWorkChangeHistoryList() {
        //TODO: get work change history from DB and replace below
        List<WorkerChangeHistory> workerChangeHistoryListFromDB = mapper.getAllWorkChangeHistory();
        List<WorkerChangeHistoryFixed> workerChangeHistoryFixedList = Lists.newArrayList();

        Iterator<WorkerChangeHistory> iter = workerChangeHistoryListFromDB.iterator();
        while (iter.hasNext()) {
            WorkerChangeHistory history = iter.next();
            if (ExperiencesConstants.RESCINDED.equals(history.getBusiness_process_status())) {
                iter.remove();
            }
        }

//        Map<String, List<WorkerChangeHistory>> workChangeHistoryMap = workerChangeHistoryListFromDB.stream().collect(
//                Collectors.groupingBy(WorkerChangeHistory::getWwid));
//
//        for (Map.Entry<String, List<WorkerChangeHistory>> entry : workChangeHistoryMap.entrySet()){
//            String wwid = entry.getKey();
//            WorkerChangeHistoryFixed workerChangeHistoryFixed = new WorkerChangeHistoryFixed();
//            workerChangeHistoryFixed.setWwid(wwid);
//            workerChangeHistoryFixed.setCountryMovements(getCountryMovements(entry.getValue()));
//            workerChangeHistoryFixed.setPromotions(getPromotions(entry.getValue()));
//            workerChangeHistoryFixed.setRegionMovements(getRegionMovements(entry.getValue()));
//            workerChangeHistoryFixed.setLateralMovement(getLateralMovements(entry.getValue()));
//            workerChangeHistoryFixed.setFunctionMovement(getFunctionMovements(entry.getValue()));
//            workerChangeHistoryFixed.setSectorMovements(getFunctionMovements(entry.getValue()));
//            workerChangeHistoryFixedList.add(workerChangeHistoryFixed);
//        }

        return workerChangeHistoryFixedList;
    }

    private static int getCountryMovements(List<WorkerChangeHistory> workChangeHistoriesList) {
        Set<String> locationSet = Sets.newHashSet();
        int countryMove = 0;

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {
            if(workerChangeHistory.getLocation_current() != null ){
                locationSet.add(workerChangeHistory.getLocation_current().substring(0,2).toUpperCase());
            }
            if(workerChangeHistory.getLocation_proposed() != null){
                locationSet.add(workerChangeHistory.getLocation_proposed().substring(0,2).toUpperCase());
            }


        }

        countryMove = locationSet.size() - 1;

        return countryMove;
    }

    private static int getPromotions(List<WorkerChangeHistory> workChangeHistoriesList) {
        List<String> promotionList = Lists.newArrayList();

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {
            if (ExperiencesConstants.YES.equals(workerChangeHistory.getPay_group_change())) {
                promotionList.add(workerChangeHistory.getCompensation_grade_current());
            }

        }

        return promotionList.size();

    }

    private static int getRegionMovements(List<WorkerChangeHistory> workChangeHistoriesList) {
        int regionMovementCount = 0;
        Set<String> regionSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {
            regionSet.add(workerChangeHistory.getRegion_current());
            regionSet.add(workerChangeHistory.getRegion_proposed());
        }

        regionMovementCount = regionSet.size() - 1;

        return regionMovementCount;

    }

    private static int getLateralMovements(List<WorkerChangeHistory> workChangeHistoriesList) {
        int lateralMovementCount = 0;
        Set<String> lateralMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {
            lateralMovementSet.add(workerChangeHistory.getJob_profile_current());
            lateralMovementSet.add(workerChangeHistory.getJob_profile_proposed());
        }

        lateralMovementCount = lateralMovementSet.size() - 1;

        return lateralMovementCount;

    }

    private static int getFunctionMovements(List<WorkerChangeHistory> workChangeHistoriesList) {
        int functionMovementCount = 0;
        Set<String> functionMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {

//            if(workerChangeHistory.getJob_profile_current() == null || )
            if(workerChangeHistory.getJob_profile_current() != null){
                int currentCommaIndex = workerChangeHistory.getJob_profile_current().indexOf(",") == -1? 0: workerChangeHistory.getJob_profile_current().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_current().substring(currentCommaIndex, workerChangeHistory.getJob_profile_current().length()-1));

            }
            if(workerChangeHistory.getJob_profile_proposed() != null){
                int proposedCommaIndex = workerChangeHistory.getJob_profile_proposed().indexOf(",") == -1? 0: workerChangeHistory.getJob_profile_proposed().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_proposed().substring(proposedCommaIndex, workerChangeHistory.getJob_profile_proposed().length()-1));
            }

          }

        functionMovementCount = functionMovementSet.size() - 1;

        return functionMovementCount;

    }

    private static int getSectorMovements(List<WorkerChangeHistory> workChangeHistoriesList) {
        int sectorMovementCount = 0;
        Set<String> sectorMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workChangeHistoriesList) {
            sectorMovementSet.add(workerChangeHistory.getCompany_current().substring(0,4).toUpperCase());
            sectorMovementSet.add(workerChangeHistory.getCompany_proposed().substring(0,4).toUpperCase());
        }

        sectorMovementCount = sectorMovementSet.size() - 1;

        return sectorMovementCount;

    }

    //create table
    public static void generateScoreTable() {
        if (isExisted()) {
            dropTable();
        }
        createTable();

        List<WorkerChangeHistoryFixed> fixedWorkChangeHistories = getFixedWorkChangeHistoryList();
        insertRecords(fixedWorkChangeHistories);


    }

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(WorkerChangeHistoryColMapping.COLUMN_MAPPING_FIXED));
    }

    //通过map,生成数据库列
    private static List<Map<String, String>> generateColList(Map<String, String> map) {
        List<Map<String, String>> cols = new LinkedList<>();
        map.forEach((col, v)->{
            Map<String, String> colMap = new HashMap<>();
            if(col.equals("wwid")){
                colMap.put("code", col);
                colMap.put("type", "STRING");
                colMap.put("length", "500");
            }else{
                colMap.put("code", col);
                colMap.put("type", "NUMBER");
                colMap.put("length", "500");
            }
            cols.add(colMap);
        });
        return cols;
    }

    public static void insertRecords(List<WorkerChangeHistoryFixed> req) {
        try {
            req.forEach(workerChangeHistoryFixed->{
                mapper.addFixedWorkChangeHistory(workerChangeHistoryFixed);
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


