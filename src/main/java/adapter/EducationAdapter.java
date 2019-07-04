package adapter;

import com.google.gson.Gson;
import entity.Education;
import table.EducationColMapping;

import java.util.List;

public class EducationAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = EducationColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = EducationColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Education> req) {
        try {
            req.forEach(education -> {
                mapper.addEducation(education);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generateRawTable() {
        init();
        if(isExisted()){
            dropTable();
        }
        createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedManageEducation.xlsx";
        List<Education> res = generateExcel(Education.class,path);
        insertRecords(res);
        sqlSession.close();
    }
}