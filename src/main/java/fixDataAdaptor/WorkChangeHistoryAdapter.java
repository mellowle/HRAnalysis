package fixDataAdaptor;

import com.google.common.collect.Lists;
import entity.WorkChangeHistory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkChangeHistoryAdapter {

    public static List<WorkChangeHistory> getWorkChangeHistoryFlatList() {
        //TODO: get work change history from DB and replace below
        List<WorkChangeHistory> workChangeHistoryListFromDB = Lists.newArrayList();
        List<WorkChangeHistory> workChangeHistoryListFlat = Lists.newArrayList();

        Map<String, List<WorkChangeHistory>> workChangeHistoryMap = workChangeHistoryListFromDB.stream().collect(
                Collectors.groupingBy(WorkChangeHistory::getWwid));

        for (Map.Entry<String, List<WorkChangeHistory>> entry : workChangeHistoryMap.entrySet()){
            String wwid = entry.getKey();
            if (entry.getValue().size() == 1) {
                workChangeHistoryListFlat.add(entry.getValue().get(0));
            } else {

            }
        }

        return workChangeHistoryListFlat;
    }
}
