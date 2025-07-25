package com.leetcode.combinations_77;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationsTest {
    @SneakyThrows
    @ParameterizedTest(name = "n: {0}, k: {1}, expected: {2}")
    @CsvSource({
//            "4, 2, '[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]'",
//            "1, 1, '[[1]]'",
//            "3, 3, '[[1, 2, 3]]'",
            "9, 3, '[[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 2, 6], [1, 2, 7], [1, 2, 8], [1, 2, 9], [1, 3, 4], [1, 3, 5], [1, 3, 6], [1, 3, 7], [1, 3, 8], [1, 3, 9], [1, 4, 5], [1, 4, 6], [1, 4, 7], [1, 4, 8], [1, 4, 9], [1, 5, 6], [1, 5, 7], [1, 5, 8], [1, 5, 9], [1, 6, 7], [1, 6, 8], [1, 6, 9], [1, 7, 8], [1, 7, 9], [1, 8, 9], [2, 3, 4], [2, 3, 5], [2, 3, 6], [2, 3, 7], [2, 3, 8], [2, 3, 9], [2, 4, 5], [2, 4, 6], [2, 4, 7], [2, 4, 8], [2, 4, 9], [2, 5, 6], [2, 5, 7], [2, 5, 8], [2, 5, 9], [2, 6, 7], [2, 6, 8], [2, 6, 9], [2, 7, 8], [2, 7, 9], [2, 8, 9], [3, 4, 5], [3, 4, 6], [3, 4, 7], [3, 4, 8], [3, 4, 9], [3, 5, 6], [3, 5, 7], [3, 5, 8], [3, 5, 9], [3, 6, 7], [3, 6, 8], [3, 6, 9], [3, 7, 8], [3, 7, 9], [3, 8, 9], [4, 5, 6], [4, 5, 7], [4, 5, 8], [4, 5, 9], [4, 6, 7], [4, 6, 8], [4, 6, 9], [4, 7, 8], [4, 7, 9], [4, 8, 9], [5, 6, 7], [5, 6, 8], [5, 6, 9], [5, 7, 8], [5, 7, 9], [5, 8, 9], [6, 7, 8], [6, 7, 9], [6, 8, 9], [7, 8, 9]]'"
    })
    void testCombinations(int n, int k, String expectedStr) {
        int[][] expected = new ObjectMapper().readValue(expectedStr, int[][].class);
        var expectedList = Arrays.stream(expected).map(arr -> Arrays.stream(arr).boxed().toList()).toList();
        assertEquals(expectedList, new Combinations().combine(n, k));
    }
}
