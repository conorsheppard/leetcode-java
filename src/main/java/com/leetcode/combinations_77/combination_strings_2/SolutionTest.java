package com.leetcode.combinations_77.combination_strings_2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @ParameterizedTest
    @CsvSource({
        "1, '1,2,3,4,5,6,7,8,9'",
        "2, '11,12,13,14,15,16,17,18,19,22,23,24,25,26,27,28,29,33,34,35,36,37,38,39,44,45,46,47,48,49,55,56,57,58,59,66,67,68,69,77,78,79,88,89,99'"
    })
    public void testCombinations(int n, String expected) {
        assertEquals(expected, Solution.run(n));
    }
}
