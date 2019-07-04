package adapter;

import com.google.gson.Gson;
import entity.EmployeeDemographics;
import entity.PerformanceRating;
import table.EmployeeDemographicsColMapping;
import table.PerformanceRatingColMapping;

import java.util.List;

public class EmployeePerformanceRatingsAdapter extends Adapter {
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

    public static void main(String[] args) {
        EmployeePerformanceRatingsAdapter employeePerformanceRatingsAdapter = new EmployeePerformanceRatingsAdapter();
        employeePerformanceRatingsAdapter.init();
//        if(employeeDemographicsAdapter.isExisted()){
//            employeeDemographicsAdapter.dropTable();
//        }
//        employeeDemographicsAdapter.createTable();
        String path = "/Users/xyang137/Documents/MergedEmployeePerformanceRatings.xlsx";
        List<PerformanceRating> res = employeePerformanceRatingsAdapter.generateExcel(PerformanceRating.class,path);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}
// MergedEmployeePerformanceRatings.xlsx