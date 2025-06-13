package com.leetcode.tic_tac_toe_winner_1275;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TicTacToeWinner {
    private char[][] gameBoard = new char[][]{
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '}
    };
    private int[][] moves;
    private static final String DIAG_1 = "Diag1";
    private static final String DIAG_2 = "Diag2";


    private final Map<String, Integer> movesMap = new HashMap<>();

    public String tictactoe(int[][] moves) {
        this.moves = moves;
        for (int i = 0; i < moves.length; i++) {
            var curPlayer = i % 2 == 0 ? "A" : "B";
            if (incrementAndCheckWin(moves[i], curPlayer)) return curPlayer;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean incrementAndCheckWin(int[] move, String player) {
        movesMap.put(player + "Row" + move[0], movesMap.getOrDefault(player + "Row" + move[0], 0) + 1);
        movesMap.put(player + "Col" + move[1], movesMap.getOrDefault(player + "Col" + move[1], 0) + 1);

        if ((move[0] == 0 && move[1] == 0) || (move[0] == 1 && move[1] == 1) || (move[0] == 2 && move[1] == 2))
            movesMap.put(player + DIAG_1, movesMap.getOrDefault(player + DIAG_1, 0) + 1);

        if ((move[0] == 0 && move[1] == 2) || (move[0] == 1 && move[1] == 1) || (move[0] == 2 && move[1] == 0))
            movesMap.put(player + DIAG_2, movesMap.getOrDefault(player + DIAG_2, 0) + 1);

        return movesMap.getOrDefault(player + "Row" + move[0], 0) == 3
                || movesMap.getOrDefault(player + "Col" + move[1], 0) == 3
                || movesMap.getOrDefault(player + DIAG_1, 0) == 3
                || movesMap.getOrDefault(player + DIAG_2, 0) == 3;
    }

    private void fillGameBoard(int[][] moves) {
        IntStream
                .range(0, moves.length)
                .forEach(i -> gameBoard[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 'A' : 'B');
    }

    private void printGameBoard() {
        Stream.of(gameBoard)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
