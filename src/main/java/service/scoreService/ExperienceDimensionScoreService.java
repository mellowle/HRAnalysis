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
        return results;
    }

    public List<DExperiencesScored> getScoredResults() throws Exception {
        List<DExperiencesScored> scoredResults = Lists.newArrayList();

        List<DExperiences> results = getAllDExperiences();

        // data100% score 100 test case
//        DExperiences t = new DExperiences();
//        t.setWwid("ttt");
//        t.setOverall_rating2016("Exceeds / Exceeds");
//        t.setOverall_rating2017("Exceeds / Exceeds");
//        t.setOverall_rating2018("Exceeds / Exceeds");
//        t.setBonus2016(10d);
//        t.setBonus2017(10000d);
//        t.setBonus2018(10000000d);
//        t.setBase2017(10d);
//        t.setBase2018(10000d);
//        t.setBase2019(10000000d);
//        t.setFunction_movements(7);
//        t.setLateral_movements(7);
//        t.setPromotions(7);
//        t.setCountry_movements(8);
//        t.setRegion_movements(8);
//        t.setSector_movements(8);
//        t.setDirect_report(10);
//        t.setHierarchy_count(3);
//        t.setExternal_roles(10);
//        t.setExternal_length_of_service(9d);
//        t.setTotal_roles(5);
//        t.setTotal_working_year(10d);
//        t.setAverage_time_of_each_role(4d);
//        t.setOverall_digital_experience_percentile(1d);
//        t.setPerformance_comments2018(5d);
//        t.setStakeholder_feedback(5d);
//
//        results.add(t);

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
                    dExperiences.getBonus2016(), dExperiences.getBonus2017(), experiencesAverageAttributes.getBonusIncrement20162017(), "BONUS_INCREMENT20162017"
            ));
            dExperiencesScored.setBonus_increment20172018(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBonus2017(), dExperiences.getBonus2018(), experiencesAverageAttributes.getBonusIncrement20172018(), "BONUS_INCREMENT20172018"
            ));
            dExperiencesScored.setBase_increment20172018(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBase2017(), dExperiences.getBase2018(), experiencesAverageAttributes.getBaseIncrement20172018(), "BASE_increment20172018"
            ));
            dExperiencesScored.setBase_increment20182019(ScoreFunctionUtils.scoreIncrement(
                    dExperiences.getBase2018(), dExperiences.getBase2019(), experiencesAverageAttributes.getBaseIncrement20182019(), "BASE_increment20182019"
            ));

            dExperiencesScored.setFunction_movements(ScoreFunctionUtils.scoreFunctionMovements(dExperiences.getFunction_movements()));
            dExperiencesScored.setLateral_movements(ScoreFunctionUtils.scoreLateralMovements(dExperiences.getLateral_movements()));
            dExperiencesScored.setPromotions(ScoreFunctionUtils.scorePromotions(dExperiences.getPromotions()));
            dExperiencesScored.setRegion_movements(ScoreFunctionUtils.scoreRegionMovements(dExperiences.getRegion_movements()));
            dExperiencesScored.setSector_movements(ScoreFunctionUtils.scoreSectorMovements(dExperiences.getSector_movements()));
            dExperiencesScored.setCountry_movements(ScoreFunctionUtils.scoreCountryMovements(dExperiences.getCountry_movements()));

            dExperiencesScored.setTeam_size(ScoreFunctionUtils.scoreTeamSize(dExperiences.getDirect_report()));

            dExperiencesScored.setHierarchy_count(ScoreFunctionUtils.scoreHierarchyCount(dExperiences.getHierarchy_count()));

            dExperiencesScored.setExternal_roles(ScoreFunctionUtils.scoreExternalRoleNumber(dExperiences.getExternal_roles()));
            dExperiencesScored.setExternal_length_of_service(ScoreFunctionUtils.scoreWithAverage(
                    dExperiences.getExternal_length_of_service(), experiencesAverageAttributes.getExternalLengthOfService(), "EXTERNAL_LENGTH_OF_SERVICE"
            ));

            dExperiencesScored.setRole_number_ranking(ScoreFunctionUtils.scoreTotalRoleNumber(dExperiences.getTotal_roles()));
            dExperiencesScored.setTotal_working_year_ranking(ScoreFunctionUtils.scoreTotalWorkingYears(dExperiences.getTotal_working_year()));
            dExperiencesScored.setAverage_time_of_each_role_ranking(ScoreFunctionUtils.scoreAverageDurationOfEachRole(dExperiences.getAverage_time_of_each_role()));

            dExperiencesScored.setDigital_experiences(ScoreFunctionUtils.scoreDigitalExperiences(dExperiences.getOverall_digital_experience_percentile()));

            //unstructured data
            dExperiencesScored.setPerformance_comments2018(ScoreFunctionUtils.scoreUnstructuredData(dExperiences.getPerformance_comments2018(), "PERFORMANCE_COMMENTS2018"));
            dExperiencesScored.setStakeholder_feedback(ScoreFunctionUtils.scoreUnstructuredData(dExperiences.getStakeholder_feedback(), "STAKEHOLDER_FEEDBACK"));

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



