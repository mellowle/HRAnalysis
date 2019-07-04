package adapter;

import entity.TalentCard;
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
                mapper.addTalentCard(talentCard);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generateRawTable() {
        init();
        if(isExisted()){
            dropTable();
        }
        createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedTalentCard.xlsx";
        List<TalentCard> res = generateExcel(TalentCard.class,path);
        insertRecords(res);
        sqlSession.close();
    }
}