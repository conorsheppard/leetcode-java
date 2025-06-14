package com.leetcode.mars_rover;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static com.leetcode.mars_rover.MarsRover.Direction.*;

@Slf4j
public class MarsRover {

    public static void main(String[] args) {
        new MarsRover().execute();
    }

    void execute() {
        // L: turn left, R: turn right, M: move forward
//        String commands = "LMLMLMLMM";
        String commands = "MMRMRM";

        var rover = new Rover(new int[]{0, 0}, N);
        var plateau = new Plateau(5, 5);

        System.out.println("Rover: " + rover);

        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L' -> rover.rotateLeft();
                case 'R' -> rover.rotateRight();
                case 'M' -> rover.move(plateau);
            }
        }

        System.out.println("Rover: " + rover);
    }

    @Data
    @AllArgsConstructor
    class Rover {
        // Todo: How to extend this if you could have a large rover that takes up 4 squares on the grid
        int[] position;
        Direction direction;

        // Todo: How to extend this if the rover could face NW, SW, SE, NE
        void move(Plateau p) {
            switch (direction) {
                case N -> position[0] = position[0] + (position[0] == 0 ? 0 : -1);
                case S -> position[0] = position[0] + (position[0] == p.ySize ? 0 : 1);
                case E -> position[1] = position[1] + (position[1] == p.xSize ? 0 : 1);
                case W -> position[1] = position[1] + (position[1] == 0 ? 0 : -1);
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
    }

    @AllArgsConstructor
    class Plateau {
        int xSize; // length of the x axis, rover.position[1]
        int ySize; // length of the y axis, rover.position[0]
    }

    enum Direction {
        N, S, E, W;
    }
}
