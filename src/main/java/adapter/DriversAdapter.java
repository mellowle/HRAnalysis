package adapter;

import entity.Drivers;
import table.DriversColMapping;

import java.util.List;

public class DriversAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = DriversColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = DriversColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Drivers> req) {
        try {
            req.forEach(drivers -> {
                mapper.addDrivers(drivers);
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
        String path = "/Users/xyang137/Documents/Archive/pending/KF4DEncoded.xlsx";
        List<Drivers> res = generateExcel(Drivers.class,path);
        insertRecords(res);
        sqlSession.close();
    }
}