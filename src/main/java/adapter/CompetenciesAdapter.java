package adapter;

import entity.excelEntity.Competencies;
import excelMapping.CompetenciesColMapping;

import java.util.List;

public class CompetenciesAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = CompetenciesColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = CompetenciesColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Competencies> req) {
        try {
            req.forEach(competencies -> {
                mapper.addCompetencies(competencies);
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
        List<Competencies> res = generateExcel(Competencies.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}