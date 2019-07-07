package service.excelService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import entity.excelEntity.WorkerChangeHistory;
import excelMapping.WorkerChangeHistoryColMapping;
import entity.excelEntity.fixed.WorkerChangeHistoryFixed;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkerChangeHistoryExcelService extends Row2EntityService {

    public static void main(String... args) throws Exception {
        WorkerChangeHistoryExcelService c = new WorkerChangeHistoryExcelService();
        List<WorkerChangeHistoryFixed> results = c.getResultsFixed();
        results.forEach(System.err::println);
        System.out.println(results.size());
    }

    public List<WorkerChangeHistory> getResults() throws Exception {
        List<WorkerChangeHistory> results;
        this.COLUMN_MAPPING = WorkerChangeHistoryColMapping.COLUMN_MAPPING;
        results = sheet2Entities(WorkerChangeHistory.class, WorkerChangeHistoryColMapping.EXCEL_NAME);
        return results;
    }

    public List<WorkerChangeHistoryFixed> getResultsFixed() throws Exception {
        List<WorkerChangeHistoryFixed> results = Lists.newArrayList();
        List<WorkerChangeHistory> workerChangeHistoryList = getResults();
        Iterator<WorkerChangeHistory> it = workerChangeHistoryList.iterator();
        while (it.hasNext()) {
            WorkerChangeHistory history = it.next();
            if (ExperiencesConstants.RESCINDED.equals(history.getBusiness_process_status())) {
                it.remove();
            }
        }

        Map<String, List<WorkerChangeHistory>> workChangeHistoryMap = workerChangeHistoryList.stream().collect(
                Collectors.groupingBy(WorkerChangeHistory::getWwid));

        for (Map.Entry<String, List<WorkerChangeHistory>> entry : workChangeHistoryMap.entrySet()) {
            String wwid = entry.getKey();
            WorkerChangeHistoryFixed workerChangeHistoryFixed = new WorkerChangeHistoryFixed();
            workerChangeHistoryFixed.setWwid(wwid);
            workerChangeHistoryFixed.setCountry_movements(getCountryMovements(entry.getValue()));
            workerChangeHistoryFixed.setPromotions(getPromotions(entry.getValue()));
            workerChangeHistoryFixed.setRegion_movements(getRegionMovements(entry.getValue()));
            workerChangeHistoryFixed.setLateral_movements(getLateralMovements(entry.getValue()));
            workerChangeHistoryFixed.setFunction_movements(getFunctionMovements(entry.getValue()));
            workerChangeHistoryFixed.setSector_movements(getSectorMovements(entry.getValue()));
            results.add(workerChangeHistoryFixed);
        }

        return results;
    }

    private int getCountryMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        Set<String> locationSet = Sets.newHashSet();
        int countryMovements = 0;

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (!workerChangeHistory.getLocation_current().isEmpty()) {
                locationSet.add(workerChangeHistory.getLocation_current().substring(0, 2).toUpperCase());
            }
            if (!workerChangeHistory.getLocation_proposed().isEmpty()) {
                locationSet.add(workerChangeHistory.getLocation_proposed().substring(0, 2).toUpperCase());
            }
        }

        countryMovements = locationSet.size() - 1;

        return countryMovements;
    }

    private int getPromotions(List<WorkerChangeHistory> workerChangeHistoryList) {
        List<String> promotionList = Lists.newArrayList();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (ExperiencesConstants.YES.equals(workerChangeHistory.getPay_group_change())) {
                promotionList.add(workerChangeHistory.getCompensation_grade_current());
            }

        }

        return promotionList.size();

    }

    private int getRegionMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int regionMovements = 0;
        Set<String> regionSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            regionSet.add(workerChangeHistory.getRegion_current());
            regionSet.add(workerChangeHistory.getRegion_proposed());
        }

        regionMovements = regionSet.size() - 1;

        return regionMovements;

    }

    private int getLateralMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int lateralMovements = 0;
        Set<String> lateralMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            lateralMovementSet.add(workerChangeHistory.getJob_profile_current());
            lateralMovementSet.add(workerChangeHistory.getJob_profile_proposed());
        }

        lateralMovements = lateralMovementSet.size() - 1;

        return lateralMovements;

    }

    private int getFunctionMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int functionMovements = 0;
        Set<String> functionMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {

            if (!workerChangeHistory.getJob_profile_current().isEmpty()) {
                int currentCommaIndex = !workerChangeHistory.getJob_profile_current().contains(",") ? 0 : workerChangeHistory.getJob_profile_current().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_current().substring(currentCommaIndex, workerChangeHistory.getJob_profile_current().length() - 1));

            }
            if (!workerChangeHistory.getJob_profile_proposed().isEmpty()) {
                int proposedCommaIndex = !workerChangeHistory.getJob_profile_proposed().contains(",") ? 0 : workerChangeHistory.getJob_profile_proposed().indexOf(",");
                functionMovementSet.add(workerChangeHistory.getJob_profile_proposed().substring(proposedCommaIndex, workerChangeHistory.getJob_profile_proposed().length() - 1));
            }

        }

        functionMovements = functionMovementSet.size() - 1;

        return functionMovements;

    }

    private int getSectorMovements(List<WorkerChangeHistory> workerChangeHistoryList) {
        int sectorMovements = 0;
        Set<String> sectorMovementSet = Sets.newHashSet();

        for (WorkerChangeHistory workerChangeHistory : workerChangeHistoryList) {
            if (!workerChangeHistory.getCompany_current().isEmpty()) {
                sectorMovementSet.add(workerChangeHistory.getCompany_current().substring(0, 4).toUpperCase());
            }
            if (!workerChangeHistory.getCompany_proposed().isEmpty()) {
                sectorMovementSet.add(workerChangeHistory.getCompany_proposed().substring(0, 4).toUpperCase());
            }
        }

        sectorMovements = sectorMovementSet.size() - 1;

        return sectorMovements;

    }
}