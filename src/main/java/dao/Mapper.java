package dao;

import entity.ScoreInterval;
import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.*;
import entity.excelEntity.*;
import entity.excelEntity.fixed.PerformanceRatingFixed;
import entity.excelEntity.fixed.WorkerChangeHistoryFixed;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Mapper {

    int isTableExist(@Param("tableName") String tableName);

    void deleteTable(@Param("tableName") String tableName);

    void createTable(@Param("newTableName") String newTableName, @Param("columns") List<Map<String, String>> columns);

    int addCompensation(Compensation compensation);

    int addCompensationWithLTI(CompensationWithLTI compensationWithLTI);

    int addDirectReport(DirectReport directReport);

    int addEducation(Education education);

    int addEmployeeDemographics(EmployeeDemographics employeeDemographics);

    int addManagementChain(ManagementChain managementChain);

    int addPerformanceRatingFixed(PerformanceRatingFixed performanceRatingFixed);

    int addTalentCard(TalentCard talentCard);

    int addUnstructuredData(UnstructuredData unstructuredData);

    int addWorkerChangeHistoryFixed(WorkerChangeHistoryFixed workerChangeHistoryFixed);

    int addTalentCardSummary(TalentCardSummary talentCardSummary);

    int addKF4DEmployeeDemographics(KF4DEmployeeDemographics kf4DEmployeeDemographics);

    //~~~~~~~~~~~DigitalExperiences~~~~~~~~~~~~~~
    int addDigitalExperiences(DigitalExperiences digitalExperiences);
    //~~~~~~~~~~~DigitalExperiences~~~~~~~~~~~~~~


    //~~~~~~~~~~~Experiences~~~~~~~~~~~~~~
    List<DExperiences> getAllDExperiences();

    int addDExperiences(DExperiences dExperiences);

    int addDExperiencesScored(DExperiencesScored dExperiencesScored);

    //~~~~~~~~~~~Experiences~~~~~~~~~~~~~~


    //~~~~~~~~~~~Competencies~~~~~~~~~~~~~~
    int addCompetencies(Competencies competencies);

    List<Competencies> getAllCompetencies();

    int addDCompetenciesScored(DCompetenciesScored dCompetenciesScored);
    //~~~~~~~~~~~Competencies~~~~~~~~~~~~~~


    //~~~~~~~~~~~Drivers~~~~~~~~~~~~~~
    int addDrivers(Drivers drivers);

    List<Drivers> getAllDrivers();

    int addDDriversScored(DDriversScored dDriversScored);
    //~~~~~~~~~~~Drivers~~~~~~~~~~~~~~


    //~~~~~~~~~~~Traits~~~~~~~~~~~~~~
    int addTraits(Traits traits);

    List<Traits> getAllTraits();

    int addDTraitsScored(DTraitsScored dTraitsScored);
    //~~~~~~~~~~~Traits~~~~~~~~~~~~~~


    //~~~~~~~~~~~Final~~~~~~~~~~~~~~
    List<FinalScore> getAllFinalScore();

    int addFinalScore(FinalScore finalScore);
    //~~~~~~~~~~~Final~~~~~~~~~~~~~~


    //~~~~~~~~~~~ScoreInterval~~~~~~~~~~~~~~
    int addScoreIntervalDExperiencesInterval(ScoreInterval scoreInterval);

    int addScoreIntervalDCompetenciesInterval(ScoreInterval scoreInterval);

    int addScoreIntervalDTraitsInterval(ScoreInterval scoreInterval);

    int addScoreIntervalDDriversInterval(ScoreInterval scoreInterval);
    //~~~~~~~~~~~ScoreInterval~~~~~~~~~~~~~~
}

