package service.intervalService;

import Constants.Pojo2DBEnum;
import com.google.common.collect.Maps;
import util.TableUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class AbstractIntervalService {

    public String TABLE_NAME;
    public Class CLAZZ;


    public void initTable() {
        if (TableUtils.isExisted(this.TABLE_NAME)) {
            TableUtils.dropTable(this.TABLE_NAME);
        }
        TableUtils.createTable(this.TABLE_NAME, getFieldTypeNameMapping());
    }

    public <T> void insertRecords(List<T> list, String tableName) throws Exception {
        TableUtils.insertRecords(list, CLAZZ, tableName);
    }

    private Map<String, String> getFieldTypeNameMapping() {
        Map<String, String> results = Maps.newLinkedHashMap();
        Field field;

        Field[] fields = CLAZZ.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            field.setAccessible(true);
            results.put(field.getName(), Pojo2DBEnum.getDBType(field.getType().getName()));
        }

        return results;
    }

}
