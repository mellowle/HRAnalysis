package adapter;

import com.google.gson.Gson;
import entity.PerformanceRating;
import table.PerformanceRatingColMapping;

import java.util.List;

public class PerformanceRatingAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = PerformanceRatingColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = PerformanceRatingColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<PerformanceRating> req) {
        try {
            req.forEach(performanceRating -> {
                System.out.println("list size======" + gson.toJson(performanceRating));
                mapper.addPerformanceRating(performanceRating);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PerformanceRatingAdapter performanceRatingAdapter = new PerformanceRatingAdapter();
        performanceRatingAdapter.init();
        if(performanceRatingAdapter.isExisted()){
            performanceRatingAdapter.dropTable();
       }
        performanceRatingAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedEmployeePerformanceRatings.xlsx";
        List<PerformanceRating> res = performanceRatingAdapter.generateExcel(PerformanceRating.class,path);
        performanceRatingAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}
// MergedEmployeePerformanceRatings.xlsx