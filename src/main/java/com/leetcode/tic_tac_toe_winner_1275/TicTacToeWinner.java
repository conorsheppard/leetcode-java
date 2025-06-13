package com.leetcode.tic_tac_toe_winner_1275;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TicTacToeWinner {
    private char[][] gameBoard = new char[][]{
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '},
            new char[]{' ', ' ', ' '}
    };

    public String tictactoe(int[][] moves) {
        if (moves.length == 0) return "Pending";

        IntStream
                .range(0, moves.length)
                .forEach(i -> gameBoard[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 'A' : 'B');

        printGameBoard();

        var res = Stream.of(checkForHorizontalWin(), checkForVerticalWin(), checkForDiagonalWin(), checkForDraw(),
                        checkForPending())
                .filter(s -> !s.isEmpty())
                .toList();

        return res.isEmpty() ? "" : res.getFirst();
    }

    private void printGameBoard() {
        Stream.of(gameBoard)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private String checkForHorizontalWin() {
        var aWins = Arrays.stream(gameBoard)
                .anyMatch(c -> IntStream.range(0, c.length)
                        .allMatch(i -> c[i] == 'A'));

//        var aWins = Stream.of(gameBoard).map(Arrays::toString).anyMatch(s -> s.equals("[A, A, A]"));
        var bWins = Stream.of(gameBoard).map(Arrays::toString).anyMatch(s -> s.equals("[B, B, B]"));

        var res = aWins ? "A" : "";
        res = bWins ? "B" : res;

        return res;
    }

    private String checkForVerticalWin() {
        int aCount = 0, bCount = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            aCount = 0;
            bCount = 0;
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[j][i] == 'A') aCount++;
                if (gameBoard[j][i] == 'B') bCount++;
            }
            if (aCount == 3) return "A";
            if (bCount == 3) return "B";
        }

        return "";
    }

    private String checkForDiagonalWin() {
        // {0, 0}
        //        {1, 1}
        //               {2, 2}

        //               {0, 2}
        //        {1, 1}
        // {2, 0}

//        if (gameBoard[0][0] == 'A' && gameBoard[1][1] == 'A' && gameBoard[2][2] == 'A') return "A";
        if(Stream.of(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]).allMatch(c -> c == 'A') ) return "A";
//        if (gameBoard[2][0] == 'A' && gameBoard[1][1] == 'A' && gameBoard[0][2] == 'A') return "A";
        if (Stream.of(gameBoard[2][0], gameBoard[1][1], gameBoard[0][2]).allMatch(c -> c == 'A')) return "A";

//        if (gameBoard[0][0] == 'B' && gameBoard[1][1] == 'B' && gameBoard[2][2] == 'B') return "B";
        if(Stream.of(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]).allMatch(c -> c == 'B') ) return "B";
//        if (gameBoard[2][0] == 'B' && gameBoard[1][1] == 'B' && gameBoard[0][2] == 'B') return "B";
        if (Stream.of(gameBoard[2][0], gameBoard[1][1], gameBoard[0][2]).allMatch(c -> c == 'B')) return "B";

        return "";
    }

    private String checkForDraw() {
        return Stream.of(gameBoard).allMatch(r -> IntStream.range(0, r.length)
                .allMatch(i -> r[i] == 'A' || r[i] == 'B')) ? "Draw" : "";
    }

    private String checkForPending() {
        return Stream.of(gameBoard).anyMatch(r -> IntStream.range(0, r.length)
                .anyMatch(i -> r[i] == ' ')) ? "Pending" : "";
    }
}
