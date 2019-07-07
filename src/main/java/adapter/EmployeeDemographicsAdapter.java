package adapter;

import entity.excelEntity.EmployeeDemographics;
import excelMapping.EmployeeDemographicsColMapping;

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
                mapper.addEmployeeDemographics(employeeDemographics);
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
        String path = "/Users/xyang137/Documents/MergedEmployeeDemographics.xlsx";
        List<EmployeeDemographics> res = generateExcel(EmployeeDemographics.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}