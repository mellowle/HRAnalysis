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

        CompetenciesListFromDB.forEach(competencies -> {

            FixedCompetencies fixedCompetencies = new FixedCompetencies();
            fixedCompetencies.setWwid(competencies.getWwid());
            fixedCompetencies.setAction_oriented(Integer.parseInt(competencies.getAction_oriented()));
            fixedCompetencies.setBalances_stakeholders(Integer.parseInt(competencies.getBalances_stakeholders()));
            fixedCompetencies.setBeing_resilient(Integer.parseInt(competencies.getBeing_resilient()));
            fixedCompetencies.setBuilds_effective_teams(Integer.parseInt(competencies.getBuilds_effective_teams()));
            fixedCompetencies.setBuilds_networks(Integer.parseInt(competencies.getBuilds_networks()));
            fixedCompetencies.setCollaborates(Integer.parseInt(competencies.getCollaborates()));
            fixedCompetencies.setCommunicates_effectively(Integer.parseInt(competencies.getCommunicates_effectively()));
            fixedCompetencies.setCourage(Integer.parseInt(competencies.getCourage()));
            fixedCompetencies.setCultivates_innovation(Integer.parseInt(competencies.getCultivates_innovation()));
            fixedCompetencies.setCustomer_focus(Integer.parseInt(competencies.getCustomer_focus()));
            fixedCompetencies.setDecision_quality(Integer.parseInt(competencies.getDecision_quality()));
            fixedCompetencies.setDevelops_talent(Integer.parseInt(competencies.getDevelops_talent()));
            fixedCompetencies.setDirects_work(Integer.parseInt(competencies.getDirects_work()));
            fixedCompetencies.setDrives_engagement(Integer.parseInt(competencies.getDrives_engagement()));
            fixedCompetencies.setDrives_results(Integer.parseInt(competencies.getDrives_results()));
            fixedCompetencies.setEnsures_accountability(Integer.parseInt(competencies.getEnsures_accountability()));
            fixedCompetencies.setGlobal_perspective(Integer.parseInt(competencies.getGlobal_perspective()));
            fixedCompetencies.setInstills_trust(Integer.parseInt(competencies.getInstills_trust()));
            fixedCompetencies.setInterpersonal_savvy(Integer.parseInt(competencies.getInterpersonal_savvy()));
            fixedCompetencies.setManages_ambiguity(Integer.parseInt(competencies.getManages_ambiguity()));
            fixedCompetencies.setManages_conflict(Integer.parseInt(competencies.getManages_conflict()));
            fixedCompetencies.setNimble_learning(Integer.parseInt(competencies.getNimble_learning()));
            fixedCompetencies.setOptimizes_work_processes(Integer.parseInt(competencies.getOptimizes_work_processes()));
            fixedCompetencies.setPersuades(Integer.parseInt(competencies.getPersuades()));
            fixedCompetencies.setPlans_and_aligns(Integer.parseInt(competencies.getPlans_and_aligns()));
            fixedCompetencies.setResourcefulness(Integer.parseInt(competencies.getResourcefulness()));
            fixedCompetencies.setSelf_development(Integer.parseInt(competencies.getSelf_development()));
            fixedCompetencies.setSituational_adaptability(Integer.parseInt(competencies.getSituational_adaptability()));
            fixedCompetencies.setStrategic_mindset(Integer.parseInt(competencies.getStrategic_mindset()));
            fixedCompetencies.setValues_differences(Integer.parseInt(competencies.getValues_differences()));
        });

        return fixedCompetenciesList;
    }

    public static void main(String[] args) {
        Class clz = FixedCompetencies.class;
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field f : declaredFields){
            //fixedCompetencies.setAction_oriented(Integer.parseInt(competencies.getAction_oriented()));
//            System.out.println(f.getName());
            String name = f.getName();
            String aa = name.substring(0, 1).toUpperCase();
            String bb = name.substring(1, name.length());
            System.out.println("fixedCompetencies.set" + aa + bb + "(Integer.parseInt(competencies.get"+ aa + bb +"()));");
        }
//        for (Method m : clz.getDeclaredMethods()){
//            System.out.println(m.getName());
//        }
    }


}


