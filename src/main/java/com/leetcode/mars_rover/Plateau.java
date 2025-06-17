package com.leetcode.mars_rover;

/**
 *
 * @param xSize length of the x axis (width of the grid), rover.position[1]
 * @param ySize length of the y axis (length of the grid), rover.position[0]
 * */
public record Plateau(int xSize, int ySize) {
    boolean isInBounds(int x, int y) {
        return x >= 0 && x <= xSize && y >= 0 && y <= ySize;
    }
}