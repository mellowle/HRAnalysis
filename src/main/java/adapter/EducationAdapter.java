package adapter;

import com.google.gson.Gson;
import entity.Education;
import entity.PerformanceRating;
import table.EducationColMapping;
import table.PerformanceRatingColMapping;

import java.util.List;

public class EducationAdapter extends Adapter {
    @Override
    void setMapping() {
        this.COLUMN_MAPPING = EducationColMapping.COLUMN_MAPPING;
    }

    @Override
    void setTableName() {
        this.tableName = EducationColMapping.TABLE_NAME;
    }

    //insert data
    @Override
    void insertRecords() {

    }

    //insert data
    private void insertRecords(List<Education> req) {
        try {
            req.forEach(education -> {
                System.out.println("list size======" + gson.toJson(education));
                mapper.addEducation(education);
                sqlSession.commit();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        EducationAdapter educationAdapter = new EducationAdapter();
        educationAdapter.init();
        if(educationAdapter.isExisted()){
            educationAdapter.dropTable();
       }
        educationAdapter.createTable();
        String path = "/Users/xyang137/Documents/Archive/pending/MergedManageEducation.xlsx";
        List<Education> res = educationAdapter.generateExcel(Education.class,path);
        educationAdapter.insertRecords(res);
        Gson gson = new Gson();
        System.out.println("list size======"+ gson.toJson(res));
    }
}
// MergedEmployeePerformanceRatings.xlsx