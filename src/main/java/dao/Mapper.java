package dao;

import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface Mapper {

    int isTableExist(@Param("tableName") String tableName);
    void deleteTable(@Param("tableName") String tableName);
    void createTable(@Param("newTableName") String newTableName, @Param("columns") List<Map<String, String>> columns);
}