package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExecel {
    public static Object[][] dataProviderFromExcel(String filePath, String Sheet) throws IOException {
        Object[][] object = null;
        //Read file
        File file = new File (filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb	= new XSSFWorkbook(inputStream);
        Sheet dataSheet = wb.getSheet(Sheet);
        // Read now number
        int rowCount = dataSheet.getLastRowNum();
        //get a Row
        Row row = dataSheet.getRow(0);
        //init object[][]
        object = new Object[rowCount][row.getLastCellNum()];
        // -> object[2][2]
        for (int i = 0; i < rowCount; i++) {
            row = dataSheet.getRow(i + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
            object[i][j] = new DataFormatter().formatCellValue(row.getCell(j));
            }
        }
        wb.close();
        return object;
    }
    
}
