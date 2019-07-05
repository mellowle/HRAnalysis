package fixDataAdaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import Constants.ExperiencesConstants.Constants;
import dao.Mapper;
import entity.WorkChangeHistory;
import fixedEntity.FixedEducation;
import fixedEntity.FixedWorkChangeHistory;
import org.apache.ibatis.session.SqlSession;
import table.EducationColMapping;
import table.WorkerChangeHistoryColMapping;
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

    public static List<FixedWorkChangeHistory> getFixedWorkChangeHistoryList() {
        //TODO: get work change history from DB and replace below
        List<WorkChangeHistory> workChangeHistoryListFromDB = mapper.getAllWorkChangeHistory();
        List<FixedWorkChangeHistory> fixedWorkChangeHistoryList = Lists.newArrayList();

        Iterator<WorkChangeHistory> iter = workChangeHistoryListFromDB.iterator();
        while (iter.hasNext()) {
            WorkChangeHistory history = iter.next();
            if ("Rescinded".equals(history.getBusiness_process_status())) {
                iter.remove();
            }
        }

        Map<String, List<WorkChangeHistory>> workChangeHistoryMap = workChangeHistoryListFromDB.stream().collect(
                Collectors.groupingBy(WorkChangeHistory::getWwid));

        for (Map.Entry<String, List<WorkChangeHistory>> entry : workChangeHistoryMap.entrySet()){
            String wwid = entry.getKey();
            FixedWorkChangeHistory fixedWorkChangeHistory = new FixedWorkChangeHistory();
            fixedWorkChangeHistory.setWwid(wwid);
            fixedWorkChangeHistory.setCountryMovements(getCountryMovements(entry.getValue()));
            fixedWorkChangeHistory.setPromotions(getPromotions(entry.getValue()));
            fixedWorkChangeHistory.setRegionMovements(getRegionMovements(entry.getValue()));
            fixedWorkChangeHistory.setLateralMovement(getLateralMovements(entry.getValue()));
            fixedWorkChangeHistory.setFunctionMovement(getFunctionMovements(entry.getValue()));
            fixedWorkChangeHistory.setSectorMovements(getFunctionMovements(entry.getValue()));
            fixedWorkChangeHistoryList.add(fixedWorkChangeHistory);
        }

        return fixedWorkChangeHistoryList;
    }

    private static int getCountryMovements(List<WorkChangeHistory> workChangeHistoriesList) {
        Set<String> locationSet = Sets.newHashSet();
        int countryMove = 0;

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {
            if(workChangeHistory.getLocation_current() != null ){
                locationSet.add(workChangeHistory.getLocation_current().substring(0,2).toUpperCase());
            }
            if(workChangeHistory.getLocation_proposed() != null){
                locationSet.add(workChangeHistory.getLocation_proposed().substring(0,2).toUpperCase());
            }


        }

        countryMove = locationSet.size() - 1;

        return countryMove;
    }

    private static int getPromotions(List<WorkChangeHistory> workChangeHistoriesList) {
        List<String> promotionList = Lists.newArrayList();

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {
            if (Constants.YES.equals(workChangeHistory.getPay_group_change())) {
                promotionList.add(workChangeHistory.getCompensation_grade_current());
            }

        }

        return promotionList.size();

    }

    private static int getRegionMovements(List<WorkChangeHistory> workChangeHistoriesList) {
        int regionMovementCount = 0;
        Set<String> regionSet = Sets.newHashSet();

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {
            regionSet.add(workChangeHistory.getRegion_current());
            regionSet.add(workChangeHistory.getRegion_proposed());
        }

        regionMovementCount = regionSet.size() - 1;

        return regionMovementCount;

    }

    private static int getLateralMovements(List<WorkChangeHistory> workChangeHistoriesList) {
        int lateralMovementCount = 0;
        Set<String> lateralMovementSet = Sets.newHashSet();

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {
            lateralMovementSet.add(workChangeHistory.getJob_profile_current());
            lateralMovementSet.add(workChangeHistory.getJob_profile_proposed());
        }

        lateralMovementCount = lateralMovementSet.size() - 1;

        return lateralMovementCount;

    }

    private static int getFunctionMovements(List<WorkChangeHistory> workChangeHistoriesList) {
        int functionMovementCount = 0;
        Set<String> functionMovementSet = Sets.newHashSet();

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {

//            if(workChangeHistory.getJob_profile_current() == null || )
            if(workChangeHistory.getJob_profile_current() != null){
                int currentCommaIndex = workChangeHistory.getJob_profile_current().indexOf(",") == -1? 0:workChangeHistory.getJob_profile_current().indexOf(",");
                functionMovementSet.add(workChangeHistory.getJob_profile_current().substring(currentCommaIndex,workChangeHistory.getJob_profile_current().length()-1));

            }
            if(workChangeHistory.getJob_profile_proposed() != null){
                int proposedCommaIndex = workChangeHistory.getJob_profile_proposed().indexOf(",") == -1? 0:workChangeHistory.getJob_profile_proposed().indexOf(",");
                functionMovementSet.add(workChangeHistory.getJob_profile_proposed().substring(proposedCommaIndex,workChangeHistory.getJob_profile_proposed().length()-1));
            }

          }

        functionMovementCount = functionMovementSet.size() - 1;

        return functionMovementCount;

    }

    private static int getSectorMovements(List<WorkChangeHistory> workChangeHistoriesList) {
        int sectorMovementCount = 0;
        Set<String> sectorMovementSet = Sets.newHashSet();

        for (WorkChangeHistory workChangeHistory : workChangeHistoriesList) {
            sectorMovementSet.add(workChangeHistory.getCompany_current().substring(0,4).toUpperCase());
            sectorMovementSet.add(workChangeHistory.getCompany_proposed().substring(0,4).toUpperCase());
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

        List<FixedWorkChangeHistory> fixedWorkChangeHistories = getFixedWorkChangeHistoryList();
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

    public static void insertRecords(List<FixedWorkChangeHistory> req) {
        try {
            req.forEach(fixedWorkChangeHistory->{
                mapper.addFixedWorkChangeHistory(fixedWorkChangeHistory);
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


