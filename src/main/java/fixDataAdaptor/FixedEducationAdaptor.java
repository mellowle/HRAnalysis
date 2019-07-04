package fixDataAdaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import Constants.ExperiencesConstants.Constants;
import entity.Education;
import fixedEntity.FixedEducation;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FixedEducationAdaptor {
    public static List<FixedEducation> getFixedEducationList() {
        //TODO get education list from DB and replace
        List<Education> educationList = Lists.newArrayList();
        List<FixedEducation> fixedEducationList = Lists.newArrayList();

        Map<String, List<Education>> educationMap = educationList.stream().collect(Collectors
                .groupingBy(Education::getWwid));


        for (Map.Entry<String, List<Education>> entry : educationMap.entrySet()) {
            HashSet educationSet = Sets.newHashSet();
            for (Education education : entry.getValue()) {
                educationSet.add(education.getHighest_degree_received());
            }

            FixedEducation fixedEducation = new FixedEducation();
            if (educationSet.contains(Constants.MBA)) {
                fixedEducation.setHighestEducation(Constants.MBA);
            }

            fixedEducationList.add(fixedEducation);

        }

        return fixedEducationList;

    }
}
