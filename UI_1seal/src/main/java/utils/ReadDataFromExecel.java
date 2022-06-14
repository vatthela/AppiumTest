package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExecel {

    public static void main(String[] args) throws Exception {
        // Blank workbook

        List<String> res = new ArrayList<String>();
        res = getRowValueFromRowAndCel("C:\\Automation\\AppiumTest\\UI_1seal\\src\\test\\java\\resource\\data.xlsx",
                "Login", 1);
        System.out.println(res.get(0));
        for (String s : res) {
            System.out.println("---print cell ---" + s);
        }
    }

    public static List<String> getRowValueFromRowAndCel(String filePath, String sheetName, int row) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<String> res = new ArrayList<String>();
        Row r = null;
        try {
            r = sheet.getRow(row);
        } catch (Exception e) {
        }
        int lengCol = r.getLastCellNum();
        for (int i = 0; i < lengCol; i++) {
            Cell c = null;
            try {
                c = r.getCell(i);
            } catch (Exception e) {
                continue;
            }
            try {
                c.getStringCellValue();
            } catch (Exception e) {
                res.add("");
                continue;
            }
            res.add(c.getStringCellValue());
        }
        file.close();
        workbook.close();
        return res;
    }

    public static String getValueFromRowAndCel(String filePath, String sheetName, int row, int cell) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row r = null;
        try {
            r = sheet.getRow(row);
        } catch (Exception e) {
            return "";
        }finally {
            file.close();
            workbook.close();
        }
        if (r == null) {
            return "";
        }
        Cell c = null;
        try {
            c = r.getCell(cell);
        } catch (Exception e) {
            return "";
        } finally {
            file.close();
            workbook.close();
        }
        if (c == null) {
            return "";
        }
        file.close();
        workbook.close();
        return c.getStringCellValue();

    }
}