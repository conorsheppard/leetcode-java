package com.leetcode.mars_rover;

import lombok.Data;

import static com.leetcode.mars_rover.Direction.*;

@Data
public class MarsRover {
    // Todo: How to extend this if you could have a large rover that takes up 4 squares on the grid
    private int[] position;
    private Direction direction;
    private final Plateau plateau;

    public MarsRover(int[] position, Direction direction, Plateau plateau) {
        this.position = convertArrayIndicesToMatrixCoordinates(position);
        this.direction = direction;
        this.plateau = plateau;
    }

    public void executeCommands(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L' -> rotateLeft();
                case 'R' -> rotateRight();
                case 'M' -> move(plateau);
            }
        }
    }

    // Todo: How to extend this if the rover could face NW, SW, SE, NE
    private void move(Plateau p) {
        int nextX = position[1];
        int nextY = position[0];
        switch (direction) {
            case N -> nextY--;
            case S -> nextY++;
            case E -> nextX++;
            case W -> nextX--;
        }
        if (isInBounds(p.xSize(), p.ySize(), nextY, nextX)) {
            position[0] = nextY;
            position[1] = nextX;
        }
    }

    void rotateLeft() {
        switch (direction) {
            case N -> direction = W;
            case S -> direction = E;
            case E -> direction = N;
            case W -> direction = S;
        }
    }

    void rotateRight() {
        switch (direction) {
            case N -> direction = E;
            case S -> direction = W;
            case E -> direction = S;
            case W -> direction = N;
        }
    }

    private int[] convertArrayIndicesToMatrixCoordinates(int[] coordinates) {
        // position[length - 1 - secondDigit][firstDigit]
        return coordinates;
    }

    private boolean isInBounds(int width, int length, int row, int col) {
        return row >= 0 && row < length && col >= 0 && col < width;
    }
}
