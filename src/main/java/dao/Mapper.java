package dao;

import entity.dimensionRawData.DExperiences;
import entity.dimensionScored.DCompetenciesScored;
import entity.dimensionScored.DDriversScored;
import entity.dimensionScored.DTraitsScored;
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

    int addCompetencies(Competencies competencies);

    List<Competencies> getAllCompetencies();

    int addDrivers(Drivers drivers);

    int addTraits(Traits traits);

    int addDCompetenciesScored(DCompetenciesScored dCompetenciesScored);


    int addEmployeeDemographics(EmployeeDemographics employeeDemographics);

    int addPerformanceRating(PerformanceRating performanceRating);

    int addDirectReport(DirectReport directReport);

    int addEducation(Education education);

    int addManagementChain(ManagementChain managementChain);

    int addTalentCard(TalentCard talentCard);

    int addWorkChangeHistory(WorkerChangeHistory workerChangeHistory);


    List<Drivers> getAllDrivers();

    List<Drivers> getJoinedDrivers();

    int addDriversScored(DDriversScored dDriversScored);




    List<Traits> getJoinedTraits();

    int addTraitsScored(DTraitsScored dTraitsScored);

    List<Education> getAllEducation();

    List<PerformanceRating> getAllPerformanceRating();

    int addFixedPerformanceRating(PerformanceRatingFixed performanceRatingFixed);

    List<DExperiences> getAllExperiences();

    List<WorkerChangeHistory> getAllWorkChangeHistory();

    int addFixedWorkChangeHistory(WorkerChangeHistoryFixed workerChangeHistoryFixed);

    int addUnstructuredData(UnstructuredData unstructuredData);
}

