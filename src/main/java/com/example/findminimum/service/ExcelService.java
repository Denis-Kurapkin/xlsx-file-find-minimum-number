package com.example.findminimum.service;

import java.io.IOException;
import java.util.List;

public interface ExcelService {

    List<Integer> readNumbersFromExcel(String filePath) throws IOException;
}
