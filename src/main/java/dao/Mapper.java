package dao;

import dimensionRawData.DExperiences;
import dimensionScored.DCompetenciesScored;
import dimensionScored.DDriversScored;
import dimensionScored.DTraitsScored;
import excel.excelEntity.*;
import fixedEntity.EducationFixed;
import fixedEntity.PerformanceRatingFixed;
import fixedEntity.WorkerChangeHistoryFixed;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface Mapper {

    int isTableExist(@Param("tableName") String tableName);
    void deleteTable(@Param("tableName") String tableName);
    void createTable(@Param("newTableName") String newTableName, @Param("columns") List<Map<String, String>> columns);

    int addEmployeeDemographics(EmployeeDemographics employeeDemographics);
    int addPerformanceRating(PerformanceRating performanceRating);
    int addCompensation(Compensation compensation);
    int addDirectReport(DirectReport directReport);

    int addEducation(Education education);

    int addManagementChain(ManagementChain managementChain);

    int addTalentCard(TalentCard talentCard);

    int addWorkChangeHistory(WorkerChangeHistory workerChangeHistory);

    int addCompetencies(Competencies competencies);

    int addDrivers(Drivers drivers);

    int addTraits(Traits traits);

    List<Drivers> getAllDrivers();

    List<Drivers> getJoinedDrivers();

    int addDriversScored(DDriversScored dDriversScored);

    List<Competencies> getJoinedCompetencies();

    int addCompetenciesScored(DCompetenciesScored dCompetenciesScored);

    List<Traits> getJoinedTraits();

    int addTraitsScored(DTraitsScored dTraitsScored);

    List<Education> getAllEducation();

    int addFixedEducation(EducationFixed educationFixed);

    List<PerformanceRating> getAllPerformanceRating();

    int addFixedPerformanceRating(PerformanceRatingFixed performanceRatingFixed);

    List<DExperiences> getAllExperiences();

    List<WorkerChangeHistory> getAllWorkChangeHistory();

    int addFixedWorkChangeHistory(WorkerChangeHistoryFixed workerChangeHistoryFixed);

    int addUnstructuredData(UnstructuredData unstructuredData);
}

