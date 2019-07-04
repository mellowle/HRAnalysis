package dao;

import dimensionScored.DCompetenciesScored;
import dimensionScored.DDriversScored;
import dimensionScored.DTraitsScored;
import entity.*;
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

    int addWorkChangeHistory(WorkChangeHistory workChangeHistory);

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
}

