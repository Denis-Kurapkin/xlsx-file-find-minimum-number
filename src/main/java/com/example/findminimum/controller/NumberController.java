package com.example.findminimum.controller;

import com.example.findminimum.model.FileRequestDto;
import com.example.findminimum.service.ExcelService;
import com.example.findminimum.service.MinimumFinderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/numbers")
@Tag(name = "Операции с числами")
public class NumberController {

    private final MinimumFinderService minimumFinderService;
    private final ExcelService excelService;

    public NumberController(MinimumFinderService minimumFinderService, ExcelService excelService) {
        this.minimumFinderService = minimumFinderService;
        this.excelService = excelService;
    }

    @PostMapping("/find-min")
    public ResponseEntity<?> findNthMinimum(
            @RequestBody FileRequestDto request) {
        try {
            List<Integer> numbers = excelService.readNumbersFromExcel(request.filePath());
            int result = minimumFinderService.findMinimumNumber(numbers, request.n());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
