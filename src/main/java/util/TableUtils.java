package util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import dao.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class TableUtils {

    public static DataConnection dataConn = new DataConnection();
    public static Mapper mapper = null;
    public static SqlSession sqlSession;

    static {
        try {
            sqlSession = dataConn.getSqlSession();
            mapper = sqlSession.getMapper(Mapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExisted(String tableName) {
        return mapper.isTableExist(tableName) != 0;
    }

    //drop table
    public static void dropTable(String tableName) {
        mapper.deleteTable(tableName);
    }

    public static void createTable(String tableName, Map<String, String> colMap) {
        mapper.createTable(tableName, generateColList(colMap));
    }

    private static List<Map<String, String>> generateColList(Map<String, String> map) {
        List<Map<String, String>> cols = Lists.newArrayList();
        map.forEach((col, v)->{
            Map<String, String> colMap = Maps.newHashMap();
            colMap.put("code", col);
            colMap.put("type", v);
            //            colMap.put("length", "500");
            cols.add(colMap);
        });
        return cols;
    }

    public static <T> void insertRecords(List<T> list, Class clazz) throws Exception {
        String methodName = "add" + clazz.getSimpleName();
        System.out.println(methodName);
        Method method = mapper.getClass().getDeclaredMethod(methodName, clazz);
        for(T item: list){
            method.invoke(mapper, item);
            sqlSession.commit();
        }
    }

    public static <T> List<T> getAllRecords(Class<T> clazz) throws Exception {
        List<T> results;
        String methodName = "getAll" + clazz.getSimpleName();
        Method method = mapper.getClass().getDeclaredMethod(methodName);
        results = (List<T>)method.invoke(mapper);
        return results;
    }
}
