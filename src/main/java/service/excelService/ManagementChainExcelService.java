package service.excelService;

import com.google.common.collect.Sets;
import entity.excelEntity.ManagementChain;
import excelMapping.ManagementChainColMapping;

import java.util.*;
import java.util.stream.Collectors;

public class ManagementChainExcelService extends AbstractExcelService {

    public ManagementChainExcelService(){
        this.COLUMN_MAPPING = ManagementChainColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = ManagementChainColMapping.EXCEL_NAME;
        this.TABLE_NAME = ManagementChainColMapping.TABLE_NAME;
        this.CLAZZ = ManagementChain.class;
    }

    public static void main(String... args) throws Exception {
        ManagementChainExcelService c = new ManagementChainExcelService();
        List<ManagementChain> results = c.getResults();
        System.out.println(results.size());
        Set<String> tmp = Sets.newHashSet();
        results.forEach(result->{
            tmp.add(result.getWwid());
        });
        List<ManagementChain> unique = results.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ManagementChain::getWwid)))
                        , ArrayList::new));
        System.err.println(unique.size());
        c.initTable();
        c.insertRecords(unique);
        System.err.println("done");
    }

    public List<ManagementChain> getResults() throws Exception {
        List<ManagementChain> results;
        results = sheet2Entities(ManagementChain.class);
        results.forEach(result->{
            result.setHierarchy_count();
        });
        return results;
    }
}
