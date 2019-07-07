package service.excelService;

import Constants.Constants;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Row2EntityService {

    public Map<String, String> COLUMN_MAPPING;

    public static Workbook getWorkBook(String path) throws Exception {
        FileInputStream input = new FileInputStream(new File(path));
        return new XSSFWorkbook(input);
    }

    public static String getCellValue(Cell cell) {
        String cellValue;
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                }
                else {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue = dataFormatter.formatCellValue(cell);
                    cellValue = cellValue.replaceAll("\\(|\\)|,", "");
                    if (cellValue.contains("%")) {
                        cellValue = cellValue.replaceAll("%", "");
                        cellValue = String.valueOf(Double.valueOf(cellValue) / 100);
                    }
                }
                break;
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = null;
                break;
            default:
                cellValue = null;
                break;
        }
        if (cellValue != null) {
            cellValue = cellValue.replaceAll(",|-", "").trim();
            if (cellValue.equals("N.A")) {
                return null;
            }
        }

        return cellValue;
    }

    public <T> List<T> sheet2Entities(Class<T> tClass, String excelName) throws Exception {
        List<T> results = new ArrayList<>();
        Workbook book = getWorkBook(Constants.INPUT_FILE_PATH + excelName);

        Sheet sheet = book.getSheetAt(0);
        int rowNum = sheet.getLastRowNum() + 1;
        int colNum = sheet.getRow(0).getLastCellNum();
        Row row;
        Cell cell;

        /* first row data for column names and index */
        Map<String, Integer> colMapByName = new HashMap<>();
        if (sheet.getRow(0).cellIterator().hasNext()) {
            for (int j = 0; j < colNum; j++) {
                colMapByName.put(sheet.getRow(0).getCell(j).getStringCellValue().trim(), j);
            }
        }

        // Create row object
        T obj;
        Field field;
        String fieldName;
        Method method;
        Method convert;
        String methodName;

        for (int i = 1; i < rowNum; i++) {

            //create row object
            row = sheet.getRow(i);

            obj = tClass.newInstance();

            for (Map.Entry<String, String> entry : COLUMN_MAPPING.entrySet()) {
                if (colMapByName.get(entry.getValue()) != null) {
                    cell = row.getCell(colMapByName.get(entry.getValue()));
                    fieldName = entry.getKey();
                    field = tClass.getField(fieldName);
                    Class fieldType = field.getType();
                    methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    method = tClass.getDeclaredMethod(methodName, fieldType);
                    String cellValue = getCellValue(cell);
                    //                    System.out.println(fieldName + "," + methodName);

                    if (fieldType == String.class) {
                        method.invoke(obj, cellValue);
                    }
                    else if (fieldType == Date.class && cellValue != null && !cellValue.isEmpty()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        Date date = sdf.parse(cellValue);
                        method.invoke(obj, date);
                    }
                    else {

                        if (cellValue != null && !cellValue.isEmpty()) {
                            convert = fieldType.getMethod("valueOf", String.class);
                            method.invoke(obj, convert.invoke(null, getCellValue(cell)));
                        }
                    }
                }
            }
            results.add(obj);

        }
        return results;
    }
}
