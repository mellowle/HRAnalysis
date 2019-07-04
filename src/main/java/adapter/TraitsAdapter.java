package adapter;

import com.google.gson.Gson;
import entity.Drivers;
import entity.Traits;
import table.DriversColMapping;
import table.TraitsColMapping;

import java.util.List;

public class TraitsAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = TraitsColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = TraitsColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Traits> req) {
        try {
            req.forEach(traits -> {
                System.out.println("list size======" + gson.toJson(traits));
                mapper.addTraits(traits);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        TraitsAdapter traitsAdapter = new TraitsAdapter();
        traitsAdapter.init();
        if(traitsAdapter.isExisted()){
            traitsAdapter.dropTable();
       }
        traitsAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/KF4DEncoded.xlsx";
        List<Traits> res = traitsAdapter.generateExcel(Traits.class,path);
        traitsAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}