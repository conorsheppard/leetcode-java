package com.leetcode.valid_sudoku_36;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidSudokuTest {
    private final ValidSudoku solution = new ValidSudoku();

    @Test
    void testValidSudokuBoard() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertTrue(solution.isValidSudoku(board));
    }

    @Test
    void testInvalidSudokuDueToRow() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','5'}, // duplicate '5' in row
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(solution.isValidSudoku(board));
    }

    @Test
    void testInvalidSudokuDueToColumn() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'5','9','8','.','.','.','.','6','.'}, // duplicate '5' in column 0
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(solution.isValidSudoku(board));
    }

    @Test
    void testInvalidSudokuDueToSubBox() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','3','1','9','5','.','.','.'}, // duplicate '3' in top-left sub-box
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(solution.isValidSudoku(board));
    }

    @Test
    void testEmptyBoardIsValid() {
        char[][] board = new char[9][9];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '.');
        }
        assertTrue(solution.isValidSudoku(board));
    }
}
