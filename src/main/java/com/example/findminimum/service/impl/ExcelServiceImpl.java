package com.example.findminimum.service.impl;

import com.example.findminimum.service.ExcelService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<Integer> readNumbersFromExcel(String filePath) throws IOException {
        if (!filePath.toLowerCase().endsWith(".xlsx")) {
            throw new IllegalArgumentException("Поддерживаются только .xlsx файлы");
        }

        List<Integer> numbers = new ArrayList<>();
        FileInputStream file = null;
        XSSFWorkbook workbook = null;

        try {
            file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }

        return numbers;
    }
}

