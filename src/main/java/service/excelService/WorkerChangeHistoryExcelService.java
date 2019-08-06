package service.excelService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import entity.excelEntity.WorkerChangeHistory;
import entity.excelEntity.fixed.WorkerChangeHistoryFixed;
import excelMapping.WorkerChangeHistoryColMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkerChangeHistoryExcelService extends AbstractExcelService {

    public WorkerChangeHistoryExcelService() {
        this.COLUMN_MAPPING = WorkerChangeHistoryColMapping.COLUMN_MAPPING;
        this.EXCEL_NAME = WorkerChangeHistoryColMapping.EXCEL_NAME;
        this.TABLE_NAME = WorkerChangeHistoryColMapping.TABLE_NAME_FIXED;
        this.CLAZZ = WorkerChangeHistoryFixed.class;
    }

    public static void main(String... args) throws Exception {
        WorkerChangeHistoryExcelService c = new WorkerChangeHistoryExcelService();
        List<WorkerChangeHistoryFixed> results = c.getResultsFixed();
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

    public Map<String, List<WorkerChangeHistory>> getResults() throws Exception {
        List<WorkerChangeHistory> results = sheet2Entities(WorkerChangeHistory.class);
        Map<String, List<WorkerChangeHistory>> workChangeHistoryMap = Maps.newHashMap();
        workChangeHistoryMap = results.stream()
                .filter(i->i.getBusiness_process_status().equals(ExperiencesConstants.SUCCESSFULLY_COMPLETED))
                .collect(Collectors.groupingBy(WorkerChangeHistory::getWwid));
        //        System.err.println(workChangeHistoryMap.size());
        //        workChangeHistoryMap.entrySet().stream().forEach(entry->
        //                {
        //                    if(entry.getKey().equals("6248fbd10c04d538f9168946db036108")){
        //                        System.out.println(entry);
        //                    }
        //                }
        //
        //
        //                );
        //        System.exit(-1);

        return workChangeHistoryMap;
    }

    public List<WorkerChangeHistoryFixed> getResultsFixed() throws Exception {
        List<WorkerChangeHistoryFixed> results = Lists.newArrayList();
        Map<String, List<WorkerChangeHistory>> workChangeHistoryMap = getResults();

        for (Map.Entry<String, List<WorkerChangeHistory>> entry : workChangeHistoryMap.entrySet()) {
            String wwid = entry.getKey();
            WorkerChangeHistoryFixed workerChangeHistoryFixed = new WorkerChangeHistoryFixed();
            workerChangeHistoryFixed.setWwid(wwid);
            workerChangeHistoryFixed.setFunction_movements(getFunctionMovements(entry.getValue()));
            workerChangeHistoryFixed.setLateral_movements(getLateralMovements(entry.getValue()));
            workerChangeHistoryFixed.setPromotions(getPromotions(entry.getValue()));
            workerChangeHistoryFixed.setCountry_movements(getCountryMovements(entry.getValue()));
            workerChangeHistoryFixed.setRegion_movements(getRegionMovements(entry.getValue()));
            workerChangeHistoryFixed.setSector_movements(getSectorMovements(entry.getValue()));
            results.add(workerChangeHistoryFixed);
        }

        return results;
    }

    private int getCountryMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int countryMovements = 0;

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (workerChangeHistory.getBusiness_process_reason().contains(ExperiencesConstants.NEW_COUNTRY)) {
                countryMovements++;
            }
        }

        return countryMovements;
    }

    private int getPromotions(List<WorkerChangeHistory> workerChangeHistoryList) {
        int promotions = 0;

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (workerChangeHistory.getBusiness_process_reason().contains(ExperiencesConstants.PROMOTION)) {
                promotions++;
            }
        }

        return promotions;

    }

    private int getRegionMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int regionMovements = 0;
        Set<String> regionSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (workerChangeHistory.getBusiness_process_reason().contains(ExperiencesConstants.NEW_COUNTRY)) {
                regionSet.add(workerChangeHistory.getLocation_current().substring(0, 2));
                regionSet.add(workerChangeHistory.getLocation_proposed().substring(0, 2));
            }
        }


        if (regionSet.size() != 0) {
            if (regionSet.contains("CN") || regionSet.contains("SA")) {
                regionMovements++;
            }

            if (regionSet.contains("US")) {
                regionMovements++;
            }

            return regionMovements - 1;

        }

        return 0;

    }

    private int getLateralMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int lateralMovements = 0;

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (workerChangeHistory.getBusiness_process_reason().contains(ExperiencesConstants.LATERAL_MOVE)) {
                lateralMovements++;
            }
        }

        return lateralMovements;
    }

    private int getFunctionMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int currentCommaIndex;
        int proposedCommaIndex;
        Set<String> functionMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {

            if (!workerChangeHistory.getJob_profile_current().isEmpty()) {
                currentCommaIndex = !workerChangeHistory.getJob_profile_current().contains(",") ? 0 : workerChangeHistory.getJob_profile_current().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_current().substring(currentCommaIndex + 1).trim());
            }
            if (!workerChangeHistory.getJob_profile_proposed().isEmpty()) {
                proposedCommaIndex = !workerChangeHistory.getJob_profile_proposed().contains(",") ? 0 : workerChangeHistory.getJob_profile_proposed().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_proposed().substring(proposedCommaIndex + 1).trim());
            }

        }

        if (functionMovementSet.size() != 0) {
            return functionMovementSet.size() - 1;
        }

        return 0;
    }

    private int getSectorMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        Set<String> sectorMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (!workerChangeHistory.getCompany_current().isEmpty()) {
                sectorMovementSet.add(workerChangeHistory.getCompany_current().substring(0, 4).toUpperCase());
            }
            if (!workerChangeHistory.getCompany_proposed().isEmpty()) {
                sectorMovementSet.add(workerChangeHistory.getCompany_proposed().substring(0, 4).toUpperCase());
            }
        }

        if (sectorMovementSet.size() != 0) {
            return sectorMovementSet.size() - 1;
        }

        return 0;

    }
}