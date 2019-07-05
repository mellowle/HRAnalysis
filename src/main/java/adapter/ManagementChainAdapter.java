package adapter;

import entity.ManagementChain;
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

    //insert data
    private void insertRecords(List<ManagementChain> req) {
        try {
            req.forEach(managementChain->{
                mapper.addManagementChain(managementChain);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generateRawTable() {
        init();
        if (isExisted()) {
            dropTable();
        }
        createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedManagementChain.xlsx";
        List<ManagementChain> res = generateExcel(ManagementChain.class, path);
        res.forEach(managementChain->{
            managementChain.setHierarchy();
        });
        insertRecords(res);
        sqlSession.close();
    }
}