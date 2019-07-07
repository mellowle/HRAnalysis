package adapter;

import entity.excelEntity.UnstructuredData;
import excelMapping.UnstructuredDataColMapping;

import java.util.List;

public class UnstructuredDataAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = UnstructuredDataColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = UnstructuredDataColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<UnstructuredData> req) {
        try {
            req.forEach(unstructuredData -> {
                mapper.addUnstructuredData(unstructuredData);
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
        String path = "/Users/xyang137/Documents/Archive/pending/MergedUnstructuredData.xlsx";
        List<UnstructuredData> res = generateExcel(UnstructuredData.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}