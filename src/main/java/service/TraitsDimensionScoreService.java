package service;

import com.google.common.collect.Lists;
import dao.Mapper;
import dimensionRawData.DTraits;
import dimensionScored.DTraitsScored;
import entity.Traits;
import org.apache.ibatis.session.SqlSession;
import table.TraitsColMapping;
import util.DataConnection;
import util.KF4DScoreFunctionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TraitsDimensionScoreService {
    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;
    public static String tableName = TraitsColMapping.TABLE_NAME_SCORED;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DTraitsScored> getTraitsScores() {
        List<DTraitsScored> dTraitsScoredList = Lists.newArrayList();

        try {
            List<DTraits> dTraitsList = Lists.newArrayList();
            //
            List<Traits> results = mapper.getJoinedTraits();
            sqlSession.commit();
            results.forEach(traits->{
                DTraits dTraits = new DTraits(traits.getWwid(), traits.getAdaptability(), traits.getAffiliation(), traits.getAssertiveness(),
                        traits.getComposure(), traits.getConfidence(), traits.getCredibility(), traits.getCuriosity(), traits.getEmpathy(),
                        traits.getFocus(), traits.getHumility(), traits.getInfluence(), traits.getNeed_for_achievement(),
                        traits.getOpenness_to_differences(), traits.getOptimism(), traits.getPersistence(), traits.getRisk_taking(),
                        traits.getSituational_self_awareness(), traits.getSociability(), traits.getTolerance_of_ambiguity(),
                        traits.getTrust());
                dTraitsList.add(dTraits);
            });

            for (DTraits dTraits : dTraitsList) {
                DTraitsScored dTraitsScored = new DTraitsScored(dTraits.getWwid(), KF4DScoreFunctionUtils.calcTraitsScore(dTraits.getTraits()));
                dTraitsScoredList.add(dTraitsScored);
            }

            return dTraitsScoredList;
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

        List<DTraitsScored> dTraitsScoredList = getTraitsScores();

        insertRecords(dTraitsScoredList);

    }

    public static boolean isExisted() {
        return mapper.isTableExist(tableName) != 0;
    }

    public static void dropTable() {
        mapper.deleteTable(tableName);
    }

    public static void createTable() {
        mapper.createTable(tableName, generateColList(TraitsColMapping.COLUMN_MAPPING_SCORED));
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

    public static void insertRecords(List<DTraitsScored> req) {
        try {
            req.forEach(dTraitsScored->{
                mapper.addTraitsScored(dTraitsScored);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        generateScoreTable();
    }

    //    public static List<DTraitsScored> getTraitsScores() {
    //        List<DTraitsScored> dTraitsScoredList = Lists.newArrayList();
    //        // TODO get DExperiences from DB and replace
    //        List<DTraits> dTraitsList = Lists.newArrayList();
    //
    //        for (DTraits dTraits : dTraitsList) {
    //            DTraitsScored dTraitsScored = new DTraitsScored(dTraits.getWwid(), KF4DScoreFunctionUtils.calcTraitsScore(dTraits.getTraits()));
    //            dTraitsScoredList.add(dTraitsScored);
    //        }
    //        return dTraitsScoredList;
    //    }
}
