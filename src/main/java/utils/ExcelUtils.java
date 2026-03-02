package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelUtils {

    public static void writeDynamicDataToExcel(String filePath, String sheetName, String[] headers, List<String[]> dataRows) throws Exception {
        File file = new File(filePath);
        Workbook workbook;

        // FIX: Load the file into memory via FileInputStream so it isn't locked.
        if (file.exists() && file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);
            fis.close(); // Close the input stream to release the file lock
        } else {
            workbook = new XSSFWorkbook();
        }

        // Remove sheet if it exists, then create a fresh one
        int sheetIndex = workbook.getSheetIndex(sheetName);
        if (sheetIndex != -1) {
            workbook.removeSheetAt(sheetIndex);
        }
        Sheet sheet = workbook.createSheet(sheetName);

        // Write Header
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // Write Data
        for (int i = 0; i < dataRows.size(); i++) {
            Row row = sheet.createRow(i + 1);
            String[] rowData = dataRows.get(i);
            for (int j = 0; j < rowData.length; j++) {
                row.createCell(j).setCellValue(rowData[j]);
            }
        }

        // Write back to the File
        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);

        // Manually close resources
        fileOut.close();
        workbook.close();
    }
}