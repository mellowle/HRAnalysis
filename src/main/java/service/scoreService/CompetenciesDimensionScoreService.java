package service.scoreService;

import com.google.common.collect.Lists;
import entity.dimensionRawData.DCompetencies;
import entity.dimensionScored.DCompetenciesScored;
import entity.excelEntity.Competencies;
import excelMapping.CompensationColMapping;
import excelMapping.CompetenciesColMapping;
import util.KF4DScoreFunctionUtils;

import java.util.List;

public class CompetenciesDimensionScoreService extends Score2EntityService{

    public CompetenciesDimensionScoreService(){
        this.TABLE_NAME_SCORED = CompetenciesColMapping.TABLE_NAME_SCORED;
        this.CLAZZ=DCompetenciesScored.class;
    }

//    public List<DCompetenciesScored> getScoredResults() {
//        List<DCompetenciesScored> dCompetenciesScoredList = Lists.newArrayList();
//
//        try {
//            List<DCompetencies> dCompetenciesList = Lists.newArrayList();
//            //
//            List<Competencies> results = mapper.getJoinedCompetencies();
//            sqlSession.commit();
//            results.forEach(competencies->{
//                DCompetencies dCompetencies = new DCompetencies(competencies.getWwid(), competencies.getAction_oriented(), competencies.getBalances_stakeholders(),
//                        competencies.getBeing_resilient(), competencies.getBuilds_effective_teams(), competencies.getBuilds_networks(),
//                        competencies.getCollaborates(), competencies.getCommunicates_effectively(), competencies.getCourage(),
//                        competencies.getCultivates_innovation(), competencies.getCustomer_focus(), competencies.getDecision_quality(),
//                        competencies.getDevelops_talent(), competencies.getDirects_work(), competencies.getDrives_engagement(),
//                        competencies.getDrives_results(), competencies.getEnsures_accountability(), competencies.getGlobal_perspective(),
//                        competencies.getInstills_trust(), competencies.getInterpersonal_savvy(), competencies.getManages_ambiguity(),
//                        competencies.getManages_conflict(), competencies.getNimble_learning(), competencies.getOptimizes_work_processes(),
//                        competencies.getPersuades(), competencies.getPlans_and_aligns(), competencies.getResourcefulness(),
//                        competencies.getSelf_development(), competencies.getSituational_adaptability(), competencies.getStrategic_mindset(),
//                        competencies.getValues_differences());
//                dCompetenciesList.add(dCompetencies);
//            });
//
//
//            for (DCompetencies dCompetencies : dCompetenciesList) {
//                DCompetenciesScored dCompetenciesScored = new DCompetenciesScored(dCompetencies.getWwid(),
//                        KF4DScoreFunctionUtils.calcMissionCriticalScore(dCompetencies.getMissionCritical()),
//                        KF4DScoreFunctionUtils.calcCriticalScore(dCompetencies.getCritical()),
//                        KF4DScoreFunctionUtils.calcLessCriticalScore(dCompetencies.getLessCritical()));
//                dCompetenciesScoredList.add(dCompetenciesScored);
//            }
//            return dCompetenciesScoredList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }



    public static void main(String... args) {
    }

}
