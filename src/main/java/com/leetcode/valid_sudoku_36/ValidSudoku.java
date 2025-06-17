package com.leetcode.valid_sudoku_36;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // check each square is valid
        return allRowsAreValid(board) && allColumnsAreValid(board) && allSquaresAreValid(board);
    }

    private boolean allRowsAreValid(char[][] board) {
        return Stream.of(board).allMatch(this::isRowValid);
    }

    private boolean isRowValid(char[] row) {
        var numMap = new HashMap<Character, Integer>();
        return CharBuffer.wrap(row).chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> valid(c, numMap));
    }

    private boolean allColumnsAreValid(char[][] board) {
        return IntStream.range(0, board.length).allMatch(col -> isColumnValid(col, board));
    }

    private boolean isColumnValid(int col, char[][] board) {
        var numMap = new HashMap<Character, Integer>();
        return IntStream.range(0, board.length).allMatch(row -> valid(board[row][col], numMap));
    }

    private boolean allSquaresAreValid(char[][] board) {
        return IntStream.range(0, 3).allMatch(boxRow ->
                IntStream.range(0, 3).allMatch(boxCol -> {
                    Set<Character> seen = new HashSet<>();
                    return IntStream.range(0, 3).allMatch(i ->
                            IntStream.range(0, 3).allMatch(j -> {
                                char c = board[boxRow * 3 + i][boxCol * 3 + j];
                                return c == '.' || seen.add(c);
                            })
                    );
                })
        );
    }

    private static boolean valid(Character c, HashMap<Character, Integer> numMap) {
        if (c == '.') return true;
        return numMap.put(c, 1) == null;
    }
}
