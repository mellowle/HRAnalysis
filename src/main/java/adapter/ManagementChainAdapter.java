package adapter;

import com.google.gson.Gson;
import entity.Education;
import entity.ManagementChain;
import table.EducationColMapping;
import table.ManagementChainColMapping;

import java.util.List;

public class ManagementChainAdapter extends Adapter {
//    @Override
    void setMapping() {
        this.COLUMN_MAPPING = ManagementChainColMapping.COLUMN_MAPPING;
    }

//    @Override
    void setTableName() {
        this.tableName = ManagementChainColMapping.TABLE_NAME;
    }

    //insert data
//    @Override
    void insertRecords() {

    }

    @Override
    void generateRawTable() {

    }

    //insert data
    private void insertRecords(List<ManagementChain> req) {
        try {
            req.forEach(managementChain -> {
                System.out.println("list size======" + gson.toJson(managementChain));
                mapper.addManagementChain(managementChain);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        ManagementChainAdapter managementChainAdapter = new ManagementChainAdapter();
        managementChainAdapter.init();
        if(managementChainAdapter.isExisted()){
            managementChainAdapter.dropTable();
       }
        managementChainAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedManagementChain.xlsx";
        List<ManagementChain> res = managementChainAdapter.generateExcel(ManagementChain.class,path);
        managementChainAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}