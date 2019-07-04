package adapter;

import com.google.gson.Gson;
import entity.TalentCard;
import entity.WorkChangeHistory;
import table.TalentCardColMapping;
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
                System.out.println("list size======" + gson.toJson(workChangeHistory));
                mapper.addWorkChangeHistory(workChangeHistory);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        WorkChangeHistoryAdapter workChangeHistoryAdapter = new WorkChangeHistoryAdapter();
        workChangeHistoryAdapter.init();
        if(workChangeHistoryAdapter.isExisted()){
            workChangeHistoryAdapter.dropTable();
       }
        workChangeHistoryAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedWorkerChangeHistory.xlsx";
        List<WorkChangeHistory> res = workChangeHistoryAdapter.generateExcel(WorkChangeHistory.class,path);
        workChangeHistoryAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}