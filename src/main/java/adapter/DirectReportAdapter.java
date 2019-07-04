package adapter;

import com.google.gson.Gson;
import entity.DirectReport;
import entity.PerformanceRating;
import table.DirectReportColMapping;
import table.PerformanceRatingColMapping;

import java.util.List;

public class DirectReportAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = DirectReportColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = DirectReportColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<DirectReport> req) {
        try {
            req.forEach(directReport -> {
                System.out.println("list size======" + gson.toJson(directReport));
                mapper.addDirectReport(directReport);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generateRawTable() {
        DirectReportAdapter directReportAdapter = new DirectReportAdapter();
        directReportAdapter.init();
        if(directReportAdapter.isExisted()){
            directReportAdapter.dropTable();
        }
        directReportAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedDirectReports.xlsx";
        List<DirectReport> res = directReportAdapter.generateExcel(DirectReport.class,path);
        directReportAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}
// MergedEmployeePerformanceRatings.xlsx