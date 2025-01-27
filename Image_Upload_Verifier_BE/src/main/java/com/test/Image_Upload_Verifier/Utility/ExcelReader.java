package com.test.Image_Upload_Verifier.Utility;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<String> readLanIds(MultipartFile file) throws Exception {
        List<String> lanIds = new ArrayList<>();
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            // Start iterating from the second row (index 1) to skip the header
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Use index-based iteration
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(0); // Read the first column
                    if (cell != null) {
                        lanIds.add(cell.getStringCellValue().trim());
                    }
                }
            }
        }

        return lanIds;
    }
}
