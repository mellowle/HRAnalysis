import entity.excelEntity.*;
import entity.excelEntity.fixed.PerformanceRatingFixed;
import entity.excelEntity.fixed.WorkerChangeHistoryFixed;
import excelMapping.EmployeeDemographicsColMapping;
import service.excelService.*;

import java.util.List;

public class ApplicationMain {
    public static void main (String... args) throws Exception {
        CompensationExcelService compensationExcelService = new CompensationExcelService();
        CompetenciesExcelService competenciesExcelService = new CompetenciesExcelService();
        DirectReportExcelService directReportExcelService = new DirectReportExcelService();
        DriversExcelService driversExcelService = new DriversExcelService();
        EducationExcelService educationExcelService = new EducationExcelService();
        EmployeeDemographicsExcelService employeeDemographicsExcelService = new EmployeeDemographicsExcelService();
        ManagementChainExcelService managementChainExcelService = new ManagementChainExcelService();
        PerformanceRatingExcelService performanceRatingExcelService = new PerformanceRatingExcelService();
        TalentCardExcelService talentCardExcelService = new TalentCardExcelService();
        TraitsExcelService traitsExcelService = new TraitsExcelService();
        UnstructuredDataExcelService unstructuredDataExcelService = new UnstructuredDataExcelService();
        WorkerChangeHistoryExcelService workerChangeHistoryExcelService = new WorkerChangeHistoryExcelService();


        List<Compensation> compensationList = compensationExcelService.getResults();
        compensationList.forEach(System.err::println);
        System.out.println(compensationList.size());

        List<Competencies> competenciesList = competenciesExcelService.getResults();
        competenciesList.forEach(System.err::println);
        System.out.println(competenciesList.size());

        List<DirectReport> directReportList = directReportExcelService.getResults();
        directReportList.forEach(System.err::println);
        System.out.println(directReportList.size());

        List<Drivers> driversList = driversExcelService.getResults();
        driversList.forEach(System.err::println);
        System.out.println(driversList.size());

        List<Education> educationList = educationExcelService.getResultsFixed();
        educationList.forEach(System.err::println);
        System.out.println(educationList.size());

        List<EmployeeDemographics> employeeDemographicsList = employeeDemographicsExcelService.getResults();
        employeeDemographicsList.forEach(System.err::println);
        System.out.println(employeeDemographicsList.size());

        List<ManagementChain> managementChainList = managementChainExcelService.getResults();
        managementChainList.forEach(System.err::println);
        System.out.println(managementChainList.size());

        List<PerformanceRatingFixed> performanceRatingFixedList = performanceRatingExcelService.getResultsFixed();
        performanceRatingFixedList.forEach(System.err::println);
        System.out.println(performanceRatingFixedList.size());

        List<TalentCard> talentCardList = talentCardExcelService.getResults();
        talentCardList.forEach(System.err::println);
        System.out.println(talentCardList.size());

        List<Traits> traitsList = traitsExcelService.getResults();
        traitsList.forEach(System.err::println);
        System.out.println(traitsList.size());

        List<UnstructuredData> unstructuredDataList = unstructuredDataExcelService.getResults();
        unstructuredDataList.forEach(System.err::println);
        System.out.println(unstructuredDataList.size());

        List<WorkerChangeHistoryFixed> workerChangeHistoryFixedList = workerChangeHistoryExcelService.getResultsFixed();
        workerChangeHistoryFixedList.forEach(System.err::println);
        System.out.println(workerChangeHistoryFixedList.size());
    }
}
