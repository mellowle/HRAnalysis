package adapter;

import excel.excelEntity.DirectReport;
import excel.excelMapping.DirectReportColMapping;

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
                mapper.addDirectReport(directReport);
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
        String path = "/Users/xyang137/Documents/Archive/done/MergedDirectReports.xlsx";
        List<DirectReport> res = generateExcel(DirectReport.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}