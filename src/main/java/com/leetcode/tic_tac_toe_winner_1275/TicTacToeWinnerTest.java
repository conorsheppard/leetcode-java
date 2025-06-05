package com.leetcode.tic_tac_toe_winner_1275;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeWinnerTest {
    @ParameterizedTest(name = "Game #{index}")
    @MethodSource("tictactoeProvider")
    @DisplayName("Test Tic Tac Toe Winner")
    void testTicTacToeWinner(int[][] moves, String expected) {
//        assertEquals(expected, tictactoe(moves));
    }

    static Stream<Arguments> tictactoeProvider() {
        return Stream.of(
                // A wins
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {0, 1}, {2, 1}, {0, 2}
                }, "A"),

                // B wins
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {0, 1}, {0, 2}, {2, 2}, {2, 0}
                }, "B"),

                // Draw
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {2, 0},
                        {1, 0}, {1, 2}, {2, 1},
                        {0, 1}, {0, 2}, {2, 2}
                }, "Draw"),

                // Pending
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}
                }, "Pending"),

                // Edge case: empty input
                Arguments.of(new int[][]{}, "Pending")
        );
    }
}
