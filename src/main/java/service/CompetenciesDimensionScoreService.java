package service;

import com.google.common.collect.Lists;
import dao.Mapper;
import dimensionRawData.DCompetencies;
import dimensionScored.DCompetenciesScored;
import excel.excelEntity.Competencies;
import org.apache.ibatis.session.SqlSession;
import excel.excelMapping.CompetenciesColMapping;
import util.DataConnection;
import util.KF4DScoreFunctionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompetenciesDimensionScoreService {
    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = CompetenciesColMapping.TABLE_NAME_SCORED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DCompetenciesScored> getCompetenciesScores() {
        List<DCompetenciesScored> dCompetenciesScoredList = Lists.newArrayList();

        try {
            List<DCompetencies> dCompetenciesList = Lists.newArrayList();
            //
            List<Competencies> results = mapper.getJoinedCompetencies();
            sqlSession.commit();
            results.forEach(competencies->{
                DCompetencies dCompetencies = new DCompetencies(competencies.getWwid(), competencies.getAction_oriented(), competencies.getBalances_stakeholders(),
                        competencies.getBeing_resilient(), competencies.getBuilds_effective_teams(), competencies.getBuilds_networks(),
                        competencies.getCollaborates(), competencies.getCommunicates_effectively(), competencies.getCourage(),
                        competencies.getCultivates_innovation(), competencies.getCustomer_focus(), competencies.getDecision_quality(),
                        competencies.getDevelops_talent(), competencies.getDirects_work(), competencies.getDrives_engagement(),
                        competencies.getDrives_results(), competencies.getEnsures_accountability(), competencies.getGlobal_perspective(),
                        competencies.getInstills_trust(), competencies.getInterpersonal_savvy(), competencies.getManages_ambiguity(),
                        competencies.getManages_conflict(), competencies.getNimble_learning(), competencies.getOptimizes_work_processes(),
                        competencies.getPersuades(), competencies.getPlans_and_aligns(), competencies.getResourcefulness(),
                        competencies.getSelf_development(), competencies.getSituational_adaptability(), competencies.getStrategic_mindset(),
                        competencies.getValues_differences());
                dCompetenciesList.add(dCompetencies);
            });


            for (DCompetencies dCompetencies : dCompetenciesList) {
                DCompetenciesScored dCompetenciesScored = new DCompetenciesScored(dCompetencies.getWwid(),
                        KF4DScoreFunctionUtils.calcMissionCriticalScore(dCompetencies.getMissionCritical()),
                        KF4DScoreFunctionUtils.calcCriticalScore(dCompetencies.getCritical()),
                        KF4DScoreFunctionUtils.calcLessCriticalScore(dCompetencies.getLessCritical()));
                dCompetenciesScoredList.add(dCompetenciesScored);
            }
            return dCompetenciesScoredList;
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

        List<DCompetenciesScored> dCompetenciesScoredList = getCompetenciesScores();
        insertRecords(dCompetenciesScoredList);


    }

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(CompetenciesColMapping.COLUMN_MAPPING_SCORED));
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

    public static void insertRecords(List<DCompetenciesScored> req) {
        try {
            req.forEach(dCompetenciesScored->{
                mapper.addCompetenciesScored(dCompetenciesScored);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        generateScoreTable();
    }

    //    public static List<DCompetenciesScored> getExperienceScores() {
    //        List<DCompetenciesScored> competenciesScoredList = Lists.newArrayList();
    //        // TODO get DExperiences from DB and replace
    //        List<DCompetencies> dCompetenciesList = Lists.newArrayList();
    //
    //        for (DCompetencies dCompetencies : dCompetenciesList) {
    //            DCompetenciesScored dCompetenciesScored = new DCompetenciesScored(dCompetencies.getWwid(),
    //                    KF4DScoreFunctionUtils.calcMissionCriticalScore(dCompetencies.getMissionCritical()),
    //                    KF4DScoreFunctionUtils.calcCriticalScore(dCompetencies.getCritical()),
    //                    KF4DScoreFunctionUtils.calcLessCriticalScore(dCompetencies.getLessCritical()));
    //            competenciesScoredList.add(dCompetenciesScored);
    //        }
    //        return competenciesScoredList;
    //    }

}
