package com.leetcode.game_of_life_289;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @ParameterizedTest(name = "Game #{index}")
    @MethodSource("testCases")
    @DisplayName("Game of Life Test Cases")
    void test(int[][] input, int[][] expected) {
        new GameOfLife().gameOfLife(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(

                Arguments.of(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}},
                        new int[][]{new int[]{0, 0, 0}, new int[]{1, 0, 1}, new int[]{0, 1, 1}, new int[]{0, 1, 0}}),

                Arguments.of(new int[][]{new int[]{1, 1}, new int[]{1, 0}},
                        new int[][]{new int[]{1, 1}, new int[]{1, 1}})

        );
    }
}
