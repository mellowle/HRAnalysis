package adapter;

import com.google.gson.Gson;
import entity.ManagementChain;
import entity.TalentCard;
import table.ManagementChainColMapping;
import table.TalentCardColMapping;

import java.util.List;

public class TalentCardAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = TalentCardColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = TalentCardColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<TalentCard> req) {
        try {
            req.forEach(talentCard -> {
                System.out.println("list size======" + gson.toJson(talentCard));
                mapper.addTalentCard(talentCard);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        TalentCardAdapter talentCardAdapter = new TalentCardAdapter();
        talentCardAdapter.init();
        if(talentCardAdapter.isExisted()){
            talentCardAdapter.dropTable();
       }
        talentCardAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedTalentCard.xlsx";
        List<TalentCard> res = talentCardAdapter.generateExcel(TalentCard.class,path);
        talentCardAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}