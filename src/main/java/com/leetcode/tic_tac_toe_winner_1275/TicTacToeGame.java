package com.leetcode.tic_tac_toe_winner_1275;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TicTacToeGame {
    private char[][] gameBoard = new char[][]{
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '}
    };
    private static final int SIZE = 3; // dimensions of the matrix (i.e. 3 x 3)
    private int[][] moves;
    private static final char PLAYER_A = 'X';
    private static final char PLAYER_B = 'O';

    public String tictactoe(int[][] moves) {
        this.moves = moves;
        for (int i = 0; i < moves.length; i++) {
            var curPlayer = i % 2 == 0 ? PLAYER_A : PLAYER_B;
            gameBoard[moves[i][0]][moves[i][1]] = curPlayer;
            if (checkHorizontalWin(curPlayer) || checkVerticalWin(curPlayer) || checkDiagonalWin(curPlayer))
                return curPlayer == PLAYER_A ? "A" : "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean checkVerticalWin(char curPlayer) {
        return IntStream.range(0, SIZE)
                .anyMatch(col -> IntStream.range(0, SIZE).allMatch(row -> gameBoard[row][col] == curPlayer));
    }

    private boolean checkHorizontalWin(char curPlayer) {
        return IntStream.range(0, SIZE)
                .anyMatch(row -> IntStream.range(0, SIZE).allMatch(col -> gameBoard[row][col] == curPlayer));
    }

    private boolean checkDiagonalWin(char curPlayer) {
        return IntStream.range(0, SIZE)
                .allMatch(i -> gameBoard[i][i] == curPlayer) ||
                IntStream.range(0, SIZE).allMatch(i -> gameBoard[i][SIZE - 1 - i] == curPlayer);
    }

    private void fillGameBoard(int[][] moves) {
        IntStream
                .range(0, moves.length)
                .forEach(i -> gameBoard[moves[i][0]][moves[i][1]] = i % 2 == 0 ? PLAYER_A : PLAYER_B);
    }

    private void fillGameBoardUpTo(int[][] moves, int limit) {
        IntStream
                .range(0, limit)
                .forEach(i -> gameBoard[moves[i][0]][moves[i][1]] = i % 2 == 0 ? PLAYER_A : PLAYER_B);
    }

    private List<String> fillGameBoardAtEachMove(int[][] moves) {
        return IntStream
                .range(0, moves.length)
                .mapToObj(i -> {
                    gameBoard[moves[i][0]][moves[i][1]] = i % 2 == 0 ? PLAYER_A : PLAYER_B;
                    return Stream.of(gameBoard)
                            .map(Arrays::toString)
                            .toList();
                })
                .map(list -> list.stream().reduce("", (x, y) -> x + y + "\n"))
                .toList();
    }

    private void printGameBoard() {
        Stream.of(gameBoard)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
