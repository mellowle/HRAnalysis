package adapter;

import excel.excelEntity.Compensation;
import excel.excelMapping.CompensationColMapping;

import java.util.List;

public class CompensationAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = CompensationColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = CompensationColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Compensation> req) {
        try {
            req.forEach(compensation -> {
                mapper.addCompensation(compensation);
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
        String path = "/Users/xyang137/Documents/Archive/done/MergedCompensation.xlsx";
        List<Compensation> res = generateExcel(Compensation.class,path);
        insertRecords(res);
        sqlSession.close();
    }
}