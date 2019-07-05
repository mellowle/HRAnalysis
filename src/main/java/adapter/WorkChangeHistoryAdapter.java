package adapter;

import entity.WorkChangeHistory;
import table.WorkerChangeHistoryColMapping;

import java.util.List;

public class WorkChangeHistoryAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = WorkerChangeHistoryColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = WorkerChangeHistoryColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<WorkChangeHistory> req) {
        try {
            req.forEach(workChangeHistory -> {
                mapper.addWorkChangeHistory(workChangeHistory);
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
        String path = "/Users/xyang137/Documents/Archive/pending/ChangeHistoryReportEncode.xlsx";
        List<WorkChangeHistory> res = generateExcel(WorkChangeHistory.class, path);
        insertRecords(res);
        sqlSession.close();
    }
}