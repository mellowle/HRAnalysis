package fixDataAdaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import constants.Constants;
import entity.Compensation;
import entity.WorkChangeHistory;
import fixedEntity.FixedCompensation;
import fixedEntity.FixedWorkChangeHistory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CompensationAdapter {

    public static List<FixedCompensation> getWorkChangeHistoryFlatList() {
        //TODO: get work change history from DB and replace below
        List<Compensation> compensationListFromDB = Lists.newArrayList();
        List<FixedCompensation> fixedCompensationList = Lists.newArrayList();

//        Iterator<Compensation> iter = compensationListFromDB.iterator();
//        while (iter.hasNext()) {
//            Compensation compensation = iter.next();
//            if ("Rescinded".equals(compensation.getBusiness_process_status())) {
//                iter.remove();
//            }
//        }

//        Map<String, List<Compensation>> compensationMap = compensationListFromDB.stream().collect(
//                Collectors.groupingBy(Compensation::getWwid));

//        for (Map.Entry<String, List<Compensation>> entry : compensationMap.entrySet()){
//            String wwid = entry.getKey();
//            FixedCompensation fixedCompensation = new FixedCompensation();
//            fixedCompensation.setWwid(wwid);
//            fixedCompensation.setBonus_2016(com);
//            fixedCompensation.setWwid(wwid);
//            fixedCompensation.setWwid(wwid);
//            fixedCompensation.setWwid(wwid);
//        }

        compensationListFromDB.forEach(compensation -> {

            FixedCompensation fixedCompensation = new FixedCompensation();
            fixedCompensation.setWwid(compensation.getWwid());
            fixedCompensation.setBonus_2016(Integer.parseInt(compensation.getBonus_2016()));
            fixedCompensation.setBonus_2017(Integer.parseInt(compensation.getBonus_2017()));
            fixedCompensation.setBonus_2018(Integer.parseInt(compensation.getBonus_2018()));

            fixedCompensation.setBase_2017(Integer.parseInt(compensation.getBase_2017()));
            fixedCompensation.setBase_2018(Integer.parseInt(compensation.getBase_2018()));
            fixedCompensation.setBase_2019(Integer.parseInt(compensation.getBase_2019()));

            fixedCompensationList.add(fixedCompensation);
        });

        return fixedCompensationList;
    }


}


