package adapter;

import com.google.gson.Gson;
import entity.Drivers;
import entity.TalentCard;
import table.DriversColMapping;
import table.TalentCardColMapping;

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
                System.out.println("list size======" + gson.toJson(drivers));
                mapper.addDrivers(drivers);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        DriversAdapter driversAdapter = new DriversAdapter();
        driversAdapter.init();
        if(driversAdapter.isExisted()){
            driversAdapter.dropTable();
       }
        driversAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/KF4DEncoded.xlsx";
        List<Drivers> res = driversAdapter.generateExcel(Drivers.class,path);
        driversAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}