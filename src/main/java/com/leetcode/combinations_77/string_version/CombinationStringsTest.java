package com.leetcode.combinations_77.string_version;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leetcode.combinations_77.Combinations;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationStringsTest {
    @SneakyThrows
    @ParameterizedTest(name = "n: {0}, k: {1}, expected: {2}")
    @CsvSource({
            "4, 2, '[12, 13, 14, 23, 24, 34]'",
            "1, 1, '[1]'",
            "4, 1, '[1, 2, 3, 4]'",
            "1, 5, '[12345]'",
            "3, 3, '[123]'",
            "9, 3, '[123, 124, 125, 126, 127, 128, 129, 134, 135, 136, 137, 138, 139, 145, 146, 147, 148, 149, 156, 157, 158, 159, 167, 168, 169, 178, 179, 189, 234, 235, 236, 237, 238, 239, 245, 246, 247, 248, 249, 256, 257, 258, 259, 267, 268, 269, 278, 279, 289, 345, 346, 347, 348, 349, 356, 357, 358, 359, 367, 368, 369, 378, 379, 389, 456, 457, 458, 459, 467, 468, 469, 478, 479, 489, 567, 568, 569, 578, 579, 589, 678, 679, 689, 789]'"
    })
    void testCombinations(int n, int k, String expectedStr) {
        List<String> expected = new ObjectMapper().readValue(expectedStr, new TypeReference<>() {});
        assertEquals(expected, new Combinations().combine(n, k));
    }
}
