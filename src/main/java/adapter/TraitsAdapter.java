package adapter;

import entity.Traits;
import table.TraitsColMapping;

import java.util.List;

public class TraitsAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = TraitsColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = TraitsColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Traits> req) {
        try {
            req.forEach(traits -> {
                mapper.addTraits(traits);
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
        String path = "/Users/xyang137/Documents/Archive/pending/KF4DEncoded.xlsx";
        List<Traits> res = generateExcel(Traits.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}