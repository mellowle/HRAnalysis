package service.excelService;

import entity.excelEntity.TalentCard;

import java.util.List;

public class TalentCardExcelService extends AbstractExcelService {

    public static void main(String... args) throws Exception {
        TalentCardExcelService c = new TalentCardExcelService();
        List<TalentCard> results = c.getResults();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<TalentCard> getResults() throws Exception {
//        List<TalentCard> results;
//        this.COLUMN_MAPPING = TalentCardColMapping.COLUMN_MAPPING;
//        results = sheet2Entities(TalentCard.class);
        return sheet2Entities();
    }
}