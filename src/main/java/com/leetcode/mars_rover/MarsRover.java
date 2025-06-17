package com.leetcode.mars_rover;

import lombok.Data;

import java.util.Arrays;

import static com.leetcode.mars_rover.Direction.*;

@Data
public class MarsRover {
    // Todo: How to extend this if you could have a large rover that takes up 4 squares on the grid
    private int[] position;
    private Direction direction;
    private final Plateau plateau;

    public MarsRover(int[] position, Direction direction, Plateau plateau) {
        this.position = position;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void executeCommands(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L' -> rotateLeft();
                case 'R' -> rotateRight();
                case 'M' -> move();
            }
        }
    }

    // Todo: How to extend this if the rover could face NW, SW, SE, NE
    private void move() {
        int nextX = position[0];
        int nextY = position[1];
        switch (direction) {
            case N -> nextY++;
            case S -> nextY--;
            case E -> nextX++;
            case W -> nextX--;
        }
        if (plateau.isInBounds(nextX, nextY)) {
            position[0] = nextX;
            position[1] = nextY;
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

    private void printRoverPosition() {
        var plateauArray = new char[plateau.ySize() + 1][plateau.xSize() + 1];
        plateauArray[this.position[1]][this.position[0]] = this.direction.toString().charAt(0);
        printPlateau(plateauArray, 0);
        System.out.println("-------------");
    }

    private void printPlateau(char[][] plateau, int count) {
        if (plateau.length == 0) {
            System.out.println("[]");
            return;
        }
        count++;
        if (count != plateau.length) printPlateau(plateau, count);
        System.out.println(Arrays.toString(plateau[count - 1]));
    }
}
