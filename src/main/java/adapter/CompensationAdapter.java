package adapter;

import com.google.gson.Gson;
import entity.Compensation;
import entity.PerformanceRating;
import table.CompensationColMapping;
import table.PerformanceRatingColMapping;

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
                System.out.println("list size======" + gson.toJson(compensation));
                mapper.addCompensation(compensation);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        CompensationAdapter compensationAdapter = new CompensationAdapter();
        compensationAdapter.init();
        if(compensationAdapter.isExisted()){
            compensationAdapter.dropTable();
       }
        compensationAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedCompensation.xlsx";
        List<Compensation> res = compensationAdapter.generateExcel(Compensation.class,path);
        compensationAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}