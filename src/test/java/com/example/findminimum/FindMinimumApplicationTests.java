package com.example.findminimum;

import com.example.findminimum.service.ExcelService;
import com.example.findminimum.service.MinimumFinderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FindMinimumApplicationTests {

    @Autowired
    private MinimumFinderService minimumFinderService;

    @Test
    public void testFindNthMinimum() {
        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 4);

        assertEquals(1, minimumFinderService.findMinimumNumber(numbers, 1));
        assertEquals(3, minimumFinderService.findMinimumNumber(numbers, 2));
        assertEquals(9, minimumFinderService.findMinimumNumber(numbers, 5));
    }

}
