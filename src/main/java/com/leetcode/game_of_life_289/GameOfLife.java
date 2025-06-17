package com.leetcode.game_of_life_289;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameOfLife {
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;

        final int[][] boardSnapshot = arrayDeepCopy(board);
        int width = board[0].length;
        int height = board.length;

        IntStream.range(0, height).forEach(row ->
                IntStream.range(0, width).forEach(col -> applyRules(boardSnapshot, board, row, col)));
    }

    private static int[][] arrayDeepCopy(int[][] board) {
        return Arrays.stream(board)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(int[][]::new);
    }

    private void applyRules(int[][] boardSnapshot, int[][] board, int row, int col) {
        var numLiveNeighbours = getNumLiveNeighbours(boardSnapshot, row, col);
        board[row][col] = switch (boardSnapshot[row][col]) {
            case DEAD -> (numLiveNeighbours == 3) ? ALIVE : DEAD;
            case ALIVE -> (numLiveNeighbours < 2 || numLiveNeighbours > 3) ? DEAD : ALIVE;
            default -> throw new IllegalStateException("Unexpected value: " + boardSnapshot[row][col]);
        };
    }

    private int getNumLiveNeighbours(int[][] board, int row, int col) {
        return Stream.of(DIRECTIONS).mapToInt(dir -> {
            int newRow = row + dir[0], newCol = col + dir[1];
            return isInBounds(board, newRow, newCol) && board[newRow][newCol] == ALIVE ? 1 : 0;
        }).sum();
    }

    private boolean isInBounds(int[][] array, int row, int col) {
        return row >= 0 && row < array.length &&
                col >= 0 && col < array[row].length;
    }

    void printBoard(int[][] board) {
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
    }
}
