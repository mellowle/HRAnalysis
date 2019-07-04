package adapter;

import com.google.gson.Gson;
import entity.Competencies;
import entity.TalentCard;
import table.CompetenciesColMapping;
import table.TalentCardColMapping;

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
                System.out.println("list size======" + gson.toJson(competencies));
                mapper.addCompetencies(competencies);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        CompetenciesAdapter competenciesAdapter = new CompetenciesAdapter();
        competenciesAdapter.init();
        if(competenciesAdapter.isExisted()){
            competenciesAdapter.dropTable();
       }
        competenciesAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/KF4DEncoded.xlsx";
        List<Competencies> res = competenciesAdapter.generateExcel(Competencies.class,path);
        competenciesAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}