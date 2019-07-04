package adapter;

import com.google.gson.Gson;
import entity.EmployeeDemographics;
import table.EmployeeDemographicsColMapping;

import java.util.List;

public class EmployeeDemographicsAdapter extends Adapter {

    @Override
    void setMapping() {
        this.COLUMN_MAPPING = EmployeeDemographicsColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = EmployeeDemographicsColMapping.TABLE_NAME;
    }

    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<EmployeeDemographics> req) {
        try {
            req.forEach(employeeDemographics -> {
                System.out.println("list size======" + gson.toJson(employeeDemographics));
                mapper.addEmployeeDemographics(employeeDemographics);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        EmployeeDemographicsAdapter employeeDemographicsAdapter = new EmployeeDemographicsAdapter();
        employeeDemographicsAdapter.init();
//        if(employeeDemographicsAdapter.isExisted()){
//            employeeDemographicsAdapter.dropTable();
//        }
//        employeeDemographicsAdapter.createTable();
        String path = "/Users/xyang137/Documents/MergedEmployeeDemographics.xlsx";
        List<EmployeeDemographics> res = employeeDemographicsAdapter.generateExcel(EmployeeDemographics.class, path);
        employeeDemographicsAdapter.insertRecords(res);
        //System.out.println("list size======"+ gson.toJson(res));
    }
}
// MergedEmployeePerformanceRatings.xlsx