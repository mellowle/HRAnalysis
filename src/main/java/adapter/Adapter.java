package adapter;

import com.google.gson.Gson;
import dao.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.DataConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Adapter {

    public DataConnection dataConn = new DataConnection();
    public Mapper mapper = null;
    SqlSession sqlSession;
    static Gson gson = new Gson();

    {
        try {
            sqlSession = dataConn.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> COLUMN_MAPPING;
    public String tableName;

    abstract void setMapping();

    abstract void setTableName();

    //initialize the mapping and table name
    public void init() {
        setMapping();
        setTableName();
        mapper = sqlSession.getMapper(Mapper.class);
    }

    public boolean isExisted() {
        return mapper.isTableExist(tableName) == 0 ? false : true;
    }

    //drop table
    public void dropTable() {
        mapper.deleteTable(tableName);
    }

    //create table
    public void createTable() {
        mapper.createTable(tableName, generateColList(COLUMN_MAPPING));
    }

    //insert records
    abstract void insertRecords();

    abstract void generateRawTable();

    //通过map,生成数据库列
    private List<Map<String, String>> generateColList(Map<String, String> map) {
        List<Map<String, String>> cols = new LinkedList<>();
        map.forEach((col, v) -> {
            Map<String, String> colMap = new HashMap<>();
            colMap.put("code", col);
            colMap.put("type", "STRING");
            colMap.put("length", "500");
            cols.add(colMap);
        });
        return cols;
    }

    //excel to List<entity>
    //parameter: entity object
    //只可以读取excel的第一个sheet，第一行必须是字段名
    public <T> List<T> generateExcel(Class<T> tClass, String path) {

        //read excel file
        System.out.println("excel File: " + path);
        File file = new File(path);
        List<T> res = new LinkedList<>();
        try (Workbook book = new XSSFWorkbook(new FileInputStream(file))) {
            //todo 默认每个excel取第一个sheet
            Sheet sheet = book.getSheetAt(0);
            int rowNum = sheet.getLastRowNum() + 1;
            int colNum = sheet.getRow(0).getLastCellNum();
            Row row = null;
            Cell cell = null;
            /* first row data for column names and index */

            Map<String, Integer> colMapByName = new HashMap<String, Integer>();
            if (sheet.getRow(0).cellIterator().hasNext()) {
                for (int j = 0; j < colNum; j++) {
                    colMapByName.put(sheet.getRow(0).getCell(j).getStringCellValue().trim(), j);
                }
            }
            System.out.println(colMapByName);//shows the indexes of columns populated by traversing first row

            for (int i = 1; i < rowNum; i++) {

                //create row object
                row = sheet.getRow(i);
                T obj = null;
                try {
                    obj = tClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //COLUMN_MAPPING consists the columnnames and alias name for it
                //COLUMN_MAPPING ("employee_pay_grade", "Employee Pay Grade");

                for (Map.Entry<String, String> colData : COLUMN_MAPPING.entrySet()) {

                    cell = row.getCell(colMapByName.get(colData.getValue()));//gives the index of column from  colMapByName Map by passing column name
                    //value:cell value
                    //key: colData.key wwid set+Wwid
                    String key = colData.getKey();
                    String field = key.substring(0, 1).toUpperCase() + key.substring(1); //wwid -> Wwid
                    Method setField = null;
                    try {
                        //get parameter type
                        setField = tClass.getDeclaredMethod("set" + field, String.class);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:
                                    setField.invoke(obj, cell.getRichStringCellValue().getString());
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        String date = cell.getDateCellValue().toString();
                                        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
                                        Date d = sdf.parse(date);
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                        setField.invoke(obj, String.valueOf(sdf.format(d)));
                                    } else {
                                        setField.invoke(obj, String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    setField.invoke(obj, String.valueOf(cell.getNumericCellValue()));
                                    break;
                                case Cell.CELL_TYPE_FORMULA:
                                    setField.invoke(obj, String.valueOf(cell.getCellFormula()));
                                    break;
                                default:
                                    setField.invoke(obj, cell.getRichStringCellValue().getString());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                res.add(obj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }
}