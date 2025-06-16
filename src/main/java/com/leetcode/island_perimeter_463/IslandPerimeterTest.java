package com.leetcode.island_perimeter_463;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandPerimeterTest {
    @ParameterizedTest(name = "Test: #{index}")
    @MethodSource("testCases")
    @DisplayName("Island Perimeter Tests")
    void testCase(int[][] input, int expected) {
        var islandPerimeter = new IslandPerimeter();
        assertEquals(expected, islandPerimeter.islandPerimeter(input));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{0, 1, 0, 0}, new int[]{1, 1, 1, 0}, new int[]{0, 1, 0, 0}, new int[]{1, 1, 0, 0}}, 16),
                Arguments.of(new int[][]{}, 0),
                Arguments.of(new int[][]{new int[]{1}}, 4),
                Arguments.of(new int[][]{new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}}, 16),
                Arguments.of(new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}}, 0)
        );
    }
}
