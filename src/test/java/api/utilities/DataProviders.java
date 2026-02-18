package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviders {

    public static Map<String, String> getMapTestData() throws IOException {
        Map<String, String> testData = new HashMap<String, String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/testData/swaggers.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNumber = sheet.getLastRowNum();

            for (int i = 0; i <= lastRowNumber; i++) {
                Row row = sheet.getRow(i);
                Cell keyCell = row.getCell(0);
                String key = keyCell.getStringCellValue().trim();

                Cell valueCell = row.getCell(1);
                String value = valueCell.getStringCellValue().trim();
                testData.put(key, value);
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return testData;
    }
}