package adapter;

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
                mapper.addPerformanceRating(performanceRating);
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
        String path = "/Users/xyang137/Documents/Archive/done/MergedEmployeePerformanceRatings.xlsx";
        List<PerformanceRating> res = generateExcel(PerformanceRating.class,path);
        insertRecords(res);
        sqlSession.close();
    }
}