package adapter;

import excel.excelEntity.TalentCard;
import excel.excelMapping.TalentCardColMapping;

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
        String path = "/Users/xyang137/Documents/Archive/done/MergedTalentCard.xlsx";
        List<TalentCard> res = generateExcel(TalentCard.class,path);
        res.forEach(talentCard -> {
//            talentCard.setAverageTimeOfEachRole();
//            talentCard.setTotalRoleNumber();
//            talentCard.setExternalLengthOfService();
//            talentCard.setTotalWorkingYears();
        });
        insertRecords(res);
        sqlSession.close();
    }
}