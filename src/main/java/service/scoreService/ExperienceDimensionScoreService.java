package service.scoreService;

import Constants.ExperiencesConstants.ExperiencesConstants;
import com.google.common.collect.Lists;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DExperiencesScored;
import entity.excelEntity.fixed.ExperiencesAverageAttributes;
import util.ScoreFunctionUtils;
import util.TableUtils;

import java.util.List;

public class ExperienceDimensionScoreService extends AbstractScoreService {

    public ExperienceDimensionScoreService() {
        this.TABLE_NAME_SCORED = ExperiencesConstants.TABLE_NAME;
        this.CLAZZ = DExperiences.class;
    }

    public static void main(String... args) throws Exception {
        ExperienceDimensionScoreService c = new ExperienceDimensionScoreService();
        List<DExperiencesScored> results = c.getScoredResults();
        System.out.println(results.size());
//        for (DExperiencesScored i : results){
//            if(i.getWwid().equals("ttt")){
//                System.out.println(i);
//            }
//        }
        c.resetTableNameAndClazz(ExperiencesConstants.TABLE_NAME_SCORED, DExperiencesScored.class);
        c.initTable();
        c.insertRecords(results);
        System.err.println("done");
    }


    public List<DExperiences> getAllDExperiences() throws Exception {
        List<DExperiences> results = TableUtils.getAllRecords(DExperiences.class);
        System.out.println(results.size());
        initTable();
        insertRecords(results);
        System.err.println("done");
        System.exit(-1);
        return results;
    }

    public List<DExperiencesScored> getScoredResults() throws Exception {
        List<DExperiencesScored> scoredResults = Lists.newArrayList();

        List<DExperiences> results = getAllDExperiences();

        // data100% score 100 test case
//                DExperiences t = new DExperiences();
//                t.setWwid("ttt");
//                t.setOverall_rating2016("Exceeds / Exceeds");
//                t.setOverall_rating2017("Exceeds / Exceeds");
//                t.setOverall_rating2018("Exceeds / Exceeds");
//                t.setBonus2016(10d);
//                t.setBonus2017(10000d);
//                t.setBonus2018(10000000d);
//                t.setBase2017(10d);
//                t.setBase2018(10000d);
//                t.setBase2019(10000000d);
//                t.setFunction_movements(7);
//                t.setLateral_movements(7);
//                t.setPromotions(7);
//                t.setCountry_movements(8);
//                t.setRegion_movements(8);
//                t.setSector_movements(8);
//                t.setDirect_report(10);
//                t.setHierarchy_count(3);
//                t.setExternal_role_number(10);
//                t.setExternal_length_of_service(9d);
//                t.setTotal_role_number(5);
//                t.setTotal_working_years(10d);
//                t.setAverage_duration_of_each_role(4d);
//                t.setCustomer_journey(4d);
//                t.setData_analytics(4d);
//                t.setInnovation(4d);
//                t.setDigital_leadership(4d);
//                t.setDigital_commerce(4d);
//                t.setDigital_products(4d);
//                t.setOperational_efficiency(4d);
//                t.setPerformance_comments2018(5d);
//                t.setStakeholder_feedback(5d);
//
//                results.add(t);

        ExperiencesAverageAttributes experiencesAverageAttributes = ScoreFunctionUtils.getAverageAttributes(results);
        for (DExperiences dExperiences : results) {
            DExperiencesScored dExperiencesScored = new DExperiencesScored();
            dExperiencesScored.setWwid(dExperiences.getWwid());

            dExperiencesScored.setEmployee_pay_grade(dExperiences.getEmployee_pay_grade());
            dExperiencesScored.setJob_function(dExperiences.getJob_function());
            dExperiencesScored.setSector(dExperiences.getSector());
            dExperiencesScored.setLength_of_service_in_years(dExperiences.getLength_of_service_in_years());
            dExperiencesScored.setOverall_rating2016(dExperiences.getOverall_rating2016());
            dExperiencesScored.setOverall_rating2017(dExperiences.getOverall_rating2017());
            dExperiencesScored.setOverall_rating2018(dExperiences.getOverall_rating2018());

            ScoreFunctionUtils.socrePerformance(dExperiences, dExperiencesScored);

            dExperiencesScored.setBonus_increment20162017(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBonus2016(), dExperiences.getBonus2017(), experiencesAverageAttributes.getBonusIncrement20162017(), "bonus_increment20162017"
            ));
            dExperiencesScored.setBonus_increment20172018(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBonus2017(), dExperiences.getBonus2018(), experiencesAverageAttributes.getBonusIncrement20172018(), "bonus_increment20172018"
            ));
            dExperiencesScored.setBase_increment20172018(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBase2017(), dExperiences.getBase2018(), experiencesAverageAttributes.getBaseIncrement20172018(), "base_increment20172018"
            ));
            dExperiencesScored.setBase_increment20182019(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBase2018(), dExperiences.getBase2019(), experiencesAverageAttributes.getBaseIncrement20182019(), "base_increment20182019"
            ));

            dExperiencesScored.setFunction_movements(ScoreFunctionUtils.scoreFunctionMovements(dExperiences.getFunction_movements()));
            dExperiencesScored.setLateral_movements(ScoreFunctionUtils.scoreLateralMovements(dExperiences.getLateral_movements()));
            dExperiencesScored.setPromotions(ScoreFunctionUtils.scorePromotions(dExperiences.getPromotions()));
            dExperiencesScored.setRegion_movements(ScoreFunctionUtils.scoreRegionMovements(dExperiences.getRegion_movements()));
            dExperiencesScored.setSector_movements(ScoreFunctionUtils.scoreSectorMovements(dExperiences.getSector_movements()));
            dExperiencesScored.setCountry_movements(ScoreFunctionUtils.scoreCountryMovements(dExperiences.getCountry_movements()));

            dExperiencesScored.setDirect_report(ScoreFunctionUtils.scoreDirectReport(dExperiences.getDirect_report()));
            dExperiencesScored.setHierarchy_count(ScoreFunctionUtils.scoreHierarchyCount(dExperiences.getHierarchy_count()));

            dExperiencesScored.setExternal_role_number(ScoreFunctionUtils.scoreExternalRoleNumber(dExperiences.getExternal_role_number()));
            dExperiencesScored.setExternal_length_of_service(ScoreFunctionUtils.scoreWithAverage(
                    dExperiences.getExternal_length_of_service(), experiencesAverageAttributes.getExternalLengthOfService(), "external_length_of_service"
            ));

            dExperiencesScored.setTotal_role_number_ranking(ScoreFunctionUtils.scoreTotalRoleNumber(dExperiences.getTotal_role_number()));
            dExperiencesScored.setTotal_working_years_ranking(ScoreFunctionUtils.scoreTotalWorkingYears(dExperiences.getTotal_working_years()));
            dExperiencesScored.setAverage_duration_of_each_role_ranking(ScoreFunctionUtils.scoreAverageDurationOfEachRole(dExperiences.getAverage_duration_of_each_role()));

            dExperiencesScored.setCustomer_journey(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getCustomer_journey(), "customer_journey"));
            dExperiencesScored.setData_analytics(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getData_analytics(), "data_analytics"));
            dExperiencesScored.setInnovation(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getInnovation(), "innovation"));
            dExperiencesScored.setDigital_leadership(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getDigital_leadership(), "digital_leadership"));
            dExperiencesScored.setDigital_commerce(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getDigital_commerce(), "digital_commerce"));
            dExperiencesScored.setDigital_products(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getDigital_products(), "digital_products"));
            dExperiencesScored.setOperational_efficiency(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getOperational_efficiency(), "operational_efficiency"));

            //unstructured data
            dExperiencesScored.setPerformance_comments2018(ScoreFunctionUtils.scoreUnstructuredData(dExperiences.getPerformance_comments2018(), "performance_comments2018"));
            dExperiencesScored.setStakeholder_feedback(ScoreFunctionUtils.scoreUnstructuredData(dExperiences.getStakeholder_feedback(), "stakeholder_feedback"));

            ScoreFunctionUtils.sumUpExperiences(dExperiencesScored);

            scoredResults.add(dExperiencesScored);
        }

        return scoredResults;
    }

    public void resetTableNameAndClazz(String tableName, Class clazz) {
        this.TABLE_NAME_SCORED = tableName;
        this.CLAZZ = clazz;
    }
}



