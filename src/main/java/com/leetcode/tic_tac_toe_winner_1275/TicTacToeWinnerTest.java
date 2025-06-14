package com.leetcode.tic_tac_toe_winner_1275;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeWinnerTest {

    private final TicTacToeGame game = new TicTacToeGame();

    @ParameterizedTest(name = "Game #{index}")
    @MethodSource("tictactoeProvider")
    @DisplayName("Test Tic Tac Toe Winner")
    void testTicTacToeWinner(int[][] moves, String expected) {
        assertEquals(expected, game.tictactoe(moves));
    }

    static Stream<Arguments> tictactoeProvider() {
        return Stream.of(
                // A wins horizontally row 1
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {0, 1}, {2, 1}, {0, 2}
                }, "A"),

                // B wins vertically column 2
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {1, 0}, {2, 1}, {0, 2}, {0, 1}
                }, "B"),

                // B wins diagonally top right to bottom left
                Arguments.of(new int[][]{
                        {0, 0}, {1, 1}, {0, 1}, {0, 2}, {2, 2}, {2, 0}
                }, "B"),

                // A wins diagonally top left to bottom right
                Arguments.of(new int[][]{
                        {0, 0}, {1, 0}, {1, 1}, {0, 2}, {2, 2}
                }, "A"),

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
