package fixDataAdaptor;

import com.google.common.collect.Lists;
import entity.Competencies;
import fixedEntity.FixedCompetencies;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class CompetenciesAdapter {

    public static List<FixedCompetencies> getWorkChangeHistoryFlatList() {
        //TODO: get work change history from DB and replace below
        List<Competencies> CompetenciesListFromDB = Lists.newArrayList();
        List<FixedCompetencies> fixedCompetenciesList = Lists.newArrayList();

        CompetenciesListFromDB.forEach(Competencies -> {

            FixedCompetencies fixedCompetencies = new FixedCompetencies();

        });

        return fixedCompetenciesList;
    }

    public static void main(String[] args) {
        Class clz = FixedCompetencies.class;
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f.getName());
        }
//        for (Method m : clz.getDeclaredMethods()){
//            System.out.println(m.getName());
//        }
    }


}


