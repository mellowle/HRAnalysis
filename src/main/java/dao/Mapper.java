package dao;

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
}

