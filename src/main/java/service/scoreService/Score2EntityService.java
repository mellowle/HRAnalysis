package service.scoreService;

import Constants.Pojo2DBEnum;
import com.google.common.collect.Maps;
import entity.dimensionScored.DCompetenciesScored;
import util.TableUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class Score2EntityService {

    public String TABLE_NAME_SCORED;
    public Class CLAZZ;

    public static void main(String... args) throws Exception {
        Score2EntityService s = new Score2EntityService();
        s.CLAZZ = DCompetenciesScored.class;
        s.getFieldTypeNameMapping();

    }

        public void initTable() throws Exception {
            if (TableUtils.isExisted(this.TABLE_NAME_SCORED)) {
                TableUtils.dropTable(this.TABLE_NAME_SCORED);
            }
            TableUtils.createTable(this.TABLE_NAME_SCORED, getFieldTypeNameMapping());
        }

        public <T> void insertRecords(List<T> list) throws Exception {
            TableUtils.insertRecords(list, CLAZZ);
        }

    private Map<String, String> getFieldTypeNameMapping() {
        Map<String, String> results = Maps.newHashMap();
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
