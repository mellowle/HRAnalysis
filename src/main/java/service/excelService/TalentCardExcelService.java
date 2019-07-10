package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.ManagementChain;
import entity.excelEntity.TalentCard;
import excelMapping.TalentCardColMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TalentCardExcelService extends AbstractExcelService {
    public TalentCardExcelService(){
        this.COLUMN_MAPPING = TalentCardColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = TalentCardColMapping.EXCEL_NAME;
        this.TABLE_NAME = TalentCardColMapping.TABLE_NAME;
        this.CLAZZ = TalentCard.class;
    }

    public static void main(String... args) throws Exception {
        TalentCardExcelService c = new TalentCardExcelService();
        List<TalentCard> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        System.err.println(tmp.size());
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }

    public List<TalentCard> getResults() throws Exception {
        List<TalentCard> results = sheet2Entities(TalentCard.class);
        results = results.stream().filter(i->i.getWwid() != null).collect(Collectors.toList());
        return results;
    }
}