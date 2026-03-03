package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelUtils {

    public static void writeDataToExcel(String filePath, String sheetName, String[] headers, List<String[]> dataRows) throws Exception {
        File file = new File(filePath);
        Workbook workbook;

        if (file.exists() && file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
        }

        int sheetIndex = workbook.getSheetIndex(sheetName);
        if (sheetIndex != -1) {
            workbook.removeSheetAt(sheetIndex);
        }
        Sheet sheet = workbook.createSheet(sheetName);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        for (int i = 0; i < dataRows.size(); i++) {
            Row row = sheet.createRow(i + 1);
            String[] rowData = dataRows.get(i);
            for (int j = 0; j < rowData.length; j++) {
                row.createCell(j).setCellValue(rowData[j]);
            }
        }

        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}