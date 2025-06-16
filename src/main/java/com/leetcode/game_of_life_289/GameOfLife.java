package com.leetcode.game_of_life_289;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        final int[][] boardToQuery = arrayDeepCopy(board);
        if (board.length == 0) return;
        int width = board[0].length;
        int height = board.length;
        IntStream.range(0, height).forEach(row ->
                IntStream.range(0, width).forEach(col -> applyRules(boardToQuery, board, row, col)));
    }

    private static int[][] arrayDeepCopy(int[][] board) {
        return Arrays.stream(board)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(int[][]::new);
    }

    private void applyRules(int[][] boardToQuery, int[][] boardToUpdate, int row, int col) {
        switch (boardToQuery[row][col]) {
            case 0 -> applyRulesOnZero(boardToQuery, boardToUpdate, row, col);
            case 1 -> applyRulesOnOne(boardToQuery, boardToUpdate, row, col);
        }
    }

    private void applyRulesOnZero(int[][] boardToQuery, int[][] boardToUpdate, int row, int col) {
        var numLiveNeighbours = getNumLiveNeighbours(boardToQuery, row, col);
        if (numLiveNeighbours == 3) boardToUpdate[row][col] = 1;
    }

    private void applyRulesOnOne(int[][] boardToQuery, int[][] boardToUpdate, int row, int col) {
        var numLiveNeighbours = getNumLiveNeighbours(boardToQuery, row, col);
        if (numLiveNeighbours < 2 || numLiveNeighbours > 3) boardToUpdate[row][col] = 0;
    }

    private int getNumLiveNeighbours(int[][] boardToQuery, int row, int col) {
        var numLiveNeighbours = 0;
        if (isInBounds(boardToQuery, row - 1, col) && boardToQuery[row - 1][col] == 1)
            numLiveNeighbours++; // check above
        if (isInBounds(boardToQuery, row + 1, col) && boardToQuery[row + 1][col] == 1)
            numLiveNeighbours++; // check below
        if (isInBounds(boardToQuery, row, col - 1) && boardToQuery[row][col - 1] == 1)
            numLiveNeighbours++; // check left
        if (isInBounds(boardToQuery, row, col + 1) && boardToQuery[row][col + 1] == 1)
            numLiveNeighbours++; // check right
        if (isInBounds(boardToQuery, row + 1, col - 1) && boardToQuery[row + 1][col - 1] == 1)
            numLiveNeighbours++; // check bottom left
        if (isInBounds(boardToQuery, row + 1, col + 1) && boardToQuery[row + 1][col + 1] == 1)
            numLiveNeighbours++; // check bottom right
        if (isInBounds(boardToQuery, row - 1, col - 1) && boardToQuery[row - 1][col - 1] == 1)
            numLiveNeighbours++; // check top left
        if (isInBounds(boardToQuery, row - 1, col + 1) && boardToQuery[row - 1][col + 1] == 1)
            numLiveNeighbours++; // check top left
        return numLiveNeighbours;
    }

    private boolean isInBounds(int[][] array, int row, int col) {
        return row >= 0 && row < array.length &&
                col >= 0 && col < array[row].length;
    }

    void printBoard(int[][] board) {
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
    }
}
